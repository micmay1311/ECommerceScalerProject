package com.capstone.EComProductService.controller;

import com.capstone.EComProductService.client.UserServiceClient;
import com.capstone.EComProductService.dto.*;
import com.capstone.EComProductService.exception.InvalidTokenException;
import com.capstone.EComProductService.exception.ProductNotFoundException;
import com.capstone.EComProductService.model.Product;
import com.capstone.EComProductService.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {



    /**
     * field dependency injection -- not recommended
     * @Autowired
     *     @Qualifier("fakeStoreProductServiceImpl")
     *     private ProductService productService;
     * */

    //Constructor injection

    private ProductService productService;
    private final UserServiceClient userServiceClient;

    @Autowired
    public ProductController(@Qualifier("productService") ProductService productService, UserServiceClient userServiceClient) {
        this.productService = productService;
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id) throws ProductNotFoundException {
        ProductResponseDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products/title/{title}")
    public ResponseEntity getProductByTitle(@PathVariable("title") String title) throws ProductNotFoundException {
        ProductResponseDTO product = productService.getProductbyTitle(title);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts(@RequestHeader("token") String token) throws Exception {
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
        validateUser(token);

        ProductListResponseDTO products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }



    @PostMapping("/products")
    public ResponseEntity addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO responseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable ("id") UUID id){
        Boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(){
        return null;
    }

    @GetMapping("/products/amount/{amount}")
    public ResponseEntity getProductByTitle(@PathVariable("amount") double amount) throws ProductNotFoundException {
        ProductListResponseDTO products = productService.findByPrice_amountLessThanEqual(amount);
        return ResponseEntity.ok(products);
    }

    private void validateUser(String token) throws Exception {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));
        ObjectMapper mapper = new ObjectMapper();
        JwtPayloadDTO jwtPayload = mapper.readValue(payload, JwtPayloadDTO.class);
        long userId = jwtPayload.getUserId();
        ValidateTokenDTO validateTokenDTO = new ValidateTokenDTO(token, userId);
        String result = userServiceClient.validateToken(validateTokenDTO);
        if(!result.contains(SessionStatus.ACTIVE.name())){
            throw new InvalidTokenException("Token is not valid");
        }
    }
}
