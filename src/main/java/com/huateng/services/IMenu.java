package com.huateng.services;

import java.util.List;

import com.huateng.model.Menu;

public interface IMenu {

	public List<Menu> selectAllMenus();
	
	public List<Menu> selectAllAccordionMenus();
	
	public List<Menu> selectChildMenus(String name);
}
