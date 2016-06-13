<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   <script>
   jQuery.fn.limit=function(){  
    var self = $("[limit]");  
    self.each(function(){  
        var objString = $(this).text();  
        var objLength = $(this).text().length;  
        var num = $(this).attr("limit");  
        if(objLength > num){  
            $(this).attr("title",objString);  
            objString = $(this).text(objString.substring(0,num) + "...");  
        }  
    })  
}  
$(function(){  
    $("[limit]").limit();  
})  
$('table').tooltip();  
   </script>
</head>
<body>
<div class="table-responsive">
<table class="table">
<c:choose>
<c:when test="${flag.id==1}">
<h1>方向:Android</h1>
</c:when>
<c:when test="${flag.id==2}">
<h1>方向:IOS</h1>
</c:when>
<c:when test="${flag.id==3}">
<h1>方向:UI</h1>
</c:when>
<c:when test="${flag.id==4}">
<h1>方向:前端</h1>
</c:when>
<c:when test="${flag.id==5}">
<h1>方向:后台</h1>
</c:when>
<c:when test="${flag.id==6}">
<h1>方向:C++</h1>
</c:when>
<c:when test="${flag.id==7}">
<h1>方向:产品</h1>
</c:when>
<c:otherwise>
<h1>方向:运营</h1>
</c:otherwise>
</c:choose>
<div class="col-md-12" style="text-align:right;margin-top:2%;">
<div class="col-md-4 col-md-offset-8">
   <form role="form" action="${pageContext.request.contextPath }/admin_flagFilter.action">
   <div class="form-group col-md-6">
      <select name="flagid" class="form-control">
         <option value="1">Android</option>
         <option value="2">IOS</option>
         <option value="3">UI</option>
         <option value="4">前端</option>
         <option value="5">后台</option>
         <option value="6">C++</option>
         <option value="7">产品</option>
         <option value="8">运营</option>
      </select>
      </div>
      <div class="col-md-6">
   <button type="submit" class="btn btn-primary form-control">过滤</button>
   </div>
      </form>
      </div>
</div>
   <thead>
      <tr>
         <th>学生id</th>
         <th>班级</th>
         <th>姓名</th>
         <th>性别</th>
         <th>联系方式</th>
         <th>技术能力</th>
         <th>个人简介</th>
         <th>作品</th>
         <th>查看详情</th>
      </tr>
   </thead>
   <tbody>
    <c:forEach items="${studentlist}" var="student">
      <tr>
         <td>${student.id}</td>
         <td>${student.classname}</td>
         <td>${student.username}</td>
         <td>${student.sex}</td>
         <td>${student.tel}</td>
         <td limit="20">${student.power}</td>
         <td limit="20">${student.introduce}</td>
         <td>${student.isfile}</td>
         <td><a href="${pageContext.request.contextPath }/admin_studentFlagfilter.action?studentid=${student.id}&flagid=${flag.id}">查看详情</a></td>
      </tr>
      </c:forEach>
   </tbody>
</table>
</div>
<div class="col-md-2 col-md-offset-10">
<a style="color:#FFF;text-decoration:none;" href="${pageContext.request.contextPath }/admin_otherStudent.action?pageNow=1">
  <button type="button" class="btn btn-primary btn-lg">
       返回学生信息页
   </button>
   </a>
</div>
</body>
</html>