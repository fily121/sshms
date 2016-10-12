<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>订单管理</title>
        <script type="text/javascript" src="static/js/baseManage/orderManage.js"></script>
    </head>
    <body>
    <section>
        <h2>
            <strong style="color: grey;">订单管理</strong>
        </h2>
        <table class="easyui-datagrid" title="订单列表" style="width:auto;height:500px;" id="datagrid">
        </table>
        <div id="tb" style="display:none">
            <a href="javascript:orderManage.addModifyOrder(true);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">创建订单</a>
            <a href="javascript:orderManage.addModifyOrder();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <span><input type="text" name="searchKey" id="searchKey"/><a href="javascript: orderManage.searchOrder($('#searchKey').val());" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">检索</a></span>
        </div>
    </section>

    <div id="orderManageDialog" style="display:none;padding: 10px;">
       
    </div>
</body>
</html>