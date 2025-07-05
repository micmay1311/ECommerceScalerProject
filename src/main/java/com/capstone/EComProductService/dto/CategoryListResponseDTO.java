package com.capstone.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryListResponseDTO {

    private List<CategoryResponseDTO> categories;

    public CategoryListResponseDTO() {
        this.categories = new ArrayList<>();
    }
}
