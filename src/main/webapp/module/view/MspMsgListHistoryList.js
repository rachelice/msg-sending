Ext.define('Fes.view.MspMsgListHistoryList', {
		extend: 'Ext.grid.Panel',
		alias: 'widget.mspMsgListHistorylist', 
		buttonAlign: 'center',  
	    width: 600,  
	    title: 'form',  
	    frame: true,  
	    fieldDefaults: {  
	        labelAlign: 'right',  
	        labelWidth: 70  
	    },  
	    items: [{  
	        xtype: 'container',  
	        layout: 'column',
	        items: [{  
	            columnWidth:.5,  
	            xtype:'fieldset',  
	            collapsible: true, //是否为可折叠  
	            collapsed: false, //默认是否折叠  
	            title: '编辑短信',  
	            height:380,  
	            defaults: {},  
	            defaultType: 'textfield',  
	            items: [{  
	                xtype:"combo",  
	                fieldLabel: '添加号码',  
	                name: 'combo',  
	                store: new Ext.data.SimpleStore({  
	                    fields: ['value', 'text'],  
	                    data: [  
	                        ['value1', '13902123456'],  
	                        ['value2', '13602123456']  
	                    ]  
	                }),  
	                displayField: 'text',  
	                valueField: 'value',  
	                mode: 'local',  
	                emptyText:'请选择'  
	            },{  
	                xtype: 'textarea',
	                width : 500,
	                height : 240,
	                fieldLabel: '短信内容',  
	                name: 'textarea'  
	            },{  
	                xtype: 'hidden',  
	                name: 'hidden'  
	            }]  
	        }]  
	    },{  
	        xtype: 'container',  
	        layout: 'form',  
	        items: []  
	    }],  
	    buttons: [{  
	        text: '保存'  
	    },{  
	        text: '读取'  
	    },{  
	        text: '取消'  
	    }]  
	});  

	form.render("form");