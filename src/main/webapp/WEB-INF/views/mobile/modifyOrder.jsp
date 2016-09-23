<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>订单管理</title>
    </head>
    <body>
        <div data-role="page">
            <div data-role="header" data-position="fixed">
                <!--<a href="#" data-role="button">Back</a>-->
                <h1>订单管理</h1>
            </div><!-- /header -->
            <div data-role="content"> 
                <div data-role="fieldcontain">
                    <label for="orderName">订单名称：</label>
                    <input type="text" name="orderName" id="orderName" value=""  />
                </div>
                <div data-role="fieldcontain">
                    <label for="orderNumber">项目编号：</label>
                    <input type="text" name="orderNumber" id="orderNumber" value=""  />
                </div>
                <div data-role="fieldcontain">
                    <label for="lxNumber">工作联系单编号：</label>
                    <input type="text" name="lxNumber" id="lxNumber" value=""  />
                </div>
                <div data-role="fieldcontain">
                    <label for="startTime">开工日期：</label>
                    <input type="date" name="startTime" id="startTime" value="">
                </div>
                <div data-role="fieldcontain">
                    <label for="startTime">开工日期：</label>
                    <input type="date" name="startTime" id="startTime" value="">
                </div>
            </div><!-- /content -->

            <div data-role="footer" data-position="fixed">
                <div data-role="navbar">
                    <ul>
                        <li><a href="#" data-icon="gear" class="ui-btn-active ui-state-persist">修改订单</a></li>
                    </ul>
                </div>
            </div>

        </div><!-- /page -->
    </body>
</html>
