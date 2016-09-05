<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <base href="<%=basePath%>">  
        <title>施工队联系</title>  
        <script type="text/javascript"  src="<%= basePath%>static/js/jquery.js"></script>
        <script type="text/javascript"  src="<%= basePath%>static/js/plugins/easyUi/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="<%= basePath%>static/js/plugins/easyUi/locale/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="<%= basePath%>static/js/main.js"></script>
        <link rel="stylesheet" type="text/css" href="<%= basePath%>static/css/style.css" />
        <link rel="stylesheet" type="text/css" href="<%= basePath%>static/js/plugins/easyUi/themes/metro-green/easyui.css" />
        <link rel="stylesheet" type="text/css" href="<%= basePath%>static/js/plugins/easyUi/themes/icon.css" />
        <script type="text/javascript">
            function setSgdIdToLianxi(sgdId){
                frameLianxi.location.href = '<%= basePath%>div/xcgl/xclx.do?id='+sgdId;
            }
        </script>
    </head>  
    <body class="easyui-layout">
        <div data-options="region:'center',title:'施工队定位信息',split:true" style="">
            <iframe id="frameWzxx" name="frameWzxx" scrolling="auto" frameborder="0"  src="<%= basePath%>div/xcgl/sgdwzxx.do" style="width:100%;height:100%;"></iframe>
        </div>
        <div data-options="region:'east',title:'实时信息'" style="padding:5px;background:#eee;width:400px;">
            <iframe id="frameLianxi" name="frameLianxi" scrolling="auto" frameborder="0"  src="<%= basePath%>div/xcgl/xclx.do" style="width:100%;height:100%;"></iframe>
        </div>
    </body>
</html>  