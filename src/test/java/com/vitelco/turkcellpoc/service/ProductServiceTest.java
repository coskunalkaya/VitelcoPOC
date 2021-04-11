package com.vitelco.turkcellpoc.service;

import com.vitelco.turkcellpoc.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void getProductList() {
        List<Product> products = this.productService.getProductList();

        assertNotNull(products);
        assertEquals(1000, products.size());
    }

    @Test
    public void updateProductInfo() {
        Stream<String> s = Stream.of("gsmNo1", "gsmNo2");
        List<String> gsmList = s.collect(Collectors.toList());

        assertDoesNotThrow(() -> {
            this.productService.updateProductInfo(gsmList);
        });
     }

}
