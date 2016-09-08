<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">
    .input_area{
        margin-bottom:20px;
        margin-right: 10px;
        float: left;
        width:350px
    }
</style>

<form action="data/cllqgl/addModifyClxx.do" method="post" id="clxxManageForm">
    <div class="input_area" style="margin-top:20px;">
        <input name="id" value="${clxx.id}" type="hidden"/>
        <input class="easyui-textbox" name="clmc" id="clmc" value="${clxx.clmc}" style="width:95%" data-options="label:'材料名称',required:true">
    </div>
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-textbox" name="detail" id="detail" value="${clxx.detail}" style="width:95%" data-options="label:'材料详情'">
    </div>
    <div style="text-align:center;padding:10px 0;float:left;margin:0 auto;width:750px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clxxManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clxxManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>
