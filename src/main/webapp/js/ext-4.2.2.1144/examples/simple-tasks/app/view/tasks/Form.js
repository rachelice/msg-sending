Ext.define('SimpleTasks.view.tasks.Form', {
    extend: 'Ext.form.Panel',
    xtype: 'taskForm',
    requires: [
       'Ext.layout.container.HBox',
       'Ext.form.field.Date',
       'Ext.ux.TreePicker'
    ],
    layout: 'hbox',
    cls: 'tasks-new-form',

    initComponent: function() {
        this.items = [
            {
                xtype: 'component',
                cls: 'tasks-new',
                width: 24,
                height: 24
            },
            {
                xtype: 'textfield',
                name: 'title',
                emptyText: '添加一个新任务'
            },
            {
                xtype: 'treepicker',
                name: 'list_id',
                displayField: 'name',
                store: Ext.create('SimpleTasks.store.Lists', {storeId: 'Lists-TaskForm'}),
                width: 195
            },
            {
                xtype: 'datefield',
                name: 'due',
                value: new Date(),
                width: 95
            }
        ];

        this.callParent(arguments);
    }

});