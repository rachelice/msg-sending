/**
 * @class SimpleParams.controller.Params
 * @extends Ext.app.Controller
 */
Ext.define('SimpleParams.controller.Params', {
    extend: 'Ext.app.Controller',

    models: ['Param'],
    stores: ['Params'],

    views: [
        'params.Grid',
        'params.Form',
        'params.EditWindow',
        'params.DefaultTimeWindow',
        'params.ReminderWindow',
        'params.ContextMenu'
    ],

    refs: [
        {
            ref: 'listTree',
            selector: 'listTree'
        },
        {
            ref: 'paramForm',
            selector: 'paramForm'
        },
        {
            ref: 'paramGrid',
            selector: 'paramGrid'
        },
        {
            ref: 'paramsToolbar',
            selector: 'paramsToolbar'
        },
        {
            ref: 'paramEditWindow',
            selector: 'paramEditWindow',
            xtype: 'paramEditWindow',
            autoCreate: true
        },
        {
            ref: 'defaultTimeWindow',
            selector: 'defaultTimeWindow',
            xtype: 'defaultTimeWindow',
            autoCreate: true
        },
        {
            ref: 'reminderWindow',
            selector: 'reminderWindow',
            xtype: 'reminderWindow',
            forceCreate: true
        },
        {
            ref: 'contextMenu',
            selector: 'paramsContextMenu',
            xtype: 'paramsContextMenu',
            autoCreate: true
        }
    ],

    init: function() {
        var me = this;
        me.control(
            {
                'paramForm textfield': {
                    specialkey: me.handleSpecialKey
                },
                '[iconCls=params-new]': {
                    click: me.focusParamForm
                },
                '#delete-param-btn': {
                    click: me.handleDeleteClick
                },
                '#delete-param-item': {
                    click: me.handleDeleteClick
                },
                '#mark-complete-item': {
                    click: me.markComplete
                },
                '#mark-complete-btn': {
                    click: me.markComplete
                },
                '#mark-active-item': {
                    click: me.markActive
                },
                '#mark-active-btn': {
                    click: me.markActive
                },
                '#show-all-btn': {
                    click: me.filterAll
                },
                '#show-active-btn': {
                    click: me.filterActive
                },
                '#show-complete-btn': {
                    click: me.filterComplete
                },
                '#edit-param-item': {
                    click: me.handleEditItemClick
                },
                'paramGrid': {
                    recordedit: me.updateParam,
                    deleteclick: me.handleDeleteIconClick,
                    editclick: me.handleEditIconClick,
                    reminderselect: me.setReminder,
                    itemmouseenter: me.showActions,
                    itemmouseleave: me.hideActions,
                    selectionchange: me.toggleButtons,
                    columnresize: me.syncParamFormFieldWidth,
                    itemcontextmenu: me.showContextMenu
                },
                'paramsToolbar': {
                    afterrender: me.initShowAll
                },
                'paramEditWindow [name=has_reminder]': {
                    change: me.toggleReminderFields
                },
                '#cancel-param-edit-btn': {
                    click: me.hideEditWindow
                },
                '#save-param-edit-btn': {
                    click: me.handleSaveParamClick
                },
                'paramEditWindow [name=reminder_date]': {
                    change: me.syncReminderField
                },
                'paramEditWindow [name=reminder_time]': {
                    change: me.syncReminderField
                },
                '#toggle-complete-btn': {
                    click: me.toggleCompleteField
                },
                '#delete-param-window-btn': {
                    click: me.deleteParamAndCloseEditWindow
                },
                'defaultTimeWindow [name=default_time]': {
                    
                },
                '#cancel-default-time-edit-btn': {
                    click: me.hideDefaultTimeWindow
                },
                '#save-default-time-btn': {
                    click: me.saveDefaultTime
                },
                '[cls=snooze-btn]': {
                    click: me.snooze
                },
                '[cls=dismiss-reminder-btn]': {
                    click: me.dismissReminder
                }
            }
        );

        me.initReminderInterval();
    },

    /**
     * Handles a "specialkey" event on an field on the param form.
     * Creates a new param if the enter key is pressed.
     * @param {Ext.form.field.Text} field
     * @param {Ext.EventObject} e
     */
    handleSpecialKey: function(field, e) {
        if(e.getKey() === e.ENTER) {
            this.newParam();
        }
    },

    /**
     * Creates a new param based on the data currently contained in the param form.
     * Saves the new param to the server and adds it to the param list view.
     */
    newParam: function() {
        var me = this,
            form = me.getParamForm(),
            basicForm = form.getForm(),
            formEl = form.getEl(),
            titleField = form.getForm().findField('title'),
            param = Ext.create('SimpleParams.model.Param');

        // require title field to have a value
        if(!titleField.getValue()) {
            return;
        }

        // update the new param record with the data from the form.
        basicForm.updateRecord(param);

        // try to blur all of this form's items to make sure that the user can't type into a field while saving
        form.items.each(function(item) {
            var inputEl = item.getEl().down('input')
            if(inputEl) {
                inputEl.blur();
            }
        });

        // mask the form element while saving
        formEl.mask('saving . . .');
        // save the param to the server
        param.save({
            success: function(param, operation) {
                me.getParamsStore().add(param);
                me.refreshFiltersAndCount();
                me.getParamsStore().sort();
                titleField.reset();
                titleField.focus();
                formEl.unmask();
            },
            failure: function(param, operation) {
                var error = operation.getError(),
                    msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                Ext.MessageBox.show({
                    title: 'Add Param Failed',
                    msg: msg,
                    icon: Ext.Msg.ERROR,
                    buttons: Ext.Msg.OK
                });
                formEl.unmask();
            }
        });
    },

    /**
     * Handles the param list's "recordedit" event.
     * Updates the param on the server whenever a param is updated using the param grid's cell editor
     * @param {SimpleParams.model.Param} param    The param record that was edited
     */
    updateParam: function(param) {
        var me = this;

        if(param.modified.done === false) {
            param.set('reminder', null);
        }
        param.save({
            success: function(param, operation) {
                me.refreshFiltersAndCount();
                me.getParamsStore().sort();
            },
            failure: function(param, operation) {
                var error = operation.getError(),
                    msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                Ext.MessageBox.show({
                    title: 'Update Param Failed',
                    msg: msg,
                    icon: Ext.Msg.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        });
    },

    /**
     * Handles a click on a delete icon in the param grid.
     * @param {Ext.grid.View} view
     * @param {Number} rowIndex
     * @param {Number} colIndex
     * @param {Ext.grid.column.Action} column
     * @param {EventObject} e
     */
    handleDeleteIconClick: function(view, rowIndex, colIndex, column, e) {
        this.deleteParam(this.getParamsStore().getAt(rowIndex));
    },

    /**
     * Handles a click on the "delete param" button or context menu item
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    handleDeleteClick: function(button, e) {
        this.deleteParam(this.getParamGrid().getSelectionModel().getSelection()[0]);
    },

    /**
     * Deletes the param from the server and updates the view.
     * @param {SimpleParams.model.Param} param
     * @param {Function} successCallback           A function to call after the param has been deleted successfully
     */
    deleteParam: function(param, successCallback) {
        var me = this;
        
        Ext.Msg.show({
            title: 'Delete Param?',
            msg: 'Are you sure you want to delete this param?',
            buttons: Ext.Msg.YESNO,
            fn: function(response) {
                if(response === 'yes') {
                    param.destroy({
                        success: function(param, operation) {
                            me.getParamsStore().remove(param);
                            me.refreshFiltersAndCount();
                            if(successCallback) {
                                successCallback();
                            }
                        },
                        failure: function(param, operation) {
                            var error = operation.getError(),
                                msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                            Ext.MessageBox.show({
                                title: 'Delete Param Failed',
                                msg: msg,
                                icon: Ext.Msg.ERROR,
                                buttons: Ext.Msg.OK
                            });
                        }
                    });
                }
            }
        });
    },

    /**
     * Refreshes the param grid's list filter, and the param counts in the list tree
     */
    refreshFiltersAndCount: function() {
        // refresh the param filters
        this.getParamGrid().refreshFilters();
        // refresh the lists list view so that the param counts will be correct
        this.getListTree().refreshView();
    },

    /**
     * Handles a click on the "Edit" context menu item
     * @param {Ext.menu.Item} item
     * @param {EventObject} e
     */
    handleEditItemClick: function(item, e) {
        this.showEditWindow(this.getContextMenu().getParam());
    },

    /**
     * Handles a click on the "Edit Param" action column
     * @param {Ext.grid.View} view
     * @param {Number} rowIndex
     * @param {Number} colIndex
     * @param {Ext.grid.column.Action} column
     * @param {EventObject} e
     */
    handleEditIconClick: function(view, rowIndex, colIndex, column, e) {
        this.showEditWindow(view.getRecord(view.findTargetByEvent(e)));
    },

    /**
     * Handles the param grid's "selectionchange" event.
     * Disables or enables the param-related toolbar buttons depending on whether or not there is a selection.
     * @param {Ext.selection.RowModel} selModel
     * @param {SimpleParams.model.Param[]} params
     */
    toggleButtons: function(selModel, params) {
        var deleteParamBtn = Ext.getCmp('delete-param-btn'),
            markCompleteBtn = Ext.getCmp('mark-complete-btn'),
            markActiveBtn = Ext.getCmp('mark-active-btn');

        if(params.length === 0) {
            deleteParamBtn.disable();
            markCompleteBtn.disable();
            markActiveBtn.disable();
        } else {
            deleteParamBtn.enable();
            markCompleteBtn.enable();
            markActiveBtn.enable();
        }
    },

    /**
     * Handles a click on the "New Param" button or context menu item
     * focuses the title field on the new param form
     * @param {Ext.Component} component
     * @param {Ext.EventObject} e
     */
    focusParamForm: function(component, e) {
        this.getParamForm().query('[name=title]')[0].focus();
    },

    /**
     * Handles a click on the "Mark Complete" button or menu item
     * Sets the selected param's "done" field to true
     * @param {Ext.Component} component
     * @param {Ext.EventObject} e
     */
    markComplete: function(component, e) {
        var contextMenu = this.getContextMenu(),
            param = contextMenu.isVisible() ? contextMenu.getParam() : this.getParamGrid().getSelectionModel().getSelection()[0];

        param.set('done', true);
        param.set('reminder', null);
        param.save({
            failure: function(param, operation) {
                var error = operation.getError(),
                    msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                Ext.MessageBox.show({
                    title: '标记完成失败 ！',
                    msg: msg,
                    icon: Ext.Msg.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        });
        this.refreshFiltersAndCount();
    },

    /**
     * Handles a click on the "Mark Active" button
     * Sets the selected param's "done" field to false
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    markActive: function(button, e) {
        var contextMenu = this.getContextMenu(),
            param = contextMenu.isVisible() ? contextMenu.getParam() : this.getParamGrid().getSelectionModel().getSelection()[0];

        param.set('done', false);
        param.save({
            failure: function(param, operation) {
                var error = operation.getError(),
                    msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                Ext.MessageBox.show({
                    title: 'Mark Active Failed',
                    msg: msg,
                    icon: Ext.Msg.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        });
        this.refreshFiltersAndCount();
    },

    /**
     * Handles the param grid columnresize event.
     * Synchronizes the width the column's associated form field with the width of the column
     * @param {Ext.grid.header.Container} headerContainer
     * @param {Ext.column.Column} column
     * @param {Number} width The new column width
     */
    syncParamFormFieldWidth: function(headerContainer, column, width) {
        var field = this.getParamForm().query('[name=' + column.dataIndex + ']')[0];
        if (field) {
            field.setWidth(width - 5);
        }
    },

    /**
     * Handles a click on the "Show All" button. Removes any filter on the done field so that all params will be displayed
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    filterAll: function(button, e) {
        var paramsStore = this.getParamsStore(),
            filters = paramsStore.filters.getRange(0, paramsStore.filters.getCount() - 1),
            filterCount = filters.length,
            i = 0;

        if(button.pressed) {
            paramsStore.clearFilter();
            for(; i < filterCount; i++) {
                if(filters[i].property === 'done') {
                    filters.splice(i, 1);
                    filterCount --;
                }
            }
            paramsStore.filter(filters);
        } else {
            button.toggle();
        } 
    },

    /**
     * Handles a click on the "Show Active" button. Filters params by done = false
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    filterActive: function(button, e) {
        var paramsStore = this.getParamsStore(),
            filters = paramsStore.filters.getRange(0, paramsStore.filters.getCount() - 1),
            filterCount = filters.length,
            i = 0;

        if(button.pressed) {
            paramsStore.clearFilter();
            for(; i < filterCount; i++) {
                if(filters[i].property === 'done') {
                    filters.splice(i, 1);
                    filterCount --;
                }
            }
            filters.push({ property: 'done', value: false });
            this.getParamsStore().filter(filters);
        } else {
            button.toggle();
        } 
    },

    /**
     * Handles a click on the "Show Complete" button. Filters params by done = true.
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    filterComplete: function(button, e) {
        var paramsStore = this.getParamsStore(),
            filters = paramsStore.filters.getRange(0, paramsStore.filters.getCount() - 1),
            filterCount = filters.length,
            i = 0;

        if(button.pressed) {
            paramsStore.clearFilter();
            for(; i < filterCount; i++) {
                if(filters[i].property === 'done') {
                    filters.splice(i, 1);
                    filterCount --;
                }
            }
            filters.push({ property: 'done', value: true });
            this.getParamsStore().filter(filters);
        } else {
            button.toggle();
        } 
    },

    /**
     * Handles the params toolbar's render event
     * Initializes the "Show All" Button to the pressed state
     * @param {SimpleParams.view.Toolbar} toolbar
     */
    initShowAll: function(toolbar) {
        toolbar.getComponent('show-all-btn').toggle();
    },

    /**
     * Handles a mouseenter event on a param grid item.
     * Shows the item's action icons.
     * @param {Ext.grid.View} view
     * @param {SimpleParams.model.Param} param
     * @param {HTMLElement} node
     * @param {Number} rowIndex
     * @param {Ext.EventObject} e
     */
    showActions: function(view, param, node, rowIndex, e) {
        var icons = Ext.DomQuery.select('.x-action-col-icon', node);
        Ext.each(icons, function(icon){
            Ext.get(icon).removeCls('x-hidden');
        });
    },

    /**
     * Handles a mouseleave event on a param grid item.
     * Hides the item's action icons.
     * @param {Ext.grid.View} view
     * @param {SimpleParams.model.Param} param
     * @param {HTMLElement} node
     * @param {Number} rowIndex
     * @param {Ext.EventObject} e
     */
    hideActions: function(view, param, node, rowIndex, e) {
        var icons = Ext.DomQuery.select('.x-action-col-icon', node);
        Ext.each(icons, function(icon){
            Ext.get(icon).addCls('x-hidden');
        });
    },

    /**
     * Handles the param grid's itemcontextmenu event
     * Shows the param context menu.
     * @param {Ext.grid.View} view
     * @param {SimpleParams.model.Param} param
     * @param {HTMLElement} node
     * @param {Number} rowIndex
     * @param {Ext.EventObject} e
     */
    showContextMenu: function(view, param, node, rowIndex, e) {
        var contextMenu = this.getContextMenu(),
            markCompleteItem = Ext.getCmp('mark-complete-item'),
            markActiveItem = Ext.getCmp('mark-active-item');

        if(param.get('done')) {
            markCompleteItem.hide();
            markActiveItem.show();
        } else {
            markCompleteItem.show();
            markActiveItem.hide();
        }
        contextMenu.setParam(param);
        contextMenu.showAt(e.getX(), e.getY());
        e.preventDefault();
    },

    /**
     * Shows the "Edit Param" window
     * @param {SimpleParams.model.Param} param       the param to edit
     */
    showEditWindow: function(param) {
        var me = this,
            paramEditWindow = me.getParamEditWindow(),
            form =  paramEditWindow.down('form').getForm(),
            reminderCheckbox = form.findField('has_reminder'),
            dateField = form.findField('reminder_date'),
            timeField = form.findField('reminder_time'),
            reminder = param.get('reminder');

        // Set the params title as the title of the edit window
        paramEditWindow.setTitle('Edit Param - ' + param.get('title'));
        // load the param data into the form
        paramEditWindow.down('form').loadRecord(param);
        // set the text of the toggle-complete button depending on the params "done" value
        Ext.getCmp('toggle-complete-btn').setText(param.get('done') ? 'Mark Active' : '标记完成');
        paramEditWindow.show();

        if(param.get('reminder')) {
            // if the param already has a reminder set check the reminder checkbox and populate the reminder date and reminder time fields
            reminderCheckbox.setValue(true);
            dateField.setValue(Ext.Date.clearTime(reminder, true));
            timeField.setValue(Ext.Date.format(reminder, timeField.format)); 
        } else {
            // if the param does not have a reminder set uncheck the reminder checkbox and set the reminder date and time fields to null
            reminderCheckbox.setValue(false);
            dateField.setValue(null);
            timeField.setValue(null); 
        }

        if(param.get('done')) {
            // if the param is done disable the reminder checkbox (reminders cannot be set on completed params)
            reminderCheckbox.disable();
        } else {
            reminderCheckbox.enable();
        }

    },

    /**
     * Handles a click on the "Edit Param" window's cancel button
     * Hides the "Edit Param" window
     * @param {Ext.Button} button
     * @param {Ext.EventObject} e
     */
    hideEditWindow: function(button, e) {
        this.getParamEditWindow().close();
    },

    /**
     * Handles the change event on the param edit window's "has_reminder" checkbox
     * Toggles the visibility of the reminder date and time fields
     * @param {Ext.form.field.Checkbox} checkbox
     * @param {Boolean} newValue
     * @param {Boolean} oldValue
     */
    toggleReminderFields: function(checkbox, newValue, oldValue) {
        var paramEditWindow = this.getParamEditWindow(),
            windowEl = paramEditWindow.getEl(),
            form = paramEditWindow.down('form').getForm(),
            param = form.getRecord(),
            dateField = form.findField('reminder_date'),
            timeField = form.findField('reminder_time'),
            defaultTimeDate, defaultTimeMilliseconds;
        
        if(newValue) { // if the "has reminder" checkbox was checked
            windowEl.mask('loading');
            // get the default reminder time from the server or cache
            this.getDefaultReminderTime(function(defaultTime) {
                // enable the date and time fields
                dateField.enable();
                timeField.enable();
                if(!dateField.getValue()) {
                    // if the reminder date has not already been set, default the reminder date to the param's due date
                    // or the current date if the param does not have a due date
                    dateField.setValue(param.get('due') || Ext.Date.clearTime(new Date()));
                    timeField.setValue(defaultTime);
                }
                // set the form's hidden reminder field by combining the reminder date and time fields
                defaultTimeDate = timeField.getValue();
                defaultTimeMilliseconds = defaultTimeDate - Ext.Date.clearTime(defaultTimeDate, true);
                form.findField('reminder').setValue(new Date(dateField.getValue().getTime() + defaultTimeMilliseconds));
                windowEl.unmask();
            }, timeField.format);
        } else { // if the "has reminder" checkbox was unchecked
            // nullify the form's hidden reminder field and disable the reminder date and time fields
            form.findField('reminder').setValue(null);
            dateField.disable();
            timeField.disable();
        }
    },

    /**
     * Handles a click on the "Param Edit" window's save button.
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    handleSaveParamClick: function(button, e) {
        this.saveEditWindow();
    },

    /**
     * Updates the param record with the form data from the edit window and saves the param to the server.
     */
    saveEditWindow: function() {
        var paramEditWindow = this.getParamEditWindow(),
            windowEl = paramEditWindow.getEl(),
            form = paramEditWindow.down('form').getForm(),
            param = form.getRecord();

        if(form.isValid()) {
            windowEl.mask('saving');
            form.updateRecord(param);
            if(param.modified.done === false) {
                param.set('reminder', null);
            }
            param.save({
                success: function(param, operation) {
                    windowEl.unmask();
                    paramEditWindow.close();
                },
                failure: function(param, operation) {
                    var error = operation.getError(),
                       msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                    Ext.MessageBox.show({
                        title: 'Edit Param Failed',
                        msg: msg,
                        icon: Ext.Msg.ERROR,
                        buttons: Ext.Msg.OK
                    });
                    windowEl.unmask();
                }
            })
        } else {
            Ext.Msg.alert('Invalid Data', 'Please correct form errors');
        }
    },

    /**
     * Syncronizes the value of the edit window's hidden reminder field whenever "reminder_date", or "reminder_time" is changed
     * @param {Ext.form.field.Picker} field     the date or time picker
     * @param {Date} oldValue
     * @param {Date} newValue
     */
    syncReminderField: function(field, oldValue, newValue) {
        var form = this.getParamEditWindow().down('form').getForm(),
            reminderField = form.findField('reminder'),
            date = form.findField('reminder_date').getValue(),
            timeDate = form.findField('reminder_time').getValue(),
            time, reminderDate;

        if(date && timeDate) {
            time = timeDate - Ext.Date.clearTime(timeDate, true);
            reminderDate = new Date(date.getTime() + time);
            reminderField.setValue(reminderDate); 
        }
    },

    /**
     * Toggles the edit window's "done" field to true when the "Mark Complete" or "Mark Active" button on the edit window is clicked
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    toggleCompleteField: function(button, e) {
        var paramEditWindow = this.getParamEditWindow(),
            doneField = paramEditWindow.down('form').getForm().findField('done');

        if(doneField.getValue() === 'true') {
            doneField.setValue(false);
        } else {
            doneField.setValue(true);
        }
        this.saveEditWindow();
    },

    /**
     * Handles a click on the "Delete" button on the edit window.
     * Deletes the param and closes the edit window
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    deleteParamAndCloseEditWindow: function(button, e) {
        var me = this,
            paramEditWindow = me.getParamEditWindow(),
            param = paramEditWindow.down('form').getRecord();

        me.deleteParam(param, function() {
            me.getParamEditWindow().close();
        });
    },

    /**
     * Handles the Param Grid's `reminderselect` event
     * Sets a param's reminder
     * @param {SimpleParams.model.Param} param    the underlying record of the row that was clicked to show the reminder menu
     * @param {String|Number} value      The value that was selected
     */
    setReminder: function(param, value) {
        var me = this,
            defaultTimeWindow = me.getDefaultTimeWindow(),
            defaultTimeField = defaultTimeWindow.down('form').getForm().findField('default_time'),
            defaultTimeDate, defaultTimeMilliseconds;

        me.getDefaultReminderTime(function(defaultTime) {
            if(value === 'set') {
                // if the user selected "Set Default Time", show the default time window.
                defaultTimeField.setValue(defaultTime);
                defaultTimeWindow.show();
            } else {
                if(Ext.isNumber(value)) {
                    // if the user selected a reminder time, set the reminder by adding the user selected value to the due date
                    defaultTimeDate = Ext.Date.parse(defaultTime, defaultTimeField.format);
                    defaultTimeMilliseconds = defaultTimeDate - Ext.Date.clearTime(defaultTimeDate, true);
                    param.set('reminder', new Date(param.get('due').getTime() - (value * 86400000) + defaultTimeMilliseconds));
                } else {
                    // if the user selected "No Reminder" set the reminder field to null
                    param.set('reminder', null);
                }
                param.save({
                    failure: function(param, operation) {
                        var error = operation.getError(),
                           msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                        Ext.MessageBox.show({
                            title: 'Set Reminder Failed',
                            msg: msg,
                            icon: Ext.Msg.ERROR,
                            buttons: Ext.Msg.OK
                        });
                    }
                });
            }
        }, defaultTimeField.format);
    },

    /**
     * Gets the default reminder time and passes it to the callback function.
     * Retrieves default reminder time from the server on the first call, then caches it for future calls.
     * @param {Function} callback
     * @param {String} timeFormat, the time format used to encode the time: the time format of the destination TimeField
     */
    getDefaultReminderTime: function(callback, timeFormat) {
        var me = this,
            defaultReminderTime;

        if(me.defaultReminderTime) {
            callback(me.defaultReminderTime);
        } else {
            me.defaultReminderTime = Ext.Date.format(Ext.Date.parse('8', 'g'), timeFormat || "g:i A"); // the default time if no value can be retrieved from storage
            if (SimpleParamsSettings.useLocalStorage) {
                defaultReminderTime = localStorage.getItem('SimpleParams-defaultReminderTime');
                if (defaultReminderTime && Ext.Date.parse(defaultReminderTime, timeFormat)) {
                    me.defaultReminderTime = defaultReminderTime;
                }
                callback(me.defaultReminderTime);
            } else {
                Ext.Ajax.request({
                    url: 'php/config/read.php',
                    params: {
                        key: 'default.reminder.time'
                    },
                    success: function(response, options) {
                        var responseData = Ext.decode(response.responseText);
                        if(responseData.success && responseData.value && Ext.Date.parse(responseData.value, timeFormat)) {
                            me.defaultReminderTime = responseData.value;
                        }
                        callback(me.defaultReminderTime);
                    },
                    failure: function(response, options) {
                        callback(me.defaultReminderTime);
                    }
                });
            }
        }
    },

    /**
     * Hides the default reminder time window when the cancel button is clicked
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    hideDefaultTimeWindow: function(button, e) {
        this.getDefaultTimeWindow().close();
    },

    /**
     * Saves the default reminder time to the server when the OK button is clicked
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    saveDefaultTime: function(button, e) {
        var me = this,
            defaultTimeWindow = me.getDefaultTimeWindow(),
            windowEl = defaultTimeWindow.getEl(),
            field = defaultTimeWindow.down('form').getForm().findField('default_time'),
            time = field.getRawValue();
            
        if (!field.isValid()) {
            return;
        }

        if (SimpleParamsSettings.useLocalStorage) {
            localStorage.setItem('SimpleParams-defaultReminderTime', time);
            me.defaultReminderTime = time;
            defaultTimeWindow.close();
        } else {
            windowEl.mask('saving');
            Ext.Ajax.request({
                url: 'php/config/update.php',
                params: {
                    key: 'default.reminder.time',
                    value: time
                },
                success: function(response, options) {
                    var responseData = Ext.decode(response.responseText);

                    if(responseData.success) {
                        me.defaultReminderTime = time;
                        defaultTimeWindow.close();
                    } else {
                        Ext.MessageBox.show({
                            title: 'Set Default Time Failed',
                            msg: responseData.message,
                            icon: Ext.Msg.ERROR,
                            buttons: Ext.Msg.OK
                        });
                    }
                    windowEl.unmask();
                },
                failure: function(response, options) {
                    Ext.MessageBox.show({
                        title: 'Set Default Time Failed',
                        msg: response.status + ' ' + response.statusText,
                        icon: Ext.Msg.ERROR,
                        buttons: Ext.Msg.OK
                    });
                    windowEl.unmask();
                }
            });
        }
    },

    /**
     * Initializes checking for params that have passed their reminder date at 10 second intervals.
     */
    initReminderInterval: function() {
        var me = this,
            now, reminderDate;

        setInterval(function() {
            now = new Date();
            me.getParamsStore().each(function(param) {
                reminderDate = param.get('reminder');
                if(reminderDate && reminderDate < now && !param.get('done')) {
                    me.showReminderWindow(param);
                }
            });
        }, 10000);
    },

    /**
     * Shows the reminder window for a given param
     * @param {SimpleParams.model.Param} param
     */
    showReminderWindow: function(param) {
        var reminderWindow = this.getReminderWindow(),
            reminderDetailsBox = reminderWindow.down('[cls=params-reminder-details]'),
            title = param.get('title');

        param.set('reminder', null);
        param.save({
            failure: function(param, operation) {
                var error = operation.getError(),
                   msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                Ext.MessageBox.show({
                    title: 'Clear Reminder Failed',
                    msg: msg,
                    icon: Ext.Msg.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        });
        reminderWindow.setParam(param);
        reminderWindow.setTitle('Reminder - ' + title);
        reminderDetailsBox.update({
            title: title,
            due: param.get('due')
        });
        reminderWindow.show();
    },


    /**
     * Handles a click on the snooze button on the reminder window.
     * Sets the param's reminder date to the current date plus snooze time selected
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    snooze: function(button, e) {
        var reminderWindow = button.findParentByType('window'),
            param = reminderWindow.getParam(),
            snoozeMilliseconds = reminderWindow.down('[name=snooze_time]').getValue() * 60000,
            reminderDate = new Date(new Date().getTime() + snoozeMilliseconds);

        param.set('reminder', reminderDate);
        param.save({
            failure: function(param, operation) {
                var error = operation.getError(),
                   msg = Ext.isObject(error) ? error.status + ' ' + error.statusText : error;

                Ext.MessageBox.show({
                    title: 'Set Reminder Failed',
                    msg: msg,
                    icon: Ext.Msg.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        });
        reminderWindow.close();
    },

    /**
     * Handle's a click on the reminder window's dismiss button.
     * Hides the reminder window.
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} e
     */
    dismissReminder: function(button, e) {
        button.findParentByType('window').close();
    }

});