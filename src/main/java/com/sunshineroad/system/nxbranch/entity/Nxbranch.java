package com.sunshineroad.system.nxbranch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sunshineroad.framework.support.entity.BaseEntity;

@Entity
@Table(name="PUBBRANCHINFO")
public class Nxbranch extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String brccode;
	
	private String brcname;
	

	@Id
	@Column(name="BRCCODE")
	public String getBrccode() {
		return brccode;
	}

	public void setBrccode(String brccode) {
		this.brccode = brccode;
	}
	
	@Column(name="BRCNAME")
	public String getBrcname() {
		return brcname;
	}

	public void setBrcname(String brcname) {
		this.brcname = brcname;
	}


}
