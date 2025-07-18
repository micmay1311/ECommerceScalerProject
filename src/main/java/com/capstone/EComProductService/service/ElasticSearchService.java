package com.capstone.EComProductService.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.capstone.EComProductService.model.Product;
import com.capstone.EComProductService.model.SearchProduct;
import com.capstone.EComProductService.repository.ProductRepository;
import com.capstone.EComProductService.repository.ElasticSearchProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElasticSearchService {

    private ProductRepository productRepository;
   // private ElasticSearchProductRepository elasticSearchProductRepository;
    private final ElasticsearchClient elasticsearchClient;

    public ElasticSearchService(ProductRepository productRepository, ElasticsearchClient elasticsearchClient){
        this.productRepository=productRepository;
        //this.elasticSearchProductRepository=elasticSearchProductRepository;
        this.elasticsearchClient=elasticsearchClient;
    }

    public void syncAll() throws IOException {
        List<Product> products = productRepository.findAll();
        List<SearchProduct> searchProducts = products.stream().map(product -> {
            SearchProduct s = new SearchProduct();
            s.setId(product.getId());
            s.setName(product.getTitle());
            s.setCategory(product.getCategory().getCategoryName());
            s.setPrice(product.getPrice().getAmount());
            s.setDescription(product.getDescription());
            return s;
        }).collect(Collectors.toList());

        //elasticSearchProductRepository.saveAll(searchProducts);
        saveAllProduct(products);



    }

    public void saveAllProduct(List<Product> products) throws IOException {
        for (Product product : products) {
            IndexResponse response = elasticsearchClient.index(IndexRequest.of(i -> i
                    .index("products") // Make sure this matches your index name
                    .id(String.valueOf(product.getId()))
                    .document(product)
            ));

            //System.out.println("Indexed product ID: " + product.getId() + ", result: " + response.result());
        }

    }

}
