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
                <shiro:hasPermission name="order:edit">
                    <li><a href="#" data-icon="plus" class="ui-btn-active ui-state-persist">创建订单</a></li>
                    </shiro:hasPermission>
                <li><a href="#" data-icon="search">查询订单</a></li>
                    <shiro:hasPermission name="order:edit">
                    <li><a href="#" data-icon="gear">修改订单</a></li>
                    </shiro:hasPermission>
            </div><!-- /content -->
        </div><!-- /page -->
    </body>
</html>
