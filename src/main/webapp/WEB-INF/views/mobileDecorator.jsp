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
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <title>中移铁通微信企业号-<sitemesh:write property='title' /></title>

    <link href="<%= basePath%>static/css/mobile/style.css"     rel="stylesheet" type="text/css">
    <link href="<%= basePath%>static/css/mobile/framework.css" rel="stylesheet" type="text/css">
    <link href="<%= basePath%>static/css/mobile/owl.carousel.css"  rel="stylesheet" type="text/css">
    <link href="<%= basePath%>static/css/mobile/owl.theme.css" rel="stylesheet" type="text/css">
    <link href="<%= basePath%>static/css/mobile/swipebox.css"　 rel="stylesheet" type="text/css">
    <link href="<%= basePath%>static/css/mobile/colorbox.css" rel="stylesheet" type="text/css">
    <script type="text/javascript"  src="<%= basePath%>static/js/jquery.js"></script>
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/jqueryui.js"></script>
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/owl.carousel.min.js"></script>
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/jquery.swipebox.js"></script>
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/snap.js"></script>
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/contact.js"></script>
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/custom.js"></script>
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/framework.js"></script>
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/framework.launcher.js"></script>
</head>
<body>
    <div id="preloader">
        <div id="status">
            <p class="center-text">
                加载中，请稍后...
                <em>加载速度依赖于您的网速!</em>
            </p>
        </div>
    </div>
    <div class="top-deco"></div>
    <sitemesh:write property='body' />
    <div style="height:28px;"></div>
    <div class="bottom-deco"></div>
</body>
</html>