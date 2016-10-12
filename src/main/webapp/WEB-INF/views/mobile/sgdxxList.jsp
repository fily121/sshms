<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>施工队列表</title>
    </head>
    <body>
        <form id="findOrder" method="post" action="findOrder.do">
            <div data-role="page">
                <div data-role="header" data-position="fixed">
                    <!--<a href="#" data-role="button">Back</a>-->
                    <h1>施工队列表</h1>
                </div><!-- /header -->
                <div data-role="content"> 
                    <table data-role="table" id="table-column-toggle" data-mode="columntoggle" class="ui-responsive table-stroke">
                        <thead>
                            <tr>
                                <th data-priority="2">施工队名称</th>
                                <th data-priority="1">队长</th>
                                <th data-priority="3">施工队详情</th>
                                <th data-priority="3">地址</th>
                                <th data-priority="2">车型</th>
                                <th data-priority="1">车牌号</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sgdxxList}" var="sgdxx">
                            <tr>
                                <th><a href="sgdxxDetail.do?id=${sgdxx.sgdxx.id}" data-rel="external">${sgdxx.sgdxx.sgdmc}</a></th>
                                <td>${sgdxx.user.userName}</td>
                                <td>${sgdxx.sgdxx.detail}</td>
                                <td>${sgdxx.sgdxx.address}</td>
                                <td>${sgdxx.sgdxx.ctype}</td>
                                <td>${sgdxx.sgdxx.cph}</td>
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
