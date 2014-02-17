package com.sunshineroad.system.role.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.resource.entity.ResourceModel;
import com.sunshineroad.system.role.dao.RoleDao;
import com.sunshineroad.system.role.entity.Role;
import com.sunshineroad.system.role.service.RoleService;
import com.sunshineroad.system.role.vo.RoleVo;

/**
 * omplatform
 * com.sunshineroad.system.role.service.impl
 * @{#} RoleServiceImpl.java Create on  2013-6-13 上午9:42:20
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：系统角色
 *
 */

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao<Role, Integer> roleDao;

	public List<RoleVo> list() {
		List<Role>    boList= roleDao.findPageByHql(" from Role ");
		List<RoleVo>  bfoList=new ArrayList<RoleVo>();
		for(Role bo:boList){
			bfoList.add(RoleToVo(bo)); 		 
		}
		return bfoList;
	}
	private RoleVo RoleToVo(Role role) {
		 RoleVo vo=new RoleVo();
		 vo.setId(role.getId());
		 vo.setCode(role.getCode());
		 vo.setName(role.getName());
		 vo.setRoleLevel(role.getRoleLevel());
		 vo.setDescription(role.getDescription());
		 
		 List<ResourceModel> resources=role.getResources();
		 if(resources!=null){
			 StringBuffer resourceIds= new StringBuffer();
			 StringBuffer resourceNames= new StringBuffer();
			 for(ResourceModel resource:resources){	 
				 resourceIds.append(resource.getId()+",");
				 resourceNames.append(resource.getText()+",");
			 }
			 vo.setResourceId(resourceIds.toString());
			 vo.setResourceName(resourceNames.toString());
		 }
 
		 return vo;		
	}
	
	@Override
	public Role getRoleById(Integer id) {
		Role role=new Role();
		List<Role>    boList= roleDao.findPageByHql(" from Role where id = ? ",id);
		if(boList!=null&&boList.size()!=0){
			role=boList.get(0);
		}
		return role;
	}
	
	@Override
	public void update(Role role) throws Exception {
		roleDao.update(role);
	}

	@Override
	public Integer save(Role role) throws Exception {
		return roleDao.save(role);
	}

	@Override
	public void delete(Role role) throws Exception {
		roleDao.delete(role);
	}

	@Override
	public List<RoleVo> getRoot() {
		return	 ListUtils.transform(roleDao.findByHQL(" from Role "),
					RoleVo.class);
	}

	@Override
	public List<Role> listByIds(Integer[] ids) { 
		if(ids==null||ids.length==0){
			return null; 
		}
		return 	roleDao.findByIdsForHql(ids);
			
	}
	
	public Integer getNextval(String sequenceName){
		return roleDao.getNextval(sequenceName);
	}
}
