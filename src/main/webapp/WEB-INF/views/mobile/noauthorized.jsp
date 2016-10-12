<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录有错</title>
    </head>
    <body>
        <c:if test="${not empty errorMessage}">
            ${errorMessage}
        </c:if>
        <c:if test="${ empty errorMessage}">
            没有权限
        </c:if>
    </body>
</html>
