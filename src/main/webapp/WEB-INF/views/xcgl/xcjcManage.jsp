<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>菜单管理</title>
</head>
<body>
	<section>
	<h2>
		<strong style="color: grey;">菜单列表</strong>
	</h2>
	<table class="table">
		<tbody>
			<tr>
				<th>菜单名称</th>
				<th>父级菜单</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${permissionList }" var="permission">
			<tr>
				<td style="width: 265px;">
				<input type="hidden" value="${permission.perId }"/>
					${permission.perName }
				</td>
				<td>${permission.parentPerName }</td>
				<td>${permission.perUrl }</td>
				<td><a href="#">修改</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</section>
</body>
</html>