package microservice.orders_service.dto;

import microservice.orders_service.entity.Order;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderResponseDto {

    private Long id;
    private Long userId;
    private String status;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private List<OrderItemDto> orderItems;

    public OrderResponseDto() {
        // Default constructor
    }

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.userId = order.getUserId();
        this.status = order.getStatus();
        this.total = order.getTotal();
        this.createdAt = order.getCreatedAt();
        this.orderItems = order.getOrderItems().stream()
                .map(OrderItemDto::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    
}

