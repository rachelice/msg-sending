package com.sunshineroad.system.usersigned.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sunshineroad.framework.support.entity.BaseEntity;

@Entity
@Table(name="SYS_USERSIGNED")
public class Usersigned extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Date occurdate;
	
	private String occurday;
	
	private String occurtime;
	
	private String user_id;	
	
	private Timestamp timestamp;
	
	private String flag;
	
	private String scope;

	@Id
	@SequenceGenerator(name = "generator",sequenceName="TLM_USERSIGNED_ITEM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="OCCURDATE")
	public Date getOccurdate() {
		return occurdate;
	}

	public void setOccurdate(Date occurdate) {
		this.occurdate = occurdate;
	}
	
	@Column(name="TIMESTAMP")
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	@Column(name="USER_ID")
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Column(name="FLAG")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name="SCOPE")
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Column(name="OCCURTIME")
	public String getOccurtime() {
		return occurtime;
	}

	public void setOccurtime(String occurtime) {
		this.occurtime = occurtime;
	}

	@Column(name="OCCURDAY")
	public String getOccurday() {
		return occurday;
	}

	public void setOccurday(String occurday) {
		this.occurday = occurday;
	}

}
