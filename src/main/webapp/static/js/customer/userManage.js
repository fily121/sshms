var userManage = function () {
    return {
        init: function () {
            $('#datagrid').datagrid({
                url: 'data/system/getUserList.do',
                method: 'post',
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
                                    return '<a href="javascript:userManage.viewDetail(\''+rows.user.userId+'\');">'+rows.user.userName+'</a>';
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
            var title = '增加用户';
            if (!isAdd) {
                title = '修改用户';
                var row = $('#datagrid').datagrid("getSelected");
                if (!row) {
                    Message.alert("请选择一条数据进行修改。");
                    return;
                }
                userId = row.user.userId;
            }
            $('#userManageDialog').dialog({
                title: title,
                width: 1000,
                height: 600,
                closed: true,
                cache: false,
                href: 'div/system/addModifyUser.do?userId=' + userId,
                modal: true
            });
            $('#userManageDialog').dialog('open');
        },
        searchUser: function (searchKey) {
            $('#datagrid').datagrid('load', {
                searchKey: searchKey
            });
        },
        deleteUser: function () {
            var row = $('#datagrid').datagrid("getSelected");
            if (!row) {
                Message.alert("请选择一条数据进行删除。");
                return;
            }

            var userId = row.user.userId;
            Message.confirm("确认删除该用户吗？", function (confirmed) {
                if (!confirmed) {
                    return;
                }
                $.post('data/system/deleteUser.do', {userId: userId}, function () {
                    Message.alert("删除成功。");
                })
            });
        },
        importUser: function () {
            $('#importUser').dialog({
                title: '导入用户',
                width: 433,
                height: 321,
                closed: true,
                cache: false,
                modal: true
            });
            $('#importUser').dialog('open');
        },
        submitForm: function () {
            submitForm('#userManageForm', function () {
                $('#userManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');

            });
        },
        submitFileForm: function () {
            $("#importUserForm").form('submit', {
                success: function (data) {
                    if (data) {
                        ustc.slideMsg(data, 50000);
                    }
                }
            });
        },
        clearForm: function () {
            clearForm('#userManageForm');
        },
        viewDetail : function(userId){
             $('#userManageDialog').dialog({
                title: "查看详情",
                width: 1000,
                height: 600,
                closed: true,
                cache: false,
                href: 'div/system/addModifyUser.do?view=true&userId=' + userId,
                modal: true
            });
            $('#userManageDialog').dialog('open');
        }
    };
}();
$(function () {
    userManage.init();
});