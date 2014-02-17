package com.sunshineroad.system.role.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.resource.service.ResourceService;
import com.sunshineroad.system.role.entity.Role;
import com.sunshineroad.system.role.service.RoleService;
import com.sunshineroad.system.role.vo.RoleVo;

/**
 * omplatform
 * com.sunshineroad.system.role.controller
 * @{#} RoleController.java Create on  2013-6-13 上午9:43:11
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：系统角色维护
 *
 */

@Controller
@RequestMapping(value="roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private ActionlogService actionlogService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list(){
		return ResponseUtils.sendPagination(roleService.list()) ;
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody RoleVo rolevo) throws Exception{
		this.roleService.update(VoToRole(rolevo));
		//String actDesc="更新角色";
		//actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody RoleVo rolevo) throws Exception{
		rolevo.setId(this.roleService.getNextval("TLM_ROLE_ITEM_SEQ"));
		//String actDesc="新建角色";
		//actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("保存成功",this.roleService.save(VoToRole(rolevo)));
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody RoleVo rolevo) throws Exception{
		this.roleService.delete(VoToRole(rolevo));
		//String actDesc="删除角色";
		//actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("删除成功");
	}
	
	
	
	@RequestMapping(value="root",method=RequestMethod.GET)
	public @ResponseBody List<RoleVo> root() throws Exception{
		return this.roleService.getRoot();
	}

	private Role VoToRole(RoleVo vo) {
		Role role=new Role();
		role.setId(vo.getId());
		role.setCode(vo.getCode());
		role.setName(vo.getName());
		role.setRoleLevel(vo.getRoleLevel());
		role.setDescription(vo.getDescription());
		 
		String resourceIds= vo.getResourceId();
		if(StringUtils.isNotBlank(resourceIds)){
			String[] stringIds=resourceIds.split(",");
			int length = stringIds.length;
			Integer[] idResourceArray = new Integer[length];
			
			for(int i=0;i<length;i++){
				idResourceArray[i]=Integer.valueOf(stringIds[i]);
			}
			
			role.setResources(this.resourceService.listByIds(idResourceArray));
		}
	
		return role;		
	}
}
