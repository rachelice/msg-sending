package com.sunshineroad.system.monitor.service;

import java.util.List;

import com.sunshineroad.system.monitor.entity.Monitor;
import com.sunshineroad.system.monitor.vo.MonitorVo;

public interface MonitorService {

	public List<MonitorVo> list();
	
	public List<MonitorVo> getRoot();
	
	public void update(Monitor monitor) throws Exception;
	
	public Integer save(Monitor monitor) throws Exception;
	
	public void delete(Monitor monitor) throws Exception;


}
