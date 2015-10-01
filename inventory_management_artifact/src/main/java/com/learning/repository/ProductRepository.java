package com.learning.repository;

import com.learning.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by amits on 25/09/15.
 */
public interface ProductRepository extends JpaRepository<Product, Long>,BaseRepository<Product> {
}
