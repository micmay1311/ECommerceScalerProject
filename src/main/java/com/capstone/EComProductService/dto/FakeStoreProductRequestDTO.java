package com.capstone.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDTO {
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
