<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>施工队伍管理</title>
        <script type="text/javascript" src="static/js/customer/sgdwManage.js"></script>
    </head>
    <body>
    <section>
        <h2>
            <strong style="color: grey;">施工队伍管理</strong>
        </h2>
        <table class="easyui-datagrid" title="施工队伍列表" style="width:auto;height:600px;" id="datagrid">
        </table>
        <div id="tb" style="display:none">
            <a href="javascript:sgdwManage.addModifySgdw(true);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
            <a href="javascript:sgdwManage.addModifySgdw();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a href="javascript:sgdwManage.deleteSgdw();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
            <span><input type="text" name="searchKey" id="searchKey"/><a href="javascript:sgdwManage.searchSgdw($('#searchKey').val());" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">检索</a></span>
        </div>
    </section>
    
    <div id="sgdwManageDialog" style="display:none;padding: 10px;">
        
    </div>
</body>
</html>