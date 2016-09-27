<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        easyuiExt.initCombobox();
    });
</script>

<form id="orderManageForm" method="post" action="data/baseManage/addModifyOrder.do" enctype="multipart/form-data">
    <div class="input_area" style="margin-top:20px;">
        <input name="orderId" value="${order.order.orderId}" type="hidden"/>
        <input class="easyui-textbox" name="orderName" id="orderName" value="${order.order.orderName}" style="width:95%" data-options="label:'项目名称',required:true" validType="maxLength[20]">
    </div>
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-textbox" name="orderNumber" id="orderNumber" value="${order.order.orderNumber}" style="width:95%" data-options="label:'项目编号'" validType="maxLength[20]">
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="lxNumber" id="lxNumber" value="${order.order.lxNumber}" style="width:95%" data-options="label:'工作联系单编号'" validType="maxLength[20]">
    </div>
    <div class="input_area" >
        <input class="easyui-textbox" name="formattedCreateDate" id="formattedCreateDate" value="${order.order.formattedCreateDate}" style="width:95%" data-options="label:'派单日期', disabled:true">
    </div>
    <div class="input_area">
        <input class="easyui-combobox" name="sgdid"  value="${order.order.sgdid}" id="sgdid" style="width:95%" data-options="label:'施工单位',valueField:'id',textField:'sgdmc',url:'data/baseManage/getAllSgd.do',required:true"/>
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="realDetail"  value="${order.order.realDetail}"  id="remark" style="width:95%" data-options="label:'实际完成情况'" validType="maxLength[200]"/>
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="remark"  value="${order.order.remark}"  id="orderDetail" style="width:95%" data-options="label:'工程内容'" validType="maxLength[200]"/>
    </div>
    <div class="input_area" >
        <input class="easyui-datebox" name="startTime" id="startTime" value="${order.order.startTime}" style="width:95%" data-options="label:'要求开工日期'">
    </div>
    <div class="input_area" >
        <input class="easyui-datebox" name="endTime" id="endTime" value="${order.order.endTime}" style="width:95%" data-options="label:'要求完工日期'">
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="problem"  value="${order.order.problem}"  id="problem" style="width:95%" data-options="label:'存在问题'" validType="maxLength[200]"/>
    </div>
    <div>
        <select id="guanlianProject" class="easyui-combogrid" name="guanlianProject" style="width:400px"
                data-options="
                panelWidth:600,
                value:${projectIds},
                label:'关联工程',
                idField:'projectId',
                textField:'projectName',
                editable:false,
                multiple:true,
                url: 'data/projectManage/getProjectList.do?all=true',
                columns:[[
                {field: 'projectId', checkbox: true},
                {field: 'projectName', title: '工程名', width: 200},
                {field: 'formattedCreateDate', title: '创建时间', width: 140},
                {field: 'projectDetail', title: '详情', width: 400}
                ]]
                "></select>
    </div>
    <br/>
    <br/>
    <br/>
    <div style="clear:both"></div>
    <a id="btn" href="javascript: orderManage.addFile();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加文件</a>
    <div class="input_area">
        <input type="file" id="file_1" name="uploadFile"/>
        <div id="fileDiv">
            <c:forEach items="${files}" var="file">
                <div>
                    <a href="data/system/downloadFile.do?fileName=${file.name}&attachmentId=${order.order.attachmentId}">${file.name}</a>
                    <a onclick="javascript: orderManage.deleteFile(this, '${order.order.attachmentId}', '${file.name}', '${order.order.sgdid}', '${order.order.orderName}', '${order.order.orderId}');"  href="javascript:void(0);">删除文件</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:750px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="orderManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="orderManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>