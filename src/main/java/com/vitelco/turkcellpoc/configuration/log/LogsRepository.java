package com.vitelco.turkcellpoc.configuration.log;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogsRepository extends MongoRepository<Logs, String> {
}