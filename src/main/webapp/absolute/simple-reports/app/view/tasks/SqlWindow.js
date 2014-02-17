/**
 * @class SimpleReports.view.tasks.EditWindow
 * @extends Ext.window.Window
 */
Ext.define('SimpleReports.view.tasks.SqlWindow', {
    extend: 'Ext.window.Window',
    xtype: 'taskSqlWindow',
    requires: [
        
        'SimpleReports.view.DataBaseGrid',
         
    ],
    closeAction: 'hide',
    modal: true,
    width: 900,
    height: 500,
    minWidth: 500,
    minHeight: 350,
    layout: 'fit',
/*
    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'top',
            items: [
                {
                    iconCls: 'tasks-mark-complete',
                    text: '导出xls',
                    id: 'toggle-complete-btn'
                },
                {
                    iconCls: 'tasks-delete-task',
                    text: '删除任务',
                    id: 'delete-task-window-btn'
                }
            ]
        }
    ],*/

    initComponent: function() {

         this.items = [Ext.create('SimpleReports.view.DataBaseGrid',{})];

        this.callParent(arguments);

    }

});