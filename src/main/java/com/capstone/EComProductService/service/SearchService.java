package com.capstone.EComProductService.service;

import com.capstone.EComProductService.dto.GenericProductDTO;
import com.capstone.EComProductService.dto.SortParams;
import com.capstone.EComProductService.model.Product;
import com.capstone.EComProductService.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<GenericProductDTO> searchProducts(String query, int pageNumber, int pageSize, List<SortParams> sortParams){

//        Sort sort = Sort.by("title").ascending()
//                .and(Sort.by("price").ascending())
//                .and(Sort.by("rating").descending())
//                .and(Sort.by("delievery_time").ascending());

        Sort sort = null;
        if(!sortParams.isEmpty()){
            if(sortParams.get(0).getSortType().equals("ASC"))
                sort = Sort.by(sortParams.get(0).getSortParamName()).ascending();
            else
                sort = Sort.by(sortParams.get(0).getSortParamName()).descending();

            for(int i=1; i<sortParams.size();i++){
                if(sortParams.get(i).getSortType().equals("ASC"))
                    sort.and(Sort.by(sortParams.get(i).getSortParamName()).ascending());
                else
                    sort.and(Sort.by(sortParams.get(i).getSortParamName()).descending());
            }
        }

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);

        List<Product> products = productRepository.findAllByTitleContainingIgnoreCase(query, pageRequest);
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();
        for(Product p : products){
            genericProductDTOS.add(GenericProductDTO.from(p));
        }
        return genericProductDTOS;
    }
}
