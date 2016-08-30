<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>施工队管理</title>
        <style type="text/css">
            body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
            #allmap{height:100%;width:100%;}
        </style>
        <script type="text/javascript" src="<%= basePath%>static/js/jquery.js"></script>
        <script type='text/javascript' src='<%= basePath%>dwr/engine.js'></script> 
        <script type='text/javascript' src='<%= basePath%>dwr/util.js'></script> 
        <script type='text/javascript' src='<%= basePath%>dwr/interface/ShowLocation.js'></script>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=GngYRfOLeNy5wwXAsTmvfEuNQU8qjx0q"></script>
        <script type="text/javascript">
            var map;
            $(function () {
                ShowLocation.onLoad();
                dwr.engine.setActiveReverseAjax(true);
                dwr.engine.setNotifyServerOnPageUnload(true);
                // 百度地图API功能
                map = new BMap.Map("allmap");
                map.centerAndZoom(new BMap.Point(116.331398, 39.897445), 11);
                map.enableScrollWheelZoom(true);
            });
            var chedui = {};
            var opts = {
                        width : 250,     // 信息窗口宽度
                        height: 80,     // 信息窗口高度
                        title : "信息窗口" , // 信息窗口标题
                        enableMessage:true//设置允许信息窗发送短息
                   };
            // 用经纬度设置地图中心点
            function showLocation(经度, 纬度, 车牌号, dateTime) {
                if (经度 !== '' && 纬度 !=='' && 经度 !== null && 纬度 !==null) {
                    map.clearOverlays();
                    var new_point = new BMap.Point(经度, 纬度);
                    chedui[车牌号] = new_point;

                    for (var cph in chedui) {
                        var point = chedui[cph];  // 创建标注
                        var marker = new BMap.Marker(point);  // 创建标注
                        map.addOverlay(marker);              // 将标注添加到地图中
                        map.panTo(new_point);
                        var content = "地址：北京市东城区正义路甲5号";
                        marker.addEventListener("click", function (e) {
                            openInfo(content, e);
                        }
                        );
                    }
                }
            }
            function openInfo(content,e){
		var p = e.target;
		var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
		var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	}
        </script> 
    </head>
    <body>
        <div id="allmap"></div>
    </body>
</html>