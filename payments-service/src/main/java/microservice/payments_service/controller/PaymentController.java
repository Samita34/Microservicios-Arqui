package microservice.payments_service.controller;

import microservice.payments_service.dto.PaymentRequestDto;
import microservice.payments_service.dto.PaymentResponseDto;
import microservice.payments_service.entity.Payment;
import microservice.payments_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<PaymentResponseDto> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(PaymentResponseDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentResponseDto> getPaymentByOrderId(@PathVariable Long orderId) {
        return paymentRepository.findAll().stream()
                .filter(payment -> payment.getOrderId().equals(orderId))
                .findFirst()
                .map(payment -> ResponseEntity.ok(new PaymentResponseDto(payment)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDto> createPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment(
                paymentRequestDto.getOrderId(),
                paymentRequestDto.getAmount(),
                paymentRequestDto.getMethod(),
                paymentRequestDto.getStatus(),
                paymentRequestDto.getTransactionId()
        );
        payment.setCreatedAt(LocalDateTime.now());

        Payment savedPayment = paymentRepository.save(payment);
        return ResponseEntity.ok(new PaymentResponseDto(savedPayment));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<PaymentResponseDto> updatePayment(@PathVariable Long orderId, @RequestBody PaymentRequestDto paymentRequestDto) {
        return paymentRepository.findAll().stream()
                .filter(payment -> payment.getOrderId().equals(orderId))
                .findFirst()
                .map(payment -> {
                    payment.setAmount(paymentRequestDto.getAmount());
                    payment.setMethod(paymentRequestDto.getMethod());
                    payment.setStatus(paymentRequestDto.getStatus());
                    payment.setTransactionId(paymentRequestDto.getTransactionId());
                    payment.setCreatedAt(LocalDateTime.now());
                    Payment updatedPayment = paymentRepository.save(payment);
                    return ResponseEntity.ok(new PaymentResponseDto(updatedPayment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deletePayment(@PathVariable Long orderId) {
        return paymentRepository.findAll().stream()
                .filter(payment -> payment.getOrderId().equals(orderId))
                .findFirst()
                .map(payment -> {
                    paymentRepository.delete(payment);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
