<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <c:if test="${order.order.orderId != null}">
                修改订单
            </c:if>
            <c:if test="${order.order.orderId == null}">
                发布订单
            </c:if>
        </title>
        <script type="text/javascript">
            $.validator.setDefaults({
                submitHandler: function () {
                    $("#orderManageForm").form('submit', {
                        success: function (data) {
                            data = eval("(" + data + ")");
                            if (data && data.code === 'true') {
                                alert(data.message);
                            }
                        }
                    });
                }
            });

            $(function () {
                $("#orderManageForm").validate();
            })
            function submitForm() {
                $("#orderManageForm").submit();
            }
        </script>
    </head>
    <body>
        <div data-role="page">
            <form id="orderManageForm" method="post" action="../data/baseManage/addModifyOrder.do" enctype="multipart/form-data">
                <div data-role="header" data-position="fixed">
                    <h1>发布订单</h1>
                </div><!-- /header -->
                <div data-role="content"> 
                    <c:if test="${order.order.orderId != null}">
                        <div data-role="fieldcontain">
                            <label for="orderName">发布日期：</label>
                            ${order.order.formattedCreateDate}
                        </div>
                    </c:if>
                    <div data-role="fieldcontain">
                        <input type="hidden" name="id" value="${order.order.orderId}"/>
                        <label for="orderName">订单名称：</label>
                        <input type="text" name="orderName" id="orderName" value="${order.order.orderName}" required />
                    </div>
                    <div data-role="fieldcontain">
                        <label for="orderNumber">项目编号：</label>
                        <input type="text" name="orderNumber" id="orderNumber" value="${order.order.orderNumber}" required />
                    </div>
                    <div data-role="fieldcontain">
                        <label for="lxNumber">工作联系单编号：</label>
                        <input type="text" name="lxNumber" id="lxNumber" value="${order.order.lxNumber}" required />
                    </div>
                    <div data-role="fieldcontain">
                        <label for="sgdid" class="select">施工单位:</label>
                        <select name="sgdid" id="sgdid" data-native-menu="false" required>
                            <option>请选择施工队</option>
                            <c:forEach items="${sgdxxList}" var="sgdxx">
                                <option value="${sgdxx.id}" <c:if test="${sgdxx.id == order.order.sgdid}">selected</c:if>>${sgdxx.sgdmc}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div data-role="fieldcontain">
                        <label for="remark">工程内容：</label>
                        <textarea cols="40" rows="8" name="remark" id="remark">${order.order.remark}</textarea>
                    </div>
                    <div data-role="fieldcontain">
                        <label for="startTime">要求开工日期：</label>
                        <input type="date" name="startTime" id="startTime" value="${order.order.startTime}" required>
                    </div>
                    <div data-role="fieldcontain">
                        <label for="endTime">要求完工日期：</label>
                        <input type="date" name="endTime" id="endTime" value="${order.order.endTime}" required>
                    </div>
                    <div data-role="fieldcontain">
                        <label for="realDetail">实际完成情况：</label>
                        <textarea cols="40" rows="8" name="realDetail" id="realDetail">${order.order.realDetail}</textarea>
                    </div>
                    <div data-role="fieldcontain">
                        <label for="problem">存在问题：</label>
                        <textarea cols="40" rows="8" name="problem" id="problem">${order.order.problem}</textarea>
                    </div>
                    <div data-role="fieldcontain">
                        <label for="uploadFile1">选择文件：</label>
                        <input type="file" id="uploadFile1" name="uploadFile"/>
                        <div id="fileDiv">
                            <c:forEach items="${files}" var="file">
                                <div>
                                    <a href="data/system/downloadFile.do?fileName=${file.name}&attachmentId=${order.order.attachmentId}">${file.name}</a>
                                    <a onclick="javascript: orderManage.deleteFile(this, '${order.order.attachmentId}', '${file.name}', '${order.order.sgdid}', '${order.order.orderName}', '${order.order.orderId}');"  href="javascript:void(0);">删除文件</a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                </div><!-- /content -->

                <div data-role="footer" data-position="fixed">
                    <div data-role="navbar">
                        <ul>
                            <li><a href="javascript: submitForm();" data-icon="plus">提交</a></li>
                        </ul>
                    </div>
                </div>

            </form>
        </div><!-- /page -->
    </body>
</html>
