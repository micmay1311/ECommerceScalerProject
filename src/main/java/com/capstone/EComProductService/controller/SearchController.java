package com.capstone.EComProductService.controller;

import com.capstone.EComProductService.dto.GenericProductDTO;
import com.capstone.EComProductService.dto.SearchRequestDTO;
import com.capstone.EComProductService.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping
    public Page<GenericProductDTO> searchProducts(@RequestBody SearchRequestDTO searchRequestDTO) {
        List<GenericProductDTO> genericProductDTOList = searchService.searchProducts(searchRequestDTO.getTitle(), searchRequestDTO.getPageNumber(),
                searchRequestDTO.getPageSize(), searchRequestDTO.getSortParams());

        Page<GenericProductDTO> genericProductDTOPage = new PageImpl<>(genericProductDTOList);

        return genericProductDTOPage;
    }
}
