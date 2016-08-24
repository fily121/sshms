<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>人员管理</title>
    </head>
    <body>
        <script type="text/javascript">
            $(function () {
                $('#datagrid').datagrid({
                    url: 'data/system/getUserList.do',
                    method: 'get',
                    toolbar: '#tb',
                    singleSelect: true,
                    pagination: true，
                    title: '施工队列表',
                    columns: [[
                            {field: 'user.userId', width: 80, hidden: true},
                            {field: 'user.orgId', width: 80, hidden: true},
                            {field: 'user.roleId', width: 80, hidden: true},
                            {field: 'user.userName', title: '用户名', width: 120},
                            {field: 'roleName', title: '角色名', width: 120},
                            {field: 'user.ext1', title: '姓名', width: 120},
                            {field: 'sgdmc', title: '所属施工队', width: 240, align: 'left'}
                        ]]
                });
            })
        </script>
    <section>
        <h2>
            <strong style="color: grey;">人员列表</strong>
        </h2>
        <table class="easyui-datagrid" title="人员列表" style="width:auto;height:600px;" id="datagrid">
        </table>
        <div id="tb" style="display:none">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">增加</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">删除</a>
        </div>
    </section>
</body>
</html>