package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.ProductListResponseDTO;
import com.capstone.EComProductService.dto.ProductResponseDTO;
import com.capstone.EComProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductListResponseDTO getAllProducts();

    ProductResponseDTO getProductById(int id);

    Product createProduct(Product product);

    Product updateProduct(int id, Product updatedProduct);
}
