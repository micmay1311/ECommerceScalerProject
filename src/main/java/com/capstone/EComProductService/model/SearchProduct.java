package com.capstone.EComProductService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Setter
@Getter
//@Document(indexName = "products")
public class SearchProduct {

    @Id
    private UUID id;
    private String name;
    private String category;
    private String description;
    private double price;
}
