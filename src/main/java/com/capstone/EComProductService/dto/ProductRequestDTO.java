package com.capstone.EComProductService.dto;

import com.capstone.EComProductService.model.Category;
import com.capstone.EComProductService.model.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    //private int id;
    private String title;
    private Price price;
    private Category category;
    private String description;
    private String image;
}
