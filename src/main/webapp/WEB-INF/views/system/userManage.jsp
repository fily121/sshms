<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>人员管理</title>
        <script type="text/javascript" src="static/js/customer/userManage.js"></script>
    </head>
    <body>
    <section>
        <h2>
            <strong style="color: grey;">人员管理</strong>
        </h2>
        <table class="easyui-datagrid" title="人员列表" style="width:auto;height:600px;" id="datagrid">
        </table>
        <div id="tb" style="display:none">
            <a href="javascript:userManage.addModifyUser(true);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
            <a href="javascript:userManage.addModifyUser();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a href="javascript:userManage.deleteUser();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
            <a href="javascript: userManage.importUser();" class="easyui-linkbutton" data-options="iconCls:'icon-import',plain:true">从excel导入用户</a>
            <span><input type="text" name="searchKey" id="searchKey"/><a href="javascript:userManage.searchUser($('#searchKey').val());" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">检索</a></span>
        </div>
    </section>
    
    <div id="userManageDialog" style="display:none;padding: 10px;">
        
    </div>
    
    <div id="importUser" style="display: none; padding: 20px;">
        <a href="data/system/downloadFile.do?attachmentId=1">下载模板文件</a>
         <br/>
            <br/>
            <br/>
        <form method="post" id="importUserForm" action="data/system/uploadUserFile.do" enctype="multipart/form-data">
            <input type="file" name="userFile"/>
            <div style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:380px;">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userManage.submitFileForm()" style="width:80px">提交</a>
            </div>
        </form>
    </div>
</body>
</html>