/**
 * @class SimpleParams.view.lists.ContextMenu
 * @extends Ext.menu.Menu
 */
Ext.define('SimpleParams.view.lists.ContextMenu', {
    extend: 'Ext.menu.Menu',
    xtype: 'listsContextMenu',
    items: [
        {
            text: '新任务',
            iconCls: 'params-new-list',
            id: 'new-list-item'
        },
        {
            text: '新目录',
            iconCls: 'params-new-folder',
            id: 'new-folder-item'
        },
        {
            text: '新任务',
            iconCls: 'params-new',
            id: 'new-param-item'
        },
        '-',
        {
            text: '删除文件夹',
            iconCls: 'params-delete-folder',
            id: 'delete-folder-item'
        },
        {
            text: '删除任务',
            iconCls: 'params-delete-list',
            id: 'delete-list-item'
        }
    ],

    /**
     * Associates this menu with a specific list.
     * @param {SimpleParams.model.List} list
     */
    setList: function(list) {
        this.list = list;
    },
    
    /**
     * Gets the list associated with this menu
     * @return {Param.model.List}
     */
    getList: function() {
        return this.list;
    }

});