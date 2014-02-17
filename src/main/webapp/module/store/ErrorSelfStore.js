/**
 * Created with JetBrains WebStorm.
 * User: Administrator
 * Date: 13-4-15
 * Time: 下午12:04
 * To change this template use File | Settings | File Templates.
 */



Ext.define('Fes.store.ErrorSelfStore', {
    extend : 'Ext.data.Store',
    fields: [
        {name : 'id',type:'int'},
        {name : 'name',mapping:'terminal',type:'string'}
    ],
    proxy : {
        type : 'rest',
        url : 'errorlogs/root',
        reader : {
            type : 'json',
            root : 'root'
        },
        writer : {
            type : 'json'
        }
    },
    autoLoad : false,
    remoteSort : true
});
