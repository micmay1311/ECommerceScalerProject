package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.OrderListResponseDTO;
import com.capstone.EComProductService.dto.OrderRequestDTO;
import com.capstone.EComProductService.dto.OrderResponseDTO;
import com.capstone.EComProductService.exception.OrderNoFoundException;
import com.capstone.EComProductService.mapper.OrderMapper;
import com.capstone.EComProductService.model.Order;
import com.capstone.EComProductService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("orderService")
public class OrderSerivceImpl implements OrderService{

    private OrderRepository orderRepository;

    public OrderSerivceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = OrderMapper.covertOrderRequestDtoToOrder(orderRequestDTO);
        order = orderRepository.save(order);
        return OrderMapper.convertOrderToOrderResponseDto(order);
    }

    @Override
    public Boolean deleteOrder(UUID orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isEmpty()){
            return false;
        }
        orderRepository.deleteById(orderId);
        return true;
    }

    @Override
    public OrderResponseDTO updateOrder(UUID orderId, OrderRequestDTO orderRequestDTO) throws OrderNoFoundException {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isEmpty()){
            throw new OrderNoFoundException("Order with given id not found.");
        }
        Order order = orderOptional.get();
        order = OrderMapper.covertOrderRequestDtoToOrder(orderRequestDTO);
        order.setId(orderId);
        orderRepository.save(order);
        return OrderMapper.convertOrderToOrderResponseDto(order);
    }

    @Override
    public OrderListResponseDTO getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderMapper.convertOrdersToOrderListResponseDTO(orders);
    }
}
