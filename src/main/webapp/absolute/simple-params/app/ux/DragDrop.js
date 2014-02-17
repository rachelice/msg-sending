/**
 * @class SimpleParams.ux.DragDrop
 * @extends Ext.grid.plugin.DragDrop
 * 
 * This plugin modifies the behavior of Ext.tree.plugin.TreeViewDragDrop. to allow the DropZone to handle
 * multiple types of records (Params and Lists)
 */
Ext.define('SimpleParams.ux.DragDrop', {
    extend: 'Ext.tree.plugin.TreeViewDragDrop',
    alias: 'plugin.paramsdragdrop',
    requires: [
        'Ext.view.DragZone',
        'SimpleParams.ux.DropZone'
    ], 

    /**
     * @event paramdrop
     * **This event is fired through the GridView. Add listeners to the GridView object**
     * 
     * Fires when a param record is dropped on the group view
     * @param {SimpleParams.model.Param} param       The param record
     * @param {SimpleParams.model.Group} group     The group that the param was dropped on
     */

    /**
     * @event groupdrop
     * **This event is fired through the GridView. Add listeners to the GridView object**
     * 
     * Fires when a group record is dropped on the group view
     * @param {SimpleParams.model.Group} group         The group that was dropped
     * @param {SimpleParams.model.Group} overGroup     The group that the group was dropped on
     * @param {String} position                 `"before"` or `"after"` depending on whether the mouse is above or below the midline of the node.
     */

    onViewRender : function(view) {
        var me = this;

        if (me.enableDrag) {
            me.dragZone = Ext.create('Ext.tree.ViewDragZone', {
                view: view,
                ddGroup: me.dragGroup || me.ddGroup,
                dragText: me.dragText,
                repairHighlightColor: me.nodeHighlightColor,
                repairHighlight: me.nodeHighlightOnRepair
            });
        }

        if (me.enableDrop) {
            me.dropZone = Ext.create('SimpleParams.ux.DropZone', {
                view: view,
                ddGroup: me.dropGroup || me.ddGroup,
                allowContainerDrops: me.allowContainerDrops,
                appendOnly: me.appendOnly,
                allowParentInserts: me.allowParentInserts,
                expandDelay: me.expandDelay,
                dropHighlightColor: me.nodeHighlightColor,
                dropHighlight: me.nodeHighlightOnDrop
            });
        }

    }

});