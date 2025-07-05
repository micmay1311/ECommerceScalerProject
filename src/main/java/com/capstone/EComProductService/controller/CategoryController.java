package com.capstone.EComProductService.controller;

import com.capstone.EComProductService.dto.*;
import com.capstone.EComProductService.exception.CategoryNotFoundException;
import com.capstone.EComProductService.model.Category;
import com.capstone.EComProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(@Qualifier("categoryService") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity getAllCategories(){

        CategoryListResponseDTO categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/categories")
    public ResponseEntity addCategory(@RequestBody Category category){
        CategoryResponseDTO responseDTO = categoryService.createCategory(category);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/categories")
    public ResponseEntity updateCategory(@RequestBody Category category) throws CategoryNotFoundException {
        CategoryResponseDTO responseDTO = categoryService.updateCategory(category);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity deleteCategory(@PathVariable UUID id){
        Boolean deleted = categoryService.deleteCategory(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity getCategoryById(@PathVariable UUID categoryId) throws CategoryNotFoundException {

        CategoryResponseDTO categoryResponseDTO = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryResponseDTO);
    }
}
