 
Ext.define('Fes.view.DataBaseList', { 
	    extend: 'Ext.grid.Panel',
	    alias: 'widget.databaselist',
	    id:'databaselist',
	    title: '数据库管理',  
	    region: 'center', 
	    renderTo:Ext.getBody(),
	    columns:[],
	    bbar: {  
	        xtype: 'pagingtoolbar',
	        id:'datapagebar',
	        displayInfo: true,
	        displayMsg: '显示 {0} - {1} 共 {2}条',  
	        emptyMsg: "没有数据需要显示"  
	    }, 
	      dockedItems:[{
	          dock: 'top',
	          xtype: 'toolbar',
	          layout:'fit',
	          items: [
	              {
	                  xtype:'tabpanel',
	                  height:80,
	                  items:[{
	                      xtype:'panel',
	                      title:'查询表',
	                      margin: '5 0 0 20',
	                      items:[
	                      {
	                             xtype: 'combobox',
	                            width: 219,
	                            id:'combtables',
	                            fieldLabel: '选择表',
	                            labelWidth: 50,
	                            maxWidth: 200,
	                            editable:false,
	                            valueField: 'tablename',
	                            displayField: 'tablename',
	                            store:Ext.create('sxpt.store.admin.Tables'),
	                            labelWidth: 80,
	                            listeners:{
	                                change:function(combo, record,index){
	                                    var griddb=Ext.getCmp('databaselist');
	                                    Ext.Ajax.request({
	                                        url:'admin/admin_database_fieldsa',
	                                        params:{
	                                            tablename:this.value
	                                        },
	                                        method : 'POST',
	                                        success : function(response) {
	                                            var strT=response.responseText;
	                                            
	                                            var json = Ext.JSON.decode(strT.replace(/\"\{/g,"{").replace(/\}\"/g,"}"));                //替换掉由　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　于struts-json序列化产生的多余双引号
	                                            var store=Ext.create('Ext.data.Store',{
	                                                fields:json.fields,
	                                                data:json.contentstr
	                                            });
	                                            var pagebar=Ext.getCmp('datapagebar');
	                                            pagebar.bind(store); //为分页栏加载数据
	                                            store.load();
	                                            griddb.reconfigure(store,json.fieldheader);
	                                        }
	                                    })
	                                    }
	                            }
	 //
	                      }
	                      ]
	                  }
	          ]
	       }]
	    }]
	});