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
        <c:forEach items="${list}" var="carousel">
  <tr><td >${carousel.teachername}</td>
  <td><a href="${pageContext.request.contextPath}/test/special_getcarousel.action?newsTypeid=${carousel.newstype.id}&newsid=${carousel.id}&flag=1">删除</a>
  <a href="${pageContext.request.contextPath}/test/special_getcarousel.action?newsTypeid=${carousel.newstype.id}&newsid=${carousel.id}&flag=2">查看详情</a>
  </td></tr>
  </c:forEach>
    
        </tbody>
    </table>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</div>
 
  </body>
</html>
