<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>规章制度管理</title>
    </head>
    <body>
        <div data-role="page">
            <div data-role="header" data-position="fixed">
                <!--<a href="#" data-role="button">Back</a>-->
                <h1>规章制度管理</h1>
            </div><!-- /header -->
            <div data-role="content"> 
                <%--<shiro:hasPermission name="gzzd:edit">--%>
                    <a href="addModifyGzzd.do" data-icon="plus" data-role="button">发布规章制度</a>
                <%--</shiro:hasPermission>--%>
                <a href="viewGzzd.do" data-icon="search" data-role="button">查询订单</a>
            </div><!-- /content -->
        </div><!-- /page -->
    </body>
</html>
