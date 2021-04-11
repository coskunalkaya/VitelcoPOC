package com.vitelco.turkcellpoc.service.seviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.vitelco.turkcellpoc.model.Product;
import com.vitelco.turkcellpoc.repository.ProductRepository;
import com.vitelco.turkcellpoc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<Product>();
		productRepository.findAll().forEach(productList::add);
		return productList;
	}

	@Async
	public CompletableFuture<Boolean> updateProductInfo(List<String> gsmNoList) {
		try {
			for (String gsmNo : gsmNoList) {
				Optional<Product> optProduct = productRepository.findByGsmNo(gsmNo);
				if (optProduct.isPresent()) {
					Product _product = optProduct.get();
					_product.setKisaNumara(generateRandomShortNumber());
					productRepository.save(_product);
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return CompletableFuture.completedFuture(false);
		}
		return CompletableFuture.completedFuture(true);
	}
	
	public String generateRandomShortNumber() {
		Random r = new Random();
		int low = 1;
		int high = 9999;
		int result = r.nextInt(high - low) + low;
		return String.format("%1$" + 4 + "s", result).replace(' ', '0');
	}

}
