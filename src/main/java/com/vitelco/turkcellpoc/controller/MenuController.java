package com.vitelco.turkcellpoc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitelco.turkcellpoc.configuration.CustomLogger;
import com.vitelco.turkcellpoc.model.Menu;
import com.vitelco.turkcellpoc.service.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Menu Api documentation")
public class MenuController {

    private final MenuService menuService;
    private final CustomLogger customLogger;

    public MenuController(MenuService menuService, CustomLogger customLogger) {
        this.menuService = menuService;
        this.customLogger = customLogger;
    }

	@ApiOperation(value = "Retrieving menu list method")
	@GetMapping("/getMenuList")
	public ResponseEntity<List<Menu>> getMenuList() {
		try {
			customLogger.info("getMenuList", null);
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
