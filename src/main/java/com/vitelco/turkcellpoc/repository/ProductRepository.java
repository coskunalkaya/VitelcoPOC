package com.vitelco.turkcellpoc.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vitelco.turkcellpoc.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	Optional<Product> findByGsmNo(String gsmNo);

}
