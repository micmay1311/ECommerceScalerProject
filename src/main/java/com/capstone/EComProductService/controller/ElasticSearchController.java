package com.capstone.EComProductService.controller;

import com.capstone.EComProductService.service.ElasticSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/apis")
public class ElasticSearchController {

    private ElasticSearchService elasticSearchService;

    public ElasticSearchController(ElasticSearchService elasticSearchService){
        this.elasticSearchService = elasticSearchService;
    }

    @GetMapping("/syncAll")
    public ResponseEntity<String> syncElasticSearchWithProduct() throws IOException {
        elasticSearchService.syncAll();
        return new ResponseEntity<>("Sync completed.", HttpStatus.OK);
    }
}
