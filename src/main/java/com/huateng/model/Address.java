package com.huateng.model;

public class Address {

	private String id;
	
	private String addressDetail;

	
	public Address() {
		super();
	}
	
	public Address(String id, String addressDetail) {
		super();
		this.id = id;
		this.addressDetail = addressDetail;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressDetail=" + addressDetail + "]";
	}
	
	
}
