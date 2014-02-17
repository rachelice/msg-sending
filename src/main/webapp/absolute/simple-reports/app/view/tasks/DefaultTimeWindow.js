/**
 * @class SimpleReports.view.tasks.DefaultTimeWindow
 * @extends Ext.window.Window
 * 
 * A window for setting the default reminder time
 */
Ext.define('SimpleReports.view.tasks.DefaultTimeWindow', {
    extend: 'Ext.window.Window',
    xtype: 'defaultTimeWindow',
    title: '设置默认提醒日期',
    closeAction: 'hide',
    width: 300,
    layout: 'fit',

    items: [
        {
            xtype: 'form',
            layout: 'anchor',
            border: false,
            frame: true,

            items: [
                {
                    xtype: 'timefield',
                    name: 'default_time',
                    editable: false,
                    labelAlign: 'top',
                    fieldLabel: '快速设置提醒时, 默认时间为：',
                    anchor: '100%'
                }
            ],
            buttons: [
                {
                    text: 'OK',
                    id: 'save-default-time-btn'
                },
                {
                    text: 'Cancel',
                    id: 'cancel-default-time-edit-btn'
                }
            ]
        }
    ]
});