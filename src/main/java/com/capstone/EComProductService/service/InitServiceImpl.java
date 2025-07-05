package com.capstone.EComProductService.service;

import com.capstone.EComProductService.model.Category;
import com.capstone.EComProductService.model.Order;
import com.capstone.EComProductService.model.Price;
import com.capstone.EComProductService.model.Product;
import com.capstone.EComProductService.repository.CategoryRepository;
import com.capstone.EComProductService.repository.OrderRepository;
import com.capstone.EComProductService.repository.PriceRepository;
import com.capstone.EComProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{

    private PriceRepository priceRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public InitServiceImpl(PriceRepository priceRepository, OrderRepository orderRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialise() {

        Category electronics = new Category();
        electronics.setCategoryName("Electronics");

        electronics = categoryRepository.save(electronics);

        Price priceIphone = new Price();
        priceIphone.setAmount(100000);
        priceIphone.setCurrency("INR");
        priceIphone.setDiscount(0);

        priceIphone = priceRepository.save(priceIphone);

        Price priceMacbook = new Price();
        priceMacbook.setAmount(300000);
        priceMacbook.setCurrency("INR");
        priceMacbook.setDiscount(0);

        priceMacbook = priceRepository.save(priceMacbook);

        Price priceWatch = new Price();
        priceWatch.setAmount(40000);
        priceWatch.setCurrency("INR");
        priceWatch.setDiscount(0);

        priceWatch = priceRepository.save(priceWatch);

        Price pricePS5 = new Price();
        pricePS5.setAmount(50000);
        pricePS5.setCurrency("INR");
        pricePS5.setDiscount(0);

        pricePS5 = priceRepository.save(pricePS5);

        Product iPhone = new Product();
        iPhone.setCategory(electronics);
        iPhone.setTitle("iPhone 13");
        iPhone.setImage("https://iphone.image");
        iPhone.setDescription("all new iPhone");
        iPhone.setPrice(priceIphone);
        iPhone = productRepository.save(iPhone);

        Product macBook = new Product();
        macBook.setCategory(electronics);
        macBook.setTitle("macBook air M3");
        macBook.setImage("https://macBook.image");
        macBook.setDescription("all new macBook");
        macBook.setPrice(priceMacbook);
        macBook = productRepository.save(macBook);

        Product watch = new Product();
        watch.setCategory(electronics);
        watch.setTitle("watch series 10");
        watch.setImage("https://watch.image");
        watch.setDescription("all new watch");
        watch.setPrice(priceWatch);
        watch = productRepository.save(watch);

        Product ps5 = new Product();
        ps5.setCategory(electronics);
        ps5.setTitle("PlayStation5");
        ps5.setImage("https://watch.image");
        ps5.setDescription("all new PS5");
        ps5.setPrice(pricePS5);
        ps5 = productRepository.save(ps5);

        Order order = new Order();
        order.setProducts(List.of(iPhone,macBook,watch));
        order = orderRepository.save(order);
    }
}
