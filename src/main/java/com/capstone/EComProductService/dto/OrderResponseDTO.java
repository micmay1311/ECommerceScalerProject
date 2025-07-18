package com.capstone.EComProductService.dto;

import com.capstone.EComProductService.model.Order;
import com.capstone.EComProductService.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderResponseDTO {

    private UUID orderId;
    private List<Product> products;
}
