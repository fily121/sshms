var clManage = function () {
    return {
        init: function () {
            $('#cltb').hide();
            $('#tb').show();
            $('#datagrid').datagrid({
                url: 'data/cllqgl/getClglDetailList.do',
                method: 'post',
                toolbar: '#tb',
                singleSelect: true,
                pagination: true,
                title: '材料领用列表',
                columns: [[
                        {field: 'clId', hidden: true, formatter: function (value, rows, index) {
                                if (rows.clxx) {
                                    return rows.clxx.id;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'lqId', hidden: true, formatter: function (value, rows, index) {
                                if (rows.cllqGl) {
                                    return rows.cllqGl.id;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'sgdId', hidden: true, formatter: function (value, rows, index) {
                                if (rows.sgdxx) {
                                    return rows.sgdxx.id;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'clmc', width: 120, title: '材料名称', formatter: function (value, rows, index) {
                                if (rows.clxx) {
                                    return rows.clxx.clmc;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'detail', width: 220, title: '材料详情', formatter: function (value, rows, index) {
                                if (rows.clxx) {
                                    return rows.clxx.detail;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'lqtime', width: 125, title: '领取日期', formatter: function (value, rows, index) {
                                if (rows.cllqGl) {
                                    return rows.cllqGl.lqtime;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'lqsl', title: '领取数量', width: 80, formatter: function (value, rows, index) {
                                if (rows.cllqGl) {
                                    return rows.cllqGl.lqsl;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'sysl', title: '已使用数量', width: 80, formatter: function (value, rows, index) {
                                if (rows.cllqGl) {
                                    return rows.cllqGl.sysl;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'clshengyu', title: '剩余数量', width: 80, formatter: function (value, rows, index) {
                                if (rows.cllqGl) {
                                    return rows.cllqGl.clshengyu;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'sgdmc', title: '领取队伍名称', width: 120, formatter: function (value, rows, index) {
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
        addModifyCllqgl: function (isAdd) {
            var id = '';
            var title = '增加领取记录';
            if (!isAdd) {
                var row = $('#datagrid').datagrid("getSelected");
                if (!row) {
                    Message.alert("请选择一条数据进行修改。");
                    return;
                }
                id = row.cllqGl.id;
                title = '修改领取记录';
            }
            $('#cllqglManageDialog').dialog({
                title: title,
                width: 800,
                height: 400,
                closed: true,
                cache: false,
                href: 'div/cllqgl/addModifyCllqgl.do?id=' + id,
                modal: true
            });
            $('#cllqglManageDialog').dialog('open');
        },
        deleteCllqgl: function () {
            var row = $('#datagrid').datagrid("getSelected");
            if (!row) {
                Message.alert("请选择一条数据进行删除。");
                return;
            }
            Message.confirm("确认删除该材料领取记录吗？", function (confirmed) {
                if (!confirmed) {
                    return;
                }
                var id = row.cllqGl.id;
                $.get('data/cllqgl/deleteCllqgl.do?id=' + id, function (data) {
                    if (data === 'true') {
                        Message.alert("删除成功。");
                        $('#datagrid').datagrid('reload');
                    } else {
                        Message.alert("删除失败。");
                    }
                });
            });
        },
        doSearch: function (searchKey, name) {
            $('#datagrid').datagrid('load', {
                searchKey: searchKey,
                name: name
            });
        },
        exportCllqgl: function () {
            var value = $('#searchCllqgl').searchbox('getValue');
            var name = $('#searchCllqgl').searchbox('getName');
            $('#searchKey').val(value);
            $('#searchType').val(name);
            submitForm($('#exportCllqgl'));
        },
        submitForm: function () {
            submitForm('#cllqglManageForm', function () {
                $('#cllqglManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');
            });
        },
        clearForm: function () {
            clearForm('#cllqglManageForm');
        }
    };
}();
var clxxManage = function () {
    return {
        init: function () {
            $('#tb').hide();
            $('#cltb').hide();
            $('#datagrid').datagrid({
                url: 'data/baseManage/getAllClxx.do',
                method: 'post',
                toolbar: '#cltb',
                singleSelect: true,
                pagination: true,
                title: '材料列表',
                columns: [[
                        {field: 'clId', hidden: true, formatter: function (value, rows, index) {
                                if (rows) {
                                    return rows.id;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'clmc', width: 120, title: '材料名称', formatter: function (value, rows, index) {
                                if (rows) {
                                    return rows.clmc;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'detail', width: 220, title: '材料详情', formatter: function (value, rows, index) {
                                if (rows) {
                                    return rows.detail;
                                } else {
                                    return '';
                                }
                            }
                        }
                    ]]
            });
        },
        addModifyClxx: function (isAdd) {
            var id = '';
            var title = '增加材料';
            if (!isAdd) {
                var row = $('#datagrid').datagrid("getSelected");
                if (!row) {
                    Message.alert("请选择一条数据进行修改。");
                    return;
                }
                id = row.id;
                title = '修改材料';
            }
            $('#cllqglManageDialog').dialog({
                title: title,
                width: 800,
                height: 400,
                closed: true,
                cache: false,
                href: 'div/cllqgl/addModifyClxx.do?id=' + id,
                modal: true
            });
            $('#cllqglManageDialog').dialog('open');
        },
        deleteClxx: function () {
            var row = $('#datagrid').datagrid("getSelected");
            if (!row) {
                Message.alert("请选择一条数据进行删除。");
                return;
            }
            Message.confirm("确认删除该材料吗？", function (confirmed) {
                if (!confirmed) {
                    return;
                }
                var id = row.id;
                $.get('data/cllqgl/deleteClxx.do?id=' + id, function (data) {
                    if (data === 'true') {
                        Message.alert("删除成功。");
                        $('#datagrid').datagrid('reload');
                    } else {
                        Message.alert("删除失败。");
                    }
                });
            });
        },
        submitForm: function () {
            submitForm('#clxxManageForm', function () {
                $('#cllqglManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');
            });
        },
        clearForm: function () {
            clearForm('#clxxManageForm');
        }
    };
}();
$(function () {
    clManage.init();
});