package microservice.orders_service.repository;

import microservice.orders_service.entity.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional query methods can be defined here
    List<Order> findByUserId(Long userId);
}
