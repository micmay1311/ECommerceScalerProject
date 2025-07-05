package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.CategoryRequestDTO;
import com.capstone.EComProductService.dto.CategoryResponseDTO;
import com.capstone.EComProductService.exception.CategoryNotFoundException;
import com.capstone.EComProductService.model.Category;
import com.capstone.EComProductService.repository.CategoryRepository;
import jakarta.persistence.Table;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;


public class CategoryServiceTest {

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCategoryById() throws CategoryNotFoundException {
        //Arrange

        UUID mockCategoryId = UUID.randomUUID();
        String mockCategoryName = "mockCategory";

        Category mockCategory = new Category();

        mockCategory.setId(mockCategoryId);
        mockCategory.setCategoryName(mockCategoryName);
        when(categoryRepository.findById(mockCategoryId)).thenReturn(Optional.of(mockCategory));

        //Act
        CategoryResponseDTO actualResponse = categoryService.getCategoryById(mockCategoryId);

        //Assert
        Assertions.assertEquals(actualResponse.getId(), mockCategory.getId());
        Assertions.assertEquals(actualResponse.getCategoryName(), mockCategory.getCategoryName());
    }
}
