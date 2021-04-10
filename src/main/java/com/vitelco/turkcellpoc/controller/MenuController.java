package com.vitelco.turkcellpoc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitelco.turkcellpoc.configuration.CustomLogger;
import com.vitelco.turkcellpoc.model.Menu;
import com.vitelco.turkcellpoc.service.MenuService;

@RestController
@RequestMapping("/api")
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@Autowired
	CustomLogger customLogger;

	@GetMapping("/getMenuList")
	public ResponseEntity<List<Menu>> getMenuList() {
		try {			
			//customLogger.info("getMenuList", null);
			
			List<Menu> menuList = new ArrayList<Menu>();			
			menuList = menuService.getMenuList();			

			if (menuList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(menuList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
