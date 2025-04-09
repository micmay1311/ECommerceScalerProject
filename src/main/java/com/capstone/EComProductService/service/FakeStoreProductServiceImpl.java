package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.ProductListResponseDTO;
import com.capstone.EComProductService.dto.ProductResponseDTO;
import com.capstone.EComProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductListResponseDTO> productResponse = restTemplate.getForEntity(url,ProductListResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String url = "https://fakestoreapi.com/products/" +id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(url, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
