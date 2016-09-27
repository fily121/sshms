<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>中移铁通微信企业号-<sitemesh:write property='title' /></title>
    <link rel="stylesheet" href="<%= basePath%>static/js/mobile/jquery.mobile-1.3.1.css">
    <script type="text/javascript" src="<%= basePath%>static/js/mobile/jquery-1.9.1.min.js"></script>
    <script type="text/javascript"  src="<%= basePath%>static/js/mobile/jquery.mobile-1.3.1.min.js"></script>
    <script type="text/javascript"  src="<%= basePath%>static/js/plugins/easyUi/jquery.easyui.min.js"></script>
    <script type="text/javascript"  src="<%= basePath%>static/js/mobile/jquery.validate.min.js"></script>
    <script type="text/javascript"  src="<%= basePath%>static/js/mobile/messages_zh.min.js"></script>
<sitemesh:write property='head' />
<script type="text/javascript">
    function confirmMessage(message, fn) {
        var popupDialogId = 'popupDialog';
        $('<div data-role="popup" id="' + popupDialogId + '" data-confirmed="no" data-transition="pop" data-overlay-theme="b" data-theme="b" data-dismissible="false" style="min-width:216px;max-width:500px;"> \
                \
                <div role="main" class="ui-content">\
                    <h3 class="ui-title" style="color:#fff; text-align:center;margin-bottom:15px">' + message + '</h3>\
                    <a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b optionConfirm" data-rel="back" style="background: #1784fd;width: 33%;border-radius: 5px;height: 30px;line-height: 30px;padding: 0;font-size: .9em;margin: 0 0 0 12%;font-weight: 100;">确定</a>\
                    <a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b optionCancel" data-rel="back" data-transition="flow" style="background: #DBDBDB;width: 33%;border-radius: 5px;height: 30px;line-height: 30px;padding: 0;font-size: .9em;margin: 0 0 0 5%;font-weight: 100;color: #333;text-shadow: none;">取消</a>\
                </div>\
            </div>')
                .appendTo($.mobile.pageContainer);
        var popupDialogObj = $('#' + popupDialogId);
        popupDialogObj.trigger('create');
        popupDialogObj.popup({
            afterclose: function (event, ui) {
                popupDialogObj.find(".optionConfirm").first().off('click');
                var isConfirmed = popupDialogObj.attr('data-confirmed') === 'yes' ? true : false;
                $(event.target).remove();
                if (isConfirmed && fn) {
                    fn.apply(this);
                }
            }
        });
        popupDialogObj.popup('open');
        popupDialogObj.find(".optionConfirm").first().on('click', function () {
            popupDialogObj.attr('data-confirmed', 'yes');
        });
    }
    function downloadFile(fileName, attachmentId) {
        var url = '../data/system/downloadFile.do';
        window.open(url + '?fileName=' + encodeURI(fileName) + '&attachmentId=' + attachmentId);
    }
</script>
</head>
<body>
<sitemesh:write property='body' />
</body>
</html>