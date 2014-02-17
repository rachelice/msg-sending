package com.sunshineroad.system.actionlog.entity;

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
@Table(name="SYS_ACTIONLOG")
public class Actionlog extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String action;
	
	private Date occurdate;
	
	private String user_id;	
	
	private Timestamp timestamp;
	
	private String status;
	
	private String comments;

	@Id
	@SequenceGenerator(name = "generator",sequenceName="TLM_ACTIONLOG_ITEM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="ACTION")
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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
	
	@Column(name="STATUS")
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Column(name="COMMENTS")
	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

}
