
Ext.define('Fes.view.Viewport', {
			extend : 'Ext.container.Viewport',
			requires : ['Fes.view.Container', 'Fes.view.Header',
					'Fes.view.Navigation'],

			layout : 'border',
			initComponent : function() {

				var me = this;
				Ext.apply(me, {
							items : [Ext.create('Fes.view.Container'),
									Ext.create('Fes.view.Header'),
									Ext.create('Fes.view.Navigation')]
						});
				this.callParent(arguments);
			}
		});

console.log('start...');
