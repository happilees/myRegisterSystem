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
  <script type="text/javascript">
  function check(form)
  {
  if((form.liuyan.value=='')||(form.liuyan.value=='回复...'))
  {
  alert("请输入留言！");
  return false;
  }
  return true;
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
  <div class="row">
    <div class="col-md-2"></div>
  <div class="col-md-10" style="margin-top:50px;">
  <div class="col-md-12" style="font-size:30px;">${comments.student.className}&nbsp;${comments.student.studentName}:${comments.comments}</div>
  <form action="${pageContext.request.contextPath }/test/comreply_liuyanreply.action?Commentsid=${comments.id}" method="post" role="form" class="form-horizontal">
     <div class="form-group">
    <textarea class="form-control" rows="10" cols="50"  name="liuyanreply"></textarea>
  </div>
    <input type="submit" value="回复"  class="form-control"  name="submit1" onclick="return check(this.form)"/>
    </form>
  </div>
  </div>
  
  </body>
</html>
