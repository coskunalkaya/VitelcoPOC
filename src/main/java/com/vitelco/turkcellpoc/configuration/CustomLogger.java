package com.vitelco.turkcellpoc.configuration;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.vitelco.turkcellpoc.model.Logs;

@Component
public class CustomLogger {

	@Autowired
	MongoTemplate mongoTemplate;

	public void info(String serviceName, String message) {
		Logs logs = new Logs();
		logs.setLevel("INFO");
		logs.setServiceName(serviceName);
		logs.setMessage(message);
		logs.setDate(new Date());
		mongoTemplate.insert(logs);
	}
}