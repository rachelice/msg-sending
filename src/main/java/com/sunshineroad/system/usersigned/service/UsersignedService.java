package com.sunshineroad.system.usersigned.service;

import java.util.List;

import com.sunshineroad.system.usersigned.dao.UsersignedDao;
import com.sunshineroad.system.usersigned.entity.Usersigned;
import com.sunshineroad.system.usersigned.vo.UsersignedVo;


public interface UsersignedService {

	public List<UsersignedVo> list();
	
	public void update(Usersigned usersigned) throws Exception;
	
	public Integer save(Usersigned usersigned) throws Exception;
	
	public void delete(Usersigned usersigned) throws Exception;
	
	public UsersignedDao<Usersigned, Integer> getUsersignedDao();
	
	public boolean IsSigned(String user_ID,String occurday,String flag);
	
	public String getSelfLoginName();

}
