<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>精品课堂管理后台</title>

			
	</head>
	<body>
	<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
	<div class="bigright">
	<div style="margin-left:50px;float:left;">
	<div style="margin-top:50px;">
	<form action="${pageContext.request.contextPath}/test/seehomework_publishhw.action?flag=1" method="post">
	<table>
	<tr><td>作业题目</td></tr>
	<tr><td><input type="text"   class="dfinput" name="hwname"/></td></tr>
	<tr><td>作业要求</td></tr>
	<tr><td>
    <textarea class="form-control"  name="require" rows="10" cols="50"></textarea>
    </td></tr>
	<tr><td><input type="submit" class="btn" value="布置">${message}</td></tr>
	</table>
	</form>
	</div>
	<div  style="margin-top:30px;">
	<table>
	<tr><td><h3>示例</h3></td></tr>
	<tr><td>作业题目</td></tr>
	<tr><td><input type="text" name="hwname" value="细胞的基本生理功能有哪些"/></td></tr>
	<tr><td>作业要求</td></tr>
	<tr><td>
    <textarea class="hwtextarea"  rows="10" cols="50"> 
	1.分点概述
	2.在下周星期一前交
	3.不少于2000字
	</textarea>
 </td></tr>
	</table>
	</div>
</div>
</div>
  </body>
</html>
