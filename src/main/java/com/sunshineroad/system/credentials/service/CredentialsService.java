package com.sunshineroad.system.credentials.service;

import java.util.List;

import com.sunshineroad.system.credentials.entity.Credentials;
import com.sunshineroad.system.credentials.vo.CredentialsVo;


public interface CredentialsService {

	public List<CredentialsVo> list();
	
	public void update(Credentials cre) throws Exception;
	
	public Integer save(Credentials cre) throws Exception;
	
	public void delete(Credentials cre) throws Exception;
	

}
