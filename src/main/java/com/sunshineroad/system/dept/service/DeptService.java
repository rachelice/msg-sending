package com.sunshineroad.system.dept.service;



import java.util.List;

import com.sunshineroad.system.dept.entity.Dept;
import com.sunshineroad.system.dept.vo.DeptVo;

public interface DeptService {

	public List<DeptVo> list(Integer id);
	
	public List<Dept> listByIds(Integer[] ids);
	
	public void update(Dept dept) throws Exception;
	
	public Dept getDeptById(Integer id) throws Exception;
	
	public  List<Dept> getDeptBypId(Integer pid) throws Exception;
	
	public Integer save(Dept dept) throws Exception;
	
	public void delete(Dept dept) throws Exception;

	public List<DeptVo> getRoot();

}
