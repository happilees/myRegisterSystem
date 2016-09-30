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
          <c:forEach items="${ziyuans}" var="Ziyuan">
    <tr><td class="homeworkmctd">${Ziyuan.intro}</td>
    <td class="homeworkmctd3"><a   href="${pageContext.request.contextPath}/test/content_goziyuanbar.action?newsTypeid=${Ziyuan.newstype.id}&Ziyuanid=${Ziyuan.id}&flag=2">删除</a></td>
    </tr>
    <form action="${pageContext.request.contextPath}/test/content_goziyuanbar.action?newsTypeid=${Ziyuan.newstype.id}&Ziyuanid=${Ziyuan.id}&flag=3" method="post">
    <tr>
    <td class="homeworkmctd"><input type="text" name="fckword" class="dfinput" value="${Ziyuan.intro}"/><input type="text" class="dfinput" name="ziyuanurl" value="${Ziyuan.ziyuanurl}"/></td>
    <td class="homeworkmctd"><input type="submit" class="btn" value="修改"/></td>
    </tr>
     </form>
  </c:forEach>
  <form action="${pageContext.request.contextPath}/test/content_goziyuanbar.action?newsTypeid=27&flag=4" method="post">
  <tr>
  <td class="homeworkmctd">名称：<input type="text" class="dfinput" name="fckword"/><br>链接：<input type="text"  class="dfinput" name="ziyuanurl" /></td>
  <td class="homeworkmctd"><input type="submit" class="btn" value="添加一个新的链接"/></td>
  </tr>
  </form>
        </tbody>
    </table>


    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</div>
 
 
  
  </body>
</html>
