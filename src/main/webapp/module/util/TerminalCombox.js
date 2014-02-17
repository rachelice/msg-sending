Ext.define('Fes.util.TerminalCombox',{
    extend: 'Ext.form.field.ComboBox',
    alias: 'widget.terminalCombox',
    valueField: 'terminal',
    displayField: 'name',
    triggerAction:"all",
    emptyText:"请选择系统",
    store: Ext.create('Fes.store.TerminalComboxStore'),

    getTerminalValue: function()
    {
        return this.getValue();
    }, 
    getDispalyValue: function()
    {
        return this.getRawValue();
    }

});
