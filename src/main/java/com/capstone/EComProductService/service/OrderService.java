package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.OrderListResponseDTO;
import com.capstone.EComProductService.dto.OrderRequestDTO;
import com.capstone.EComProductService.dto.OrderResponseDTO;
import com.capstone.EComProductService.exception.OrderNoFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

    Boolean deleteOrder(UUID orderId);

    OrderResponseDTO updateOrder(UUID orderId, OrderRequestDTO orderRequestDTO) throws OrderNoFoundException;

    OrderListResponseDTO getAllOrders();
}
