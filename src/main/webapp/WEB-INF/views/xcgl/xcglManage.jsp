<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>现场管理</title>
    </head>
    <body>
    <section>
        <h2>
            <strong style="color: grey;">施工队列表</strong>
        </h2>
        <table class="table">
            <tbody>
                <tr>
                    <th>施工队名称</th>
                    <th>队长</th>
                    <th>详情</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${sgdList }" var="sgd">
                    <tr>
                        <td style="width: 265px;">
                            <input type="hidden" value="${sgd.id }"/>
                            ${sgd.sgdmc }
                        </td>
                        <td><input type="hidden" value="${sgd.duizhang }"/>${sgd.duizhangMc }</td>
                        <td>${sgd.detail }</td>
                        <td><a href="xcgl/sgdgl.do?id=${sgd.id }&dzid=${sgd.duizhang }">管理</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
</body>
</html>