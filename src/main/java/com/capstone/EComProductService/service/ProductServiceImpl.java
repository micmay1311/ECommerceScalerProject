package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.ProductListResponseDTO;
import com.capstone.EComProductService.dto.ProductRequestDTO;
import com.capstone.EComProductService.dto.ProductResponseDTO;
import com.capstone.EComProductService.exception.ProductNotFoundException;
import com.capstone.EComProductService.mapper.ProductMapper;
import com.capstone.EComProductService.model.Product;
import com.capstone.EComProductService.repository.PriceRepository;
import com.capstone.EComProductService.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    public PriceRepository priceRepository;
    private final ProductRepository productRepository;

    public ProductServiceImpl(PriceRepository priceRepository,
                              ProductRepository productRepository) {
        this.priceRepository = priceRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        List<Product> products = productRepository.findAll();
        productListResponseDTO = ProductMapper.convertProductsToProductListResponseDTO(products);
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
            return productResponseDTO;
        }else{
            throw new ProductNotFoundException("Product not found.");
        }
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        Product product = ProductMapper.convertProductRequestDTOTOProduct(productRequestDTO);
        product =  productRepository.save(product);
        productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }

    @Override
    public Product updateProduct(UUID id, Product updatedProduct) {
        return null;
    }

    @Override
    public Boolean deleteProduct(UUID id){
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public ProductResponseDTO getProductbyTitle(String title) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        Product product = productRepository.findProductByTitle(title);
        productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }

    @Override
    public ProductListResponseDTO findByPrice_amountLessThanEqual(double amount) {
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        List<Product> products = productRepository.findByPrice_amountLessThanEqual(amount);
        productListResponseDTO = ProductMapper.convertProductsToProductListResponseDTO(products);
        return productListResponseDTO;
    }
}
