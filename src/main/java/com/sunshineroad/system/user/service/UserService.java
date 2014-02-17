package com.sunshineroad.system.user.service;

import java.util.List;

import com.sunshineroad.system.user.model.UserModel;
import com.sunshineroad.system.user.vo.UserModelVo;

public interface UserService   {

	public List<UserModelVo> list(UserModel userModel);	 
	
	public void update(UserModel userModel) throws Exception;
	
	public Integer save(UserModel userModel) throws Exception;
	
	public void delete(UserModel userModel) throws Exception;

	public UserModel getSelfUserModelBy();
	
	public String getSelfLoginName();

	public List<UserModelVo> loginUser();
	
	public boolean existUser(String userID);

	public int getNextval(String sequenceName);

}
