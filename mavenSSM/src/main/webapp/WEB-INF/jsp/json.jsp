<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>json.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<h1>json</h1>
<form id="myform">  
        <table>  
            <tr>  
                <td>username</td>  
                <td>  
                    <input type="text" name="userName" id="userName">  
                </td>  
            </tr>  
            <tr>  
                <td>userphone</td>  
                <td>  
                    <input type="text" name="userPhone" id="userPhone">  
                </td>  
            </tr>
            <tr>  
                <td>useremail</td>  
                <td>  
                    <input type="email" name="userEmail" id="userEmail">  
                </td>  
            </tr>  
            <tr>  
                <td>password</td>  
                <td>  
                    <input type="password" name="userPwd" id="userPwd">  
                </td>  
            </tr>  
            <tr>  
                <td> </td>  
                <td>  
                    <input type="button" value="提交" id="submit" />
                </td>  
            </tr>  
        </table>  
    </form>  
    <script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/jquery-1.9.1.min.js"></script>  
    <script type="text/javascript"> 
    $(function(){
	$('#submit').click(function(){
		//选取表单
		var form = $('#myform');
		//获取表单数据
		var name = $("#userName").val();  
         var phone = $("#userPhone").val();  
         var email = $("#userEmail").val();  
         var pwd = $("#userPwd").val();
         var user = {userName:name,userPhone:phone,userEmail:email,userPwd:pwd};//拼装成json格式  
		//发送AJAX请求
		$.post('user/addUserJson',user,function(user){
			alert(user);
		});
	
	});
	
});
</script>  
  </body>
</html>
