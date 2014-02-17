
Ext.define('Fes.view.Container', {
		   	alias: 'widget.fescontainer',
			extend : 'Ext.tab.Panel',
			requires : ['Ext.app.Portlet', 'Ext.app.PortalColumn', 'Ext.app.PortalPanel',
					   'Ext.app.PortalDropZone', 'Ext.ux.TabReorderer','Ext.ux.TabCloseMenu'],
			activeTab : 0,
			enableTabScroll : true,
			 
			//border : true,
			 
			region : 'center',
			 plugins: Ext.create('Ext.ux.TabCloseMenu', {
				 closeTabText: '关闭当前面板',
     		  	closeOthersTabsText: '关闭其他',
     		  	closeAllTabsText: '关闭所有',
	                extraItemsTail: [
	                    '-',
	                    {
	                        text: 'Closable',
	                        checked: true,
	                        hideOnClick: true,
	                        handler: function (item) {
	                            currentItem.tab.setClosable(item.checked);
	                        }
	                    },
	                    '-',
	                    {
	                        text: 'Enabled',
	                        checked: true,
	                        hideOnClick: true,
	                        handler: function(item) {
	                            currentItem.tab.setDisabled(!item.checked);
	                        }
	                    }
	                ],
	                listeners: {
	                    beforemenu: function (menu, item) {
	                        var enabled = menu.child('[text="Enabled"]'); 
	                        menu.child('[text="Closable"]').setChecked(item.closable);
	                        if (item.tab.active) {
	                            enabled.disable();
	                        } else {
	                            enabled.enable();
	                            enabled.setChecked(!item.tab.isDisabled());
	                        }

	                        currentItem = item;
	                    }
	                }
	            }) ,
			split : true
		});

 