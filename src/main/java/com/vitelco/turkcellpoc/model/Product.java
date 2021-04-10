package com.vitelco.turkcellpoc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "product")
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	
	@Id
	private String id;	
	private String gsmNo;
	private String kullaniciAdi;
	private String hatTipi;
	private String hatDurumu;
	private String odemeTipi;
	private String kisaNumara;
	
	public Product(String gsmNo, String kullaniciAdi, String hatTipi, String hatDurumu, String odemeTipi,String kisaNumara) {
		this.gsmNo = gsmNo;
		this.kullaniciAdi = kullaniciAdi;
		this.hatTipi = hatTipi;
		this.hatDurumu = hatDurumu;
		this.odemeTipi = odemeTipi;
		this.kisaNumara = kisaNumara;
	}
}
