<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style>
   
  #user_addForm input,select{
     width:130px;
  }
   
  #user_addForm{
      margin:15px 0px 0px 10px;
  }  
  

</style>



 <form id="user_addForm" method="post">
 
  <input type="hidden" name="userId" id="id"/>
  <input type="hidden" name="userDesc" id="add_role"/>
 
  <table >
     <tr>
        <th> 账号：</th>
        <td>  <input id="add_userAccount" name="userAccount" class="easyui-validatebox textbox" data-options="required:true" type="text" /> </td>
       
     </tr>  
        
     <tr>
        <th> 角色：</th>
        <td> 
           <select id="add_seleRole" class="easyui-validatebox textbox" data-options="required:true">
                <option value="0"></option>
                <option value="营业员">营业员</option>
                <option value="系统管理员">系统管理员</option>
           </select> 
        </td>
     </tr>
     
        <tr>
        <th> 用户名：</th>
        <td>  <input id="userName" name="userName" class="easyui-validatebox textbox" data-options="required:true" type="text" /> </td>
       
     </tr>
     
    <tbody id="password_tr">
     <tr>   
        <th> 密码：</th>
        <td>  
           <input id="userPassword"  name="userPassword" class="easyui-validatebox textbox" data-options="required:true" type="password" /> 
        </td>     
     </tr>
    </tbody>
                                  
   </table>
   
  </form>
 


