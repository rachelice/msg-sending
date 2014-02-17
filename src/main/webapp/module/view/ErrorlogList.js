
console.log('errorlogList...');
Ext.require(['Fes.view.DeptComboTree']);
Ext.require(['Fes.util.RoleCombox']);
Ext.require(['Fes.util.ErrorCombox']);
Ext.require(['Fes.util.DateTime']);

userlistinit=false;

/*
Ext.apply(Ext.form.field.VTypes, {
    daterange: function(val, field) {
        var date = field.parseDate(val);

        if (!date) {
            return false;
        }
        if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
            var start = field.up('toolbar').down('#' + field.startDateField);
            start.setMaxValue(date);
            start.validate();
            this.dateRangeMax = date;
        }
        else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
            var end = field.up('toolbar').down('#' + field.endDateField);
            end.setMinValue(date);
            end.validate();
            this.dateRangeMin = date;
        }
        
         * Always return true since we're only using this vtype to set the
         * min/max allowed values (these are tested for after the vtype test)
         
        return true;
    },

    daterangeText: '开始日期必须小于结束日期'

});*/

Ext.define('Fes.view.ErrorlogList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.errorloglist',
	title : '历史监控信息',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载人员列表'
	},
	createRoleCombox:function(){
	 
	},
	columns : [	{xtype : 'rownumberer'},
	           	
						{text : '终端',width : 200,sortable : true,dataIndex : 'terminal',field : {xtype : 'textfield',required : true}},
						{text : '发生时间',width : 200,sortable : true,dataIndex : 'occurdate',field : {xtype : 'date',required : true}},
					/*	{text : '用户',width : 150,sortable : true,dataIndex : 'user',field : {xtype : 'textfield',required : true}},
						{text : '响应时间',width : 260,sortable : true,dataIndex : 'responsedate', field : {xtype : 'textfield',required : true}},
						*/{text : '信息',width : 400,sortable : true,dataIndex : 'description', field : {xtype : 'textfield',required : true}}
					],
	// store : [Ext.create('Fes.hr.user.Store')],
	listeners : {		
		hide:function(panel,o){
			
		},
		itemdblclick:function(  view,  record,   item,   index,   e,   eOpts ){
			
			var info='异常终端：'+record.data.terminal+'<br>'+'异常时间：'+record.data.occurdate;
			info+='<br>异常信息：<lable   style="width:10;overflow-x:visible;overflow-y:visible;">'+record.data.description+'</label>';
	
			//	win.show();
			 Ext.MessageBox.show({
		           title: '异常信息详细情况',
		           msg: info,
		           width:460,
		            
		           buttons: Ext.MessageBox.OK,
		          
		           fn: function(){
		        	   console.log('record1='+Ext.encode(record.data));
		        	   var newRecord=Ext.create('Fes.model.ErrorlogModelUpdate',{'id':record.data.id});
		        	   
		        	   newRecord.save({
							success : function(user, options) {
								
							}
						});
		           },
		           icon: 'x-message-box-warning'
		       });
		}
	},
	initComponent : function() {	 
		this.createStore();		
		var me = this;
		 if(!userlistinit){			 
		 }
		userlistinit=true; 
	   this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true
		};
		
 
             win = Ext.create('widget.window', {
                title: 'Layout Window',
                closable: true,
                closeAction: 'hide',
                width: 600,
                y:200,
                minWidth: 350,
                height: 350,
                layout: {
                    type: 'border',
                    padding: 5
                },
                items: [{
                    region: 'west',
                    title: 'Navigation',
                    width: 200,
                    split: true,
                    collapsible: true,
                    floatable: false
                }, {
                    region: 'center',
                    xtype: 'tabpanel',
                    items: [{
                        title: 'Bogus Tab',
                        html: 'Hello world 1'
                    }, {
                        title: 'Another Tab',
                        html: 'Hello world 2'
                    }, {
                        title: 'Closable Tab',
                        html: 'Hello world 3',
                        closable: true
                    }]
                }]
            });
        
		this.callParent();
		//定时任务定义
		me=this;
		  var getNewDate = {
			        run: function(){
			         //如功能tab关闭或隐藏 则不读取
			        	if(me.isHidden()){
			        		return;
			        	}
			        	console.log('getNewDate......');
			        	me.getStore().load();
			        },
		  			interval: 10000 //1000=1 second
		  };
		  //定时任务启动
		    Ext.TaskManager.start(getNewDate);
	},
	showWin:function(){this.win.show();},
	hideWin:function(){this.win.hide();},
	params:{'user':null},
	setParams:function(o){
		this.params=o ;
	},
	getParams:function(){
		return this.params;
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.ErrorlogStore',{
		/*	listeners:{
			beforeload:function(store,operation,success,e){
				 	operation=Ext.merge(operation,me.getParams());
				 	Ext.Msg.alert('',Ext.JSON.encode(operation));
				
				    }
			}*/
		});
	    //排序
	     /*  sorters: [{
	           property: 'Master_Name',
	           direction: 'DESC'
	       }] */
		me.store.sort([{ property: "occurdate", direction: "DESC" }, { property: "terminal", direction: "DESC"}]);
		me.store.on("beforeload",function(){
			console.log('beforeload.......');
			Ext.apply(me.store.proxy.extraParams, me.getParams());
		});
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [		{		
					     fieldLabel: '请选择终端',
						xtype: 'errorCombox',
	                    valueField: 'name',
	                    displayField: 'name',
	                    id:'errorlist'+'ErrorCombox',
	                    allText:'全选',//默认字符是All
	                    addAllSelector: true
	                } , '-',{
						xtype : 'datetimefield',
						  fieldLabel: '开始时间',
						  id:'errorlogStart',
					//	 value:Ext.Date.add(new Date(), Ext.Date.DAY, -1),
					      /*  vtype: 'daterange',
					        name: 'startdt',
		                    itemId: 'startdt',
		                    maxValue: new Date(),
		                    vtype: 'daterange',
		                    endDateField: 'enddt', // id of the end date field
*/						format : 'Y-m-d H:i:s'
					},
					{
						xtype : 'datetimefield',
						  fieldLabel: '结束时间',
						  id:'errorlogEnd',
						 
						format : 'Y-m-d H:i:s'/*,
				        name: 'enddt',
	                    itemId: 'enddt',
	                    vtype: 'daterange',
	                    startDateField: 'startdt' // id of the start date field
*/					} , '-', {
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.setParams({
										terminal : Ext.getCmp('errorlist'+'ErrorCombox').getValue(),
										errorlogStart : Ext.getCmp('errorlogStart').getValue(),
										errorlogEnd : Ext.getCmp('errorlogEnd').getValue()
									}),
								
									me.getStore().load();
								}
							}]
				});
	}
});