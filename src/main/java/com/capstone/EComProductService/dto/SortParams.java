package com.capstone.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParams {

    private String sortParamName;
    private String sortType; //ASC or DESC
}
