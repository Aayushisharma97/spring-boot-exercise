package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Order entity.
 *
 * <p>
 * Provides CRUD operations and can be extended for custom queries.
 * </p>
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Find all orders by a specific user ID.
     *
     * @param userId the ID of the user
     * @return list of orders for the user
     */
    List<Order> findByUserId(Long userId);
}
