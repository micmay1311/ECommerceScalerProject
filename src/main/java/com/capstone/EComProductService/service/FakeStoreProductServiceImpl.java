package com.capstone.EComProductService.service;

import com.capstone.EComProductService.client.FakeStoreAPIClient;
import com.capstone.EComProductService.dto.*;
import com.capstone.EComProductService.exception.ProductNotFoundException;
import com.capstone.EComProductService.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static com.capstone.EComProductService.mapper.ProductMapper.fakeProductResponseToProductResponse;
import static com.capstone.EComProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.capstone.EComProductService.util.ProductUtils.isNull;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;



    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }


    @Override
    public ProductListResponseDTO getAllProducts() {

        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOList){
            productListResponseDTO.getProductResponseDTOList().add(fakeProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductResponseDTO)) {
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        return fakeProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(product);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public Product updateProduct(UUID id, Product updatedProduct) {
        return null;
    }

    @Override
    public Boolean deleteProduct(UUID id){
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }

    @Override
    public ProductResponseDTO getProductbyTitle(String title) {
        return null;
    }

    @Override
    public ProductListResponseDTO findByPrice_amountLessThanEqual(double amount) {
        return null;
    }
}
