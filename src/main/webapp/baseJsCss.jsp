<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link rel="stylesheet"	href="common/js/plugins/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet"	href="common/js/plugins/easyui/themes/icon.css"	type="text/css"></link>
<script type="text/javascript"	src="common/js/plugins/webUI/jquery-1.7.2.js"></script>
<script type="text/javascript"	src="common/js/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="common/js/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="common/js/MyJs/main.js"></script>

<!-- 日期控件，要加<%=basePath%>使用项目路径，否则会无法使用 -->
<script type="text/javascript" src="<%=basePath%>common/js/plugins/component/DatePicker/WdatePicker.js"></script>


