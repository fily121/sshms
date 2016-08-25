<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">
    .input_area{
       margin-bottom:20px;
       margin-right: 10px;
       float: left;
       width:350px
    }
</style>
<form action="data/system/addUser.do" method="post" id="userManageForm">
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-textbox" name="userName" id="password1" style="width:95%" data-options="label:'用户名',required:true" validType="maxLength[20]">
    </div>
     <div class="input_area" style="margin-top:20px;">
        <input class="easyui-combobox" name="roleId" id="roleId" style="width:95%" data-options="label:'所属角色',required:true,valueField:'roleId',textField:'roleName',url:'data/system/getAllRole.do'">
    </div>
    <div class="input_area">
        <input class="easyui-passwordbox" name="userPwd" id="password2" style="width:95%" data-options="label:'密码:',required:true" validType="maxLength[20]">
    </div>
    <div class="input_area">
        <input class="easyui-passwordbox" name="password3" id="password3" style="width:95%" data-options="label:'确认密码:',required:true"  validType="equals['#password2']">
    </div>
    <div class="input_area">
        <input class="easyui-combobox" name="orgId" id="orgId" style="width:95%" data-options="label:'所属施工队',valueField:'id',textField:'sgdmc',url:'data/system/getAllSgd.do'">
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="ext1"  id="ext1" style="width:95%" data-options="label:'姓名'" validType="maxLength[20]">
    </div>
    <div style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:750px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>
