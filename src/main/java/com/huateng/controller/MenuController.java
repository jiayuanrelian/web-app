package com.huateng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huateng.model.Menu;
import com.huateng.services.IMenu;

@Controller
@RequestMapping(value="/menuController")
public class MenuController {

	@Autowired
	private IMenu iMenu;
	@RequestMapping(value="/selectAllMenus.do",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private List<Menu> selectAllMenus(){
		List<Menu> menus = iMenu.selectAllMenus();
		return menus;
	}
	
	@RequestMapping(value="/selectAllAccordionMenus.do",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private List<Menu> selectAllAccordionMenus(){
		List<Menu> accordionMenus = iMenu.selectAllAccordionMenus();
		return accordionMenus;
	}
	
	@RequestMapping(value="/selectChildMenus.do",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private List<Menu> selectChildMenus(@RequestParam(value="name")String name){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Menu> childMenus = iMenu.selectChildMenus(name);
		return childMenus;
	}
}
