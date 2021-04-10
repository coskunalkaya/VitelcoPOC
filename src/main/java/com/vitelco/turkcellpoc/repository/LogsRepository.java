package com.vitelco.turkcellpoc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vitelco.turkcellpoc.model.Logs;

public interface LogsRepository extends MongoRepository<Logs, String> {
}