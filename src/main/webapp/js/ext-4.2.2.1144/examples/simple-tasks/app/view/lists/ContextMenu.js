/**
 * @class SimpleTasks.view.lists.ContextMenu
 * @extends Ext.menu.Menu
 */
Ext.define('SimpleTasks.view.lists.ContextMenu', {
    extend: 'Ext.menu.Menu',
    xtype: 'listsContextMenu',
    items: [
        {
            text: '新任务',
            iconCls: 'tasks-new-list',
            id: 'new-list-item'
        },
        {
            text: '新目录',
            iconCls: 'tasks-new-folder',
            id: 'new-folder-item'
        },
        {
            text: '新任务',
            iconCls: 'tasks-new',
            id: 'new-task-item'
        },
        '-',
        {
            text: '删除文件夹',
            iconCls: 'tasks-delete-folder',
            id: 'delete-folder-item'
        },
        {
            text: '删除任务',
            iconCls: 'tasks-delete-list',
            id: 'delete-list-item'
        }
    ],

    /**
     * Associates this menu with a specific list.
     * @param {SimpleTasks.model.List} list
     */
    setList: function(list) {
        this.list = list;
    },
    
    /**
     * Gets the list associated with this menu
     * @return {Task.model.List}
     */
    getList: function() {
        return this.list;
    }

});