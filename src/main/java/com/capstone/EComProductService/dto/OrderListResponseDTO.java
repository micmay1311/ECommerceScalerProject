package com.capstone.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderListResponseDTO {

    private List<OrderResponseDTO> orderResponseDTOList;

    public OrderListResponseDTO(){
        this.orderResponseDTOList = new ArrayList<>();
    }
}
