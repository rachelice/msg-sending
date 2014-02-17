package com.sunshineroad.system.nxbranch.service;

import java.util.List;

import com.sunshineroad.system.nxbranch.entity.Nxbranch;
import com.sunshineroad.system.nxbranch.vo.NxbranchVo;

public interface NxbranchService {

	public List<NxbranchVo> list();
	
	public void update(Nxbranch ulog) throws Exception;
	
	public Integer save(Nxbranch ulog) throws Exception;
	
	public void delete(Nxbranch ulog) throws Exception;

	public List<NxbranchVo> getRoot(String query);


}
