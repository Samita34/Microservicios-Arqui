package microservice.orders_service.dto;

import java.math.BigDecimal;

import microservice.orders_service.entity.OrderItem;

public class OrderItemDto {

    private Long productId;
    private Integer quantity;
    private BigDecimal price;

    public OrderItemDto() {
        // Default constructor
    }

    public OrderItemDto(OrderItem orderItem) {
        this.productId = orderItem.getProductId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
