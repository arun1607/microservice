package com.learning.repository;

import com.learning.entity.ShipmentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 28/09/15.
 */
public interface ShipmentCustomerRepository extends JpaRepository<ShipmentCustomer, Long> {

}
