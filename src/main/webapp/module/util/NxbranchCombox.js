Ext.define('Fes.util.NxbranchCombox',{
    extend: 'Ext.form.field.ComboBox',
    alias: 'widget.nxbranchCombox',
    valueField: 'brccode',
    displayField: 'brcname',
    triggerAction:"all",
    typeAhead:true,
    editable : true,
    minChars:0,
    emptyText:"请选择机构",
    store: Ext.create('Fes.store.NxbranchComboxStore'),  

    getTerminalValue: function()
    {
        return this.getValue();
    }, 
    getDispalyValue: function()
    {
        return this.getRawValue();
    }

});
