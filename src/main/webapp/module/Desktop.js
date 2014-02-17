
Ext.define('Fes.Desktop', {
			extend : 'Ext.app.Application',
			appFolder : 'module',

			name : 'Fes',

			controllers : ['DesktopController'],

			enableQuickTips : true,

    		autoCreateViewport: true,
    		
            launch: function() {
            //Ext.Msg.alert('1','323333333');
              Ext.tip.QuickTipManager.init();
            }

		});



//@ sourceURL=module/Desktop.js