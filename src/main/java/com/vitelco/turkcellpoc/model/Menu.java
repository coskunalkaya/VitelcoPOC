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

@Document(collection = "menu")
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="Menu API model", description= "Model")
public class Menu {
	
	@Id
	@ApiModelProperty(value="Menu id field for Menu model")
	private String id;
	
	@ApiModelProperty(value="Menu title field for Menu model")
	private String title;
	
	public Menu(String title) {
		this.title = title;
	}
	
}
