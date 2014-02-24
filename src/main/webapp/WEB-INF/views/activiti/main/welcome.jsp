<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.activiti.sit.util.PropertyFileUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<%@ include file="/activiti/common/global.jsp"%> 
	<%@ include file="/activiti/common/meta.jsp"%>

	<%@ include file="/activiti/common/include-base-styles.jsp" %>
    <%@ include file="/activiti/common/include-jquery-ui-theme.jsp" %>
    <link href="${ctx }/activiti/js/common/plugins/jui/extends/portlet/jquery.portlet.min.css?v=1.1.2" type="text/css" rel="stylesheet" />
    <link href="${ctx }/activiti/js/common/plugins/qtip/jquery.qtip.css?v=1.1.2" type="text/css" rel="stylesheet" />
    <%@ include file="/activiti/common/include-custom-styles.jsp" %>
    <style type="text/css">
    	.template {display:none;}
    	.version {margin-left: 0.5em; margin-right: 0.5em;}
    	.trace {margin-right: 0.5em;}
    </style>

    <script src="${ctx }/activiti/js/common/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="${ctx }/activiti/js/common/plugins/jui/jquery-ui-${themeVersion }.min.js" type="text/javascript"></script>
    <script src="${ctx }/activiti/js/common/plugins/jui/extends/portlet/jquery.portlet.pack.js?v=1.1.2" type="text/javascript"></script>
    <script src="${ctx }/activiti/js/common/plugins/qtip/jquery.qtip.pack.js" type="text/javascript"></script>
	<script src="${ctx }/activiti/js/common/plugins/html/jquery.outerhtml.js" type="text/javascript"></script>
	<script src="${ctx }/activiti/js/module/activiti/workflow.js" type="text/javascript"></script>
    <script src="${ctx }/activiti/js/module/main/welcome-portlet.js" type="text/javascript"></script>
</head>
<body style="margin-top: 1em;">
	<center><h3>欢迎访问Activiti Demo，专为优秀的BPMN2.0规范的轻量级工作流引擎Activiti服务</h3></center>
	<div id='portlet-container'></div>

	<!-- 隐藏 -->
	<div class="forms template">
		<ul>
			<li>
				<b>普通表单</b>：每个节点的表单内容都写死在JSP或者HTML中。
			</li>
			<li>
				<b>动态表单</b>：表单内容存放在流程定义文件中（包含在启动事件以及每个用户任务中）。
			</li>
			<li>
				<b>外置表单</b>：每个用户任务对应一个单独的<b>.form</b>文件，和流程定义文件同时部署（打包为zip/bar文件）。
			</li>
		</ul>
	</div>
	<div id="multiInstance" class="template">
		在填写<strong>会签参与人</strong>字段时使用用户的ID作为值，例如：<code>sit,admin</code>表示两个用户，即两个任务实例被创建。
	</div>
	<div class="project-info template">
		<ul>
			<li><a target="_blank" href='https://github.com/henryyan/msg-sending'>msg-sending</a>为Activiti初学者快速入门所设计。</li>
			<li>源代码托管Github：<a target="_blank" href='https://github.com/henryyan/msg-sending'>https://github.com/henryyan/msg-sending</a></li>
		</ul>
	</div>

	<div class="arch template">
		<ul>
			<li>Activiti版本：${prop['activiti.version']}</li>
			<li>Spring版本：3.1</li>
			<li>使用<a href="http://maven.apache.org" target="_blank">Maven</a>管理依赖</li>
		</ul>
	</div>

	<div class="demos template">
		<ul>
			<li>部署流程</li>
			<li>启动流程</li>
			<li>任务签收</li>
			<li>任务办理</li>
			<li>驳回请求</li>
			<li>查询运行中流程</li>
			<li>查询历史流程</li>
			<li>任务监听</li>
			<li>自定义表单</li>
			<li>动态表单</li>
			<li>外置表单</li>
			<li>个人待办任务汇总</li>
			<li>分页查询(<font color='red'>New</font>)</li>
			<li>流程定义缓存(<font color='red'>New</font>)</li>
			<li>集成Activiti Modeler(<font color='red'>New</font>)</li>
		</ul>
	</div>

	<div class="links template">
		<p>
			<b>Wiki：</b><a target="_blank" href="https://github.com/henryyan/msg-sending/wiki">https://github.com/henryyan/msg-sending/wiki</a>
		</p>
		<p>
			<b>Demo源码：</b><a target="_blank" href="https://github.com/henryyan/msg-sending">https://github.com/henryyan/msg-sending</a>
		</p>
		<p>
			<b>Activiti资料：</b><a target="_blank" href="http://www.sit.me/categories.html#activiti-ref">http://www.sit.me/categories.html#activiti-ref</a>
		</p>
	</div>

	<div class="aboutme template">
		<ul>
			<li>
				<b>作者：</b><a target="_blnak" href="http://www.sit.me/?f=kad">咖啡兔</a>
			</li>
			<li>
				<b>QQ：</b>576525789
			</li>
			<li>
				<b>QQ群：</b>236540304
			</li>
			<li>
				<b>Weibo：</b><a target="_blank" href="http://weibo.com/sitzi">@sitzi</a>
			</li>
		</ul>
	</div>
</body>
</html>
