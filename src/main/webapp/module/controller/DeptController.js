/*
* ClassName 部门管理控制器
*/


Ext.define("Fes.controller.DeptController",{
		extend:	'Ext.app.Controller',
		GridDoActionUtil:Ext.create("Fes.util.GridDoActionUtil"),
		init:function(){
			 
			  this.getGridObj = function(button){
			  	 return button.ownerCt.ownerCt;
			  },
			  this.getTreeObj = function(button){
			  		return button.ownerCt.ownerCt.ownerCt.ownerCt.child("#west-tree").child("#dept-tree");
			  },
				this.control({
					 
					'deptList button[id=deptDelete]':{
					  click:function(deleteButton){
						  
								var grid = this.getGridObj(deleteButton);
								var tree = this.getTreeObj(deleteButton);	
								this.GridDoActionUtil.doDelete(grid,tree);
						}
					
					},
					'deptList button[id=deptSave]':{
						click:function(addButton){
								var grid = this.getGridObj(addButton);
								var tree = this.getTreeObj(addButton);	
								this.GridDoActionUtil.doSave(grid,tree);
						}
				  },
					//设定列表添加按钮的事件
					'deptList button[id=deptAdd]':{
						click:function(addButton){
						 
							//得到数据表格的对象
							var grid = this.getGridObj(addButton);
							var modelObj = {
									text:'',
								//	id:'A01',
									info:'',
									orderIndex:0,
									manager:'',
									nodeType:'Root',
									leaf:true
							};
							//得到tree
							var tree = this.getTreeObj(addButton);
							this.GridDoActionUtil.doInsert(grid,modelObj,tree);	
						}
					},
					//设定列表添加按钮的事件
					'deptList button[id=deptInsert]':{
						click:function(addButton){
						 
							//得到数据表格的对象
							var grid = this.getGridObj(addButton);
							var records = grid.getSelectionModel().getSelection();
						
							var record = new Fes.model.DeptModel({
								deptName : '新建机构'
							});
							if (records.length > 0){
								// record =	records[records.length-1];
								record= new Fes.model.DeptModel({
														deptName : '新建机构',	
														 password:	records[records.length-1].data.password,
														 parentDeptName:			records[records.length-1].data.parentDeptName,
														 deptId:			records[records.length-1].data.deptId,
														 parentId:	records[records.length-1].data.parentId
													});
							}
							
						
							grid.getStore().add(record);
							grid.rowEditor.startEdit(record, 1);
						}
					}
				});	
		},
		views:[
		  'DeptList',
			'DeptLayout',
			'DeptTree'
		],
		stores:[
				'DeptStore',
				'DeptStore4Tree'
		],
		models:[
				'DeptModel'
		]
});