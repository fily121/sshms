<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>材料管理</title>
        <script type="text/javascript" src="static/js/baseManage/clManage.js"></script>
    </head>
    <body>
    <section>
        <h2>
            <strong style="color: grey;">材料管理</strong>
        </h2>
        <table class="easyui-datagrid" title="材料领取列表" style="width:auto;height:600px;" id="datagrid">
        </table>
        <div id="tb" style="display:none">
            <a href="javascript:clManage.addModifyCllqgl(true);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加记录</a>
            <a href="javascript:clManage.addModifyCllqgl();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改记录</a>
            <a href="javascript:clManage.deleteCllqgl();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除记录</a>
            <a href="javascript:clxxManage.init();" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">查看材料信息</a>
        </div>
        <div id="cltb" style="display:none">
            <a href="javascript:clxxManage.addModifyClxx(true);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加材料</a>
            <a href="javascript:clxxManage.addModifyClxx();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改材料</a>
            <a href="javascript:clxxManage.deleteClxx();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除材料</a>
            <a href="javascript:clManage.init();" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">查看领取记录</a>
        </div>
    </section>
    
    <div id="cllqglManageDialog" style="display:none;padding: 10px;">
        
    </div>
</body>
</html>