/**
 * @class SimpleParams.view.params.ContextMenu
 * @extends Ext.menu.Menu
 */
Ext.define('SimpleParams.view.params.ContextMenu', {
    extend: 'Ext.menu.Menu',
    xtype: 'paramsContextMenu',
    items: [
        {
            text: '编辑',
            id: 'edit-param-item'
        },
        '-',
        {
            text: '标记完成',
            iconCls: 'params-mark-complete',
            id: 'mark-complete-item'
        },
        {
            text: '激活',
            iconCls: 'params-mark-active',
            id: 'mark-active-item'
        },
        {
            text: '删除',
            iconCls: 'params-delete-param',
            id: 'delete-param-item'
        }
    ],

    /**
     * Associates this menu with a specific param.
     * @param {SimpleParams.model.Param} param
     */
    setParam: function(param) {
        this.param = param;
    },
    
    /**
     * Gets the param associated with this menu
     * @return {Param.model.Param}
     */
    getParam: function() {
        return this.param;
    }

});