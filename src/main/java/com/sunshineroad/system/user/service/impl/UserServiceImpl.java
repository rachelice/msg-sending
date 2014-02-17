package com.sunshineroad.system.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sunshineroad.system.role.entity.Role;
import com.sunshineroad.system.user.dao.UserDao;
import com.sunshineroad.system.user.model.UserModel;
import com.sunshineroad.system.user.service.UserService;
import com.sunshineroad.system.user.vo.UserModelVo;

/**
 * omplatform
 * com.sunshineroad.system.user.service.impl
 * @{#} UserServiceImpl.java Create on  2013-6-13 上午9:45:01
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：系统用户
 *
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	protected static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Override
	public List<UserModelVo> list(UserModel userModel) {
		String username = userModel.getUsername();
		String loginName = userModel.getLoginName();
		if (username == null) {
			username = "";
		}
		if (loginName == null) {
			loginName = "";
		}
		username = "%" + username + "%";
		loginName = "%%" + loginName + "%";
		List<UserModel> boList = userDao
				.findPageByHql(
						" from UserModel  where username like ?  and loginName like ? ",
						username, loginName);
		List<UserModelVo> bfoList = new ArrayList<UserModelVo>();
		for (UserModel bo : boList) {
			bfoList.add(userModelToVo(bo));
		}
		return bfoList;
	}

	@Override
	public List<UserModelVo> loginUser() {
		List<UserModelVo> bfoList = new ArrayList<UserModelVo>();
		UserModel userModel = getSelfUserModelBy();
		bfoList.add(userModelToVo(userModel));
		return bfoList;
	}

	@Override
	public boolean existUser(String user_ID) {
		UserModel userModel = userDao.findByUsername(user_ID);
		if (userModel != null)
		{
			return true;
		}else{
			return false;
		}
	}

	private UserModelVo userModelToVo(UserModel userModel) {
		UserModelVo vo = new UserModelVo();
		vo.setId(userModel.getId());
		vo.setEmail(userModel.getEmail());
		vo.setPassword(userModel.getPassword());
		vo.setUsername(userModel.getUsername());
		vo.setLoginName(userModel.getLoginName());

		List<Role> roles = userModel.getRoles();
		if (roles != null) {
			StringBuffer roleIds = new StringBuffer();
			StringBuffer roleNames = new StringBuffer();
			for (Role role : roles) {
				roleIds.append(role.getId() + ",");
				roleNames.append(role.getName() + ",");
			}
			vo.setRoleName(roleNames.toString());
			vo.setRoleId(roleIds.toString());
		}

		/*
		 * List<Dept> depts=userModel.getDepts(); if(depts!=null){ StringBuffer
		 * deptIds= new StringBuffer(); StringBuffer deptNames= new
		 * StringBuffer(); for(Dept dept:depts){
		 * deptIds.append(dept.getId()+",");
		 * deptNames.append(dept.getDeptName()+","); }
		 * vo.setDeptId(deptIds.toString());
		 * vo.setDeptName(deptNames.toString()); }
		 */

		if (userModel.getNxbranch() != null) {
			vo.setDeptName(userModel.getNxbranch().getBrcname());
			vo.setDeptId(userModel.getNxbranch().getBrccode());
		}

		return vo;
	}

	@Override
	public void update(UserModel userModel) throws Exception {
		this.userDao.update(userModel);

	}

	@Override
	public Integer save(UserModel userModel) throws Exception {
		return this.userDao.save(userModel);

	}

	@Override
	public void delete(UserModel userModel) throws Exception {
		this.userDao.delete(userModel);

	}

	@Override
	public int getNextval(String sequenceName) {
		return userDao.getNextval(sequenceName);
	}

	@Override
	public UserModel getSelfUserModelBy() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String loginName = userDetails.getUsername();
		return userDao.findByUsername(loginName);
	}

	@Override
	public String getSelfLoginName() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername();
	}

}