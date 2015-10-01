package com.learning.repository;

import com.learning.entity.Logistic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 28/09/15.
 */
public interface LogisticRepository extends JpaRepository<Logistic,Long> {
}
