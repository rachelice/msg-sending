/**
 * @class SimpleReports.view.lists.Tree
 * @extends Ext.tree.Panel
 * The task list view.  A tree that displays all of the task lists.
 */
Ext.define('SimpleReports.view.lists.Tree', {
    extend: 'Ext.tree.Panel',
    xtype: 'listTree',
    requires: [
        'Ext.grid.plugin.CellEditing',
        'Ext.tree.plugin.TreeViewDragDrop',
        'Ext.grid.column.Action'
    ],
    title: '清单',
    store: 'Lists',
    hideHeaders: true,

    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'bottom',
            items: [
                {
                    iconCls: 'tasks-new-list',
                    tooltip: '新清单'
                },
                {
                    iconCls: 'tasks-delete-list',
                    id: 'delete-list-btn',
                    tooltip: '删除清单'
                },
                {
                    iconCls: 'tasks-new-folder',
                    tooltip: '新目录'
                },
                {
                    iconCls: 'tasks-delete-folder',
                    id: 'delete-folder-btn',
                    tooltip: '删除目录'
                }
            ]
        }
    ],

    viewConfig: {
        plugins: {
            ptype: 'tasksdragdrop',
            dragText: 'Drag to reorder',
            ddGroup: 'task'
        }
    },

    initComponent: function() {
        var me = this;
            
        /**
         * This Tree Panel's cell editing plugin
         * @property cellEditingPlugin
         * @type Ext.grid.plugin.CellEditing
         */
        me.plugins = [me.cellEditingPlugin = Ext.create('Ext.grid.plugin.CellEditing')];

        me.columns = [
            {
                xtype: 'treecolumn',
                dataIndex: 'parName',
                flex: 1,
                editor: {
                    xtype: 'textfield',
                    selectOnFocus: true,
                    allowOnlyWhitespace: false
                },
                renderer: Ext.bind(me.renderName, me)
            },
            {
                xtype: 'actioncolumn',
                width: 24,
                icon:  extLibPath+'/examples/simple-tasks/resources/images/delete.png',
                iconCls: 'x-hidden',
                tooltip: 'Delete',
                handler: Ext.bind(me.handleDeleteClick, me)
            }
        ];
        
        me.callParent(arguments);

        me.addEvents(
            /**
             * @event deleteclick
             * Fires when the delete icon is clicked
             * @param {Ext.grid.View} gridView
             * @param {Number} rowIndex
             * @param {Number} colIndex
             * @param {Ext.grid.column.Action} column
             * @param {EventObject} e
             */
            'deleteclick',

            /**
             * @event taskdrop
             * Fires when a task record is dropped on this grid
             * @param {SimpleReports.model.Task} task       The task record
             * @param {SimpleReports.model.List} list       The list that the task was dropped on
             */
            'taskdrop',

            /**
             * @event listdrop
             * Fires when a list record is dropped on this grid
             * @param {SimpleReports.model.List} list         The list that was dropped
             * @param {SimpleReports.model.List} overList     The list that the list was dropped on
             * @param {String} position               `"before"` or `"after"` depending on whether the mouse is above or below the midline of the node.
             */
            'listdrop'
        );

        me.on('beforeedit', me.handleBeforeEdit, me);
        me.relayEvents(me.getView(), ['taskdrop', 'listdrop'])

    },

    /**
     * Handles a click on a delete icon
     * @private
     * @param {Ext.tree.View} treeView
     * @param {Number} rowIndex
     * @param {Number} colIndex
     * @param {Ext.grid.column.Action} column
     * @param {EventObject} e
     */
    handleDeleteClick: function(gridView, rowIndex, colIndex, column, e) {
        // Fire a "deleteclick" event with all the same args as this handler
        this.fireEvent('deleteclick', gridView, rowIndex, colIndex, column, e);
    },

    /**
     * Handles this grid's "beforeedit" event (relayed from the CellEditing plugin).
     * Prevents editing of "All Lists" root by returning false if the record has an id of -1
     * @private
     * @param {Ext.grid.plugin.CellEditing} editingPlugin       The cell editing plugin
     * @param {Object} e                                        an edit event object
     */
    handleBeforeEdit: function(editingPlugin, e) {
        return e.record.get('id') !== -1;
    },

    /**
     * Renderer for the name field.
     * Adds the task count after the list name.
     * @private
     * @param {String} value
     * @param {Object} metaData
     * @param {SimpleReports.model.List} list
     * @param {Number} rowIndex
     * @param {Number} colIndex
     * @param {SimpleReports.store.Lists} store
     * @param {Ext.grid.View} view
     */
    renderName: function(value, metaData, list, rowIndex, colIndex, store, view) {
    //	console.log('renderName-value='+value);
        var tasksStore = Ext.StoreMgr.lookup('Tasks'),
            count = 0;

        (function countTasks(list) {
            count += tasksStore.queryBy(function(task, id) {
                // only show count for tasks that are not done
                return task.get('parentParamId') === list.get('id') && task.get('state') === false;
            }).getCount();

            list.eachChild(function(child) {
                countTasks(child);
            });
        })(list);

        return value + ' (' + count + ')';
    },

    /**
     * Triggers the list tree to refresh its view.  This is necessary in two scenarios:
     * 1) Since the lists and tasks are loaded asyncrounously, The Lists store may have finished
     *    loading before the tasks store.  In this case, the tasks data would not be available so all
     *    of the task counts would be rendered as (0).
     * 2) When a task is dragged and dropped onto a list, or when a list is deleted the task count won't automatially be updated
     *    because none of the data in the lists store actually changed (the renderer gets the count
     *    from the tasks store).
     *    
     * In both situations refreshing the lists view we ensure that the task counts are accurate.
     */
    refreshView: function() {
        // refresh the data in the view.  This will trigger the column renderers to run, making sure the task counts are up to date.
        this.getView().refresh();
    }



});