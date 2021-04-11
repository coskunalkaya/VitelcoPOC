package com.vitelco.turkcellpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import com.vitelco.turkcellpoc.configuration.LoadData;
import com.vitelco.turkcellpoc.repository.MenuRepository;
import com.vitelco.turkcellpoc.repository.ProductRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TurkcellPocApplication implements ApplicationListener<ApplicationReadyEvent>{	
	public static void main(String[] args) {
		SpringApplication.run(TurkcellPocApplication.class, args);	
	}
	
	@Autowired
	MenuRepository menuRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		LoadData loadData = new LoadData();
		loadData.loadMenu(menuRepository);
		loadData.loadProduct(productRepository);	
	}
}
