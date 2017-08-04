package com.huateng.exception;
/**
 * 自定义的业务异常
 * @author zhuenran
 *
 */
public class BusinessException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BusinessException(Object object){
		super(object.toString());
	}

}
