<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修改施工队信息</title>
        <script type="text/javascript">
            $.validator.setDefaults({
                submitHandler: function () {
                    $("#orderManageForm").form('submit', {
                        success: function (data) {
                            data = eval("(" + data + ")");
                            if (data && data.code === 'true') {
                                window.location.href = 'sgdxxDetail.do?id='+data.id;
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
        </script>
    </head>
    <body>
        <div data-role="page">
            <form id="orderManageForm" method="post" action="../data/baseManage/addModifySgdxx.do" enctype="multipart/form-data">
                <div data-role="header" data-position="fixed">
                    <!--<a href="#" data-role="button">Back</a>-->
                    <h1>修改施工队信息</h1>
                </div><!-- /header -->
                <div data-role="content"> 
                    <div data-role="fieldcontain">
                        <label for="sgdmc">施工队名称：</label>
                        <input type="hidden" name="id" value="${sgdxx.id}"/>
                        <input type="text" name="sgdmc" id="sgdmc" value="${sgdxx.sgdmc}" required />
                    </div>
                    <div data-role="fieldcontain">
                        <label for="detail">施工队详情：</label>
                        <input type="text" name="detail" id="detail" value="${sgdxx.detail}" required />
                    </div>
                    <div data-role="fieldcontain">
                        <label for="address">施工队地址：</label>
                        <input type="text" name="address" id="address" value="${sgdxx.address}" required />
                    </div>
                    <div data-role="fieldcontain">
                        <label for="ctype">车型：</label>
                        <input type="text" name="ctype" id="ctype" value="${sgdxx.ctype}" required />
                    </div>
                    <div data-role="fieldcontain">
                        <label for="remark">队长：</label>
                        ${sgdxx.duizhangMc}
                    </div>
                    <div data-role="fieldcontain">
                        <label for="cph">车牌号：</label>
                        <input type="text" name="cph" id="cph" value="${sgdxx.cph}" required />
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
