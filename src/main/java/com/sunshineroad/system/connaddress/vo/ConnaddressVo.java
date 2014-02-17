package com.sunshineroad.system.connaddress.vo;

import java.sql.Timestamp;


public class ConnaddressVo {

	private Integer id;

	private String type;
	
	private String ipaddress;
	
	private String account;	
	
	private String password;
	
	private String user_id;
	
	private String commands;
	
	private String description;
	
	private String parameters;
	
	private Timestamp timestamp;
	
	private boolean ipaddresschg;

	private boolean accountchg;
	
	private boolean passwordchg;	
	
	public boolean isIpaddresschg()
	{
		return ipaddresschg;
	}

	public void setIpaddresschg(boolean ipaddresschg)
	{
		this.ipaddresschg = ipaddresschg;
	}

	public boolean isAccountchg()
	{
		return accountchg;
	}

	public void setAccountchg(boolean accountchg)
	{
		this.accountchg = accountchg;
	}

	public boolean isPasswordchg()
	{
		return passwordchg;
	}

	public void setPasswordchg(boolean passwordchg)
	{
		this.passwordchg = passwordchg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getParameters()
	{
		return parameters;
	}

	public void setParameters(String parameters)
	{
		this.parameters = parameters;
	}

}
