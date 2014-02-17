package com.sunshineroad.system.credentials.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sunshineroad.framework.support.entity.BaseEntity;

@Entity
@Table(name="SYS_CREDENTIALS")
public class Credentials extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String idtype;
	
	private String idname;	
	
	private Timestamp timestamp;

	@Id
	@SequenceGenerator(name = "generator",sequenceName="TLM_CREDEN_ITEM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="IDTYPE")
	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	
	@Column(name="IDNAME")
	public String getIdname() {
		return idname;
	}

	public void setIdname(String idname) {
		this.idname = idname;
	}
	
	@Column(name="TIMESTAMP")
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
