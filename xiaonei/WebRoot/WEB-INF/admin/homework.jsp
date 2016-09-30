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
    
    <div class="rightinfo">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>已布置的作业</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <c:forEach items="${list}" var="teacherphw">
    <tr><td class="homeworkmctd"><font class="font25">${teacherphw.hwname}</font></td>
    </tr>
  </c:forEach>
 
        </tr>
        </tbody>
    </table>
    <div class="pagin">
        <ul class="paginList">
        <li class="paginItem"><a href="${pageContext.request.contextPath }/test/seehomework_gohomework.action?pageNow=1" style="font-weight:normal;display:inline-block;">首页</a></li>
       <c:forEach var="i" begin="1" end="${pageCount}">
          <li class="paginItem"><a href="${pageContext.request.contextPath }/test/seehomework_gohomework.action?pageNow=${i}">${i}</a></li>
            </c:forEach>
        <li class="paginItem"><a href="${pageContext.request.contextPath }/test/seehomework_gohomework.action?pageNow=${pageCount}" style="font-weight:normal;display:inline-block;">尾页</a></li>
        </ul>
    </div>

    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</div>
  </body>
</html>
