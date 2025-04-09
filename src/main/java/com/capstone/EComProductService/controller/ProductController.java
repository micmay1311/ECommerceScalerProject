package com.capstone.EComProductService.controller;

import com.capstone.EComProductService.dto.ProductListResponseDTO;
import com.capstone.EComProductService.dto.ProductResponseDTO;
import com.capstone.EComProductService.model.Product;
import com.capstone.EComProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductServiceImpl")
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
//        ProductResponseDTO p1 = new ProductResponseDTO();
//        p1.setId(1);
//        p1.setTitle("iPhone 16e");
//        p1.setCategory("Electronics");
//        p1.setPrice(150000);
//        p1.setDescription("Costly phone");
//        p1.setImage("www.google.com/images/iphone16e");
//
//        ProductResponseDTO p2 = new ProductResponseDTO();
//        p2.setId(2);
//        p2.setTitle("MacBook Pro");
//        p2.setCategory("Electronics");
//        p2.setPrice(350000);
//        p2.setDescription("Costly MacBook");
//        p2.setImage("www.google.com/images/macbook");
//
//        List<ProductResponseDTO> products = Arrays.asList(p1,p2);
//
//        return ResponseEntity.ok(products);
        ProductListResponseDTO products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/1")
    public ResponseEntity getProductById(){
        ProductResponseDTO product = productService.getProductById(1);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/products")
    public Product addProduct(){
        return null;
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(){
        return null;
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(){
        return null;
    }
}
