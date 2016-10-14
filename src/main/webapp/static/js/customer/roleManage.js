var roleManage = function () {
    return {
        init: function () {
            $('#datagrid').datagrid({
                url: 'data/system/getRoleList.do',
                method: 'post',
                toolbar: '#tb',
                singleSelect: true,
                pagination: true,
                columns: [[
                        {field: 'roleId', width: 80, hidden: true, formatter: function (value, rows, index) {
                                if (rows.role) {
                                    return rows.role.roleId;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'roleName', title: '角色名', width: 120, formatter: function (value, rows, index) {
                                if (rows.role) {
                                    return rows.role.roleName;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'sgdmc', title: '拥有权限', width: 600, formatter: function (value, rows, index) {
                                if (rows.permissions) {
                                    var permissions = rows.permissions;
                                    var perName = [];
                                    permissions.forEach(function (e) {
                                        perName.push(e.perName)
                                    });
                                    return perName.join();
                                } else {
                                    return '';
                                }
                            }}
                    ]]
            });
        },
        addModifyRole: function (isAdd) {
            var roleId = '';
            var roleName = '';
            var perIds = [];
            var title = '增加权限';
            if (!isAdd) {
                title = '修改权限';
                var row = $('#datagrid').datagrid("getSelected");
                if (!row) {
                    Message.alert("请选择一条数据进行修改。");
                    return;
                }
                roleId = row.role.roleId;
                roleName = row.role.roleName;
                var permissions = row.permissions;
                permissions.forEach(function (e) {
                    perIds.push(e.perId);
                });
            }
            $('#roleManageDialog').dialog({
                title: title,
                width: 600,
                height: 300,
                closed: true,
                cache: false,
                href: 'div/system/addModifyRole.do?perIds=' + perIds.join() + '&roleName=' + roleName + '&roleId=' + roleId,
                modal: true
            });
            $('#roleManageDialog').dialog('open');
        },
        searchRole: function (searchKey) {
            $('#datagrid').datagrid('load', {
                searchKey: searchKey
            });
        },
        deleteRole: function () {
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
                $.post('data/system/deleteRole.do', {userId: userId}, function () {
                    Message.alert("删除成功。");
                })
            });
        },
        submitForm: function () {
            submitForm('#roleManageForm', function () {
                $('#roleManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');

            });
        },
        submitFileForm: function () {
            $("#importRoleForm").form('submit', {
                success: function (data) {
                    if (data) {
                        ustc.slideMsg(data, 50000);
                    }
                }
            });
        },
        clearForm: function () {
            clearForm('#roleManageForm');
        },
        viewDetail: function (userId) {
            $('#roleManageDialog').dialog({
                title: "查看详情",
                width: 1000,
                height: 600,
                closed: true,
                cache: false,
                href: 'div/system/addModifyRole.do?view=true&userId=' + userId,
                modal: true
            });
            $('#roleManageDialog').dialog('open');
        }
    };
}();
$(function () {
    roleManage.init();
});