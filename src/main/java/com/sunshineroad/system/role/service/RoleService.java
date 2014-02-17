package com.sunshineroad.system.role.service;

import java.util.List;

import com.sunshineroad.system.role.entity.Role;
import com.sunshineroad.system.role.vo.RoleVo;

public interface RoleService {

	public List<RoleVo> list();
	
	public void update(Role role) throws Exception;
	
	public Integer save(Role role) throws Exception;
	
	public void delete(Role role) throws Exception;

	public List<RoleVo> getRoot();

	public List<Role> listByIds(Integer[] ids);

	public Role getRoleById(Integer id);

	public Integer getNextval(String sequenceName);

}
