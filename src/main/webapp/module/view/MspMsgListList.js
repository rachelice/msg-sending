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
	title: '短信发送 :-)',
	
	initComponent: function() {
		
		var gdCbxSt = new Ext.data.ArrayStore({
			pageSize: 50,
			autoLoad: false,
			fields: [{
				name: 'no'
			},
			{
				name: 'subject'
			},
			{
				name: 'credit'
			},
			{
				name: 'debit'
			},
			{
				name: 'summary'
			}],
			proxy: {
				type: 'ajax',
				url: 'edited/data.json',
				reader: {
					type: 'json',
					root: 'data.list',
					totalProperty: 'data.total'
				}
			}
		});
		
		var me = this;

		Ext.applyIf(me, {
			dockedItems: [{
				xtype: 'label',
				dock: 'top',
				text: '短信正文：'
			},
			{
				xtype: 'textareafield',
				dock: 'top',
			}],
			items: [{
				xtype: 'container',
				x: 0,
				y: 40,
				height: 25,
				layout: {
					type: 'hbox',
					align: 'stretch'
				},
				items: [
				    new Ext.form.field.GridComboBox({
					fieldLabel: '选择收信人',
					multiSelect: true,
					displayField: 'subject',
					valueField: 'no',
					width: 300,
					labelWidth: 100,
					labelAlign: 'right',
					store: gdCbxSt,
					queryMode: 'remote',
					matchFieldWidth: false,
					pickerAlign: 'bl',
					gridCfg: {
						store: gdCbxSt,
						selModel: new Ext.selection.CheckboxModel({
							checkOnly: true
						}),
						height: 200,
						width: 400,
						columns: [{
							text: 'No',
							width: 40,
							dataIndex: 'no'
						},
						{
							text: 'Subject',
							width: 120,
							dataIndex: 'subject'
						},
						{
							text: 'Credit',
							width: 60,
							dataIndex: 'credit'
						},
						{
							text: 'Debit',
							width: 60,
							dataIndex: 'debit'
						},
						{
							text: 'Summary',
							width: 200,
							dataIndex: 'summary'
						}],
						bbar: Ext.create('Ext.PagingToolbar', {
							store: gdCbxSt,
							displayInfo: true,
							displayMsg: 'Displaying {0} - {1} of {2}',
							emptyMsg: "No data to display"
						})
					}
				}), {
					xtype: 'button',
					text: '删除已选收信人'
				}]
			},
			{
				xtype: 'gridpanel',
				x: -2,
				y: 70,
				height: 304,
				autoScroll: true,
				title: '选定收信人',
				selModel: new Ext.selection.CheckboxModel({
					checkOnly: true
				}),
				columns: [{
					xtype: 'gridcolumn',
					dataIndex: 'string',
					text: 'String'
				},
				{
					xtype: 'numbercolumn',
					dataIndex: 'number',
					text: '姓名'
				},
				{
					xtype: 'datecolumn',
					dataIndex: 'date',
					text: '电话号码'
				}]
			},
			{
				xtype: 'container',
				x: 320,
				y: 390,
				height: 38,
				width: 140,
				layout: 'table',
				items: [{
					xtype: 'button',
					text: '发  送'
				},
				{
					xtype: 'button',
					text: '保  存'
				},
				{
					xtype: 'button',
					text: '清  空'
				}]
			}]
		});
		me.callParent(arguments);
	}
});