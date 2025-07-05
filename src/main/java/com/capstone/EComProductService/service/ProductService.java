package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.ProductListResponseDTO;
import com.capstone.EComProductService.dto.ProductRequestDTO;
import com.capstone.EComProductService.dto.ProductResponseDTO;
import com.capstone.EComProductService.exception.ProductNotFoundException;
import com.capstone.EComProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    ProductListResponseDTO getAllProducts();

    ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException;

    ProductResponseDTO createProduct(ProductRequestDTO product);

    Product updateProduct(UUID id, Product updatedProduct);

    Boolean deleteProduct(UUID id);

    ProductResponseDTO getProductbyTitle(String title);

    ProductListResponseDTO findByPrice_amountLessThanEqual(double amount);
}
