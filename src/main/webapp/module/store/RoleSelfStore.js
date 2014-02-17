/**
 * Created with JetBrains WebStorm.
 * User: Administrator
 * Date: 13-4-15
 * Time: 下午12:04
 * To change this template use File | Settings | File Templates.
 */



Ext.define('Fes.store.RoleSelfStore', {
    extend : 'Ext.data.Store',
    fields: [
        {name : 'id',type:'int'},
        {name : 'name',type:'string'},
        {name : 'code',type:'string'},
        {name : 'description',type:'string'},
        {name : 'roleLevel'}
    ],
    proxy : {
        type : 'rest',
        url : 'users/roles',
        reader : {
            type : 'json',
            root : 'root'
        },
        writer : {
            type : 'json'
        }
    },
    autoLoad : true,
    remoteSort : true
});
