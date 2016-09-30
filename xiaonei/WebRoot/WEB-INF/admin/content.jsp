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
<link href="${pageContext.request.contextPath}/css/adminstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>

<div class="bigright">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">内容管理</a></li>
    <li><a href="#">内容列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        
        <th>标题</th>
        <th>查看</th>

        </tr>
        </thead>
        <tbody>
        
        
        <tr>
        <c:forEach items="${list}" var="Newstype">
  <tr><td class="contenttd">${Newstype.newsTypeName}</td><td class="contenttd">
    <c:choose>
    <c:when test="${Newstype.templet=='1'}">
  <a href="${pageContext.request.contextPath}/test/content_gochangeword.action?newsTypeid=${Newstype.id}">查看详情</a>
  </c:when>
   <c:when test="${Newstype.templet=='3'}">
  <a href="${pageContext.request.contextPath}/test/content_godeleteworddoc.action?newsTypeid=${Newstype.id}&flag=1">查看详情</a>
  </c:when>
   <c:when test="${Newstype.templet=='6'}">
  <a href="${pageContext.request.contextPath}/test/content_goziyuanbar.action?newsTypeid=${Newstype.id}&flag=1">查看详情</a>
  </c:when>
  <c:otherwise>
   <a href="${pageContext.request.contextPath}/test/content_godeletethirdbar.action?newsTypeid=${Newstype.id}">查看详情</a>
  </c:otherwise>
    </c:choose>
  </td></tr>
  </c:forEach>
        </tr>
        
        
        
        
        </tbody>
    </table>
    
   
    <div class="pagin">
        <ul class="paginList">
        <li class="paginItem"><a href="${pageContext.request.contextPath}/test/content_gocontent.action?pageNow=1" style="font-weight:normal;display:inline-block;">首页</a></li>
         <c:forEach var="i" begin="1" end="${pageCount}">
          <li class="paginItem"> <a href="${pageContext.request.contextPath}/test/content_gocontent.action?pageNow=${i}">${i}</a></li>
            </c:forEach>
        <li class="paginItem"><a href="${pageContext.request.contextPath}/test/content_gocontent.action?pageNow=${pageCount}" style="font-weight:normal;display:inline-block;">尾页</a></li>
        </ul>
    </div>
    

    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</div>

</body>

</html>