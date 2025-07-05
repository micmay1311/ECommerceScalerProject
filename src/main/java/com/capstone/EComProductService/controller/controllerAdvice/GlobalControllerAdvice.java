package com.capstone.EComProductService.controller.controllerAdvice;

import com.capstone.EComProductService.dto.ErrorResponseDTO;
import com.capstone.EComProductService.exception.InvalidTokenException;
import com.capstone.EComProductService.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalControllerAdvice {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(Exception ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setMessageCode(404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= InvalidTokenException.class)
    public ResponseEntity<ErrorResponseDTO> handleTokenInvalidException(Exception ex){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setMessageCode(403);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.FORBIDDEN);
    }
}
