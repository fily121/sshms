<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>订单列表</title>
    </head>
    <body>
        <form id="findOrder" method="post" action="findOrder.do">
            <div data-role="page">
                <div data-role="header" data-position="fixed">
                    <!--<a href="#" data-role="button">Back</a>-->
                    <h1>订单列表</h1>
                </div><!-- /header -->
                <div data-role="content"> 
                    <table data-role="table" id="table-column-toggle" data-mode="columntoggle" class="ui-responsive table-stroke">
                        <thead>
                            <tr>
                                <th data-priority="2">订单名称</th>
                                <th>工程内容</th>
                                <th data-priority="3">要求开工日期</th>
                                <th data-priority="1">要求完工日期</th>
                                <th data-priority="5">实际完成情况</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orderList}" var="order">
                            <tr>
                                <th><a href="orderDetail.do?orderId=${order.order.orderId}" data-rel="external">${order.order.orderName}</a></th>
                                <td>${order.order.remark}</td>
                                <td>${order.order.startTime}</td>
                                <td>${order.order.endTime}</td>
                                <td>${order.order.realDetail}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div><!-- /content -->
                <div data-role="footer" data-position="fixed">
                    <div data-role="navbar">
                        <ul>
                            <li><a href="javascript: history.go(-1);" data-icon="arrow-l">返回</a></li>
                        </ul>
                    </div>
                </div>

            </div><!-- /page -->
        </form>
    </body>
</html>
