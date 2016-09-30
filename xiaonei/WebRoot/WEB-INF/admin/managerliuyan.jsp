<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>精品课堂管理后台</title>

<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
  </head>
  
  <body>
  <jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="bigright">
<div style="margin-left:50px;margin-top:50px;float:left;">
<table class="gridtable">
  <c:forEach items="${list}" var="Comments">
  <tr><td>${Comments.student.className}&nbsp;${Comments.student.studentName}:</td><td>${Comments.comments}</td>
  <td>${Comments.commentsTime}</td></tr>
  <c:choose>
  <c:when test="${Comments.replyornot==0}">
  <tr><td><a href="${pageContext.request.contextPath }/test/liuyan_goreply.action?Commentsid=${Comments.id}">回复:</a></td>
  </c:when>
  <c:otherwise>
  <tr><td >已回复</td>
  <c:forEach items="${Comments.commentsreplies}" var="commentsreply" begin="0" end="0">
  <td>${commentsreply.reply}</td><td >${commentsreply.replyTime}</td></tr>
  </c:forEach>
  </c:otherwise>
  </c:choose>
  </c:forEach>
</table>
  
      <div class="pagin">
        <ul class="paginList">
        <li class="paginItem"><a href="${pageContext.request.contextPath }/test/liuyan_gomanagerliuyan.action?pageNow=1" style="font-weight:normal;display:inline-block;">首页</a></li>
       <c:forEach var="i" begin="1" end="${pageCount}">
          <li class="paginItem"><a href="${pageContext.request.contextPath }/test/liuyan_gomanagerliuyan.action?pageNow=${i}">${i}</a></li>
            </c:forEach>
        <li class="paginItem"><a href="${pageContext.request.contextPath }/test/liuyan_gomanagerliuyan.action?pageNow=${pageCount}" style="font-weight:normal;display:inline-block;">尾页</a></li>
        </ul>
    </div>
  </div>
  </div>
  </body>
</html>
