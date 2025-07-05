package com.capstone.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceResponseDTO {

    private String currency;
    private double amount;
    private double discount;
}
