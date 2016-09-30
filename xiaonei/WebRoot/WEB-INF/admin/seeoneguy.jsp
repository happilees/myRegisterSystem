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
  <div class="row">
    <div class="col-md-3"></div>
  <div class="col-md-9">
  <div class="col-md-12">
  <h1> ${homework.student.className}  ${homework.student.studentName}
       ${homework.student.studentNo}</h1>
  </div>
  <iframe src="${pageContext.request.contextPath}/uploadstuword/${homework.fileUrl}"  width="904" height="600">
  </iframe>
  </div>
  </div>

  </body>
</html>
