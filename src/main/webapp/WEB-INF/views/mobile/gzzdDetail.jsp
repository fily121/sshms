<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>规章制度详情</title>
    </head>
    <body>
        <div data-role="page">
            <div data-role="header" data-position="fixed">
                <!--<a href="#" data-role="button">Back</a>-->
                <h1>规章制度详情</h1>
            </div><!-- /header -->
            <div data-role="content"> 
                <div data-role="fieldcontain">
                    <label for="orderName">名称：</label>
                    ${gzzd.name}
                </div>
                <div data-role="fieldcontain">
                    <label for="orderName">详情：</label>
                    ${gzzd.detail}
                </div>
                <div data-role="fieldcontain">
                    <label for="orderName">发布人：</label>
                    ${addUser}
                </div>
                <div data-role="fieldcontain">
                    <label for="orderName">发布时间：</label>
                    ${gzzd.formattedTime}
                </div>
                <div data-role="fieldcontain">
                    <label for="uploadFile1">文件(若要下载文件，请点击右上角的三个点，选择在浏览器中打开)：</label>
                    <!--<div id="fileDiv">-->
                        <c:forEach items="${files}" var="file">
                            <div>
                                <a href="javascript:downloadFile('${file.name}', '${gzzd.attachmentId}');">${file.name}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div><!-- /content -->
                <div data-role="footer" data-position="fixed">
                    <div data-role="navbar">
                        <ul>
                            <%--<shiro:hasPermission name="order:edit">--%>
                            <li><a href="addModifyOrder.do?orderId=${gzzd.orderId}" data-icon="edit">修改</a></li>
                            <%--</shiro:hasPermission>--%>
                            <c:if test="${empty modify or !modify}">
                            <li><a href="javascript: history.go(-1);" data-icon="arrow-l">返回</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div><!-- /page -->
    </body>
</html>
