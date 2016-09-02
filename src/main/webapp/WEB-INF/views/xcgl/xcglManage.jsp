<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>  
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
                    url: 'data/baseManage/getSgdList.do',
                    method: 'get',
                    toolbar: '#tb',
                    singleSelect: true,
                    title: '施工队列表',
                    pagination: true,
                    columns: [[
                            {field: 'id', width: 80, hidden: true, formatter: function (value, row, index) {
                                    return row.sgdxx.id;
                                }
                            },
                            {field: 'duizhang', width: 80, hidden: true, formatter: function (value, row, index) {
                                    return row.user.userId;
                                }
                            },
                            {field: 'sgdmc', title: '施工队名称', width: 120, formatter: function (value, row, index) {
                                    return row.sgdxx.sgdmc;
                                }
                            },
                            {field: 'duizhangMc', title: '队长名称', width: 120, formatter: function (value, row, index) {
                                    return row.user.name;
                                }
                            },
                            {field: 'detail', title: '详情', width: 240, align: 'left', formatter: function (value, row, index) {
                                    return row.sgdxx.detail;
                                }
                            },
                            {field: 'cph', title: '车牌号', width: 240, align: 'left', formatter: function (value, row, index) {
                                    return row.sgdxx.cph;
                                }
                            },
                            {field: 'caozuo', title: '操作', width: 120, align: 'center', formatter: function (value, row, index) {
                                    return '<a href="xcgl/xclx.do?id=' + row.sgdxx.id + '" class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true">联系</a>';
                                }
                            }
                        ]]
                });
            });
            function openLocation() {
                 window.open ("<%= basePath%>div/xcgl/sgdwzxx.do", "_blank", "height=768, width=1024, toolbar= no, menubar=no, scrollbars=no, resizable=no, location=no, status=no,top=100,left=300")
            }
        </script>
    <section>
        <h2>
            <strong style="color: grey;">施工队列表</strong>
        </h2>
        <div><a href="javascript:openLocation();">位置信息</a></div>
        <table title="施工队列表" style="width:auto;height:600px;" id="datagrid"> </table>
        <div id="tb" style="display:none">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
        </div>
    </section>
</body>
</html>