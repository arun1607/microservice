package com.learning.repository;

import com.learning.entity.InventoryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 28/09/15.
 */
public interface InventoryOrderRepository extends JpaRepository<InventoryOrder,Long> {

    InventoryOrder findByOrderId(Long orderId);
}
