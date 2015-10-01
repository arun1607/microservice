package com.learning.repository;

import com.learning.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by amits on 22/09/15.
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByFirstNameLikeOrLastNameLike(String firstName,String lastName);
}
