package microservice.orders_service.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderRequestDto {

    private Long userId;
    private String status;
    private BigDecimal total;
    private List<OrderItemDto> orderItems;
    
    public OrderRequestDto(Long userId, String status, BigDecimal total, List<OrderItemDto> orderItems) {
        this.userId = userId;
        this.status = status;
        this.total = total;
        this.orderItems = orderItems;
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
    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

   
}
