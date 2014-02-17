/**
 * @class SimpleParams.view.params.List
 * @extends Ext.grid.Panel
 * The params list view.  A grid that displays a list of params.
 */
Ext.define('SimpleParams.view.params.Grid', {
    extend: 'Ext.grid.Panel',
    xtype: 'paramGrid',
    requires: [
        'SimpleParams.ux.DragDrop',
        'SimpleParams.ux.StatusColumn',
        'SimpleParams.ux.ReminderColumn',
        'Ext.grid.plugin.CellEditing',
        'Ext.grid.column.Action',
        'Ext.grid.column.Date',
        'Ext.grid.feature.Grouping',
        'Ext.grid.plugin.DragDrop',
        'Ext.ux.TreePicker'
    ],
    store: 'Params',

    viewConfig: {
        plugins: {
            ptype: 'gridviewdragdrop',
            ddGroup: 'param',
            dragText: 'Drag param to change list',
            enableDrop: false
        },
        getRowClass: function(record, rowIndex, rowParams, store){
            var due = record.get('due');
            if(record.get('done')) {
                return 'params-completed-param';
            } else if(due && (due < Ext.Date.clearTime(new Date()))) {
                return 'params-overdue-param';
            }
        }
    },

    dockedItems: [
        {
            xtype: 'paramForm',
            dock: 'top',
            // the grid's column headers are a docked item with a weight of 100.
            // giving this a weight of 101 causes it to be docked under the column headers
            weight: 101,
            bodyStyle: {
                'background-color': '#E4E5E7'
            }
        }
    ],

    initComponent: function() {
        var me = this,
            cellEditingPlugin = Ext.create('Ext.grid.plugin.CellEditing'),
            groupingFeature = Ext.create('Ext.grid.feature.Grouping', {
                groupHeaderTpl: [
                    '{groupValue:this.renderDueDate}',
                    {
                        renderDueDate: me.renderDueDate
                    }
                ],
                enableGroupingMenu: false
            });

        me.plugins = [cellEditingPlugin];

        me.features = [groupingFeature];

        me.columns = {
            defaults: {
                draggable: false,
                resizable: false,
                hideable: false
            },
            items: [
                {
                    xtype: 'statuscolumn',
                    dataIndex: 'done',
                    cls: 'params-icon-column-header params-done-column-header',
                    width: 24,
                    align: 'center',
                    menuDisabled: true,
                    sortable: false,
                    listeners: {
                        'checkchange': Ext.bind(me.handleCheckChange, me)
                    }
                },
                {
                    text: '简介',
                    dataIndex: 'title',
                    flex: 1,
                    emptyCellText: '',
                    editor: {
                        xtype: 'textfield',
                        selectOnFocus: true
                    }
                },
                {
                    text: '清单',
                    dataIndex: 'list_id',
                    width: 200,
                    editor: {
                        xtype: 'treepicker',
                        displayField: 'name',
                        store: Ext.create('SimpleParams.store.Lists', {storeId: 'Lists-ParamGrid' })
                    },
                    renderer: me.renderList
                },
                {
                    xtype: 'datecolumn',
                    text: '到期日',
                    dataIndex: 'due',
                    width: 100,
                    editor: 'datefield',
                    format: 'Y/n/j',
                    emptyCellText: ''
                },
                {
                    xtype: 'remindercolumn',
                    dataIndex: 'reminder',
                    cls: 'params-icon-column-header params-reminder-column-header',
                    width: 24,
                    tooltip: '设置提醒',
                    menuPosition: 'tr-br',
                    menuDisabled: true,
                    sortable: false,
                    emptyCellText: '',
                    listeners: {
                        select: Ext.bind(me.handleReminderSelect, me)
                    }
                },
                {
                    xtype: 'actioncolumn',
                    cls: 'params-icon-column-header params-edit-column-header',
                    width: 24,
                      
                    icon: extLibPath+'/examples/simple-params/resources/images/edit_param.png',
                    iconCls: 'x-hidden',
                    tooltip: '编辑',
                    menuDisabled: true,
                    sortable: false,
                    handler: Ext.bind(me.handleEditClick, me)
                },
                {
                    xtype: 'actioncolumn',
                    cls: 'params-icon-column-header params-delete-column-header',
                    width: 24,
                    icon: extLibPath+'/examples/simple-params/resources/images/delete_param.png',
                    iconCls: 'x-hidden',
                    tooltip: '删除',
                    menuDisabled: true,
                    sortable: false,
                    handler: Ext.bind(me.handleDeleteClick, me)
                }
            ]
        };

        me.callParent(arguments);

        me.addEvents(
            /**
             * @event editclick
             * Fires when an edit icon is clicked
             * @param {Ext.grid.View} view
             * @param {Number} rowIndex
             * @param {Number} colIndex
             * @param {Ext.grid.column.Action} column
             * @param {EventObject} e
             */
            'editclick',

            /**
             * @event deleteclick
             * Fires when a delete icon is clicked
             * @param {Ext.grid.View} view
             * @param {Number} rowIndex
             * @param {Number} colIndex
             * @param {Ext.grid.column.Action} column
             * @param {EventObject} e
             */
            'deleteclick',

            /**
             * @event edit
             * Fires when a record is edited using the CellEditing plugin or the statuscolumn
             * @param {SimpleParams.model.Param} param     The param record that was edited
             */
            'recordedit',
            
            /**
             * @event reminderselect
             * Fires when a reminder time is selected from the reminder column's dropdown menu
             * @param {SimpleParams.model.Param} param    the underlying record of the row that was clicked to show the reminder menu
             * @param {String|Number} value      The value that was selected
             */
            'reminderselect'
        );

        cellEditingPlugin.on('edit', me.handleCellEdit, this);

    },

    /**
     * Handles a click on the edit icon
     * @private
     * @param {Ext.grid.View} gridView
     * @param {Number} rowIndex
     * @param {Number} colIndex
     * @param {Ext.grid.column.Action} column
     * @param {EventObject} e
     */
    handleEditClick: function(gridView, rowIndex, colIndex, column, e) {
        // Fire a "deleteclick" event with all the same args as this handler
        this.fireEvent('editclick', gridView, rowIndex, colIndex, column, e);
    },

    /**
     * Handles a click on a delete icon
     * @private
     * @param {Ext.grid.View} gridView
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
     * Handles a "checkchange" event on the "done" column
     * @private
     * @param {SimpleParams.ux.StatusColumn} column
     * @param {Number} rowIndex
     * @param {Boolean} checked
     */
    handleCheckChange: function(column, rowIndex, checked) {
        this.fireEvent('recordedit', this.store.getAt(rowIndex));
    },

    /**
     * Handles a "select" event on the reminder column
     * @private
     * @param {SimpleParams.model.Param} param    the underlying record of the row that was clicked to show the reminder menu
     * @param {String|Number} value      The value that was selected
     */
    handleReminderSelect: function(param, value) {
        this.fireEvent('reminderselect', param, value);
    },

    /**
     * Handles the CellEditing plugin's "edit" event
     * @private
     * @param {Ext.grid.plugin.CellEditing} editor
     * @param {Object} e                                an edit event object
     */
    handleCellEdit: function(editor, e) {
        this.fireEvent('recordedit', e.record);
    },

    /**
     * Reapplies the store's current filters. This is needed because when data in the store is modified
     * after filters have been applied, the filters do not automatically get applied to the new data.
     */
    refreshFilters: function() {
        var store = this.store,
            filters = store.filters;

        // save a reference to the existing param filters before clearing them
        filters = filters.getRange(0, filters.getCount() - 1);

        // clear the params store's filters and reapply them.
        store.clearFilter();
        store.filter(filters);
    },

    /**
     * Renderer for the list column
     * @private
     * @param {Number} value
     * @param {Object} metaData
     * @param {SimpleParams.model.Param} param
     * @param {Number} rowIndex
     * @param {Number} colIndex
     * @param {SimpleParams.store.Params} store
     * @param {Ext.grid.View} view
     */
    renderList: function(value, metaData, param, rowIndex, colIndex, store, view) {
        var listsStore = Ext.getStore('Lists'),
            node = value ? listsStore.getNodeById(value) : listsStore.getRootNode();

        return node.get('name');
    },

    /**
     * Renderer for the group headers
     * @private
     * @param {Date} date
     */
    renderDueDate: function(date) {
        var today = Ext.Date.clearTime(new Date()),
            todayTime = today.getTime(),
            dueDateTime;

        if(!date) {
            return '(No Date)';
        }
        dueDateTime = Ext.Date.clearTime(date).getTime();
        if(dueDateTime === todayTime) {
            return 'Today';
        }
        if(dueDateTime > todayTime) {
            if(dueDateTime === Ext.Date.add(today, Ext.Date.DAY, 1).getTime()) {
                // due date is current date + 1 day
                return 'Tomorrow';
            }
            if(dueDateTime < Ext.Date.add(today, Ext.Date.DAY, 7).getTime()) {
                // if the due date is less than one week in the future, return the day of the week.
                return Ext.Date.format(date, 'l');
            }
        } else {
            if(dueDateTime === Ext.Date.add(today, Ext.Date.DAY, -1).getTime()) {
                // due date is current date - 1 day.
                return 'Yesterday';
            }
            if(dueDateTime > Ext.Date.add(today, Ext.Date.DAY, -7).getTime()) {
                // if the due date is less than one week past, return 'Last' + the day of the week.
                return 'Last '+ Ext.Date.format(date, 'l');
            }
        }
        return date.getFullYear() === today.getFullYear() ? Ext.Date.format(date, 'D m/d') : Ext.Date.format(date, 'D m/d/Y');
    }

});