/**
 * @class SimpleTasks.view.Toolbar
 * @extends Ext.toolbar.Toolbar
 */
Ext.define('SimpleTasks.view.Toolbar', {
    extend: 'Ext.toolbar.Toolbar',
    xtype: 'tasksToolbar',
    items: [
        {
            text: '新建',
            iconCls: 'tasks-new',
            menu: {
                items: [
                    {
                        text: '新建任务',
                        iconCls: 'tasks-new'
                    },
                    {
                        text: '新建任务清单',
                        iconCls: 'tasks-new-list'
                    },
                    {
                        text: '新建任务目录',
                        iconCls: 'tasks-new-folder'
                    }
                ]
            }
        },
        {
            iconCls: 'tasks-delete-task',
            id: 'delete-task-btn',
            disabled: true,
            tooltip: '删除任务'
        },
        {
            iconCls: 'tasks-mark-complete',
            id: 'mark-complete-btn',
            disabled: true,
            tooltip: '标记完成'
        },
        {
            iconCls: 'tasks-mark-active',
            id: 'mark-active-btn',
            disabled: true,
            tooltip: '激活'
        },
        '->',
        {
            iconCls: 'tasks-show-all',
            id: 'show-all-btn',
            tooltip: '全部任务',
            toggleGroup: 'status'
        },
        {
            iconCls: 'tasks-show-active',
            id: 'show-active-btn',
            tooltip: '激活任务',
            toggleGroup: 'status'
        },
        {
            iconCls: 'tasks-show-complete',
            id: 'show-complete-btn',
            tooltip: '完成任务',
            toggleGroup: 'status'
        }

    ]
});


