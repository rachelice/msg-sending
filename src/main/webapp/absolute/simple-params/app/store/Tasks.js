Ext.define('SimpleParams.store.Params', {
    extend: 'Ext.data.Store',
    model: 'SimpleParams.model.Param',
    groupers: [{
        property: 'due',
        // Use the group string here so we don't need to worry about time
        // during any grouping based comparisons
        getGroupString: function(rec){
            return Ext.Date.format(rec.get('due'), 'Y-m-d');
        }
    }]
});