package com.vitelco.turkcellpoc.configuration;

import java.util.ArrayList;
import java.util.List;
import com.vitelco.turkcellpoc.model.Menu;
import com.vitelco.turkcellpoc.model.Product;
import com.vitelco.turkcellpoc.repository.MenuRepository;
import com.vitelco.turkcellpoc.repository.ProductRepository;

public class LoadData {

	public void loadMenu(MenuRepository menuRepository) {
		List<Menu> menuList = new ArrayList<Menu>();
		menuRepository.findAll().forEach(menuList::add);
		if (menuList.isEmpty()) {
			try {
				menuRepository.save(new Menu("Fatura İşlemleri"));
				menuRepository.save(new Menu("Tarife İşlemleri"));
				menuRepository.save(new Menu("Paket İşlemleri"));
				menuRepository.save(new Menu("Hat İşlemleri"));
				menuRepository.save(new Menu("Ayarlar"));
				menuRepository.save(new Menu("Ürün ve Servisler"));
				menuRepository.save(new Menu("Faturasız Hat İşlemleri"));
				menuRepository.save(new Menu("Yetkili ve Kullanıcı İşlemleri"));
				menuRepository.save(new Menu("Raporlama Merkezi"));
				menuRepository.save(new Menu("İştecep Kampanyası"));
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	public void loadProduct(ProductRepository productRepository) {		
		List<Product> productList = new ArrayList<Product>();
		productRepository.findAll().forEach(productList::add);
		if (productList.isEmpty()) {
			for (int i = 1; i <= 1000; i++) {
				productRepository.save(
						new Product("gsmNo" + i, "kullaniciAdi" + i, "hatTipi", "hatDurumu", "odemeTipi", null));
			}
		}
	}
}
