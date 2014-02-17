/**
 * @class SimpleParams.view.Toolbar
 * @extends Ext.toolbar.Toolbar
 */
Ext.define('SimpleParams.view.Toolbar', {
    extend: 'Ext.toolbar.Toolbar',
    xtype: 'paramsToolbar',
    items: [
        {
            text: '新建',
            iconCls: 'params-new',
            menu: {
                items: [
                    {
                        text: '新建任务',
                        iconCls: 'params-new'
                    },
                    {
                        text: '新建任务清单',
                        iconCls: 'params-new-list'
                    },
                    {
                        text: '新建任务目录',
                        iconCls: 'params-new-folder'
                    }
                ]
            }
        },
        {
            iconCls: 'params-delete-param',
            id: 'delete-param-btn',
            disabled: true,
            tooltip: '删除任务'
        },
        {
            iconCls: 'params-mark-complete',
            id: 'mark-complete-btn',
            disabled: true,
            tooltip: '标记完成'
        },
        {
            iconCls: 'params-mark-active',
            id: 'mark-active-btn',
            disabled: true,
            tooltip: '激活'
        },
        '->',
        {
            iconCls: 'params-show-all',
            id: 'show-all-btn',
            tooltip: '全部任务',
            toggleGroup: 'status'
        },
        {
            iconCls: 'params-show-active',
            id: 'show-active-btn',
            tooltip: '激活任务',
            toggleGroup: 'status'
        },
        {
            iconCls: 'params-show-complete',
            id: 'show-complete-btn',
            tooltip: '完成任务',
            toggleGroup: 'status'
        }

    ]
});


