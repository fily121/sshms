var projectManage = function () {
    return {
        init: function () {
            $('#datagrid').datagrid({
                url: 'data/projectManage/getProjectList.do',
                method: 'get',
                toolbar: '#tb',
                singleSelect: true,
                pagination: true,
                title: '工程列表',
                columns: [[
                        {field: 'projectId', hidden: true},
                        {field: 'projectName', title: '工程名', width: 200},
                        {field: 'formattedCreateDate', title: '创建时间', width: 140},
                        {field: 'projectDetail', title: '详情', width: 400}
                    ]]
            });
        },
        addModifyProject: function (isAdd) {
            var projectId = '';
            if (!isAdd) {
                var row = $('#datagrid').datagrid("getSelected");
                if (!row) {
                    Message.alert("请选择一条数据进行修改。");
                    return;
                }
                projectId = row.projectId;
            }
            $('#projectManageDialog').dialog({
                title: '增加用户',
                width: 800,
                height: 400,
                closed: true,
                cache: false,
                href: 'div/projectManage/addModifyProject.do?id=' + projectId,
                modal: true
            });
            $('#projectManageDialog').dialog('open');
        },
        searchProject: function (searchKey) {
            $('#datagrid').datagrid('load', {
                searchKey: searchKey
            });
        },
        deleteProject: function () {
            var row = $('#datagrid').datagrid("getSelected");
            if (!row) {
                Message.alert("请选择一条数据进行删除。");
                return;
            }

            var userId = row.user.userId;
            Message.confirm("确认删除该工程吗？", function () {
                $.post('data/projectManage/deleteProject.do', {id: userId}, function () {
                    Message.alert("删除成功。");
                })
            });
        },
        addFile: function () {
            var fileDiv = '<div>'
                    + '<input type="file" name="uploadFile"/>'
                    + '<a  onclick="projectManage.deleteFile(this);" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:\'icon-add\'">删除文件</a>'
                    + '</div>';
            $("#fileDiv").append(fileDiv);
        },
        deleteFile: function (thisLink, attachmentId, fileName) {
            Message.confirm("确认要删除这个文件吗？文件删除会立即生效。", function () {
                if (attachmentId) {
                    $.post('data/projectManage/deleteFile.do', {attachmentId: attachmentId, fileName: fileName});
                }
                $(thisLink).parent().remove();
            });
        },
        submitForm: function () {
            submitForm('#projectManageForm', function () {
                $('#projectManageDialog').dialog('close');
                $('#datagrid').datagrid('reload');

            });
        },
        clearForm: function () {
            clearForm('#projectManageForm');
        }
    };
}();
$(function () {
    projectManage.init();
});