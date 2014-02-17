Ext.define('SimpleParams.store.Lists', {
    extend: 'Ext.data.TreeStore',
    model: 'SimpleParams.model.List',

    root: {
        expanded: true,
        id: -1,
        name: 'All Lists'
    }

});