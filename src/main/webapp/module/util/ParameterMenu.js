 //定义菜单  
    Ext.define('Fes.util.ParameterMenu', {  
        extend: 'Ext.menu.Menu',  
        xtype: 'parameterMenu',  
        items: [  
            {  
                text: '新建参数',  
                iconCls: 'tasks-new-list',  
                id: 'new-list-item'  
            },  
            {  
                text: '新建参数目录',  
                iconCls: 'tasks-new-folder',  
                id: 'new-folder-item'  
            },  
            {  
                text: '新建参数目录',  
                iconCls: 'tasks-new-folder',  
                id: 'rename-item'  
            },
            {  
                text: '删除',  
                iconCls: 'tasks-delete-folder',  
                id: 'delete-folder-item'  
            }  
        ]  
      
    });  