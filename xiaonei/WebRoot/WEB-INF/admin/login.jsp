<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>精品课程后台</title>
<link href="${pageContext.request.contextPath}/css/adminstyle.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  



    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       <form action="${pageContext.request.contextPath }/test/login_checkuserlogin.action" method="post">
    <div class="loginbox">
    
    <ul>
    
    <li><input name="username" type="text" class="loginuser" value="qiu" onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
    <li><input name="" type="submit" class="loginbtn" value="登录"   /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    <li><font color="red">&nbsp;&nbsp;&nbsp;${message}</font></li>

    </ul>
    

    </div>
           </form> 
    
    </div>
    
    
    
  
	
    
</body>

</html>