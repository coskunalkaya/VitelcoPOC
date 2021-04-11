package com.vitelco.turkcellpoc.service.seviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vitelco.turkcellpoc.model.Menu;
import com.vitelco.turkcellpoc.repository.MenuRepository;
import com.vitelco.turkcellpoc.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuRepository menuRepository;

	public List<Menu> getMenuList() {
		List<Menu> menuList = new ArrayList<Menu>();
		menuRepository.findAll().forEach(menuList::add);
		return menuList;
	}
}
