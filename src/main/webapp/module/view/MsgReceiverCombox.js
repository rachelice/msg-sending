Ext.define("Fes.view.combo.MsgReceiverComboBox",{
	extend:'Ext.form.ComboBox',
	alias :'widget.MsgReceiverComboBox',
	queryMode: 'remote',
	valueField: 'mobileNumber',
    displayField: 'name',
	store:'MsgReceiverStore'
});
