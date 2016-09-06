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
                        {field: 'orderName', width: 120, title: '订单名称', formatter: function (value, rows, index) {
                                if (rows.order) {
                                    return rows.order.orderName;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'formattedCreateDate', width: 80, title: '创建日期', formatter: function (value, rows, index) {
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
                        }
                    ]]
            });
        },
        addModifyOrder: function (isAdd) {
            var userId = '';
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
            if (!searchKey) {
                $('#datagrid').datagrid('load', {
                    searchKey: searchKey
                });
            }
        },
        submitForm: function () {
            submitForm('#orderManageForm', function () {
                $('#orderManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');
            });
        },
        clearForm: function () {
            clearForm('#orderManageForm');
        }
    };
}();
$(function () {
    orderManage.init();
});