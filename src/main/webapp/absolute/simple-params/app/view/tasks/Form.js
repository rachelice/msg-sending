Ext.define('SimpleParams.view.params.Form', {
    extend: 'Ext.form.Panel',
    xtype: 'paramForm',
    requires: [
       'Ext.layout.container.HBox',
       'Ext.form.field.Date',
       'Ext.ux.TreePicker'
    ],
    layout: 'hbox',
    cls: 'params-new-form',

    initComponent: function() {
        this.items = [
            {
                xtype: 'component',
                cls: 'params-new',
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
                store: Ext.create('SimpleParams.store.Lists', {storeId: 'Lists-ParamForm'}),
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