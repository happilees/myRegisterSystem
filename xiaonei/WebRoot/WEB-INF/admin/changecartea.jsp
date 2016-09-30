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


<link href="${pageContext.request.contextPath}/css/content.css" rel="stylesheet" type="text/css"/>

  <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"/>
  
   <script type="text/javascript"> 

      window.onbeforeunload = function(){
      return "必您确定要退出页面吗？";

       } 
</script>
  </head>
  
  <body>
  <jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="bigright">
  <form action="${pageContext.request.contextPath}/test/special_alreadychanged.action?newsTypeid=${carousel.newstype.id}&newsid=${carousel.id}" enctype="multipart/form-data" method="post" >
  <div class="contentleft"><textarea class="textareatt" name="intro">${carousel.intro}</textarea></div>
  <div class="contentright"><img src="${pageContext.request.contextPath}/images/${carousel.pictureurl}"/>
  <br><input type="file" name="image"/></div>
  <div class="contentbottom"><input type="submit" class="btn"  value="修改"/></div>
  </form>
  </div>
  </body>
</html>
