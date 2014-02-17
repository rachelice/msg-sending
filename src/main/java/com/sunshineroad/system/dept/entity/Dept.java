package com.sunshineroad.system.dept.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.userdetails.User;

import com.sunshineroad.framework.support.entity.BaseEntity;
import com.sunshineroad.system.resource.entity.ResourceModel;


@Entity
@Table(name="SYS_DEPT")
public class Dept extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private Integer id;

	private String deptName;
	/**
	 * 代码
	 */
	private String deptCode;
	/**
	 * 描述
	 */
	private String description;
 
	
	private String deptLevel;
	
	
	private Integer parentId;

	private String address;
	
	private String email;
	
	private String leaf;
	
	private Integer orderIndex;
	
	private Integer manager;
	
	
private List<User> users;
	

	public Dept(){
		
	}
	@Id 
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="DEPT_NAME")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name="DEPT_CODE")
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(targetEntity=ResourceModel.class,fetch=FetchType.LAZY)
	@JoinTable(name="SYS_USER_DEPT",joinColumns=@JoinColumn(name = "DEPT_ID"),inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	@Fetch(FetchMode.SUBSELECT)
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Column(name="DEPT_LEVEL")
	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	@Override
	public String toString() {
		return this.deptCode;
	}
	@Column(name="PARENT_ID")
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="LEAF")
	public String getLeaf() {
		return leaf;
	}
	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	@Column(name="ORDERINDEX")
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	
	@Column(name="MANAGER")
	public Integer getManager() {
		return manager;
	}
	public void setManager(Integer manager) {
		this.manager = manager;
	}

	
}
