package com.learning.repository;

import com.learning.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 26/09/15.
 */
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
