package com.sunshineroad.system.updatelog.service;

import java.util.List;

import com.sunshineroad.system.updatelog.dao.UpdatelogDao;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.vo.UpdatelogVo;


public interface UpdatelogService {

	public List<UpdatelogVo> list(UpdatelogVo updatelogVo);
	
	public List<Updatelog> findRecord(String table,String keys,String keyvalue,String flag);
	
	public void update(Updatelog ulog) throws Exception;
	
	public Integer save(Updatelog ulog) throws Exception;
		
	public void delete(Updatelog ulog) throws Exception;
	
	public UpdatelogDao<Updatelog, Integer> getUpdatelogDao();

	public Integer saveUlog(Updatelog ulog) throws Exception;

}
