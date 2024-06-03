package microservice.payments_service.dto;

import java.math.BigDecimal;

public class PaymentRequestDto {

    private Long orderId;
    private BigDecimal amount;
    private String method;
    private String status;
    private String transactionId;
    
    public PaymentRequestDto() {
    }

    public PaymentRequestDto(Long orderId, BigDecimal amount, String method, String status, String transactionId) {
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.transactionId = transactionId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
}
