package com.capstone.EComProductService.dto;

import com.capstone.EComProductService.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {

    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
    private int inventoryCount;

    public static GenericProductDTO from(Product product){
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setTitle(product.getTitle());
        genericProductDTO.setCategory(product.getCategory().getCategoryName());
        genericProductDTO.setPrice(product.getPrice().getAmount());
        genericProductDTO.setDescription(product.getDescription());
        genericProductDTO.setImage(product.getImage());
        genericProductDTO.setInventoryCount(0);
        return genericProductDTO;
    }
}

