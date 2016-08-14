<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <body>
   
  <form id="user_modForm" method="post">
 
  <input type="hidden" name="userId" id="id"/>
  <input type="hidden" name="userDesc" id="mod_Role"/>
 
  <table style="margin:15px 0px 0px 10px;">
     <tr>
        <th> 账号：</th>
        <td>  <input id="userAccount" name="userAccount" class="easyui-validatebox textbox" data-options="required:true" type="text" /> </td>
       
     </tr>  
        
     <tr>
        <th> 角色：</th>
        <td> 
           <select id="mod_seleRole" class="easyui-validatebox textbox" data-options="required:true">
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
                              
   </table>
   
  </form>
  
  
  
 </body>

