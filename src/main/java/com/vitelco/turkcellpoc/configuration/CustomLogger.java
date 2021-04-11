package com.vitelco.turkcellpoc.configuration;

import java.util.Date;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.vitelco.turkcellpoc.model.Logs;

@Component
public class CustomLogger {

	private final MongoTemplate mongoTemplate;

	public CustomLogger(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void info(String serviceName, String message) {
		Logs logs = new Logs();
		logs.setLevel("INFO");
		logs.setServiceName(serviceName);
		logs.setMessage(message);
		logs.setDate(new Date());
		mongoTemplate.insert(logs);
	}
}