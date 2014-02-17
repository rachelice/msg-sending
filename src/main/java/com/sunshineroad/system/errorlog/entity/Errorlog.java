package com.sunshineroad.system.errorlog.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sunshineroad.framework.support.entity.BaseEntity;
import com.sunshineroad.system.monitor.entity.Monitor;

@Entity
@Table(name="SYS_ERRORLOG")
public class Errorlog extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	//private String terminal;
	
	private Date occurdate;
	
	private String user_id;	
	
	private Date responsedate;
	
	private String description;
	
	private Timestamp timestamp;
		
	private Monitor monitor;
	
	private String dimension;
	
	private String flag;

	@Id	
	@SequenceGenerator(name = "generator",sequenceName="TLM_ELOG_ITEM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//@Column(name="TERMINAL")
/*	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}*/

	@Column(name="OCCURDATE")
	public Date getOccurdate() {
		return occurdate;
	}

	public void setOccurdate(Date date) {
		this.occurdate = date;
	}

	@Column(name="USER_ID")
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Column(name="RESPONSEDATE")
	public Date getResponsedate() {
		return responsedate;
	}

	public void setResponsedate(Date responsedate) {
		this.responsedate = responsedate;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="TIMESTAMP")
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp date) {
		this.timestamp = date;
	}
	 

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY )
	@JoinColumn(name="TERMINAL", referencedColumnName="TERMINAL")
	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
	@Column(name="DIMENSION")
	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	@Column(name="FLAG")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
