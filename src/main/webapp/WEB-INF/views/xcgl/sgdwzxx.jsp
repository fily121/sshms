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
            var cheduiContent = {};
            var cheduiContentWithTime = {};
            var cheduiXX = {};
            var opts = {
                width: 350, // 信息窗口宽度
                height: 350, // 信息窗口高度
                title: "施工队信息", // 信息窗口标题
                enableMessage: true//设置允许信息窗发送短息
            };
            
            var geoc = new BMap.Geocoder();
            // 用经纬度设置地图中心点
            function showLocation(经度, 纬度, 车牌号, dateTime) {
                if (经度 !== '' && 纬度 !== '' && 经度 !== null && 纬度 !== null) {
                    map.clearOverlays();
                    var new_point = new BMap.Point(经度, 纬度);
                    chedui[车牌号] = new_point;
                    if (!cheduiContent[车牌号]) {
                        getContent(车牌号, dateTime, new_point);
                    } else {
                        dingwei(车牌号, dateTime, new_point);
                    }

                }
            }
            
            function openInfo(e) {
                var p = e.target;
                var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                var cph = cheduiXX[point.lng + "_" + point.lat];
                geoc.getLocation(point, function(rs){
			var addComp = rs.addressComponents;
                        var infoWindow = new BMap.InfoWindow(cheduiContentWithTime[cph]+"<br/>当前地址："+addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber, opts);  // 创建信息窗口对象 
                        map.openInfoWindow(infoWindow, point); //开启信息窗口
		});
                
                parent.setSgdIdToLianxi(cphToSgdId[cph]);
            }
            var cphToSgdId = {};
            function getContent(车牌号, dateTime, new_point) {
                $.post('<%= basePath%>data/xcgl/getCheduiXX.do', {cph: 车牌号}, function (data) {
                    data = eval("(" + data + ")");
                    cheduiContent[车牌号] = data.sgdxx;
                    var sgdId = data.sgdId;
                    if (!cphToSgdId[车牌号] && sgdId) {
                        cphToSgdId[车牌号] = sgdId;
                    }
                    dingwei(车牌号, dateTime, new_point);
                });
            }

            function dingwei(车牌号, dateTime, new_point) {
                var content = cheduiContent[车牌号] + "<br/>定位时间：" + dateTime;
                cheduiContentWithTime[车牌号] = content;
                for (var cph in chedui) {
                    var point = chedui[cph];  // 创建标注
                    var marker = new BMap.Marker(point);  // 创建标注
                    cheduiXX[point.lng + "_" + point.lat] = cph;
                    marker.addEventListener("click", function (e) {
                        openInfo(e);
                    }
                    );
                    map.addOverlay(marker);              // 将标注添加到地图中
                    map.panTo(new_point);
                }
            }
        </script> 
    </head>
    <body>
        <div id="allmap"></div>
    </body>
</html>