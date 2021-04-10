package com.vitelco.turkcellpoc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vitelco.turkcellpoc.model.Menu;

public interface MenuRepository extends MongoRepository<Menu, String>{

}
