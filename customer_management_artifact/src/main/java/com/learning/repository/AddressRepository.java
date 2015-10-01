package com.learning.repository;

import com.learning.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 28/09/15.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
