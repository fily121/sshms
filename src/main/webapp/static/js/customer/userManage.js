var userManage = function () {
    return {
        init: function () {
            $('#datagrid').datagrid({
                url: 'data/system/getUserList.do',
                method: 'get',
                toolbar: '#tb',
                singleSelect: true,
                pagination: true,
                title: '施工队列表',
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
                        {field: 'ext1', title: '姓名', width: 120, formatter: function (value, rows, index) {
                                if (rows.user) {
                                    return rows.user.ext1;
                                } else {
                                    return '';
                                }
                            }
                        },
                        {field: 'sgdmc', title: '所属施工队', width: 240, align: 'left'}
                    ]]
            });
        },
        addUser: function () {
            $('#userManageDialog').dialog({
                title: '增加用户',
                width: 800,
                height: 400,
                closed: true,
                cache: false,
                href: 'div/system/addUser.do',
                modal: true
            });
            $('#userManageDialog').dialog('open');
        },
        modifyUser: function () {},
        deleteUser: function () {},
        importUser: function () {},
        submitForm: function () {},
        clearForm: function () {}
    };
}();
$(function () {
    userManage.init();
});