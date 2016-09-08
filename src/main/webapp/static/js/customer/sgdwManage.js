var sgdwManage = function () {
    return {
        init: function () {
            $('#datagrid').datagrid({
                url: 'data/baseManage/getSgdList.do',
                method: 'get',
                toolbar: '#tb',
                singleSelect: true,
                pagination: true,
                title: '队伍列表',
                columns: [[
                        {field: 'id', width: 80, hidden: true, formatter: function (value, rows, index) {
                                if (rows.sgdxx) {
                                    return rows.sgdxx.id;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'duizhang', width: 80, hidden: true, formatter: function (value, rows, index) {
                                if (rows.sgdxx) {
                                    return rows.sgdxx.duizhang;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'sgdmc', title: '施工队名', width: 120, formatter: function (value, rows, index) {
                                if (rows.sgdxx) {
                                    return rows.sgdxx.sgdmc;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'detail', title: '施工队详情', width: 120, formatter: function (value, rows, index) {
                                if (rows.sgdxx) {
                                    return rows.sgdxx.detail;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'name', title: '队长名', width: 120, formatter: function (value, rows, index) {
                                if (rows.user) {
                                    return rows.user.name;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'wechatNo', title: '队长微信号', width: 120, formatter: function (value, rows, index) {
                                if (rows.user) {
                                    return rows.user.wechatNo;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'cph', title: '车牌号', width: 80, formatter: function (value, rows, index) {
                                if (rows.sgdxx) {
                                    return rows.sgdxx.cph;
                                } else {
                                    return '';
                                }
                            }
                        }
                    ]]
            });
        },
        addModifySgdw: function (isAdd) {
            var id = '';
            var title = '增加队伍';
            if (!isAdd) {
                var row = $('#datagrid').datagrid("getSelected");
                if (!row) {
                    Message.alert("请选择一条数据进行修改。");
                    return;
                }
                id = row.sgdxx.id;
                title = '修改队伍';
            }
            $('#sgdwManageDialog').dialog({
                title: title,
                width: 800,
                height: 400,
                closed: true,
                cache: false,
                href: 'div/baseManage/addModifySgdxx.do?id=' + id,
                modal: true
            });
            $('#sgdwManageDialog').dialog('open');
        },
        deleteSgdw: function () {
            var row = $('#datagrid').datagrid("getSelected");
            if (!row) {
                Message.alert("请选择一条数据进行删除。");
                return;
            }
            Message.confirm("确认删除该队伍吗？", function (confirmed) {
                if (!confirmed) {
                    return;
                }
                var id = row.sgdxx.id;
                $.get('data/baseManage/deleteSgdw.do?id=' + id, function (data) {
                    if (data) {
                        Message.alert("删除成功。");
                        $('#datagrid').datagrid('reload');
                    } else {
                        Message.alert("删除失败。");
                    }
                });
            });
        },
        submitForm: function () {
            submitForm('#sgdxxManageForm', function () {
                $('#sgdwManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');
            });
        },
        clearForm: function () {
            clearForm('#sgdxxManageForm');
        }
    };
}();
$(function () {
    sgdwManage.init();
});