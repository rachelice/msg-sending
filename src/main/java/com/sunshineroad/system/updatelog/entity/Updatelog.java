package com.sunshineroad.system.updatelog.entity;

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
@Table(name="SYS_UPDATELOG")
public class Updatelog extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String action;
	
	private Date occurdate;
	
	private String user_id;	
	
	private String table_name;
	
	private String key_value;
	
	private String old_value;
	
	private String new_value;
	
	private Timestamp timestamp;
	
	private String keys;
	
	private String columns;
	
	private String flag;

	@Id
	@SequenceGenerator(name = "generator",sequenceName="TLM_UPDATELOG_ITEM_SEQ")
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
	
	@Column(name="TABLE_NAME")
	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	
	@Column(name="KEY_VALUE")
	public String getKey_value() {
		return key_value;
	}

	public void setKey_value(String key_value) {
		this.key_value = key_value;
	}
	
	@Column(name="OLD_VALUE")
	public String getOld_value() {
		return old_value;
	}

	public void setOld_value(String old_value) {
		this.old_value = old_value;
	}
	
	@Column(name="NEW_VALUE")
	public String getNew_value() {
		return new_value;
	}

	public void setNew_value(String new_value) {
		this.new_value = new_value;
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

	@Column(name="KEYS")
	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	@Column(name="COLUMNS")
	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	@Column(name="FLAG")
	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	
}
