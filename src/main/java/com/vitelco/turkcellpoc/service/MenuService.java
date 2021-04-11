package com.vitelco.turkcellpoc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vitelco.turkcellpoc.model.Menu;

@Service
public interface MenuService {
	public List<Menu> getMenuList();
}
