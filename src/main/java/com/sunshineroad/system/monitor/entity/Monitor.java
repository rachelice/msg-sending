package com.sunshineroad.system.monitor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sunshineroad.framework.support.entity.BaseEntity;


@Entity
@Table(name="SYS_MONITOR")
public class Monitor extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 监控终端名称
	 */
	private String name;
	/**
	 * 监控代码
	 */
	private String terminal;
	/**
	 * 监控描述
	 */
	private String description;
	
	
	@Id
	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="TERMINAL")
	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
}
