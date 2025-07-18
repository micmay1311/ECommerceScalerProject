package com.capstone.EComProductService.repository;

import com.capstone.EComProductService.model.SearchProduct;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

//public interface ElasticSearchProductRepository extends ElasticsearchRepository<SearchProduct, UUID> {
public interface ElasticSearchProductRepository{
    //List<SearchProduct> findByDescriptionContainingOrNameContaining(String desc, String name);
}
