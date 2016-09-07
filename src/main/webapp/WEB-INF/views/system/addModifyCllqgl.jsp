<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">
    .input_area{
        margin-bottom:20px;
        margin-right: 10px;
        float: left;
        width:350px
    }
</style>
<script>
    $(function () {
        $('#lqtime').datebox().datebox('calendar').calendar({
            validator: function (date) {
                var now = new Date();
                return date <= now;
            }
        });
    });
</script>

<form action="data/cllqgl/addModifyCllqgl.do" method="post" id="cllqglManageForm">
    <div class="input_area" style="margin-top:20px;">
        <input name="id" value="${cllqGl.id}" type="hidden"/>
        <input class="easyui-combobox" name="lqclh" id="lqclh" value="${cllqGl.lqclh}" style="width:95%" data-options="label:'材料名称',required:true,valueField:'id',textField:'clmc',url:'data/baseManage/getAllClxx.do'">
    </div>
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-datebox" name="lqtime" id="lqtime" value="${cllqGl.lqtime}" style="width:95%" data-options="label:'领取日期'">
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="lqsl" id="lqsl" value="${cllqGl.lqsl}" style="width:95%" data-options="label:'领取数量',required:true"/>
    </div>
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-textbox" name="sysl" id="sysl" value="${cllqGl.sysl}" style="width:95%" data-options="required:true,label:'使用数量'">
    </div>
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-combobox" name="lqdw" id="lqdw" value="${cllqGl.lqdw}" style="width:95%" data-options="required:true,label:'领取队伍',valueField:'id',textField:'sgdmc',url:'data/baseManage/getAllSgd.do'">
    </div>
    <div style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:750px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>
