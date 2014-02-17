package com.sunshineroad.system.dept.controller;


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
import com.sunshineroad.system.dept.entity.Dept;
import com.sunshineroad.system.dept.service.DeptService;
import com.sunshineroad.system.dept.vo.DeptVo;

@Controller
@RequestMapping(value="depts")
public class DeptController {
	
	@Autowired
	private DeptService deptService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list() throws Exception{
		System.out.println("=============");
		 HttpServletRequest request =WebUtils.getRequestByContext();
		 request.setCharacterEncoding("utf-8");
		String idStr=request.getParameter("id");
		String deptName="总行";
		Integer id=0;
		if(!StringUtils.isBlank(idStr)&&!idStr.equals("null")){
			id=Integer.valueOf(idStr);
			Dept dept =this.deptService.getDeptById(id);
			deptName=dept.getDeptName();
		}
		 List<DeptVo> list=deptService.list(id);
		 for(DeptVo vo:list){
			 vo.setParentDeptName((deptName));
		 }		
		return ResponseUtils.sendPagination(list) ;
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody Dept dept) throws Exception{
		this.deptService.update(dept);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody Dept dept) throws Exception{
		return ResponseUtils.sendSuccess("保存成功",this.deptService.save(dept));
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody Dept dept) throws Exception{
		this.deptService.delete(dept);
		return ResponseUtils.sendSuccess("删除成功");
	}
	
	
	
	@RequestMapping(value="root",method=RequestMethod.GET)
	public @ResponseBody List<TreeNode> root() throws Exception{
		 HttpServletRequest request =WebUtils.getRequestByContext();
			String id=request.getParameter("id"); 
		if(null==id||id.length()==0){
			return null;
		}else{
			Integer pid=Integer.valueOf(id);
			List<TreeNode> nodeList=DeptVo.deptList2TreeNodeList((this.deptService.getDeptBypId(pid)));
			
			return	nodeList;
			 
		}
		//return this.deptService.getRoot();
	}
	@RequestMapping(value="deptTreeJSON",method=RequestMethod.GET)
	public @ResponseBody void  deptTreeJSON(HttpServletRequest request,HttpServletResponse response) throws Exception{

		String id=request.getParameter("id"); 
		if(null==id||id.length()==0){
			return ;
		}
		TreeNodeJsonUtil util = new TreeNodeJsonUtil();
		Integer pid=Integer.valueOf(id);
		Dept dept =this.deptService.getDeptById(pid);
		if(null==dept){
			return ;
		}
		TreeNode node = DeptVo.dept2TreeNode(dept);
		
		List<Dept> deptList =this.deptService.getDeptBypId(pid);
		List<TreeNode> nodeList=DeptVo.deptList2TreeNodeList(deptList);
		util.recursionNoRootFn(nodeList, node);
		String returnStr=util.modifyStr(deptList.size());
		System.out.println("returnStr-------------------------"+returnStr);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(returnStr);
		out.close();
	// 	WebUtils.send(returnStr);
		//return  "{'count':'10','children': [{ 'id':1, 'text':'XX单位', 'node_type':0, 'full_name':'单位全名', 'phone':'0991-22334444', 'address':'地址', 'remark':'单位级别（总分公司）', 'iconCls':'icon-org-0', 'expanded': true, 'children':[{      'id':11,      'text':'XX管区',      'node_type':1,      'full_name':'XX管区',      'phone':'010-22334444',      'address':'地址',      'remark':'管区',      'expanded': true,      'iconCls':'icon-org-1',      'children':[{   'id':111,   'text':'XX公司',   'node_type':2,   'remark':'分公司',   'expanded': true,   'iconCls':'icon-org-2',   'children':[{       'id':30,       'text':'中小客户组',       'node_type':3,       'remark':'客户组',       'expanded': true,       'iconCls':'icon-org-3',       'children':[{    'id':112,    'text':'XX分销站',    'node_type':5,    'remark':'分销站',    'expanded': true,    'iconCls':'icon-org-4',    'children':[{        'id':21,        'text':'hg001',        'node_type':6,        'remark':'线路',        'leaf':true,        'iconCls':'icon-org-5'    },{        'id':20,        'text':'hg002',        'node_type':6,        'remark':'线路',        'leaf':true,        'iconCls':'icon-org-5'    }]       },{    'id':16,    'text':'XX分销站',    'node_type':5,    'remark':'分销站',    'leaf':true,    'iconCls':'icon-org-4'       }]   },{       'id':14,       'text':'重点客户组',       'node_type':3,       'remark':'客户组',       'leaf':true,       'iconCls':'icon-org-3'   },{       'id':13,       'text':'外埠客户组',       'node_type':3,       'remark':'客户组',       'leaf':true,       'iconCls':'icon-org-3'   }]      },{   'id':112,   'text':'XX公司',   'node_type':2,   'remark':'分公司',   'leaf':true,   'iconCls':'icon-org-2'      }]  },{      'id':12,      'text':'XX管区',      'node_type':1,      'remark':'管区',      'leaf':true,      'iconCls':'icon-org-1'  }]     }] }";
	}
	
}
