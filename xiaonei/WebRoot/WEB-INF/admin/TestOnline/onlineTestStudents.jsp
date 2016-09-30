<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2016/1/5
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="text/javascript">
    function deleteAllStudent(){
      if(confirm("确定要删除所有学生及成绩吗?")){
        return true;
      }else{
        return false;
      }
    }
  </script>
</head>
<body>
<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="bigright">
  <form action="${pageContext.request.contextPath}examOnline/deleteStudentOnlineScore_Action" method="post">
    <input type="submit" value="删除所有学生成绩"  class="btn" onclick="return deleteAllStudent()">
  </form>
<c:forEach items="${studentList}" var="students">
  <p><a href="${pageContext.request.contextPath}/examOnline/findOnlineTestFlag_Action?studentId=${students.id}">${students.studentName}</a></p>
</c:forEach>
</div>
</body>
</html>
