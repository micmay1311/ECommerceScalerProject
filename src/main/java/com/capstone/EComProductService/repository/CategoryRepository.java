package com.capstone.EComProductService.repository;

import com.capstone.EComProductService.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}