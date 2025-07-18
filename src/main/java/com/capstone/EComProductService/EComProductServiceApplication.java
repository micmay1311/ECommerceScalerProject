package com.capstone.EComProductService;

import com.capstone.EComProductService.service.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EComProductServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EComProductServiceApplication.class, args);
	}

	public EComProductServiceApplication(InitService initService) {
		this.initService = initService;
	}

	public InitService initService;


	@Override
	public void run(String... args) throws Exception {

		//initService.initialise();


	}
}
