package com.sunshineroad.system.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.nxbranch.entity.Nxbranch;
import com.sunshineroad.system.nxbranch.service.NxbranchService;
import com.sunshineroad.system.role.service.RoleService;
import com.sunshineroad.system.user.model.UserModel;
import com.sunshineroad.system.user.service.UserService;
import com.sunshineroad.system.user.vo.UserModelVo;

/**
 * omplatform
 * com.sunshineroad.system.user.controller
 * @{#} UsersController.java Create on  2013-6-13 上午9:46:33
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：系统用户维护
 *
 */

@Controller
@RequestMapping(value="users")
public class UsersController { 
	public UsersController(){
		System.out.println("UsersController...........................");
	}
	private static final Logger logger = Logger.getLogger(UsersController.class);
	@Autowired
	private RoleService roleService;
	
	/*@Autowired
	private DeptService deptService;*/
	
	@Autowired
	private NxbranchService nxbranchService;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private ActionlogService actionlogService;
    
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list( ){
		HttpServletRequest request =WebUtils.getRequestByContext();
		UserModel userModel= new UserModel();
		String username=request.getParameter("username");
		String loginName=request.getParameter("loginName");

		if(StringUtils.isNotBlank(username)){
			userModel.setUsername(username);
		}
		if(StringUtils.isNotBlank(loginName)){
			userModel.setLoginName(loginName);
		}
		return ResponseUtils.sendPagination(userService.list(userModel)) ;
	}
	
	@RequestMapping(value="nxbranchs",method=RequestMethod.GET)
	public @ResponseBody Object nxbranchs() throws Exception{
		HttpServletRequest request =WebUtils.getRequestByContext();
		//String query=new String(request.getParameter("query").getBytes("ISO-8859-1"),"UTF-8");
		String query=request.getParameter("query");
		logger.debug("usernxbranchs: "+query);
		return ResponseUtils.sendPagination(this.nxbranchService.getRoot(query.trim()));
		
	}
	
	@RequestMapping(value="roles",method=RequestMethod.GET)
	public @ResponseBody Object roles() throws Exception{
		return this.roleService.getRoot();
	}

	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody UserModelVo userModelVo) throws Exception{	
		this.userService.update(VoToUserModel(userModelVo));
		String actDesc="更新用户";
		actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody UserModelVo userModelVo) throws Exception{

		userModelVo.setId(this.userService.getNextval("TLM_USER_ITEM_SEQ"));
		if(!userService.existUser(userModelVo.getLoginName()))
			{
				String actDesc="新建用户";
				actionlogService.saveAlog("",actDesc,true,"");
				this.userService.save(VoToUserModel(userModelVo));
				return ResponseUtils.sendSuccess("添加成功",userModelVo.getId());
			}else{
				return ResponseUtils.sendFailure("登陆用户名已存在，请重新输入登录名！",userModelVo.getId());
			}


	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody UserModelVo userModelVo) throws Exception{
		this.userService.delete(VoToUserModel(userModelVo));
		String actDesc="删除用户";
		actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("删除成功");
	}

	private UserModel VoToUserModel(UserModelVo userModelVo)  throws Exception {
		UserModel userModel =new UserModel();
		PropertyUtils.copyProperties(userModel, userModelVo);

		String deptIds=userModelVo.getDeptId();
		if(StringUtils.isNotBlank(deptIds)){
			/*String[] stringIds=deptIds.split(",");
			int length = stringIds.length;
			Integer[] idArray = new Integer[length];
			
			for(int i=0;i<length;i++){
				idArray[i]=Integer.valueOf(stringIds[i]);
			}
			
			userModel.setDepts(this.deptService.listByIds(idArray));*/
			Nxbranch nxbranch=new Nxbranch();
			nxbranch.setBrccode(deptIds);
			nxbranch.setBrcname(userModelVo.getDeptName());
			
			userModel.setNxbranch(nxbranch);
		}
		
		String roleIds= userModelVo.getRoleId();
		if(StringUtils.isNotBlank(roleIds)){
			String[] stringIds=roleIds.split(",");
			int length = stringIds.length;
			Integer[] idRoleArray = new Integer[length];
			
			for(int i=0;i<length;i++){
				idRoleArray[i]=Integer.valueOf(stringIds[i]);
			}
			
			userModel.setRoles(this.roleService.listByIds(idRoleArray));
		}
		 
		return userModel;		
	}

	public UserModel getSelfUserModel(){

		// HttpServletRequest request =WebUtils.getRequestByContext();
	
		//UserService userService = (UserService)SpringContextUtil.getBean("userServiceImpl");
		return 	userService.getSelfUserModelBy();
	}
}
