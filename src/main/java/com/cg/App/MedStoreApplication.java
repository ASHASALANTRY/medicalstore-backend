package com.cg.App;

import java.sql.Date;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.App.model.Product;
import com.cg.App.repository.ProductRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MedStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedStoreApplication.class, args);
	}
	// comment added for trial

//	@Bean
//	 CommandLineRunner run(ProductRepository productrepository){
//		return args -> IntStream.rangeClosed(1, 20).forEach(i->{
//			Product product = new Product();
//			product.setBatchNo(i+100);
//			product.setExpdate(Date.valueOf("2021-02-"+i));
//			product.setManufacturerName("manufacturer "+i);
//			product.setMfgDate(Date.valueOf("2022-03-"+i));
//			product.setPrice(i);
//			product.setProdName("product"+i);
//			productrepository.save(product);
//		});
//	}
		
	}
