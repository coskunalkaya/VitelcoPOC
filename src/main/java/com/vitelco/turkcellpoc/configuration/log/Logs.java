package com.vitelco.turkcellpoc.configuration.log;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "logs")
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Logs {
	
	@Id
	private String id;
	private Date date;
	private String method;
	private String path;
	private String statusCode;
	private String message;
	
}
