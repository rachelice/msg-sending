<%@page import="org.activiti.sit.util.PropertyFileUtil"%>
<%@page import="org.springframework.beans.factory.config.PropertiesFactoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
PropertyFileUtil.init();
%>
<html lang="en">
<head>
	<%@ include file="/activiti/common/global.jsp"%>
	<script> 
		var notLogon = ${empty user};
		if (notLogon) {
			location.href = '${ctx}/login?timeout=true';
		}
	</script>
	<%@ include file="/activiti/common/meta.jsp" %>
    <title>Activiti-演示系统</title>
    <%@ include file="/activiti/common/include-base-styles.jsp" %>
	<%@ include file="/activiti/common/include-jquery-ui-theme.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctx }/activiti/css/menu.css" />
    <%@ include file="/activiti/common/include-custom-styles.jsp" %>
	<link href="${ctx }/activiti/css/main.css" type="text/css" rel="stylesheet"/>
	<style type="text/css">
	.ui-tabs-panel {height: 100%; width: 100%;}
	.ui-tabs .ui-tabs-nav li a {padding-right: .5em;}
	#tabs li .ui-icon-close { float: left; margin: 0.5em 0.2em 0 0; cursor: pointer; }
	#add_tab { cursor: pointer; }
	</style>

    <script src="${ctx }/activiti/js/common/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="${ctx }/activiti/js/common/plugins/jui/jquery-ui-${themeVersion }.min.js" type="text/javascript"></script>
    <script src="${ctx }/activiti/js/common/plugins/jui/extends/themeswitcher/jquery.ui.switcher.js" type="text/javascript"></script>
    <script src="${ctx }/activiti/js/common/plugins/tools/jquery.cookie.js" type="text/javascript"></script>
	<script src="${ctx }/activiti/js/common/plugins/jui/extends/layout/jquery.layout.min.js?v=1.3" type="text/javascript"></script>
	<script src='${ctx }/activiti/js/common/common.js' type="text/javascript"></script>
    <script src='${ctx }/activiti/js/module/main/main-frame.js' type="text/javascript"></script>
</head>
<body>
<!-- #TopPane -->
<div id="topPane" class="ui-layout-north ui-widget ui-widget-header ui-widget-content">
	<div style="padding-left:5px; font-size: 16px; margin-top: 1px;">
       	<table id="topTable" style="padding: 0px;margin: 0px;margin-top: -5px" width="100%">
       		<tr>
       			
       			<td>
       				<span style="font-size: 17px;color:#FFFF33">Activiti<br/>工作流管理</span><br/>
       			</td>
       			<td>
       				<div style="float:right; color: #fff;font-size: 12px;margin-top: 2px">
		        		<div>
		        			<label for="username">欢迎：</label>
		        			<span title="角色：${groupNames }">${user.firstName } ${user.lastName }/${user.id }</span>
		        		</div>
		        		<div style="text-align: right;">
		        			<a id="chang-theme" href="#">切换风格</a>
		       				<a href="#" id="loginOut">安全退出</a>
		        		</div>
		        	</div>
       			</td>
       		</tr>
       	</table>
       </div>
</div>

<!-- RightPane -->
<div id="centerPane" class="ui-layout-center ui-helper-reset ui-widget-content">
	<div id="tabs">
		<ul><li><a class="tabs-title" href="#tab-index">首页</a><span class='ui-icon ui-icon-close' title='关闭标签页'></span></li></ul>
		<div id="tab-index">
			<iframe id="mainIframe" name="mainIframe" src="welcome" class="module-iframe" scrolling="auto" frameborder="0" style="width:100%;height:100%;"></iframe>
		</div>
	</div>
</div>

<!-- #BottomPane -->
<div id="bottomPane" class="ui-layout-south ui-widget ui-widget-content">
	<div class="footer ui-state-default">
		<a href="http://www.sit.com。cn" target="_blank">熙菱信息</a>
		<span class="copyright">©2013</span>
		<span class="version">Version：${prop['system.version']}</span>
	</div>
</div>
<%@ include file="menu.jsp" %>
<div id="themeswitcherDialog"><div id="themeSwitcher"></div></div>
</body>
</html>
