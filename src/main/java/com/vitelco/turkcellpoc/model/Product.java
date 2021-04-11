package com.vitelco.turkcellpoc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="Product API model", description= "Model")
public class Product {
	
	
	@Id
	@ApiModelProperty(value="Unique Product id field for Product model")
	private String id;	
	@ApiModelProperty(value="gsmNo field for Product model")
	private String gsmNo;
	@ApiModelProperty(value="kullaniciAdi field for Product model")	
	private String kullaniciAdi;
	@ApiModelProperty(value="hatTipi field for Product model")	
	private String hatTipi;
	@ApiModelProperty(value="hatDurumu field for Product model")	
	private String hatDurumu;
	@ApiModelProperty(value="odemeTipi field for Product model")	
	private String odemeTipi;
	@ApiModelProperty(value="kisaNumara field for Product model")	
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
