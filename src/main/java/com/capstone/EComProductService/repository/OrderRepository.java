package com.capstone.EComProductService.repository;

import com.capstone.EComProductService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}