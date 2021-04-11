package com.vitelco.turkcellpoc.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.vitelco.turkcellpoc.model.Product;

@Service
public interface ProductService {
	public List<Product> getProductList();
	@Async
	public CompletableFuture<Boolean> updateProductInfo(List<String> gsmNoList);	
}
