<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
    <div style="color:red; font-size:22px;">${message_login }</div>

	<form action="${pageContext.request.contextPath}/user/login" method="POST">
	  姓名：<input type="text" name="userName"/><br/>
	  密码：<input type="text" name="userPwd"/><br/>
	  验证：<input type="text" name="verifyCode"/>
     <img src="user/getVerifyCodeImage"/ onclick="this.src='${pageContext.request.contextPath}/user/getVerifyCodeImage?d='+Math.random();" title="点击刷新验证码"><br/>
  	 <input type="submit" value="登录"/>
    </form>
  </body>
</html>
