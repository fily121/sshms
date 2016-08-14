<%@ page language="java" pageEncoding="UTF-8"%>

<!--prefix="c"是一个标签符，作用：使用 项目路径时 ${pageContext.request.contextPath}在jsp中使用不报错 -->

<script type="text/javascript">
	$(function() {
		$('#changePassWordDialog').dialog('close');//隐藏登录div		
		
		$('#changePassWordForm').form({
			url : '${pageContext.request.contextPath}/user/changePasswordUser.action',
			success : function(r) {
				console.info(r);
				
				var obj = jQuery.parseJSON(r);
				if (obj.msg) {
					$('#changePassWordDialog').dialog('close');
					
					$.messager.show({
						title : '提示',
						msg : obj.msg
					});
				}else{
				  $.messager.show({
					title : '警告',
					msg : obj.err
				  });
			    }
			}
		});
		$('#changePassWordForm input').bind('keyup', function(event) {/* 增加回车提交功能 */
			if (event.keyCode == '13') {
				$('#changePassWordForm').submit();
			}
		});

		window.setTimeout(function() {
			$('#changePassWordForm input[name="param.oldPassword"]').focus();
		}, 0);
	});
</script>

<div id="changePassWordDialog" class="easyui-dialog" data-options="title:'修改密码',modal:true,closable:true,buttons:[{
				text:'保存',
				iconCls:'icon-help',
				handler:function(){
					$('#changePassWordForm').submit();
				}
			}]">
	<form id="changePassWordForm" method="post" >
		<table>
			<tr>
				<th>原密码:</th>
				<td><input type="password" id="oldPassword"  name="param.oldPassword" class="easyui-validatebox" data-options="required:true,missingMessage:'原密码必填'" />
				</td>
			</tr>
			
			<tr>
				<th>新密码:</th>
				<td><input type="password" id="newPassword" name="param.newPassword"  class="easyui-validatebox" data-options="required:true,missingMessage:'新密码必填'" />
				</td>
			</tr>
			
			<tr>
				<th>确认新密码:</th>
				<td><input type="password" name="param.surePassword" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#changePassWordForm input[id=newPassword]\']'" />
				</td>
			</tr>			
		</table>
	</form>
</div>