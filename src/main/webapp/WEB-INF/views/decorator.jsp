<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8"/>
<%@ include file="/WEB-INF/views/baseJsCss.jsp" %>
<title>中移铁通微信企业号-<sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body>
<header>
 <h1><img src="static/css/images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a href="http://www.baidu.com" target="_blank" class="website_icon">站点首页</a></li>
  <li><a href="#" class="admin_icon">DeathGhost</a></li>
  <li><a href="#" class="set_icon">账号设置</a></li>
  <li><a href="<%= basePath%>/logout.do" class="quit_icon">安全退出</a></li>
 </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index.php">起始页</a></h2>
 <ul>
  <li>
   <dl>
    <shiro:hasPermission name="系统管理">
    <dt>系统管理</dt>
    </shiro:hasPermission>
    <shiro:hasPermission name="菜单管理">
    <dd><a href="system/menuManage.do" class="active">菜单管理</a></dd>
    </shiro:hasPermission>
    <shiro:hasPermission name="人员管理">
    <dd><a href="#">人员管理</a></dd>
    </shiro:hasPermission>
    <shiro:hasPermission name="角色管理">
    <dd><a href="#">角色管理</a></dd>
    </shiro:hasPermission>
   </dl>
  </li>
  <li>
   <dl>
    <shiro:hasPermission name="基础管理">
    <dt>基础管理</dt>
    </shiro:hasPermission>
    <shiro:hasPermission name="订单管理">
    <dd><a href="#">订单管理</a></dd>
    </shiro:hasPermission>
    <shiro:hasPermission name="规章制度">
    <dd><a href="#">规章制度</a></dd>
    </shiro:hasPermission>
    <shiro:hasPermission name="材料管理">
    <dd><a href="#">材料管理</a></dd>
    </shiro:hasPermission>
    <shiro:hasPermission name="施工队伍">
    <dd><a href="#">施工队伍</a></dd>
    </shiro:hasPermission>
   </dl>
  </li>
  <li>
   <dl>
    <shiro:hasPermission name="现场相关管理">
    <dt>现场相关管理</dt>
    </shiro:hasPermission>
    <shiro:hasPermission name="现场管理">
    <dd><a href="xcgl/xcglManage.do">现场管理</a></dd>
    </shiro:hasPermission>
    <shiro:hasPermission name="现场检查">
    <dd><a href="xcgl/xcjcManage">现场检查</a></dd>
    </shiro:hasPermission>
   </dl>
  </li>
  <li>
   <dl>
    <shiro:hasPermission name="项目管理">
    <dt>项目管理</dt>
    </shiro:hasPermission>
    <shiro:hasPermission name="工程承揽情况">
    <dd><a href="#">工程承揽情况</a></dd>
    </shiro:hasPermission>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© 中国移动版权所有</p>
  </li>
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
         <sitemesh:write property='body' />
 </div>
</section>
</body>
</html>

