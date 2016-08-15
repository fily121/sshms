var userGrid;

var user_addDialog=null;

$(document).ready(function(){
	
 var toolbar;
	 
     toolbar=[{
		    text:'增加',
			iconCls: 'icon-add',
			handler: function(){
			   
				f_addUser();
			}
			
		},'-',{
			text:'修改',
			iconCls: 'icon-edit',
			handler: function(){
												
				f_modUser();   
				
			}
		}		
		,'-',{
			text:'删除',
			iconCls: 'icon-remove',
			handler: function(){
			    
			    f_del('userGrid','user/deleteUser.action','userId');
			}
		
		}];
	
     userGrid=$('#userGrid').datagrid({    
	    url:'user/ajaxListUser.action', 
	    striped:true,//斑马线
	    toolbar: toolbar,
	    sortName:'',
	    sortOrder:'',
	    pagination:true,
	    pageList:[10,20,30,40,50],
	    idField:'',
	    columns:[[    
	        {fineld:'',checkbox:true},
	        {field:'userId',title:'id',width:100},  //,hidden:true
	        {field:'userAccount',title:'登录账号',width:150,sortable:'true'},
	        {field:'userName',title:'用户名',width:150,sortable:'true'},
	        {field:'userPassword',hidden:true,title:'密码',width:180,sortable:'true'},
	        {field:'userDesc',title:'角色',width:180,sortable:'true'}
	    ]]
	   
	});

});

function f_addUser(){
		
	user_addDialog=$("<div/>").dialog({
		   title:'用户资料增加',
		   width:320,
		   height:280,
		   href:'user/addUser.jsp',
		   modal: true,
		   buttons:[{
				  text:'保存',
				  iconCls:'icon-save',
				  handler:function(){
					  f_saveUser();
				  }
			  
		  },{
			  text:'放弃',
			  iconCls:'icon-save',
			  handler:function(){
				  user_addDialog.dialog('close');
			  }
			  
		  }],
		  onLoad:function(){
			
			  $('#add_userAccount').focus();
				  		 
		  },
		  onClose:function(){
			  $(this).dialog("destroy");//
		  }
	      
	  });
	
}
	
function  f_user_search(){
	
	//console.info( sy.serializeObject( $("#user_searchForm").form() )  );
		
	$('#userGrid').datagrid('load',
			sy.serializeObject( $("#user_searchForm").form() ) //将searchForm表单内的元素序列为对象传递到后台
	);	
	
}

function f_user_clearSearchForm(){ 
   $('#user_searchForm').form('clear');//清空增加的表单

}

function f_modUser(){

//第一种修改方法，不用给每个input赋值。动态创建dialog，注意关闭时要销毁动态创建的这个dialog内存，否则每创建一个就在内存生成一个	

	/*
	 * 取选中行的值时也可以用getChecked这种，不过这是返回一个数组类型，这种取值语法是如：rows[0]，这取出一行，取列值 ：rows[0].userId
	 * 我个人更喜欢用getSelected，直接返回一个对象，这种取值语法是如：rows，这取出一行，取列值 ：rows.userId
	 */
//var rows = $('#userGrid').datagrid('getChecked');
  
  var row = $('#userGrid').datagrid('getSelected'); 
	
//  console.info(rows);
 if( f_getGridRows(userGrid)){	
  var user_modDialog=$("<div/>").dialog({
	   title:'用户资料修改',
	   width:300,
	   height:200,
	   href:'user/modUser.jsp',
	   modal: true,
	   buttons:[{
			  text:'保存',
			  iconCls:'icon-save',
			  handler:function(){
			      
				  if($('#user_modForm').form('validate')){
					
						$('#user_modForm').form('submit', {   
							url:'user/updateUser.action',
							dataType:'json',
						    success: function(data){ 
						    	//console.info(data);
						    	 data= $.parseJSON(data);
						    	 //data = eval('(' + data + ')');  // change the JSON string to javascript object 
						    	  
						    	//console.info(data);
						        if (data.success){    
						        	showMsg(data.msg); 
						            user_modDialog.dialog('close');
			            
						            //getRowIndex的参数可以是一行，也可以是idField列
						            var index=$('#userGrid').datagrid('getRowIndex',row);
						            
						           //console.info(index);
						           
						            $('#userGrid').datagrid('updateRow',{
						    			index: index,	// 索引从0开始
						    			row: data.obj
						    		});
					           
						        }    
						    }    
						});  

					  }				  
			  }
		  
	  },{
		  text:'放弃',
		  iconCls:'icon-save',
		  handler:function(){
			  user_modDialog.dialog('close');
		  }
		  
	  }],
	  onLoad:function(){
				  
		  $("#user_modForm").form("load",row);  
	  
	 
  
		   $("#mod_seleRole").val(row.userDesc);
	  },
	  onClose:function(){
		  $(this).dialog("destroy");//
	  }
      
  });
 }

 /* 第二种修改方法，这种要给每一个input赋值
  * 
  * var row = $('#userGrid').datagrid('getSelected'); 

  if( f_getGridRows(userGrid)){
  
	   $('#user_addOrModDiv').dialog('open');
	 
	   $('#id').val(row.userId);
	   $('#userAccount').val(row.userAccount);
	   $('#userName').val(row.userName);
	   $('#userPassword').val(row.userPassword);//虽然密码不在这里修改，但也要赋值，因为不能为空，后台sql不更改保存的密码
	   $('#role').val(row.userDesc);	  
	    	  
	   $("#seleRole").val(row.userDesc);

	   $('#userAccount').focus();
  }
       
	if( $('#password_tr').css('visibility')=='visible'){
		 
	    $('#password_tr').css('visibility','hidden');//隐藏密码栏
	    				    			    
	}*/

}

function f_saveUser(){
	
  if($('#user_addForm').form('validate')){
	
	$('#user_addForm').form({    
	   url:'user/saveUser.action',   
	   dataType:'json',	    
	   onSubmit: function(){  
		 return userBeforSubmit();  
	   },
	   success:function(data){    
		  data= $.parseJSON(data);		  
	    	//data=eval("("+data+")");	    
		  //console.info(data);
	    	
		  if(data.err){
	           showAlert(data.err);
	      }else if(data.msg){
	    		showMsg(data.msg);
	    		
	    		//插入成功后从后台返回插入的数据，在grid第一行插入，这样就不用从后台获取一次数据来更新
	    		$('#userGrid').datagrid('insertRow',{
	    			index: 0,	// 索引从0开始
	    			row: data.obj
	    		});

 	    		//$('#userGrid').datagrid('load');    ;//利用空参数查找，刷新grid数据	，不再推荐用这种了，这种要往后台取一次数    
	    		
	    		user_addDialog.dialog('close');//user_addDialog使用了全局变量
	      }
	    	
	    }	   
	});    
	// submit the form    	
			
	$('#user_addForm').submit();  
  }	
}

function userBeforSubmit(){
	
	$('#add_role').val($("#add_seleRole").val());	  
	  
	if($('#add_role').val()==""){
		showAlert("角色不能为空！请选择角色。");
		return false;
	}
		
	return true;
}



