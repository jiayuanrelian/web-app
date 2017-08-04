package com.huateng.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.huateng.model.Student;
/**
 * 登录的拦截器
 * @author zhuenran
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 登录的验证，如果返回ture则往下执行，如果返回false则终止执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("拦截器拦截到了........");
		Student student = (Student) request.getSession().getAttribute("student");
		if (null == student) {
			response.sendRedirect(request.getContextPath()+"/loginController/goLogin.do");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
