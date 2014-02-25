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
<html>
	<head>
		<title>DE Msg-Sending</title>
		<link rel="icon" href="${ctx}/images/heat.ico" type="image/x-icon" />
			<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="Heat">
	<meta http-equiv="description" content="Heat">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	
	<style type="text/css"  >  
       #label2{font-size: 12px; color: #868600;background-color:#808000}   
       .classDiv1{font-size: 12px; color: #ffffff; }   
       .classDiv2{font-size: 12px; color: #EEE000; }   
   </style>  
		
<meta http-equiv="Access-Control-Allow-Origin" content="*">   
	</head>
	<body>
		<div id="loading-tip" style="border-radius:3px;position: absolute;z-index: 1;border: solid 1px #ccc;background-color: #ffffff;padding: 10px;">
			<div class="loading-indicator" style="color: #444;font: bold 13px tahoma, arial, helvetica;padding: 10px;height: auto;">
				<img src="${ctx}/images/loading32.gif" width="31" height="31"
					style="margin-right: 8px; float: left; vertical-align: top;" />
				 DE Msg-Sending
				<br />
				<span id="loading-msg" style="font: normal 10px arial, tahoma, sans-serif;">加载样式和图片...</span>
			</div>
		</div>
		<script type="text/javascript">
			var extLibPath = "${extLibPath}";
			var ctx = "${ctx}";
			var tip = document.getElementById("loading-tip");
			tip.style.top = (document.body.clientHeight - 200) / 2;
			tip.style.left = (document.body.clientWidth - 200) / 2;
		</script> 
		<link rel="stylesheet" type="text/css" href="${extLibPath}/resources/css/ext-all-neptune.css" />
		<link rel="stylesheet" type="text/css" href="${extLibPath}/examples/simple-tasks/resources/css/_tasks.css" />
		<link rel="stylesheet" type="text/css" href="css/icon.css" />
		<style type="text/css">
			.x-panel-ghost {
			    z-index: 1;
			}
			.x-border-layout-ct {
			    background: #DFE8F6;
			}
			.x-portal-body {
			    padding: 0 0 0 8px;
			}
			.x-portal .x-portal-column {
			    padding: 8px 8px 0 0;
			}
			.x-portal .x-panel-dd-spacer {
			    border: 2px dashed #99bbe8;
			    background: #f6f6f6;
			    border-radius: 4px;
			    -moz-border-radius: 4px;
			    margin-bottom: 10px;
			}
			.x-portlet {
			    margin-bottom:10px;
			    padding: 1px;
			}
			.x-portlet .x-panel-body {
			    background: #ffffff;
			}
			.portlet-content {
			    padding: 10px;
			    font-size: 11px;
			}
		</style>
		<script type="text/javascript">
			document.getElementById("loading-msg").innerHTML = "加载核心组件...";
		</script>
		<script type="text/javascript" src="${extLibPath}/ext-all-debug.js"></script> 
		<script type="text/javascript" src="${extLibPath}/ext-theme-neptune.js"></script> 
		<script type="text/javascript" src="${extLibPath}/locale/ext-lang-zh_CN.js"></script>
		
		 
		<link rel="stylesheet" type="text/css" href="css/icon.css" />
		<script type="text/javascript">
			document.getElementById("loading-msg").innerHTML = "加载核心组件...";
		</script>
		
		
		<script type="text/javascript" src="js/currentDate.js"></script>
		 <script type="text/javascript" src="${extLibPath}/examples/simple-tasks/SimpleTaskSettings.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
		<script type="text/javascript" src="js/cryptojs.js"></script>
		<script src="module/util/GridComboBox.js"></script>
		<script src="module/util/GridComboBoxList.js"></script>
<!-- 		<script type="text/javascript" src="js/extexcel/export-all.js"></script>
		<script type="text/javascript" src="js/firebugx.js"></script> -->
		<script type="text/javascript" src="js/ExporterExcel-all.js"></script> 
		<script type="text/javascript">
			Ext.appPath = '<%=ctx%>';
			 
		</script>
		 
	</body>
</html>
