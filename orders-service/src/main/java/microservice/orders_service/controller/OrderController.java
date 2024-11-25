package microservice.orders_service.controller;

import microservice.orders_service.dto.OrderResponseDto;
import microservice.orders_service.dto.OrderRequestDto;
import microservice.orders_service.entity.Order;
import microservice.orders_service.entity.OrderItem;
import microservice.orders_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderResponseDto>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<OrderResponseDto> response = orders.stream()
                                                .map(OrderResponseDto::new)
                                                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        try{
            Order order = new Order(orderRequestDto.getUserId(), orderRequestDto.getStatus(), orderRequestDto.getTotal());

        order.setCreatedAt(LocalDateTime.now());

        // Crear y guardar los OrderItems
        List<OrderItem> orderItems = orderRequestDto.getOrderItems().stream()
                .map(dto -> new OrderItem(order, dto.getProductId(), dto.getQuantity(), dto.getPrice()))
                .collect(Collectors.toList());
        

        // Guardar la entidad Order para obtener su ID
        order.setOrderItems(orderItems);
        Order savedOrder = orderRepository.save(order);

        // Devolver el DTO de respuesta
        return ResponseEntity.ok(new OrderResponseDto(savedOrder));
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setUserId(orderDetails.getUserId());
                    order.setStatus(orderDetails.getStatus());
                    order.setTotal(orderDetails.getTotal());
                    order.setCreatedAt(LocalDateTime.now());
                    Order updatedOrder = orderRepository.save(order);
                    return ResponseEntity.ok(new OrderResponseDto(updatedOrder));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    orderRepository.delete(order);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
