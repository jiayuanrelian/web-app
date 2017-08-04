package com.huateng.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.dao.mapper.MenuMapper;
import com.huateng.model.Menu;
import com.huateng.services.IMenu;
@Service
public class MenuImpl implements IMenu{

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> selectAllMenus() {
		List<Menu> menus = menuMapper.selectAllMenus();
		Map<Integer, Menu> map = new HashMap<Integer, Menu>();
		//第一次遍历遍历出第一层菜单项
		for (Menu menu : menus) {
			if (menu.getPid()==0) {
				map.put(menu.getId(), menu);
				menus.remove(menu);
				//第二次遍历遍历出第二层菜单项
				for (Menu menu1 : menus) {
					Integer pid = menu1.getPid();
					if (map.containsKey(pid)) {
						map.get(pid).getMenus().add(menu1);
						menus.remove(menu1);
					}
				}
			}
		}
		return menuMapper.selectAllMenus();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Menu> selectAllAccordionMenus() {
		return menuMapper.selectAllAccordionMenus();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Menu> selectChildMenus(String name) {
		return menuMapper.selectChildMenus(name);
	}
	
}
