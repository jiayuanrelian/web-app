package com.huateng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="gzEventController")
public class GzEventController {

	@RequestMapping(value="/goGzEvent.do",method=RequestMethod.GET)
	public String goGzEvent(){
		return "gzEvent";
	}
}
