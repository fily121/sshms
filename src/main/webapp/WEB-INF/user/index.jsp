<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>采集首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    
    <h1>User List</h1>
    
    <shiro:hasPermission name="采集审核">
    	<h1>采集审核</h1>
    </shiro:hasPermission>
    
    <shiro:hasPermission name="信息采集">
    	<h1>信息采集</h1>
    </shiro:hasPermission>
    
    <shiro:hasPermission name="采集进度">
    	<h1>采集进度</h1>
    </shiro:hasPermission>
    
    <table border="1">
    	<tr>
    		<th>index</th>
    		<th>userId</th>
    		<th>userName</th>
    		<th>createDate</th>
    	</tr>
    	
    	<c:forEach items="${pageList.list }" var="user" varStatus="status">
	    	<tr>
	    		<td>${status.index }</td>
	    		<td>${user.userId }</td>
	    		<td>${user.userName }</td>
	    		<td><fmt:formatDate value="${user.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    	</tr>
	    </c:forEach>
    	
    </table>
	    
  </body>
</html>
