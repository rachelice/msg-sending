<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
	java.util.ResourceBundle  bundlePath = java.util.ResourceBundle.getBundle("resources//base_config");
	String extLibPath=bundlePath.getString("js")+"/ext-4.2.2.1144";
	//String extLibPath =jsBasePath/extjs4.1"//"js/extjs";// request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/ext4";
		
	pageContext.setAttribute("extLibPath", extLibPath);
	response.setHeader("Access-Control-Allow-Origin", "*");    
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>登录 </title>
    <link rel="icon" href="images/heat.ico" type="image/x-icon" />
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="Heat">
	<meta http-equiv="description" content="Heat">
	<link rel="stylesheet" type="text/css" href="${extLibPath}/resources/css/ext-all-neptune.css" />
		<link rel="stylesheet" type="text/css" href="css/icon.css" />
	<style type="text/css">
		.app-heatIcon{background-image: url(images/heat.png) !important;}
		.app-homeIcon {background-image: url(images/icon/home.png) !important;}
	</style>
	
		<script type="text/javascript" src="${extLibPath}/ext-all-debug.js"></script> 
		<script type="text/javascript" src="${extLibPath}/ext-theme-neptune.js"></script> 
		<script type="text/javascript" src="${extLibPath}/locale/ext-lang-zh_CN.js"></script>
	<script type="text/javascript" src="login/login.js"></script>
	<script type="text/javascript" src="js/cryptojs.js"></script>
	<script type="text/javascript">
	
		Ext.Loader.setPath({
			'Ext.LoginApp' : 'login'
		});
		
		Ext.appPath = '<%=ctx%>';
		Ext.BLANK_IMAGE_URL = 'images/s.gif';
		Ext.tip.QuickTipManager.init();
		
		Ext.onReady(function() {
			Ext.Loader.setConfig({enabled:true}); 
			loginPage = Ext.create('Ext.LoginApp.Login').show(Ext.getBody());
		});
	</script>

  </head>
  
  <body style='background-color:#bad0ee;'>
<%-- 	<%
		HttpSession ses=request.getSession();
		String sesname= (String)ses.getAttribute("LOGIN_CAPTCHA") ;
		String sesname_2= (String)ses.getAttribute("LOGIN_CAPTCHA_2") ;
	%>
 	<script>
		var namese = '<%=sesname %>';
		var namese2 = '<%=sesname_2 %>';
	</script> --%>

  </body>
</html>
