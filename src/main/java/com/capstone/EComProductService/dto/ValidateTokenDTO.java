package com.capstone.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenDTO {

    private String token;
    private long userId;

    public ValidateTokenDTO(){

    }

    public ValidateTokenDTO(String token, long userId) {
        this.token = token;
        this.userId = userId;
    }
}
