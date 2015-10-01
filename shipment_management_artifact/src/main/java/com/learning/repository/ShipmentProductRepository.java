package com.learning.repository;

import com.learning.entity.ShipmentProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 28/09/15.
 */
public interface ShipmentProductRepository extends JpaRepository<ShipmentProduct,Long> {
}
