package com.sunshineroad.system.resource.service;

import java.util.List;

import com.sunshineroad.system.resource.entity.ResourceModel;
import com.sunshineroad.system.resource.vo.ResourceNode;

public interface ResourceService {

	public List<ResourceNode> getRoot() throws Exception;
	
	public List<ResourceNode> getChildren(Integer id) throws Exception;

	public List<ResourceNode> list(ResourceNode node) throws Exception;

	public void delete(ResourceModel model) throws Exception;

	public void update(ResourceModel model) throws Exception;

	public void save(ResourceModel model) throws Exception;

	public List<ResourceModel> getTreeResByRoleId(Integer id) throws Exception;

	public List<ResourceModel> listByIds(Integer[] ids);
}
