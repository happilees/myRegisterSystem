<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>水产学院精品课程</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <style>
body{TEXT-ALIGN: center;}
#center{ MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;
height:200px;
background:#Fff;
width:800px;
vertical-align:middle;
line-height:200px;
}
</style>

  </head>
<body >
<div id="center"><h1>${message }<br>
<a href="${pageContext.request.contextPath }/test/word_gohomework.action?pageNow=1">返回作业界面</a>
</h1></div>
</body>
</html>
