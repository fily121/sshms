<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>施工队管理</title>
    </head>
    <body>
        <script type="text/javascript">
            $(function () {
                $('#datagrid').datagrid({
                    url: 'data/system/getSgdList.do',
                    method: 'get',
                    toolbar: '#tb',
                    singleSelect: true,
                    title: '施工队列表',
                    pagination: true,
                    columns: [[
                            {field: 'id', width: 80, hidden: true},
                            {field: 'duizhang', width: 80, hidden: true},
                            {field: 'sgdmc', title: '施工队名称', width: 120},
                            {field: 'duizhangMc', title: '队长名称', width: 120},
                            {field: 'detail', title: '详情', width: 240, align: 'left'},
                            {field: 'caozuo', title: '操作', width: 120, align: 'center', formatter: function (value, row, index) {
                                    return '<a href="xcgl/xclx.do?id='+row.id+'" class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true">联系</a>';
                                }}
                        ]]
                });
            })
        </script>
    <section>
        <h2>
            <strong style="color: grey;">施工队列表</strong>
        </h2>
        <table title="施工队列表" style="width:auto;height:600px;" id="datagrid">
        </table>
        <div id="tb" style="display:none">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
        </div>
    </section>
</body>
</html>