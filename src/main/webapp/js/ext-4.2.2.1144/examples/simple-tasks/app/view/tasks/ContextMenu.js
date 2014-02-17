/**
 * @class SimpleTasks.view.tasks.ContextMenu
 * @extends Ext.menu.Menu
 */
Ext.define('SimpleTasks.view.tasks.ContextMenu', {
    extend: 'Ext.menu.Menu',
    xtype: 'tasksContextMenu',
    items: [
        {
            text: '编辑',
            id: 'edit-task-item'
        },
        '-',
        {
            text: '标记完成',
            iconCls: 'tasks-mark-complete',
            id: 'mark-complete-item'
        },
        {
            text: '激活',
            iconCls: 'tasks-mark-active',
            id: 'mark-active-item'
        },
        {
            text: '删除',
            iconCls: 'tasks-delete-task',
            id: 'delete-task-item'
        }
    ],

    /**
     * Associates this menu with a specific task.
     * @param {SimpleTasks.model.Task} task
     */
    setTask: function(task) {
        this.task = task;
    },
    
    /**
     * Gets the task associated with this menu
     * @return {Task.model.Task}
     */
    getTask: function() {
        return this.task;
    }

});