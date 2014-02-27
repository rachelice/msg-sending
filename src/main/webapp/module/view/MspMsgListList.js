
Ext.define('Fes.view.MspMsgListList', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.mspMsgListlist',
	title: '[短信清单]列表',
	requires: ['Ext.form.Label', 
	           'Ext.form.field.TextArea', 
	           'Ext.form.field.ComboBox', 
	           'Ext.button.Button', 
	           'Ext.grid.Panel', 
	           'Ext.grid.column.Number', 
	           'Ext.grid.column.Date', 
	           'Ext.grid.View'],

//	height: 576,
//	width: 785,
	layout: 'absolute',
	title: '短信发送',
	
	initComponent: function() {
		
		var gdCbxSt = new Ext.data.Store({
			pageSize: 50,
			autoLoad: false,
			fields:[
				{name:'licenseCode',type:'string'}	,	//驾校许可证号
				{name:'enterpriseName',type:'string'}	,	//驾校名称
				{name:'semesterName',type:'string'}	,	//班期名称
				{name:'userTel',type:'string'}	,	//电话
				{name:'enterpriseId',type:'string'}	,	//驾校id
				{name:'learnerName',type:'string'}	,	//学员姓名
				{name:'identityNumber',type:'string'}	,	//身份证号
				{name:'gender',type:'string'}	,	//性别
				{name:'semesterId',type:'string'}	,	//班期id
				{name:'mobileNumber',type:'string'}	,	//手机号码
				{name:'subjectOneThFinishtime',type:'string'}	,	//科目一已完成学时
				{name:'subjectTwoThFinishtime',type:'string'}	,	//科目二理论已完成学时
				{name:'subjectTwoOpFinishtime',type:'string'}	,	//科目二实操已完成学时
				{name:'subjectThreeThFinishtime',type:'string'}	,	//科目三理论已完成学时
				{name:'subjectThreeOpFinishtime',type:'string'}	,	//科目三实操已完成学时
				{name:'updateTime',type:'auto'}	,	//更新时间
				{name:'createTime',type:'auto'}	,	//创建时间
				{name:'remark',type:'string'}	,	//备注
				{name:'id',type:'int'}
			],
			proxy: {
				appendId:false,
				type: 'rest',
				url: 'mspStudent/showStudent',
				reader: {
					type: 'json',
					root: 'root',
					totalProperty: 'total'
				},
				actionMethods:{
				    read: 'GET'
				}
			}
		});
		var me = this;
		Ext.applyIf(me, {
			dockedItems: [{  
		        xtype: 'container',  
		        layout: 'column',
		        items: [{  
		            columnWidth:.5,  
		            xtype:'fieldset',  
		            collapsible: true, //是否为可折叠  
		            collapsed: false, //默认是否折叠  
		            title: '<b>编辑短信</b>',  
		            autoHeight:true,  
		            defaults: {},  
		            defaultType: 'textfield',  
		            items: [
	                    {xtype: 'textarea',
		                width : 500,
		                height : 200,
		                fieldLabel: '<b>短信内容</b>',  
		                name: 'textarea'
					},new Ext.form.field.GridComboBox({
						fieldLabel: '<b>添加收信人</b>',
						multiSelect: true,
						displayField: 'mobileNumber',
						valueField: 'id',
						width: 500,
						store: gdCbxSt,
						queryMode: 'remote',
//						matchFieldWidth: false,
//						pickerAlign: 'bl',
						gridCfg: {
							store: gdCbxSt,
							selModel: new Ext.selection.CheckboxModel({
								checkOnly: true
							}),
							height: 200,
							width: 400,
							columns: [{
								text: '姓名',
								width: 100,
								dataIndex: 'learnerName'
							},
							{
								text: '手机号码',
								width: 100,
								dataIndex: 'mobileNumber'
							},{
								text: 'id',
								width: 100,
								dataIndex: 'id'
							}],
							bbar: Ext.create('Ext.PagingToolbar', {
								store: gdCbxSt,
								displayInfo: true,
								displayMsg: 'Displaying {0} - {1} of {2}',
								emptyMsg: "无数据"
							})
						}
					}),{
						xtype: 'container',
						x: 320,
						y: 390,
						height: 112,
						width: 140,
						layout: 'table',
						items: []
					},{
						xtype: 'container',
						x: 320,
						y: 390,
						height: 38,
						width: 140,
						layout: 'table',
						items: [{
							xtype: 'button',
							text: '发  送',
							handler : me.send
						},{
							xtype: 'button',
							text: '保  存',
							handler : me.save
							
							
						},{
							xtype: 'button',
							text: '清  空',
							handler : me.clear
						}]
					}]  
		        },{	
//		        	xtype: 'container',  
	                columnWidth:.35,  
	                layout:'form',
	                xtype:'fieldset',  
		            collapsible: true, //是否为可折叠  
		            collapsed: false, //默认是否折叠  
		            title: '<b>已选收信人</b>',
    				items:[{
    					xtype: 'gridpanel',
	    				loadMask:true,
	    				forceFit:true,
	    				border : true,
	    				height : 380,
	    				autoScroll: true,
	    				trackMouseOver:true, //鼠标特效   
	                    autoScroll:true,   
	                    stripeRows:true,
	                    buttons:[ 
                         new Ext.Button({ 
                          text:'<b>删除收信人</b>' 
                         }) 
                        ],
	                    viewConfig:{   
	                        columnsText:"显示/隐藏列",   
	                        sortAscText:"正序排列",   
	                        sortDescText:"倒序排列",   
	                        forceFit:true  
	                    },
	    				selModel: new Ext.selection.CheckboxModel({
	    					checkOnly: true	
	    				}),
	    				columns: [ Ext.grid.RowNumberer(),
	    				{
	    					xtype: 'numbercolumn',
	    					dataIndex: 'number',
	    					text: '姓名'
	    				},{
	    					xtype: 'datecolumn',
	    					dataIndex: 'date',
	    					text: '电话号码'
	    				}] 
    				}]
		        }]  
		    }]
		});
		me.callParent(arguments);
	},
	save : function (){
		alert('保存');
//		me.saveRecode(_mspMsgTaskWindow.down('form').getValues());
	},
	send : function (){
		alert('发送');
//		me.saveRecode(_mspMsgTaskWindow.down('form').getValues());
	},
	clear : function (){
		alert('清空');
//		me.saveRecode(_mspMsgTaskWindow.down('form'));
	}

});