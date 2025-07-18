package com.capstone.EComProductService.mapper;

import com.capstone.EComProductService.dto.OrderListResponseDTO;
import com.capstone.EComProductService.dto.OrderRequestDTO;
import com.capstone.EComProductService.dto.OrderResponseDTO;
import com.capstone.EComProductService.dto.ProductListResponseDTO;
import com.capstone.EComProductService.model.Order;

import java.util.List;

public class OrderMapper {

    public static Order covertOrderRequestDtoToOrder (OrderRequestDTO orderRequestDTO){
        Order order = new Order();
        order.setProducts(orderRequestDTO.getProducts());
        return order;
    }

    public static OrderResponseDTO convertOrderToOrderResponseDto(Order order){
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderId(order.getId());
        orderResponseDTO.setProducts(order.getProducts());
        return orderResponseDTO;
    }

    public static OrderListResponseDTO convertOrdersToOrderListResponseDTO(List<Order> orders){
        OrderListResponseDTO orderListResponseDTO = new OrderListResponseDTO();
        for(Order o: orders){
            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
            orderResponseDTO.setOrderId(o.getId());
            orderResponseDTO.setProducts(o.getProducts());

            orderListResponseDTO.getOrderResponseDTOList().add(orderResponseDTO);
        }
        return orderListResponseDTO;
    }
}
