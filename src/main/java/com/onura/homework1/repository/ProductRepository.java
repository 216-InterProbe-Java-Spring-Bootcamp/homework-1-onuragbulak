package com.onura.homework1.repository;

import com.onura.homework1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByExpirationDateLessThan(Date currentDate);

    List<Product> findAllByExpirationDateIsGreaterThanEqualOrExpirationDateIsNull(Date currentDate);
}
