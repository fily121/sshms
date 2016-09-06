<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">
    .input_area{
        margin-bottom:20px;
        margin-right: 10px;
        float: left;
        width:350px
    }
</style>
<form id="orderForm" name="orderManageForm" method="post" action="data/baseManage/addModifyOrder.do" enctype="multipart/form-data">
    <div class="input_area" style="margin-top:20px;">
        <input name="orderId" value="${order.order.orderId}" type="hidden"/>
        <input class="easyui-textbox" name="orderName" id="orderName" value="${order.order.orderName}" style="width:95%" data-options="label:'订单名称',required:true" validType="maxLength[20]">
    </div>
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-textbox" name="formattedCreateDate" id="formattedCreateDate" value="${order.order.formattedCreateDate}" style="width:95%" data-options="label:'创建日期', disabled:true">
    </div>
    <div class="input_area">
        <input class="easyui-combobox" name="sgdid"  value="${order.order.sgdid}" id="sgdid" style="width:95%" data-options="label:'所属施工队',valueField:'id',textField:'sgdmc',url:'data/baseManage/getAllSgd.do'">
    </div>
    <div class="input_area">
        <textarea class="easyui-textbox" name="remark"  value="${order.order.remark}"  id="remark" style="width:95%" data-options="label:'备注'" validType="maxLength[200]"></textarea>
    </div>
    <a id="btn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加文件</a>
    <div class="input_area">
        <input type="file" id="file1" name="uploadFile"/>
    </div>
    <div style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:750px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="orderManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="orderManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>
</form>
