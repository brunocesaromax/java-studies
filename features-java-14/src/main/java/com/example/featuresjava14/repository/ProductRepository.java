package com.example.featuresjava14.repository;

import com.example.featuresjava14.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
