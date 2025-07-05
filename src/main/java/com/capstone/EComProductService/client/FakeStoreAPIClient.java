package com.capstone.EComProductService.client;

import com.capstone.EComProductService.dto.FakeStoreProductRequestDTO;
import com.capstone.EComProductService.dto.FakeStoreProductResponseDTO;
import com.capstone.EComProductService.dto.ProductListResponseDTO;
import com.capstone.EComProductService.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreAPIURL;
    @Value("${fakestore.api.path.product}")
    private String fakeStoreAPIPathProduct; //this is field injection but we should always use constructor injection.

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreAPIURL){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){

        RestTemplate restTemplate = restTemplateBuilder.build();
        //String createProductURL = "https://fakestoreapi.com/products";
        String createProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(createProductURL,fakeStoreProductRequestDTO,FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(UUID id){
        //String getProductByIdURL = "https://fakestoreapi.com/products/" +id;
        String getProductByIdURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" +id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(getProductByIdURL, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public void deleteProduct(UUID id){
        //String deleteProductURL = "https://fakestoreapi.com/products/" +id;
        String deleteProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" +id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        //String getAllProductsURL = "https://fakestoreapi.com/products";
        String getAllProductsURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProductsURL,FakeStoreProductResponseDTO[].class);
        return List.of(productResponseArray.getBody());
    }

    public void updateProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        //String updateProductURL = "https://fakestoreapi.com/products";
        String updateProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(updateProductURL,fakeStoreProductRequestDTO,FakeStoreProductResponseDTO.class);
    }
}
