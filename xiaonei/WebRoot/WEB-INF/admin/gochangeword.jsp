<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="robots" content="noindex, nofollow" />
		<link href="../sample.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="../fckeditor.gif"
				type="image/x-icon" />
		<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = editorInstance.Description;
			}
			</script>
		
		<script type="text/javascript"> 

      window.onbeforeunload = function(){
      return "必您确定要退出页面吗？";

       } 
</script>
			
	</head>
	<body>
	<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
	<div class="bigright">
		<form action="${pageContext.request.contextPath}/test/content_changeword?wordid=${word.id}" method="post" target="_blank"  role="form">
			<FCK:editor instanceName="fckword"  value="${word.wordcontent}" height="540" width="1038">
			</FCK:editor>
			<input type="submit"  class="btn" value="确定修改"/><br><font size="14" color="red">${message}</font>
		</form>
		</div>
	</body>
</html>