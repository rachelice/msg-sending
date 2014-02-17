Ext.define('SimpleReports.store.Tasks', {
    extend: 'Ext.data.Store',
    model: 'SimpleReports.model.Task',
    groupers: [{
        property: 'parentParamId',
        // Use the group string here so we don't need to worry about time
        // during any grouping based comparisons
        getGroupString: function(rec){
            return rec.get('parentParamName');//Ext.Date.format(rec.get('due'), 'Y-m-d');
        }
    }]
});