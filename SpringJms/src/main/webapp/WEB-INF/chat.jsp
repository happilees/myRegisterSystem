<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>chat</title>

    </head>

    <body>
       
         
      <div>
      
         
         <div>
            <form action="/SpringJms/publish" method="post">
                <input type="text" name="said"/>
                <input type='submit' value='publish'/>     
            </form>
         </div>
    </body>

</html>

