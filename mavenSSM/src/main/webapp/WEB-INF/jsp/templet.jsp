<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>templet.jsp</title>
    
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
<h1>templet</h1>
    <form>  
         <table>  
            <tr>  
                <td>username</td>  
                <td>  
                    <input type="text" name="userName">  
                </td>  
            </tr>  
            <tr>  
                <td>userphone</td>  
                <td>  
                    <input type="text" name="userPhone">  
                </td>  
            </tr>
            <tr>  
                <td>useremail</td>  
                <td>  
                    <input type="email" name="userEmail">  
                </td>  
            </tr>  
            <tr>  
                <td>password</td>  
                <td>  
                    <input type="password" name="userPwd">  
                </td>  
            </tr>  
                <td> </td>  
                <td>  
                    <input type="button" value="提交" onclick="addUser()">  
                </td>  
            </tr>  
        </table>  
    </form>  
    <script type="text/javascript">  
    //添加用户  
    function addUser() {  
        var form = document.forms[0];  
        form.action = "user/addUserTemplet?flag=add";  
        form.method = "post";  
        form.submit();  
    }  
</script>  
  </body>
</html>
