package com.huateng.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huateng.model.Student;
import com.huateng.services.IStudent;

/**
 * 测试的控制类
 * @author zhuenran
 *
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {
	
	@Autowired
	private IStudent iStudent;

	@RequestMapping(value="/testMethod.do",method=RequestMethod.GET)
	public String testMethod(@RequestParam(value="id")String id){
		System.out.println("hello");
		System.out.println(id);
		return "new";
	}
	/*
	 * 登录请求
	 */
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(@RequestParam(value="name")String name,@RequestParam(value="password")String password,
			HttpServletRequest request){
		Student student = iStudent.login(name,password);
		if (null != student) {
			request.getSession().setAttribute("student", student);
			return "welcome";
		} 
		return "login";
	}
	
	/*
	 * 跳转到登录页面
	 */
	@RequestMapping(value="goLogin.do",method=RequestMethod.GET)
	public String goLogin(){
		return "login";
	}
	
	/*
	 * 跳转到规则引擎配置页面
	 */
	@RequestMapping(value="goDrools.do",method=RequestMethod.GET)
	public String goDrools(){
		return "drools";
	}
	
	/*
	 * 跳转到欢迎页面
	 */
	@RequestMapping(value="goWelcome.do",method=RequestMethod.GET)
	public String goWelcome(){
		return "welcome";
	}
}
