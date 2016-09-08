var orderManage = function () {
    return {
        init: function () {
            $('#datagrid').datagrid({
                url: 'data/baseManage/getOrderList.do',
                method: 'post',
                toolbar: '#tb',
                singleSelect: true,
                pagination: true,
                title: '订单列表',
                columns: [[
                        {field: 'orderId', hidden: true, formatter: function (value, rows, index) {
                                if (rows.order) {
                                    return rows.order.orderId;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'attachmentId', hidden: true, formatter: function (value, rows, index) {
                                if (rows.order) {
                                    return rows.order.attachmentId;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'orderName', width: 220, title: '订单名称', formatter: function (value, rows, index) {
                                if (rows.order) {
                                    return rows.order.orderName;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'formattedCreateDate', width: 150, title: '创建日期', formatter: function (value, rows, index) {
                                if (rows.order) {
                                    return rows.order.formattedCreateDate;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'remark', title: '备注', width: 220, formatter: function (value, rows, index) {
                                if (rows.order) {
                                    return rows.order.remark;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'sgdmc', title: '施工队名称', width: 120, formatter: function (value, rows, index) {
                                if (rows.sgdxx) {
                                    return rows.sgdxx.sgdmc;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'ckxq', title: '操作', width: 120, formatter: function (value, rows, index) {
                                return '<a href="javascript:orderManage.showDetail(' + rows.order.orderId + ');">查看详情</a>';
                            }
                        }
                    ]]
            });
        },
        addModifyOrder: function (isAdd) {
            var orderId = '';
            if (!isAdd) {
                var row = $('#datagrid').datagrid("getSelected");
                if (!row) {
                    Message.alert("请选择一条数据进行修改。");
                    return;
                }
                orderId = row.order.orderId;
            }
            $('#orderManageDialog').dialog({
                title: '创建订单',
                width: 800,
                height: 400,
                closed: true,
                cache: false,
                href: 'div/baseManage/addModifyOrder.do?id=' + orderId,
                modal: true
            });
            $('#orderManageDialog').dialog('open');
        },
        searchOrder: function (searchKey) {
            $('#datagrid').datagrid('load', {
                searchKey: searchKey
            });
        },
        submitForm: function () {
            submitForm('#orderManageForm', function () {
                $('#orderManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');
            });
        },
        addFile: function () {
            var fileDiv = '<div>'
                    + '<input type="file" name="uploadFile"/>'
                    + '<a  onclick="orderManage.deleteFile(this);" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:\'icon-add\'">删除文件</a>'
                    + '</div>';
            $("#fileDiv").append(fileDiv);
        },
        deleteFile: function (thisLink, attachmentId, fileName, sgdId, orderName, orderId) {
            Message.confirm("确认要删除这个文件吗？文件删除会立即生效。", function (y) {
                if (!y) {
                    return;
                }
                if (attachmentId) {
                    $.post('data/baseManage/deleteFile.do', {attachmentId: attachmentId, fileName: fileName, sgdId: sgdId, orderName: orderName, orderId: orderId});
                }
                $(thisLink).parent().remove();
            });
        },
        clearForm: function () {
            clearForm('#orderManageForm');
        },
        showDetail: function (orderId, basePath) {
            window.open("div/baseManage/orderDetail.do?orderId=" + orderId, "_blank", "height=768, width=1024, toolbar= no, menubar=no, scrollbars=no, resizable=no, location=no, status=no,top=100,left=300");
        }
    };
}();
$(function () {
    orderManage.init();
});