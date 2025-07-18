package com.capstone.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDTO {

    private String title;
    private int pageNumber;
    private int pageSize;
    private List<SortParams> sortParams;
}
