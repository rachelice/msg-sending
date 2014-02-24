package com.sunshineroad.system.resource.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sunshineroad.framework.support.entity.BaseEntity;

@Entity
@Table(name="MSP_RESOURCE")
public class ResourceModel extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String text;
	
	private String component;
	
	private String description;
	
	private String iconCls;
	
	private List<ResourceModel> children = new ArrayList<ResourceModel>();
	
	private ResourceModel parent;
	
	private Integer index;
	
	private String type;
	
	private String url;
	
	@Transient
	private boolean checked;
	
	@Id 
	//@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name="DESCRIPTON")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="ICONCLS")
	public String getIconCls() {
		return iconCls;
	}
	public void setUrl(String url) {
		// TODO Auto-generated method stub
		this.url= url;
	}
	@Column(name="URL")
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}

	public void setIconCls(String IconCls) {
		this.iconCls = IconCls;
	}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "PARENT_ID")
	@OrderBy("index asc")
	public List<ResourceModel> getChildren() {
		return children;
	}

	public void setChildren(List<ResourceModel> children) {
		this.children = children;
	}

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY )
    @JoinColumn(name = "PARENT_ID")
	@OrderBy("index asc")
	public ResourceModel getParent() {
		return parent;
	}

	public void setParent(ResourceModel parent) {
		this.parent = parent;
	}

	@Column(name="COMPONENT")
	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}
	
	@Column(name="TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="SORT")
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public boolean hasChildren(){
		return this.getChildren().size() > 0;
	}
	
	@Transient
	public boolean getLeaf(){
		return !this.hasChildren();
	}

	@Transient
	public boolean isChecked() {
		return checked;
	}

	@Transient
	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	
}
