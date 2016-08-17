<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="static/js/jquery.js"></script>
<script src="static/js/Particleground.js"></script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
	});
</script>
</head>

<body>
	<div style="color: red; font-size: 22px;">${message_login }</div>
		<form action="${pageContext.request.contextPath}/user/login.do" method="POST">
		<dl class="admin_login">
		 <dt>
		  <strong>站点后台管理系统</strong>
		  <em>Management System</em>
		 </dt>
			 <dd class="user_icon">
			  <input type="text" placeholder="账号" class="login_txtbx" name="userName"/>
			 </dd>
			 <dd class="pwd_icon">
			  <input type="password" placeholder="密码" class="login_txtbx" name="userPwd"/>
			 </dd>
			 <dd class="val_icon">
			  <div class="checkcode">
			    <input type="text" name="verifyCode" placeholder="验证码" maxlength="4" class="login_txtbx"/> 
			    <img src="user/getVerifyCodeImage.do" class="J_codeimg" onclick="this.src='${pageContext.request.contextPath}/user/getVerifyCodeImage.do?d='+Math.random();"
						title="点击刷新验证码">
			  </div>
			 </dd>
		 <dd>
		  <input type="submit" value="立即登陆" class="submit_btn"/>
		 </dd>
		 <dd>
		  <p>© 2015-2016 sinoi 版权所有</p>
		 </dd>
		</dl>
		 </form>
</body>
</html>
