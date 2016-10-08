<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <c:if test="${not empty order}">
                修改规章制度
            </c:if>
            <c:if test="${empty order}">
                发布规章制度
            </c:if>
        </title>
        <script type="text/javascript">
            $.validator.setDefaults({
                submitHandler: function () {
                    $("#orderManageForm").form('submit', {
                        success: function (data) {
                            data = eval("(" + data + ")");
                            if (data && data.code === 'true') {
                                window.location.href = 'gzzdDetail.do?modify=true&id='+data.id;
                            }
                        }
                    });
                }
            });

            $(function () {
                $("#orderManageForm").validate();
            })
            function submitForm(){
                $("#orderManageForm").submit();
            }
            function deleteFile (thisLink, attachmentId, fileName) {
            confirmMessage("确认要删除这个文件吗？文件删除会立即生效。", function (y) {
                if (attachmentId) {
                    $.post('../data/baseManage/deleteFile.do', {attachmentId: attachmentId, fileName: fileName});
                }
                $(thisLink).parent().remove();
            });
        }
        </script>
    </head>
    <body>
        <div data-role="page">
            <form id="orderManageForm" method="post" action="../mobile/addModifyGzzd.do" enctype="multipart/form-data">
                <div data-role="header" data-position="fixed">
                    <h1> <c:if test="${not empty gzzd}">
                            修改规章制度
                        </c:if>
                        <c:if test="${empty gzzd}">
                            发布规章制度
                        </c:if></h1>
                </div><!-- /header -->
                <div data-role="content"> 
                    <c:if test="${gzzd.id != null}">
                        <input type="hidden" name="id" value="${gzzd.id}" />
                        <input type="hidden" name="lastmodifyuserid" value="${gzzd.lastmodifyuserid}" />
                        <input type="hidden" name="lastmodifytime" value="${gzzd.lastmodifytime}" />
                        <div data-role="fieldcontain">
                            <label for="orderName">发布日期：</label>
                            ${gzzd.formattedTime}
                        </div>
                    </c:if>
                    <div data-role="fieldcontain">
                        <label for="orderName">规章制度名称：</label>
                        <input type="text" name="name" id="name" value="${gzzd.name}" required />
                    </div>
                    <div data-role="fieldcontain">
                        <label for="problem">详情：</label>
                        <textarea cols="40" rows="8" name="detail" id="detail">${gzzd.detail}</textarea>
                    </div>
                    <div data-role="fieldcontain">
                        <label for="uploadFile1">选择文件：</label>
                        <input type="file" id="uploadFile1" name="uploadFile"/>
                        <div id="fileDiv">
                            <c:forEach items="${files}" var="file">
                                <div>
                                    <a href="../data/system/downloadFile.do?fileName=${file.name}&attachmentId=${order.order.attachmentId}">${file.name}</a>
                                    <a onclick="javascript: deleteFile(this, '${gzzd.attachmentId}', '${file.name}');"  href="javascript:void(0);">删除文件</a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                </div><!-- /content -->

                <div data-role="footer" data-position="fixed">
                    <div data-role="navbar">
                        <ul>
                            <li><a href="javascript:submitForm();" data-icon="plus">提交</a></li>
                        </ul>
                    </div>
                </div>

            </form>
        </div><!-- /page -->
    </body>
</html>
