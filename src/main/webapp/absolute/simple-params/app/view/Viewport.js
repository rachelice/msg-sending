Ext.define('SimpleParams.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires: [
        'Ext.layout.container.Border'
    ],

    layout: 'border',

    items: [
        {
            xtype: 'paramsToolbar',
            region: 'north'
        },
        {
            xtype: 'listTree',
            region: 'west',
            width: 300,
            collapsible: true,
            split: true
        },
        {
            region: 'center',
            xtype: 'paramGrid',
            title: 'All Lists'
        }
    ]

});