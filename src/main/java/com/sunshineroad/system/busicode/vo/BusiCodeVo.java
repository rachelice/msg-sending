package com.sunshineroad.system.busicode.vo;

import java.math.BigDecimal;


public class BusiCodeVo {
	
	private BigDecimal id;

	private String action;
	
	private String businessname;
	
	private String businesstype;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}
	
	

}