package com.learning.repository;

import com.learning.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 22/09/15.
 */
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    InventoryItem findByProductName(String productName);

    InventoryItem removeByProductName(String productName);

    InventoryItem removeByProductId(Long productId);

    InventoryItem findByProductId(Long productId);
}
