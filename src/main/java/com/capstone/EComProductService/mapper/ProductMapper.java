package com.capstone.EComProductService.mapper;

import com.capstone.EComProductService.dto.*;
import com.capstone.EComProductService.model.Product;

import java.util.List;

public class ProductMapper {

    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO){
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory().getCategoryName());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice().getAmount());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        return productResponseDTO;
    }

    public static ProductListResponseDTO convertProductsToProductListResponseDTO(List<Product> products){
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(Product p : products){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setCategory(p.getCategory().getCategoryName());
            productResponseDTO.setId(p.getId());
            productResponseDTO.setTitle(p.getTitle());
            productResponseDTO.setImage(p.getImage());
            productResponseDTO.setPrice(p.getPrice().getAmount());
            productResponseDTO.setDescription(p.getDescription());

            productListResponseDTO.getProductResponseDTOList().add(productResponseDTO);
        }
        return productListResponseDTO;
    }

    public static ProductResponseDTO convertProductToProductResponseDTO(Product p){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setDescription(p.getDescription());;
        productResponseDTO.setPrice(p.getPrice().getAmount());
        productResponseDTO.setTitle(p.getTitle());
        productResponseDTO.setCategory(p.getCategory().getCategoryName());
        productResponseDTO.setId(p.getId());
        productResponseDTO.setImage(p.getImage());
        return productResponseDTO;
    }

    public static Product convertProductRequestDTOTOProduct(ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setTitle(productRequestDTO.getTitle());
        product.setImage(productRequestDTO.getImage());
        product.setCategory(productRequestDTO.getCategory());
        return product;
    }
}
