<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript"  src="resources/js/jquery.js"></script>
<script type="text/javascript"  src="resources/js/Particleground.js"></script>
<!-- 日期控件，要加<%=basePath%>使用项目路径，否则会无法使用 -->
<script type="text/javascript" src="<%=basePath%>resources/js/plugins/component/DatePicker/WdatePicker.js"></script>


