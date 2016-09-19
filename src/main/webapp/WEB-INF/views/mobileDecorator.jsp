<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <title>中移铁通微信企业号-<sitemesh:write property='title' /></title>

    <link rel="stylesheet" href="<%= basePath%>static/js/mobile/jquery.mobile-1.3.1.css">
    
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/jquery-1.9.1.min.js"></script>
    <script type="text/javascript"  src="<%= basePath%>static/js/mobile/jquery.mobile-1.3.1.min.js"></script>

    <script type="text/javascript" src="<%= basePath%>static/js/mobile/framework.launcher.js"></script>
</head>
<body>
    <div id="preloader">
        <div id="status">
            <p class="center-text">
                Loading...
                <em>Please waite!</em>
            </p>
        </div>
    </div>
    <sitemesh:write property='body' />
`</body>
</html>