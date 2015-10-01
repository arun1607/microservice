package com.learning.repository;

import com.learning.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 22/09/15.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
