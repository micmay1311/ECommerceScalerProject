package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.CategoryListResponseDTO;
import com.capstone.EComProductService.dto.CategoryRequestDTO;
import com.capstone.EComProductService.dto.CategoryResponseDTO;
import com.capstone.EComProductService.dto.ProductResponseDTO;
import com.capstone.EComProductService.exception.CategoryNotFoundException;
import com.capstone.EComProductService.mapper.CategoryMapper;
import com.capstone.EComProductService.model.Category;
import com.capstone.EComProductService.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryListResponseDTO getAllCategories() {
        CategoryListResponseDTO categoryListResponseDTO = new CategoryListResponseDTO();
        List<Category> categories = categoryRepository.findAll();
        categoryListResponseDTO = CategoryMapper.convertCategoriesToCategoryListResponseDTO(categories);
        return categoryListResponseDTO;
    }

    public CategoryResponseDTO createCategory(Category category) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        //CategoryRequestDTO categoryRequestDTO = CategoryMapper.convertCategoryToCategoryListRequestDTO(category);
        category = categoryRepository.save(category);
        categoryResponseDTO = CategoryMapper.convertCategoryToCategoryResponseDTO(category);
        return categoryResponseDTO;
    }

    public Boolean deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }

    public CategoryResponseDTO getCategoryById(UUID categoryId) throws CategoryNotFoundException {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        //Category category = new Category();
        Optional<Category> category= categoryRepository.findById(categoryId);
        if(category.isPresent()) {
            categoryResponseDTO = CategoryMapper.convertCategoryToCategoryResponseDTO(category.get());
            return categoryResponseDTO;
        }
        else
            throw new CategoryNotFoundException("Category is not present.");
    }

    public CategoryResponseDTO updateCategory(Category category) throws CategoryNotFoundException {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        Optional<Category> foundCategory = categoryRepository.findById(category.getId());
        if(foundCategory.isPresent()){
            Category category1 = new Category();
            category1.setCategoryName(category.getCategoryName());
            category1.setId(category.getId());
            Category updatedCategory = categoryRepository.save(category1);
            categoryResponseDTO = CategoryMapper.convertCategoryToCategoryResponseDTO(updatedCategory);
            return categoryResponseDTO;
        }
        else{
            throw new CategoryNotFoundException("Category not found for given request.");
        }
    }
}
