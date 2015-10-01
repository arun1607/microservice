package com.learning.repository;

import com.learning.entity.DeliveryStatus;
import com.learning.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by amits on 24/09/15.
 */
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findByStatus(DeliveryStatus status);
}
