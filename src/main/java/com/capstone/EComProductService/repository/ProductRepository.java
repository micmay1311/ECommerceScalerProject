package com.capstone.EComProductService.repository;

import com.capstone.EComProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findProductByTitle(String title);

    List<Product> findByPrice_amountLessThanEqual(double amount);

}