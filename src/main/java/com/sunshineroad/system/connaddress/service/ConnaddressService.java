package com.sunshineroad.system.connaddress.service;

import java.util.List;

import com.sunshineroad.system.connaddress.entity.Connaddress;
import com.sunshineroad.system.connaddress.vo.ConnaddressVo;


public interface ConnaddressService {

	public List<ConnaddressVo> list();
	
	public List<Connaddress> findByType(String type);
	
	public void update(Connaddress connaddr) throws Exception;
	
	public Integer save(Connaddress connaddr) throws Exception;
	
	public void delete(Connaddress connaddr) throws Exception;
	
}
