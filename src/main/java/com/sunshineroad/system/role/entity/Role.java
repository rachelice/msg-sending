package com.sunshineroad.system.role.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sunshineroad.framework.support.entity.BaseEntity;
import com.sunshineroad.framework.support.matchrule.annotation.MatchRule;
import com.sunshineroad.framework.support.matchrule.annotation.Rule;
import com.sunshineroad.system.resource.entity.ResourceModel;


@Entity
@Table(name="MSP_ROLE")
public class Role extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 角色名称
	 */
	@MatchRule({@Rule(name="name")})
	private String name;
	/**
	 * 角色代码
	 */
	private String code;
	/**
	 * 角色描述
	 */
	private String description;
	
	/**
	 * 该角色对应的资源菜单
	 */
	private List<ResourceModel> resources;
	

	
	private String roleLevel;

	public Role(){
		
	}
	
	
	@Id 
	//@SequenceGenerator(name = "generator",sequenceName="TLM_ROLE_ITEM_SEQ")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
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

	@Column(name="CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(targetEntity=ResourceModel.class,fetch=FetchType.LAZY)
	@JoinTable(name="MSP_ROLE_RESOURCE",joinColumns=@JoinColumn(name = "ROLE_ID"),inverseJoinColumns = @JoinColumn(name = "RESOURCE_ID"))
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("index asc")
	public List<ResourceModel> getResources() {
		return resources;
	}

	public void setResources(List<ResourceModel> resources) {
		this.resources = resources;
	}

	@Column(name="ROLE_LEVEL")
	public String getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

	@Override
	public String toString() {
		return this.code;
	}

	
}
