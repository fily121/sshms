<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">
    .input_area{
        margin-top:20px;
        margin-bottom:20px;
        margin-right: 10px;
        float: left;
        width:350px
    }
</style>
<script>
    $(function () {
        easyuiExt.initCombobox();
    });
</script>

<form action="data/baseManage/addModifySgdxx.do" method="post" id="sgdxxManageForm">
    <div class="input_area">
        <input name="id" value="${sgdxx.id}" type="hidden"/>
        <input class="easyui-textbox" name="sgdmc" id="sgdmc" value="${sgdxx.sgdmc}" style="width:95%" data-options="label:'施工队名',required:true">
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="detail" id="detail" value="${sgdxx.detail}" style="width:95%" data-options="label:'施工队详情'">
    </div>
    <div class="input_area">
        <select class="easyui-combogrid" name="duizhang" id="duizhang" style="width:95%" data-options="label:'队长信息',required:true,idField:'userId',
                value:'${sgdxx.duizhang}',
                textField:'name',url:'data/system/getAllUser.do',columns: [[
                {field:'userId',hidden:true},
                {field:'name',title:'姓名',width:80},
                {field:'wechatNo',title:'微信号',width:120}]],fitColumns: true">
        </select>
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="cph" id="cph" value="${sgdxx.cph}" style="width:95%" data-options="required:true,label:'车牌号'">
    </div>
    <div style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:750px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="sgdwManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="sgdwManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>
