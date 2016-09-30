<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>精品课堂管理后台</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
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
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    <div class="formbody">
    <form action="${pageContext.request.contextPath}/test/fckupload_execute.action" method="post">
    <ul class="forminfo">
    <li><label>目录</label>
    <select name="newsTypeid">
	<c:forEach items="${ntlist}" var="Newstype">
	<option value="${Newstype.id}">${Newstype.newsTypeName}</option>
	</c:forEach>
	</select>
   </li>
    <li><label>文章标题</label><input type="text" name="nwesTitle"  class="dfinput" /></li>
    <li><label>文章内容</label>
			<FCK:editor instanceName="fckword" height="540">
			</FCK:editor>
			</li>
    <li><label>&nbsp;</label><input type="submit"  class="btn" value="发表"/><font size="20" color="red">${message}</font></li>
    </ul>
    		</form>
    </div>
</div>
</body>
</html>