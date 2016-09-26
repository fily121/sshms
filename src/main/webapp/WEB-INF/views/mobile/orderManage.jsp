<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>订单管理</title>
    </head>
    <body>
        <div data-role="page">
            <div data-role="header" data-position="fixed">
                <!--<a href="#" data-role="button">Back</a>-->
                <h1>订单管理</h1>
            </div><!-- /header -->
            <div data-role="content"> 
                <%--<shiro:hasPermission name="order:edit">--%>
                    <a href="addModifyOrder.do" data-icon="plus" data-role="button">发布订单</a>
                <%--</shiro:hasPermission>--%>
                <a href="#" data-icon="search" data-role="button">查询订单</a>
                <%--<shiro:hasPermission name="order:edit">--%>
                    <a href="#" data-icon="gear" data-role="button">修改订单</a>
                <%--</shiro:hasPermission>--%>
            </div><!-- /content -->
        </div><!-- /page -->
    </body>
</html>
