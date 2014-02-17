package com.sunshineroad.system.resource.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.TreeNode;
import com.sunshineroad.framework.util.TreeNodeJsonUtil;
import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.resource.entity.ResourceModel;
import com.sunshineroad.system.resource.service.ResourceService;
import com.sunshineroad.system.resource.vo.ResourceNode;

/**
 * omplatform
 * com.sunshineroad.system.resource.controller
 * @{#} ResourcesController.java Create on  2013-6-13 上午9:41:26
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：系统资源维护处理
 *
 */
@Controller
@RequestMapping("resources")
public class ResourcesController {

	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private ActionlogService actionlogService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list() throws Exception{
		HttpServletRequest request =WebUtils.getRequestByContext();
		String text=request.getParameter("text");
		ResourceNode node = new ResourceNode();
		if(StringUtils.isNotBlank(text)){
			node.setText("%"+text+"%");
		}

		return ResponseUtils.sendPagination(resourceService.list(node)) ;
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody ResourceNode node) throws Exception{	
		this.resourceService.update(NodeToModel(node));
		String actDesc="更新资源";
		actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody ResourceNode node) throws Exception{	
		this.resourceService.save(NodeToModel(node));
		String actDesc="新建资源";
		actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("添加成功",node.getId());
	}

	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody ResourceNode node) throws Exception{
		this.resourceService.delete(NodeToModel(node));
		String actDesc="删除资源";
		actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("删除成功");
	}
	
	private ResourceModel NodeToModel(ResourceNode node){
		ResourceModel model = new ResourceModel();
		model.setId(node.getId());
		model.setType(node.getType());
		model.setText(node.getText());
		model.setComponent(node.getComponent());
		model.setDescription(node.getDescription());
		model.setIconCls(node.getIconCls());
		model.setIndex(node.getIndex());
		model.setUrl(node.getUrl());
		
		if(node.getParent_id()!=null){
			ResourceModel parent = new ResourceModel();
			parent.setId(node.getParent_id());
			model.setParent(parent);
		}
		
		return model;
	}
	@RequestMapping(value="TreeJson",method=RequestMethod.GET)
	public @ResponseBody void TreeJson(HttpServletRequest request,HttpServletResponse response) throws Exception{

		String id=request.getParameter("id");
		if(null==id||id.length()==0){
			return ;
		}

		TreeNodeJsonUtil util = new TreeNodeJsonUtil();
		Integer roleid=Integer.valueOf(id);
		ResourceModel resource =new ResourceModel();
		resource.setId(0);
		resource.setType("");
		resource.setText("");
		resource.setComponent("");
		resource.setDescription("");
		resource.setIconCls("");
		resource.setIndex(0);
		resource.setUrl("");
		
		TreeNode node = ResourceNode.resource2TreeNode(resource);
		List<ResourceModel> resourceList =this.resourceService.getTreeResByRoleId(roleid);
		List<TreeNode> nodeList=ResourceNode.resourceList2TreeNodeList(resourceList);
		util.recursionNoRootFn(nodeList, node);
		String returnStr=util.modifyStr(resourceList.size());
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(returnStr);
		out.close();
	}
    
}
