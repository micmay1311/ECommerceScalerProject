package com.capstone.EComProductService.mapper;

import com.capstone.EComProductService.dto.CategoryListResponseDTO;
import com.capstone.EComProductService.dto.CategoryRequestDTO;
import com.capstone.EComProductService.dto.CategoryResponseDTO;
import com.capstone.EComProductService.model.Category;

import java.util.List;

public class CategoryMapper {

    public static CategoryListResponseDTO convertCategoriesToCategoryListResponseDTO(List<Category> categories){
        CategoryListResponseDTO categoryListResponseDTO = new CategoryListResponseDTO();
        for(Category c : categories){
            CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
            categoryResponseDTO.setCategoryName(c.getCategoryName());
            categoryResponseDTO.setId(c.getId());

            categoryListResponseDTO.getCategories().add(categoryResponseDTO);
        }
        return categoryListResponseDTO;
    }

    public static CategoryRequestDTO convertCategoryToCategoryListRequestDTO(Category category){
        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO();
        categoryRequestDTO.setCategoryName(category.getCategoryName());
        return categoryRequestDTO;
    }

    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getCategoryName());
        categoryResponseDTO.setId(category.getId());
        return categoryResponseDTO;
    }
}
