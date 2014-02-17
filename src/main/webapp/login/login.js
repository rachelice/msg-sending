/**
* @author        
* @date          2013-01-05
* @description   
*/
Ext.define('Ext.LoginApp.Login', {
    extend : 'Ext.window.Window',
    
    /** 页面基本属性配置 */
    title : '登录 ',
    iconCls : 'app-heatIcon',
    width : 500,
    height : 300,
    closable : false,
    resizable : false,
    draggable : false,
    layout : {
        type : 'vbox',
        align : 'stretch',
        pack : 'start'
    },
    
    /** 自定义属性,自动生成setter/getter */
    config : {
        loginForm : {},
        focusField : {}
    },
    
    /** 初始化页面组件 */
    initComponent : function() {
        var loginForm = Ext.create('Ext.form.Panel', {
            flex : 1,
            layout : 'anchor',
            bodyPadding : 10,
            margin : '0 -1 -1 -1',
            defaults : {
                xtype : 'textfield',
                labelAlign : 'right',
                labelWidth : 110,
                allowBlank : false,
                anchor : '85%',
                msgTarget : 'qtip'
            },
            items : [{
                fieldLabel : '帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号',
                blankText : '请输入您的账号',
                fieldStyle : 'background:url(images/icon/user.png) no-repeat left center; padding-left:20px; font-weight:bold;',
                name : 'username'
            }, {
                fieldLabel : '密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码',
                blankText : '请输入您的密码',
                fieldStyle : 'background:url(images/icon/key.png) no-repeat left center; padding-left:20px; font-weight:bold;',
                inputType : 'password',
                name : 'password',
                id:'passwd'
            }, {
                xtype : 'fieldcontainer',
                layout : 'hbox',
                items : [{
                    flex : 1,
                    xtype : 'textfield',
	                labelAlign : 'right',
	                labelWidth : 110,
	                allowBlank : false,
	                msgTarget : 'qtip',   
	                value:'8888',
	                fieldLabel : '验&nbsp;证&nbsp;码',
	                blankText : '请输入右边图片中的数字',
                    maxLength : 4,
                    maxLengthText : '请输入四位验证码',
                    minLength : 4,
                    minLengthText : '请输入四位验证码',
                    fieldStyle : 'background:url(images/icon/locked.png) no-repeat left center; padding-left:20px; font-weight:bold;',
                    name : 'captcha'
	            }, {
                    xtype : 'container',
                    width : 100,
                    margin : '0 0 0 5',
                    html : '<img onclick=\'javascprit:loginPage.refreshImg(this);\' src=\'captcha.jsp\' alt=\'看不清？点击刷新\' title=\'看不清？点击刷新\' style=\'cursor:pointer;\'>'
                }]
            }, {
                xtype : 'fieldcontainer',
                layout : 'hbox',
                items : [{
                    xtype : 'container',
                    width : 115
                }, {
                    flex : 1,
	                xtype : 'checkboxfield',
	                boxLabel : '记住帐号',
                    name : 'remember-username'
	            }, {
                    flex : 1,
	                xtype : 'checkboxfield',
	                boxLabel : '记住密码',
                    name : 'remember-password'
	            }]
            }]
        });



        //添加回车事件
        this.on('afterrender', function(thiz, opts) {
            Ext.create('Ext.util.KeyNav', thiz.getEl(), {enter : this.loginAction, scope : this});
            /*var key = new Ext.KeyMap('passwd', {    
            	key: [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254],  // Enter    
                //shift: true,    
                //ctrl: true,    
                fn: function()    
                {    
                    this.input=1;
                },    
                scope: this    
            });*/
        }, this);
        
        this.buttons = [{
            text : '登&nbsp;&nbsp;录',
//            iconCls : 'app-homeIcon',
            handler : this.loginAction,
            scope : this
        }, {
            text : '选&nbsp;&nbsp;项',
//            iconCls : 'app-homeIcon',
            handler : function(btn) {
            },
            scope : this
        }];
        
        this.items = [{
            height : 100,
            border : false,
            html : '<div style=\'background:url(images/heat100.png) no-repeat left center; height:100%;' +
                   'padding-left:120px; font-size:30px; font-weight:bold; font-family:华文隶书,sans-serif; line-height:100px;\'>' +
                   'DE Msg-Sending' + 
                   '</div>'
        }, loginForm];
        
        this.initConfig({
            loginForm : loginForm
        });
        
        this.callParent();
        this.on('beforeshow', this.loadData, this);
        this.on('show', function() {this.getFocusField().focus(true);}, this, {delay : 300});
    },
    
    /** 界面显示后加载数据 */
    loadData : function(thiz) {
        var form = thiz.getLoginForm().getForm();
            
        var usernameField = form.findField('username');
        var passwordField = form.findField('password');
        var captchaField = form.findField('captcha');
        var reUsernameField = form.findField('remember-username');
        var rePasswordField = form.findField('remember-password');
        
        //取出cookies是否记住密码和帐号
        var reUsername = Ext.util.Cookies.get('OMPFREUID');
        var rePassword = Ext.util.Cookies.get('OMPFREPSS');
        reUsernameField.setValue(reUsername == 'Y');
        rePasswordField.setValue(rePassword == 'Y');
        
        //根据"记住"情况,给帐号和密码赋值,并确定光标位置
        this.setFocusField(usernameField);
    	var key  = CryptoJS.enc.Latin1.parse('1234567812345678');
    	var iv   = CryptoJS.enc.Latin1.parse('1234567812345678');
        if(reUsername == 'Y') {
        	var decode_u = CryptoJS.AES.decrypt(Ext.util.Cookies.get('OMPFUID'),key,{iv:iv,padding:CryptoJS.pad.ZeroPadding});
            usernameField.setValue(decode_u.toString(CryptoJS.enc.Utf8));
            this.setFocusField(passwordField);
        }
        if(rePassword == 'Y') {
        	var decode_p = CryptoJS.AES.decrypt(Ext.util.Cookies.get('OMPFPSS'),key,{iv:iv,padding:CryptoJS.pad.ZeroPadding});
            passwordField.setValue(decode_p.toString(CryptoJS.enc.Utf8));
            this.setFocusField(captchaField);
        }
        
        this.input=0;
    },
    
    /** 刷新验证码 */
    refreshImg : function(thiz) {
        thiz.src = 'captcha.jsp?' + Math.round(Math.random()*100000);
    },
    
    /** 登陆操作 */
    loginAction : function() {
        var form = this.getLoginForm().getForm();
        if(!form.isValid()) {
            return;
        }
        
        var reUsername = form.findField('remember-username').checked;
        var rePassword = form.findField('remember-password').checked;
        var P_username = form.findField('username').getValue();
        var P_password = form.findField('password').getValue();
    	var key  = CryptoJS.enc.Latin1.parse('1234567812345678');
    	var iv   = CryptoJS.enc.Latin1.parse('1234567812345678');
        
        //有效期为一周
        var expires = new Date(new Date().getTime() + (7 * 24 * 60 * 60 * 1000));

        //记住帐号
        if(reUsername) {
            var encode_u = CryptoJS.AES.encrypt(P_username, key, 
            		{ iv: iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding});
            Ext.util.Cookies.set('OMPFUID', encode_u, expires);
        } else {
            Ext.util.Cookies.set('OMPFUID', '');
        }
        
        //记住密码
        if(rePassword) {
            var encode_p = CryptoJS.AES.encrypt(P_password, key, 
            		{ iv: iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding});
            Ext.util.Cookies.set('OMPFPSS', encode_p, expires);
        } else {
            Ext.util.Cookies.set('OMPFPSS', '');
        }
        
        //记住checkbox
        Ext.util.Cookies.set('OMPFREUID', reUsername ? 'Y' : 'N', expires);
        Ext.util.Cookies.set('OMPFREPSS', rePassword ? 'Y' : 'N', expires);
        
        form.findField('password').setValue(CryptoJS.MD5(P_password).toString());

        //执行登陆
        this.getEl().mask('正在登陆中，请稍候...');
        Ext.Ajax.request({
            method : 'POST',
            url : 'j_spring_security_check',
            params :  form.getValues(),
            success : function(response, options) {
                var rtn = Ext.decode(response.responseText);
                if(rtn.success) {                   
                    window.location.href = Ext.appPath + '/index.jsp';
                } else {
                	form.findField('password').setValue(P_password);
//                    Ext.MessageBox.alert('系统登陆', rtn.msg);
                			Ext.Msg.show({
										title : '系统登陆',
										msg : rtn.msg,
										buttons : Ext.Msg.OK,
										icon : 'x-message-box-error'
									});
                }
                this.getEl().unmask();
            },
              failure : function(response, options) {
                this.getEl().unmask();
            },
            scope : this
        });
    }
});