package com.sunshineroad.framework.util;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeJsonUtil {
	private StringBuffer returnStr=new StringBuffer();       
	    public void recursionFn(List<TreeNode> list , TreeNode node){       
			   	  returnStr.append("{'id':");     
		          returnStr.append(node.getId());     
		          returnStr.append(",'parentId':");     
		          returnStr.append(node.getParentId());
		          returnStr.append(",'checked':");
		          returnStr.append(node.isChecked());
		          returnStr.append(",'expanded':");
		          returnStr.append(node.isExpanded());
		          returnStr.append(",'text':'");
		          returnStr.append(node.getText()==null?"":WebUtils.getUTF8String(node.getText()));
		          returnStr.append("','str8':'");
		          returnStr.append(node.getStr8()==null?"":WebUtils.getUTF8String(node.getStr8()));
		          returnStr.append("','str7':'");
		          returnStr.append(node.getStr7()==null?"":WebUtils.getUTF8String(node.getStr7()));
		          returnStr.append("','str6':'");
		          returnStr.append(node.getStr6()==null?"":WebUtils.getUTF8String(node.getStr6()));
		          returnStr.append("','str5':'");
		          returnStr.append(node.getStr5()==null?"":WebUtils.getUTF8String(node.getStr5()));
		          returnStr.append("','str4':'");
		          returnStr.append(node.getStr4()==null?"":WebUtils.getUTF8String(node.getStr4()));
		          returnStr.append("','str3':'");
		          returnStr.append(node.getStr3()==null?"":WebUtils.getUTF8String(node.getStr3()));
		          returnStr.append("','str2':'");
		          returnStr.append(node.getStr2()==null?"":WebUtils.getUTF8String(node.getStr2()));
		          returnStr.append("','str1':'");
		          returnStr.append(node.getStr1()==null?"":WebUtils.getUTF8String(node.getStr1()));
	        
		            returnStr.append("','int4':");
		            returnStr.append(node.getInt4()==null?0:node.getInt4());
		            returnStr.append(",'int3':");
		            returnStr.append(node.getInt3()==null?0:node.getInt3());
		            returnStr.append(",'int2':");
		            returnStr.append(node.getInt2()==null?0:node.getInt2());
		            returnStr.append(",'int1':");
		            returnStr.append(node.getInt1()==null?0:node.getInt1());
		            returnStr.append(",'index':");
		            returnStr.append(node.getIndex()==null?0:node.getIndex());
		        if(hasChild(list,node)){       
	          
	            
	            returnStr.append(",'children':[");       
	            List<TreeNode> childList = getChildList(list,node);      
	            
	            for (TreeNode treeNode : childList) {
	            	 recursionFn(list,treeNode);    
				}
	  
	            returnStr.append("]},");       
	        }else{ 
 
	            returnStr.append(",'leaf':true},"); 
	        }       
	               
	    }       
	    public boolean hasChild(List<TreeNode> list, TreeNode node){  //判断是否有子节点     
	    	return !node.isLeaf();
	    //    return getChildList(list,node).size()>0?true:false;     
	    }     
	    public List<TreeNode> getChildList(List<TreeNode> list , TreeNode node){  //得到子节点列表     
	        List<TreeNode> li = new ArrayList<TreeNode>();       
	        for (TreeNode n : list) {
	        	  if(n.getParentId()==node.getId()){       
		                li.add(n);       
		            }       
			}
	        return li;       
	    }     
	    public void recursionNoRootFn(List<TreeNode> list , TreeNode node){       
		     
          List<TreeNode> childList = getChildList(list,node);      
          
          for (TreeNode treeNode : childList) {
          	 recursionFn(list,treeNode);    
			}

      
             
  }      
	    public String modifyStr(int count ){//修饰一下才能满足Extjs的Json格式     
	    	
	        return ("{'count':'"+count+"','children':["+this.returnStr+"]").replaceAll(",]", "]")+"}";     
	             
	    }     
}
