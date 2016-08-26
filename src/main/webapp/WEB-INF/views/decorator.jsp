<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta charset="utf-8"/>
        <%@ include file="/WEB-INF/views/baseJsCss.jsp" %>
        <title>中移铁通微信企业号-<sitemesh:write property='title' /></title>
    <sitemesh:write property='head' />
    <script type="text/javascript" >
        function changePassword() {
            $('#changePasswordFormDialog').dialog({
                title: '修改密码',
                width: 400,
                height: 300,
                closed: true,
                cache: false,
                modal: true
            });
            $('#changePasswordFormDialog').dialog('open');
        }
        function logout() {
            $('#changePasswordForm').form('clear');
            window.location.href = "<%= basePath%>/logout.do";
        }
    </script>
</head>
<body>
<header>
    <h1><img src="static/css/images/admin_logo.png"/></h1>
    <ul class="rt_nav">
        <li style="margin-top: 16px;color: white;font-size: 16px">欢迎您，${userName}</li>
        <li><a href="javascript:changePassword();" class="set_icon">修改密码</a></li>
        <li><a href="<%= basePath%>/logout.do" class="quit_icon">安全退出</a></li>
    </ul>
</header>

<aside class="lt_aside_nav content mCustomScrollbar">
    <h2><a href="user/index.do" <c:if test="${menuId eq 0}">class="active"</c:if> >起始页</a></h2>
        <ul>
            <li>
                <dl>
                <shiro:hasPermission name="系统管理">
                    <dt>系统管理</dt>
                </shiro:hasPermission>
                <shiro:hasPermission name="菜单管理">
                    <dd><a href="system/menuManage.do?menuId=1" <c:if test="${menuId eq 1}">class="active"</c:if>>菜单管理</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="人员管理">
                    <dd><a href="system/userManage.do?menuId=2" <c:if test="${menuId eq 2}">class="active"</c:if>>人员管理</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="角色管理">
                    <dd><a href="system/roleManage.do?menuId=3" <c:if test="${menuId eq 3}">class="active"</c:if>>角色管理</a></dd>
                </shiro:hasPermission>
            </dl>
        </li>
        <li>
            <dl>
                <shiro:hasPermission name="基础管理">
                    <dt>基础管理</dt>
                </shiro:hasPermission>
                <shiro:hasPermission name="订单管理">
                    <dd><a href="baseManage/orderManage.do?menuId=4" <c:if test="${menuId eq 4}">class="active"</c:if>>订单管理</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="规章制度">
                    <dd><a href="baseManage/gzzdManage.do?menuId=5" <c:if test="${menuId eq 5}">class="active"</c:if>>规章制度</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="材料管理">
                    <dd><a href="baseManage/clManage.do?menuId=6" <c:if test="${menuId eq 6}">class="active"</c:if>>材料管理</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="施工队伍">
                    <dd><a href="baseManage/sgdwManage.do?menuId=7" <c:if test="${menuId eq 7}">class="active"</c:if>>施工队伍</a></dd>
                </shiro:hasPermission>
            </dl>
        </li>
        <li>
            <dl>
                <shiro:hasPermission name="现场相关管理">
                    <dt>现场相关管理</dt>
                </shiro:hasPermission>
                <shiro:hasPermission name="现场管理">
                    <dd><a href="xcgl/xcglManage.do?menuId=8" <c:if test="${menuId eq 8}">class="active"</c:if>>现场管理</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="现场检查">
                    <dd><a href="xcgl/xcjcManage.do?menuId=9" <c:if test="${menuId eq 9}">class="active"</c:if>>现场检查</a></dd>
                </shiro:hasPermission>
            </dl>
        </li>
        <li>
            <dl>
                <shiro:hasPermission name="项目管理">
                    <dt>项目管理</dt>
                </shiro:hasPermission>
                <shiro:hasPermission name="工程承揽情况">
                    <dd><a href="projectManage/projectManage.do?menuId=10" <c:if test="${menuId eq 10}">class="active"</c:if>>工程承揽情况</a></dd>
                </shiro:hasPermission>
            </dl>
        </li>
        <li>
            <p class="btm_infor">© 中移铁通版权所有</p>
        </li>
    </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <sitemesh:write property='body' />
    </div>
</section>
<div id="changePasswordFormDialog" style="display:none;padding: 10px;">
    <form action="data/system/changePassword.do" method="post" id="changePasswordForm">
        <div style="margin-bottom:20px">
            <input class="easyui-passwordbox" name="password1" id="password1" style="width:95%" data-options="label:'原密码:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-passwordbox" name="password2" id="password2" style="width:95%" data-options="label:'新密码:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-passwordbox" name="password3" id="password3" style="width:95%" data-options="label:'确认新密码:',required:true"  validType="equals['#password2']">
        </div>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm('#changePasswordForm', logout)" style="width:80px">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm('#changePasswordForm')" style="width:80px">清空</a>
        </div>
    </form>
</div>
</body>
</html>

