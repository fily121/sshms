<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="static/js/customer/roleManage.js"></script>
        <title>角色管理</title>
    </head>
    <body>
    <section>
        <h2>
            <strong style="color: grey;">角色管理</strong>
        </h2>
        <table class="easyui-datagrid" title="角色列表" style="width:auto;height:500px;" id="datagrid">
        </table>
        <div id="tb" style="display:none">
            <a href="javascript:roleManage.addModifyRole(true);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
            <a href="javascript:roleManage.addModifyRole();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a href="javascript:roleManage.deleteRole();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
        </div>
    </section>
    
    <div id="roleManageDialog" style="display:none;padding: 10px;">
        
    </div>
</body>
</html>