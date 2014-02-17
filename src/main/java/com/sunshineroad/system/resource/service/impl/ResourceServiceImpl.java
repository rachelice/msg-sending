package com.sunshineroad.system.resource.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.resource.dao.ResourceDAO;
import com.sunshineroad.system.resource.entity.ResourceModel;
import com.sunshineroad.system.resource.service.ResourceService;
import com.sunshineroad.system.resource.vo.ResourceNode;
import com.sunshineroad.system.role.entity.Role;
import com.sunshineroad.system.role.service.RoleService;
import com.sunshineroad.system.user.model.UserModel;
import com.sunshineroad.system.user.service.UserService;

/**
 * omplatform
 * com.sunshineroad.system.resource.service.impl
 * @{#} ResourceServiceImpl.java Create on  2013-6-13 上午9:40:14
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：系统资源
 *
 */

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected ResourceDAO<ResourceModel, Integer> resourceDAO;
	
	@Autowired
	private UserService userService;
		
	@Autowired
	private RoleService roleService;

	public List<ResourceModel> resources;
	
	@Override
	public List<ResourceNode> list(ResourceNode renode) throws Exception {
		List<ResourceModel>  modelList;
		if(StringUtils.isNotBlank(renode.getText())){
			modelList= resourceDAO.findPageByHql(" from ResourceModel where text like ? ",renode.getText());
		}else{
			modelList= resourceDAO.findPageByHql(" from ResourceModel ");
		}
		
		List<ResourceNode>  nodeList=new ArrayList<ResourceNode>();
		for(ResourceModel model:modelList){
			ResourceNode node = new ResourceNode();
			node.setId(model.getId());
			node.setType(model.getType());
			node.setText(model.getText());
			node.setComponent(model.getComponent());
			node.setDescription(model.getDescription());
			node.setIconCls(model.getIconCls());
			node.setIndex(model.getIndex());
			node.setUrl(model.getUrl());
			if(model.getParent()!=null){
				node.setParent_id(model.getParent().getId());
			}else{
				node.setParent_id(0);
			}
			nodeList.add(node); 		 
		}		 
		return nodeList;
	}
	
	@Override
	public List<ResourceNode> getRoot() throws Exception {
		//取得用户的权限		
		getUserResources();
		
		List<ResourceModel> parents = new ArrayList<ResourceModel>();
		for (ResourceModel res : resources) {			
			if(res.getType().equalsIgnoreCase("PANEL")){
				parents.add(res);
			}
		}
		return ListUtils.transform(parents,ResourceNode.class);
	}
	
	public List<ResourceNode> getChildren(Integer id) throws Exception{
		List<ResourceModel> childs = new ArrayList<ResourceModel>();
		for (ResourceModel resource : resources) {
			if(resource.getParent()!= null &&
				resource.getParent().getId().equals(id)){
				childs.add(resource);
			}
		}
		return ListUtils.transform(childs,ResourceNode.class);
	}
	
	@Override
	public void update(ResourceModel model) throws Exception {
		this.resourceDAO.update(model);	
	}
	
	@Override
	public void save(ResourceModel model) throws Exception {
		this.resourceDAO.save(model);	
	}

	@Override
	public void delete(ResourceModel model) throws Exception {
		this.resourceDAO.delete(model);	
	}

	@Override
	public List<ResourceModel> getTreeResByRoleId(Integer id) throws Exception {
		List<ResourceModel>  listAll=resourceDAO.findByHQL(" from ResourceModel");
		List<ResourceModel>  listRole=roleService.getRoleById(id).getResources();
		if(listRole != null){
			for(ResourceModel res:listAll){
				for(ResourceModel temp:listRole){
					if(res.getId()==temp.getId()){
						res.setChecked(true);
						break;
					}
				}
			}
		}

		return listAll;
	}
	
	public List<ResourceModel> listByIds(Integer[] ids){
		if(ids==null||ids.length==0){
			return null; 
		}

		return 	resourceDAO.findByIdsForHql(ids);
	}
	
	private List<ResourceModel> getUserResources(){
		resources = new ArrayList<ResourceModel>();
		UserModel userModel = this.userService.getSelfUserModelBy();
		List<Role> roles =  userModel.getRoles();
		boolean flag;
		for (Role role : roles) {
			List<ResourceModel> tempRes = role.getResources();
			for (ResourceModel tempres : tempRes) {
				flag = false;
				for (ResourceModel res : resources) {
					if(tempres.getId()== res.getId()){
						flag = true;
						break;
					}	
				}
				if(!flag){
					resources.add(tempres);
				}
			}
		}		
		return resources;
	}
	
}
