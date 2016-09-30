<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'publicfile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="${pageContext.request.contextPath}/css/vediodetail.css" rel="stylesheet" type="text/css">


  </head>
  
  <body>
  <jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
     <div class="vediobig">
     <div class="vediocenter">
<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="490" height="390">

<param name="movie" value="${pageContext.request.contextPath}/uploadvideo/Flvplayer.swf">

<param name="quality" value="high">

<param name="allowFullScreen" value="true" />

<param name="FlashVars" value="vcastr_file=${pageContext.request.contextPath}/uploadvideo/${vedio.news.id}.flv" />

<embed src="${pageContext.request.contextPath}/uploadvideo/Flvplayer.swf" allowFullScreen="true" FlashVars="vcastr_file=${pageContext.request.contextPath}/uploadvideo/${vedio.news.id}.flv" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="490" height="390"></embed>

</object>
</div>
</div>

  </body>
</html>
