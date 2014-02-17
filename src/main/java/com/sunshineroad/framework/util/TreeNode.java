package com.sunshineroad.framework.util;

public class TreeNode {
	private Integer id;
	private Integer parentId;
	private Integer index;
	private Integer int1;
	private Integer int2;
	private Integer int3;
	private Integer int4;
	private String  text;
	private String  str1;
	private String  str2;
	private String  str3;
	private String  str4;
	private String  str5;
	private String  str6;
	private String  str7;
	private String  str8;
	private boolean leaf;
	private boolean checked;
	private boolean expanded;

	public TreeNode() {
	}

 
	public TreeNode(Integer id, Integer parentId, String text, boolean leaf) {
		 
		this.id = id;
		this.parentId = parentId;
		this.text = text;
		this.leaf = leaf;
	}


	public TreeNode(
			Integer id, 
			Integer parentId, 
			Integer index, 
			Integer int1,
			Integer int2, 
			Integer int3, 
			Integer int4,
			String text, 
			String str1,
			String str2,
			String str3, 
			String str4, 
			String str5, 
			String str6,
			String str7,
			String str8, 
			boolean leaf,
			boolean checked,
			boolean expanded) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.index = index;
		this.int1 = int1;
		this.int2 = int2;
		this.int3 = int3;
		this.int4 = int4;
		this.text = text;
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		this.str4 = str4;
		this.str5 = str5;
		this.str6 = str6;
		this.str7 = str7;
		this.str8 = str8;
		this.leaf = leaf;
		this.checked = checked;
		this.expanded = expanded;
	}
	
	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", parentId=" + parentId + ", index="
				+ index + ", int1=" + int1 + ", int2=" + int2 + ", int3="
				+ int3 + ", int4=" + int4 + ", text=" + text + ", str1=" + str1
				+ ", str2=" + str2 + ", str3=" + str3 + ", str4=" + str4
				+ ", str5=" + str5 + ", str6=" + str6 + ", str7=" + str7
				+ ", str8=" + str8 + ", leaf=" + leaf + ", checked=" + checked +", expanded="
				+ expanded + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getParentId() {
		return parentId;
	}


	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public Integer getIndex() {
		return index;
	}


	public void setIndex(Integer index) {
		this.index = index;
	}


	public Integer getInt1() {
		return int1;
	}


	public void setInt1(Integer int1) {
		this.int1 = int1;
	}


	public Integer getInt2() {
		return int2;
	}


	public void setInt2(Integer int2) {
		this.int2 = int2;
	}


	public Integer getInt3() {
		return int3;
	}


	public void setInt3(Integer int3) {
		this.int3 = int3;
	}


	public Integer getInt4() {
		return int4;
	}


	public void setInt4(Integer int4) {
		this.int4 = int4;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getStr1() {
		return str1;
	}


	public void setStr1(String str1) {
		this.str1 = str1;
	}


	public String getStr2() {
		return str2;
	}


	public void setStr2(String str2) {
		this.str2 = str2;
	}


	public String getStr3() {
		return str3;
	}


	public void setStr3(String str3) {
		this.str3 = str3;
	}


	public String getStr4() {
		return str4;
	}


	public void setStr4(String str4) {
		this.str4 = str4;
	}


	public String getStr5() {
		return str5;
	}


	public void setStr5(String str5) {
		this.str5 = str5;
	}


	public String getStr6() {
		return str6;
	}


	public void setStr6(String str6) {
		this.str6 = str6;
	}


	public String getStr7() {
		return str7;
	}


	public void setStr7(String str7) {
		this.str7 = str7;
	}


	public String getStr8() {
		return str8;
	}


	public void setStr8(String str8) {
		this.str8 = str8;
	}


	public boolean isLeaf() {
		return leaf;
	}


	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}


	public boolean isExpanded() {
		return expanded;
	}


	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}


	public boolean isChecked() {
		return checked;
	}


	public void setChecked(boolean checked) {
		this.checked = checked;
	}


}
