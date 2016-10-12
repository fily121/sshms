<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>菜单管理</title>
    </head>
    <body>
    <section>
        <h2>
            <strong style="color: grey;">菜单列表</strong>
        </h2>
        <table class="easyui-datagrid" title="菜单列表" style="width:auto;height:500px;"
               data-options="singleSelect:true,url:'data/system/getMenuList.do',method:'get',pagination:true">
            <thead>
                <tr>
                    <th data-options="field:'perId',width:80,hidden:true">id</th>
                    <th data-options="field:'parentPerId',width:80,hidden:true">pId</th>
                    <th data-options="field:'perName',width:120">菜单名称</th>
                    <th data-options="field:'parentPerName',width:120">父级菜单</th>
                    <th data-options="field:'perUrl',width:240,align:'left'">地址</th>
                    <th data-options="field:'status',width:120,align:'center'">操作</th>
                </tr>
            </thead>
        </table>
    </section>
</body>
</html>