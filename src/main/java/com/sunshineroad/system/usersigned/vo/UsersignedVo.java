package com.sunshineroad.system.usersigned.vo;

import java.util.Date;

public class UsersignedVo {

	private Integer id;
	
	private Date occurdate;
	
	private String occurday;
	
	private String occurtime;
	
	private String user_id;	
	
	private String flag;
	
	private String scope;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOccurdate() {
		return occurdate;
	}

	public void setOccurdate(Date occurdate) {
		this.occurdate = occurdate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOccurday() {
		return occurday;
	}

	public void setOccurday(String occurday) {
		this.occurday = occurday;
	}

	public String getOccurtime() {
		return occurtime;
	}

	public void setOccurtime(String occurtime) {
		this.occurtime = occurtime;
	}

}
