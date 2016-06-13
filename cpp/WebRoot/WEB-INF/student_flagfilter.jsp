<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
   <title>C++ 后台管理</title>
   <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
   <script src="${pageContext.request.contextPath }/js/jquery-2.2.0.min.js"></script> 
   <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="panel panel-default">
<div class="panel-heading">
      <h1 class="panel-title">
        学生基本信息
      </h1>
   </div>
   <div class="panel-body">
      ${student.classname }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${student.username }
   </div>
   <div class="panel-heading">
      <h3 class="panel-title">
        性别
      </h3>
   </div>
   <div class="panel-body">
    ${student.sex } 
   </div>
   <div class="panel-heading">
      <h3 class="panel-title">
        联系方式
      </h3>
   </div>
   <div class="panel-body">
    长号：${student.tel } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;QQ:${student.qq }
   </div>
    <div class="panel-heading">
      <h3 class="panel-title">
        选择方向
      </h3>
   </div>
   <div class="panel-body">
      ${student.myflags }
   </div>
   <div class="panel-heading">
      <h3 class="panel-title">
        个人简介
      </h3>
   </div>
   <div class="panel-body">
      ${student.introduce }
   </div>
   <div class="panel-heading">
      <h3 class="panel-title">
       技术能力
      </h3>
   </div>
   <div class="panel-body">
      ${student.power}
   </div>
    <div class="panel-heading">
      <h3 class="panel-title">
       有无作品
      </h3>
   </div>
   <div class="panel-body">
      ${student.isfile}
   </div>
    <div class="panel-heading">
      <h3 class="panel-title">
       作品名称
      </h3>
   </div>
   <div class="panel-body">
      ${student.filename}
   </div>
</div>
<div class="col-md-6 col-md-offset-6">
<a style="color:#FFF;text-decoration:none;" href="${pageContext.request.contextPath }/admin_flagFilter.action?flagid=${flag.id}">
  <button type="button" class="btn btn-primary btn-lg">
       返回上一级
   </button>
   </a>
</div>
</body>
</html>