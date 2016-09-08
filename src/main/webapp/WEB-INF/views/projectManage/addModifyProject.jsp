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
<form id="projectManageForm" method="post" action="data/projectManage/addModifyProject.do" enctype="multipart/form-data">
    <div class="input_area" style="margin-top:20px;">
        <input name="projectId" value="${project.projectId}" type="hidden"/>
        <input class="easyui-textbox" name="projectName" id="projectName" value="${project.projectName}" style="width:95%" data-options="label:'工程名',required:true" validType="maxLength[20]">
    </div>
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-textbox" name="createTime" id="createTime" value="${project.formattedCreateDate}" style="width:95%" data-options="label:'创建日期', disabled:true">
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="projectDetail"  value="${project.projectDetail}"  id="projectDetail" style="width:95%" data-options="label:'详情'" validType="maxLength[200]"/>
    </div>
    <div style="clear:both;"></div>
    <a id="btn" href="javascript: projectManage.addFile();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加文件</a>
    <div class="input_area">
        <input type="file" id="file_1" name="uploadFile"/>
        <div id="fileDiv">
            <c:forEach items="${files}" var="file">
            <div>
                <a href="data/system/downloadFile.do?fileName=${file.name}&attachmentId=${project.attachmentId}">${file.name}</a>
                <a onclick="javascript: projectManage.deleteFile(this, '${project.attachmentId}', '${file.name}');"  href="javascript:void(0);">删除文件</a>
            </div>
            </c:forEach>
        </div>
    </div>
    <div style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:750px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="projectManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="projectManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>
