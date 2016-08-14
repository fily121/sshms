<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login_1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	 <style>
       body{
		  font-size:12px; 
		   padding:0px;
		   margin:0px;
		 
	   }
   
	   #login_div{
		   
		   margin: auto;
           position: absolute;
           top: 0; left: 0; bottom: 0; right: 0;
		    
		  
		   background-image:url(login_logo.jpg);
		 
		   width:800px;
           height:407px;
	   }
	   
       #login_div form label{
		   font-weight:bold
		   
		}
	
	    #login_div form{
			margin-top:100px;
			margin-left:420px;
		}
		
		#login_div form input{
              
			  margin-top:10px;

		}
		
		#login_div input{
			 width:130px;
		}
		
		#login_div input[type="submit"]{
			 width:50px;
			 margin-left:80px;
		}
		
		
	    
   </style>
   
   <script type="text/javascript">
       function changeValidateImg() {
	      document.getElementById('validateImg').src='/SSHMS/servlet/CheckCode?t='+new Date().getTime();
	  }  
   </script>

  </head>
  
  <body onload="window.document.forms[0].login_username.focus();">
     
      <div id="login_div">
          
         <form id="user_login_loginForm" method="post" action="user/loginUser.action">
          
             <label style="margin-left:50px;font-size:16px;">管理员登录</label><br/>
             <label>账号：</label><input name="userAccount" value="admin"  id="login_username" tabindex="1"/>
             <br />
             <label>密码：</label><input name="userPassword" type="password"  value="admin"  tabindex="2" />
              <br/> 
            	      
       
          <s:if test="#session.showCheckCode==1">
		      
		      <div id="checkCode_div">
			
			   <div>
				<label for="validateCode">验证码:</label>
		   	         
			        <input id="validateCode" name="validateCode" type="text" id="vCode" style="width:118px;" tabindex="3" maxlength="4" />	
			       
			        <span style="margin:20px;">
			            <img id="validateImg" alt="无法显示验证码" src="/SSHMS/servlet/CheckCode" onclick="changeValidateImg();return false;"/>
			           
			            <a href="javascript:void(0);" onclick="changeValidateImg();return false;">换一张</a>
			        </span>
			       
			        <div style="margin-top:5px;margin-left:50px;">
			            <font color="red"> ${sessionScope['SECURITY_LOGIN_EXCEPTION']}</font>		           
			        </div>
			         
		        </div>
	    
		       
		       </div>
		
		 </s:if>
         
             <input type="submit" value="登录" />
         </form>
             
     </div>
   
  </body>
</html>
