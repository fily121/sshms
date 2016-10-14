<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .input_area{
        margin-bottom:20px;
        margin-right: 10px;
        float: left;
        width:450px
    }
</style>
<script>
    $(function () {
        easyuiExt.initCombobox();
    });
</script>

<form action="data/system/addModifyRole.do" method="post" id="roleManageForm">
    <div class="input_area" style="margin-top:20px;">
        <input name="roleId" value="${roleId}" type="hidden"/>
        <input class="easyui-textbox" name="roleName" id="roleName" value="${roleName}" style="width:80%" data-options="label:'角色名：',required:true" validType="maxLength[20]"/>
    </div>
    <div class="input_area" style="margin-top:20px;">
        <select id="guanlianPer" class="easyui-combogrid" name="guanlianPer" style="width:400px"
                data-options="
                panelWidth:280,
                value:${perIds},
                label:'权限：',
                idField:'perId',
                textField:'perName',
                editable:false,
                multiple:true,
                url: 'div/system/findPerList.do',
                columns:[[
                {field: 'perId', checkbox: true},
                {field: 'perName', title: '资源名', width: 200}
                ]]
                "></select>
    </div>
    <div id="submitDiv" style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:100%;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="roleManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="roleManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>
