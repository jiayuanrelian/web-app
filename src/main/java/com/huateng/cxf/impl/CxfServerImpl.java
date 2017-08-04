package com.huateng.cxf.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.google.gson.Gson;
import com.huateng.cxf.ICxfServer;
import com.huateng.model.Address;
import com.huateng.model.Person;
@WebService(endpointInterface="com.huateng.cxf.ICxfServer")
public class CxfServerImpl implements ICxfServer{

	@Override
	public String getPersonalInfo(String id) {
		Person person = new Person();
		person.setId(id);
		person.setName("小明");
		person.setSex("男");
		person.setAge(10);
		List<Address> addresses = new ArrayList<Address>();
		Address address1 = new Address("001", "河南省郑州市");
		Address address2 = new Address("002", "江苏省南京市");
		addresses.add(address1);
		addresses.add(address2);
		person.setAddresss(addresses);
		
		Gson gson = new Gson();
		String json = gson.toJson(person);
		return json;
	}

}
