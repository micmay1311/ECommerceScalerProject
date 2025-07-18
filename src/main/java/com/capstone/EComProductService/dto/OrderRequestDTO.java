package com.capstone.EComProductService.dto;

import com.capstone.EComProductService.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {

    private List<Product> products;
}
