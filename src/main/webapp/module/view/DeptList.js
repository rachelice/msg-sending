/*
*  ClassName 部门管理数据列表视图
*/
 Ext.require(['Fes.view.DeptComboTree']);
Ext.define("Fes.view.DeptList",{
	 extend:'Ext.grid.Panel',
	 alias:'widget.deptList',
	
	 selModel:{//选择模式
		 selType:'checkboxmodel'	
	 },
	 border:0,
		rowLines : true,
		columnLines : true,
		multiSelect : true,
		simpleSelect : true,
	 frame:true,//自动渲染边框
	 tbar:[
	 		{xtype:'button',text:'添加',id:'deptAdd',iconCls:'dept_table',hidden:true},
	 		{xtype:'button',text:'删除',id:'deptDelete',iconCls:'dept_table'},
	 		{xtype:'button',text:'保存',id:'detpSave',iconCls:'dept_table'},
	 		{xtype:'button',text : '添加',iconCls : 'icon-add',id:'deptInsert'}
	 ],
	
	 enableKeyNav:true,
	 columnLine:true,
	
	 columns:[
	 		{text:'部门名称',dataIndex:'deptName',width:100,
	 			field:{
	 				xtype:'textfield',
	 				allowBlank:false		
	 			}
	 		},
	 		{text:'部门经理',dataIndex:'manager',width:100,
	 			field:{
	 				xtype:'textfield',
	 				allowBlank:false		
	 			}
	 		},
			{text : '上级机构',width : 260,sortable : true,dataIndex : 'parentDeptName',field :  {xtype:'deptComboTree',
				fieldLabel: '机构',
				labelWidth: 40,   
				rootText : '总行',
				rootId:'0', 
				expanded:true,
				storeUrl : 'depts/deptTreeJSON',		
                id:'DeptList'+'DeptComboTree',
				selectMode:'all',
				treeHeight:600,
				//width : 300,
				rootVisible:true,
			 
		        listeners :  {
		        	"select" :function(){
						//alert(Ext.getCmp('cmbJS').getValue());
		        		//Ext.getCmp('cmbJS').getValue();
		        	}
		        }
			}
			} ,
	 		{text:'顺序排序',dataIndex:'orderIndex',width:100},
	 		{text:'职能简介',dataIndex:'description',width:'100'}
	 ],
 
	 initComponent:function(){
		 	//	this.editing = Ext.create("Ext.grid.plugin.CellEditing");
		 	//	this.plugins = [ this.editing ];
		 		
				this.store = Ext.create('Fes.store.DeptStore', {
					autoLoad:true,
				    listeners : {
				        load:function(s,records,success,e){
				           // alert(Ext.JSON.encode(records[0].data));

				        //	alert(Ext.JSON.encode(Ext.getCmp('DeptLayoutDeptTree').id)); 
				        }
				    }
				});
				// this.store.load();
				
				this. dockedItems=[{
				 		xtype:'pagingtoolbar',
				 		store: this.store,
				 		dock:'bottom',
				 		displayInfo:true
				 }];
				
				this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
					id:'deptListRowEditor',
					listeners : {
						beforeedit:function( editor,  e,  eOpts ){
					
				 
						},
						startEdit:function(record, columnHeader ){
						//	   Ext.Msg.alert('11',Ext.JSON.encode(record));
							this.editRecord=record;
						},
						edit : function(editor, e) {
			 
						if(e.originalValues.parentDeptName!=e.record.data.parentDeptName){
							
							
						    //Ext.Msg.alert('11',Ext.JSON.encode(Ext.getCmp('userlist'+'DeptComboTree').getValue()));
						 	e.record.data.parentId=Ext.getCmp('DeptList'+'DeptComboTree').getValue();
						 	e.record.data.parentDeptName=Ext.getCmp('DeptList'+'DeptComboTree').getTreeValue().data.text;
							
						}
							e.record.save({
										success : function(dept, options) {											 
											var data = Ext
													.decode(options.response.responseText);
											if (data.extra) {
												dept.set('id', data.extra);
											}
											dept.commit();
										}
									});
		
						}
					}
				});
				this.plugins = [this.rowEditor];
				this.callParent(arguments);
	 }
});
 