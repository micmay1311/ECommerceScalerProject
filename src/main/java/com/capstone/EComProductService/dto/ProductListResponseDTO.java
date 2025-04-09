package com.capstone.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductListResponseDTO {

    private List<ProductResponseDTO> productResponseDTOList;
}
