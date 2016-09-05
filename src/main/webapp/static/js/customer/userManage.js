var userManage = function () {
    return {
        init: function () {
            $('#datagrid').datagrid({
                url: 'data/system/getUserList.do',
                method: 'get',
                toolbar: '#tb',
                singleSelect: true,
                pagination: true,
                title: '人员列表',
                columns: [[
                        {field: 'userId', width: 80, hidden: true, formatter: function (value, rows, index) {
                                if (rows.user) {
                                    return rows.user.userId;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'orgId', width: 80, hidden: true, formatter: function (value, rows, index) {
                                if (rows.user) {
                                    return rows.user.orgId;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'roleId', width: 80, hidden: true, formatter: function (value, rows, index) {
                                if (rows.user) {
                                    return rows.user.roleId;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'userName', title: '用户名', width: 120, formatter: function (value, rows, index) {
                                if (rows.user) {
                                    return rows.user.userName;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'roleName', title: '角色名', width: 120},
                        {field: 'name', title: '姓名', width: 120, formatter: function (value, rows, index) {
                                if (rows.user) {
                                    return rows.user.name;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'sgdmc', title: '所属施工队', width: 240, align: 'left'}
                    ]]
            });
        },
        addModifyUser: function (isAdd) {
            var userId = '';
            if (!isAdd) {
                var row = $('#datagrid').datagrid("getSelected");
                if (!row) {
                    Message.alert("请选择一条数据进行修改。");
                    return;
                }
                userId = row.user.userId;
            }
            $('#userManageDialog').dialog({
                title: '增加用户',
                width: 800,
                height: 400,
                closed: true,
                cache: false,
                href: 'div/system/addModifyUser.do?userId=' + userId,
                modal: true
            });
            $('#userManageDialog').dialog('open');
        },
        searchUser: function (searchKey) {
            if (!searchKey) {
                $('#datagrid').datagrid('load', {
                    searchKey: searchKey
                });
            }
        },
        deleteUser: function () {
            var row = $('#datagrid').datagrid("getSelected");
            if (!row) {
                Message.alert("请选择一条数据进行删除。");
                return;
            }

            var userId = row.user.userId;
            Message.confirm("确认删除该用户吗？", function () {
                $.post('data/system/deleteUser.do', {userId: userId}, function () {
                    Message.alert("删除成功。");
                })
            });
        },
        importUser: function () {
            
        },
        submitForm: function () {
            submitForm('#userManageForm', function () {
                $('#userManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');

            });
        },
        clearForm: function () {
            clearForm('#userManageForm');
        }
    };
}();
$(function () {
    userManage.init();
});