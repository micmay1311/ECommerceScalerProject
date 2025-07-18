package com.capstone.EComProductService.controller;

import com.capstone.EComProductService.dto.OrderListResponseDTO;
import com.capstone.EComProductService.dto.OrderRequestDTO;
import com.capstone.EComProductService.dto.OrderResponseDTO;
import com.capstone.EComProductService.exception.OrderNoFoundException;
import com.capstone.EComProductService.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(@Qualifier("orderService") OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<OrderListResponseDTO> getAllOrders(){
        OrderListResponseDTO orderListResponseDTO = orderService.getAllOrders();
        return new ResponseEntity<>(orderListResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        OrderResponseDTO orderResponseDTO = orderService.createOrder(orderRequestDTO);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable("orderId") String id){
        UUID orderId = UUID.fromString(id);
        Boolean status = orderService.deleteOrder(orderId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@RequestBody OrderRequestDTO orderRequestDTO, @PathVariable("orderId") UUID orderId) throws OrderNoFoundException {
        OrderResponseDTO orderResponseDTO = orderService.updateOrder(orderId, orderRequestDTO);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }
}
