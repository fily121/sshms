<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  
    <jsp:include page="/baseJsCss.jsp"></jsp:include>  
    
   
    <script type="text/javascript" src="user/js/list.js"></script></head>
 
   <style>  
 
     #user_searchForm{
          margin:10px;
          font-size:12px;
     }
     
     #user_searchForm input[type="text"]{
          width:120px;
     }
     #user_searchForm label{
          
          font-weight:bold;
      
     }
     
      #user_searchForm span{
          margin:12px;
      }
      
   </style>
  
  <body>
  

    <div class="easyui-layout" id="iid" fit="true">

        <div data-options="region:'north',title:'查询条件'" style="height:80px">
           <form id="user_searchForm" method="post">
             
             <span>
              <label>账号:</label> <input id="userAccount" name="param.userAccount" type="text" /> 
             </span>
             
             <span>  
              <label>用户名:</label><input id="userName" name="param.userName" type="text" /> 
             </span>
             
             <span>
              <label>角色:</label>  <input type="text" name="param.userDesc" id="role"/>
              </span>
              <input type="button" value="搜索" onclick="f_user_search()"/>
              <input type="button" value="清空" onclick="f_user_clearSearchForm()"/>
           </form>
               
        </div>

    <div id="bbb" data-options="region:'center',title:'',iconCls:'icon-ok'" > 
      <table id="userGrid" fit="true"></table>
    </div>

    </div>
     
    
  </body>
</html>
