package com.huateng.cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ICxfServer {

	@WebMethod
	public String getPersonalInfo(String id);
}
