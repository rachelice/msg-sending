Ext.define('SimpleParams.model.Param', {
    extend: 'Ext.data.Model',
    requires:[
        'Ext.data.proxy.LocalStorage',
        'Ext.data.proxy.Ajax'
    ],
    fields: [
        { name: 'id', type: 'int' },
        { name: 'title' },
        { name: 'list_id', type: 'int' },
        { name: 'due', type: 'date', dateFormat: 'c' },
        { name: 'reminder', type: 'date', dateFormat: 'c' },
        { name: 'done', type: 'boolean', defaultValue: false },
        { name: 'note' }
    ],

    proxy: SimpleParamsSettings.useLocalStorage ? {
        type: 'localstorage',
        id: 'SimpleParams-Param'
    } : {
        type: 'ajax',
        api: {
            create: 'php/param/create.php',
            read: 'php/param/read.php',
            update: 'php/param/update.php',
            destroy: 'php/param/delete.php'
        },
        reader: {
            type: 'json',
            root: 'params',
            messageProperty: 'message'
        }
    }

});