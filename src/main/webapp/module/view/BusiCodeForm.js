console.log('BusiCodeForm...');
var pageVar={};
//--------------------------弹出窗口的设置-----------------------------
pageVar.SRC_LOC_Y = 40;		//Panel中item项的起始点的x
pageVar.SRC_LOC_X = 300;		//Panel中item项的起始点的y
pageVar.EACH_DIST_Y = 30;	//上下两个Item之间的距离
pageVar.FIELD_WIDTH = 60;	//item项的默认长度
pageVar.vWidth=210;         //标签的整体宽度
pageVar.vFieldW=130;        //标签空白内容的宽度
pageVar.LABEL_WIDTH = 70;	//item项的标签的默认宽度
pageVar.vOneLineWidth = 2 * pageVar.vWidth;                 //一行只放置一个标签时，标签的长度
pageVar.vPanelW = pageVar.vOneLineWidth + 40;
pageVar.vPanelH = 300;
pageVar.BUSICODE_BUSITYPEStore = eval("[{'value':'1', 'text':'系统业务'},{'value':'2', 'text':'银行业务'}]"); 


//--------------------与grid相关的参数设置--------------------

pageVar.alertPanelTitle = '业务代码生成器';


//其中数字1代表有效，0代表无效
pageVar.bButtons = [ 0, 1, 0, 0 ];              //bButtons[0]为添加按钮，bButtons[1]为修改，bButtons[2]为查询，bButtons[3]为删除;

//用来修改和添加的菜单  
Ext.define('Fes.view.BusiCodeForm', {  
extend : 'Ext.form.Panel',  
  layout: 'absolute',         //该panel的布局  
  border: false, //是否显示边框  
  frame: true,                //是否显示帧  
  autoScroll: true,           //允许当内容超出高度时，自动产生滚动条  
  initComponent: function() {  
      var BUSICODE_BUSITYPEStore = Ext.create('Ext.data.Store', {  
          fields: ['value', 'text'],  
          data:pageVar.BUSICODE_BUSITYPEStore  
      });
      
      var count = -1;         //用来记录panel中的行数，便于排版  

      this.items = [                  //为该panel添加内容    
           {  
	               xtype: 'textfield',  
	               fieldLabel: '业务名称',  
	               allowBlank: false,  
	               id: 'BUSICODE_BUSINAME',  
	               fieldWidth: pageVar.vFieldW,  
	               labelWidth: pageVar.LABEL_WIDTH,   
	               width: pageVar.vWidth,  
	               x:pageVar.SRC_LOC_X ,  
	               y: pageVar.SRC_LOC_Y + pageVar.EACH_DIST_Y * ( ++count )
	               
	        },   
	        {  
	        	store: BUSICODE_BUSITYPEStore,  
	            queryMode: 'local',  
	            displayField: 'text',  
	            valueField: 'value',  
	               xtype: 'combobox',   
	               fieldLabel: '业务类型', 
	               emptyText:"请选择...",
	               allowBlank: false,  
	               id: 'BUSICODE_BUSITYPE',  
	               fieldWidth: pageVar.vFieldW,  
	               width: pageVar.vWidth+20,  
	               labelWidth: pageVar.LABEL_WIDTH,  
	               labelAlign: 'right',  
	               x:pageVar.SRC_LOC_X + pageVar.vWidth+30, 
	               y: pageVar.SRC_LOC_Y + pageVar.EACH_DIST_Y * ( count )
	        },
	        {
				xtype : 'button',
				text : '提&nbsp;&nbsp;&nbsp;&nbsp;交',
				iconCls : 'icon-yes',
	            width: 80,  
	            x:pageVar.SRC_LOC_X+380,  
	            y: pageVar.SRC_LOC_Y +100,
				handler : this.genBusiCode,
				scope : this
		},
        {
			xtype : 'label',
			html:'提示：<br><br><font color="red">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp1.将生成的压缩包中<font color="black">src、WebRoot</font>两个文件夹覆盖工程中对应的文件夹'
				+'<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2.更新工程</font>',
            width: 600,
            x:pageVar.SRC_LOC_X,  
            y: pageVar.SRC_LOC_Y +250
	}

   ];  
      this.callParent(arguments);  
  },
  
  genBusiCode : function() {
		var me = this;
		businame =Ext.getCmp('BUSICODE_BUSINAME').getValue();
		busitype =Ext.getCmp('BUSICODE_BUSITYPE').getValue();
		if(Ext.isEmpty( Ext.util.Format.trim(businame)) ||
				Ext.isEmpty( Ext.util.Format.trim(busitype)) ){
			Ext.Msg.show({
				title : '业务代码生成',
				msg : '业务名称 与 业务类型  均不能为空',
				buttons : Ext.Msg.OK,
				icon : 'x-message-box-warning'
			});
			return;
		}
		Ext.Msg.show({
			title : '业务代码生成',
			msg : '确认提交',
			buttons : Ext.Msg.YESNO,
			icon : 'x-message-box-question',

			fn : function(id) {
				if (id == 'yes') {
					var mk = new Ext.LoadMask(document.body, {
								msg : '正在生成中，请稍候...'
							});
					mk.show();
					Ext.Ajax.request({
						url : 'busicodes',// 要跳转的url,此为属性必须要有
						method : 'GET',
						params : {
							businame : Ext.getCmp('BUSICODE_BUSINAME').getValue(),
							busitype : Ext.getCmp('BUSICODE_BUSITYPE').getValue()

						}, // 提交参数
						success : function(response, options) {
							var responseArray = Ext
									.decode(response.responseText);
							if (responseArray.success == true) {
								window.location.href = responseArray.text;
							} else {
								Ext.Msg.show({
											title : '业务代码生成',
											msg : responseArray.text,
											buttons : Ext.Msg.OK,
											icon : 'x-message-box-warning'
										});
							}
							mk.hide();
						},

						failure : function(response, options) {
							mk.hide();
							Ext.Msg.alert(
								'警告',
								"'数据处理错误原因\'"
								+ response.responseText);
						}
					});
				}
			}
		});
	}
});  
