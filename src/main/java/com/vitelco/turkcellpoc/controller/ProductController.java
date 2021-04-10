package com.vitelco.turkcellpoc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitelco.turkcellpoc.configuration.CustomLogger;
import com.vitelco.turkcellpoc.model.Product;
import com.vitelco.turkcellpoc.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CustomLogger customLogger;

	@GetMapping("/getProductList")
	public ResponseEntity<List<Product>> getProductList() {
		try {
			//customLogger.info("getProductList", null);

			List<Product> productList = new ArrayList<Product>();
			productList = productService.getProductList();

			if (productList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(productList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateProductInfo")
	public ResponseEntity<String> updateProductInfo(@RequestBody List<String> gsmNoList) {		
		//customLogger.info("getProductList","Income Params : " + Arrays.toString(gsmNoList.toArray()));

		if (!gsmNoList.isEmpty()) {
			productService.updateProductInfo(gsmNoList);
			return new ResponseEntity<>("Update Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
