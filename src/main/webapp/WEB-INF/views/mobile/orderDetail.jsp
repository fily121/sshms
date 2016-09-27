<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>订单详情</title>
    </head>
    <body>
        <div data-role="page">
            <div data-role="header" data-position="fixed">
                <!--<a href="#" data-role="button">Back</a>-->
                <h1>订单详情</h1>
            </div><!-- /header -->
            <div data-role="content"> 
                <div data-role="fieldcontain">
                    <label for="orderName">订单名称：</label>
                    ${order.order.orderName}
                </div>
                <div data-role="fieldcontain">
                    <label for="orderNumber">项目编号：</label>
                    ${order.order.orderNumber}
                </div>
                <div data-role="fieldcontain">
                    <label for="lxNumber">工作联系单编号：</label>
                    ${order.order.lxNumber}
                </div>
                <div data-role="fieldcontain">
                    <label for="sgdid" class="select">施工单位:</label>
                    ${order.sgdxx.sgdmc}
                </div>
                <div data-role="fieldcontain">
                    <label for="remark">工程内容：</label>
                    ${order.order.remark}
                </div>
                <div data-role="fieldcontain">
                    <label for="startTime">要求开工日期：</label>
                    ${order.order.startTime}
                </div>
                <div data-role="fieldcontain">
                    <label for="endTime">要求完工日期：</label>
                    ${order.order.endTime}
                </div>
                <div data-role="fieldcontain">
                    <label for="realDetail">实际完成情况：</label>
                    ${order.order.realDetail}
                </div>
                <div data-role="fieldcontain">
                    <label for="problem">存在问题：</label>
                    ${order.order.problem}
                </div>
                <div data-role="fieldcontain">
                    <label for="uploadFile1">文件(若要下载文件，请点击右上角的三个点，选择在浏览器中打开)：</label>
                    <!--<div id="fileDiv">-->
                        <c:forEach items="${files}" var="file">
                            <div>
                                <a href="javascript:downloadFile('${file.name}', '${order.order.attachmentId}');">${file.name}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div><!-- /content -->
                <div data-role="footer" data-position="fixed">
                    <div data-role="navbar">
                        <ul>
                            <%--<shiro:hasPermission name="order:edit">--%>
                            <li><a href="addModifyOrder.do?orderId=${order.order.orderId}" data-icon="edit">修改</a></li>
                            <%--</shiro:hasPermission>--%>
                            <li><a href="javascript: history.go(-1);" data-icon="arrow-l">返回</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div><!-- /page -->
    </body>
</html>
