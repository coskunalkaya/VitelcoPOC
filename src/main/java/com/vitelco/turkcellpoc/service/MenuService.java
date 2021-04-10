package com.vitelco.turkcellpoc.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vitelco.turkcellpoc.model.Menu;
import com.vitelco.turkcellpoc.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepository;

	public List<Menu> getMenuList() {
		List<Menu> menuList = new ArrayList<Menu>();
		menuRepository.findAll().forEach(menuList::add);
		return menuList;
	}

	public void addMenu(Menu menu) {
		try {
			menuRepository.save(new Menu(menu.getTitle()));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
