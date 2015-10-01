package com.learning.repository;

import com.learning.entity.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 27/09/15.
 */
public interface OrderCustomerRepository extends JpaRepository<OrderCustomer, Long> {

}
