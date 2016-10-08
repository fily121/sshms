<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>规章制度列表</title>
    </head>
    <body>
        <form id="findOrder" method="post" action="findOrder.do">
            <div data-role="page">
                <div data-role="header" data-position="fixed">
                    <!--<a href="#" data-role="button">Back</a>-->
                    <h1>规章制度列表</h1>
                </div><!-- /header -->
                <div data-role="content"> 
                    <table data-role="table" id="table-column-toggle" data-mode="columntoggle" class="ui-responsive table-stroke">
                        <thead>
                            <tr>
                                <th data-priority="2">名称</th>
                                <th>详情</th>
                                <th data-priority="1">最后修改时间</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${gzzdList}" var="gzzd">
                            <tr>
                                <th><a href="gzzdDetail.do?id=${gzzd.id}" data-rel="external">${gzzd.name}</a></th>
                                <td>${gzzd.detail}</td>
                                <td>
                                    ${gzzd.lastmodifytime}
                                </td>
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
