<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2016/1/5
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>

<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="bigright">
<p>学生：${student.studentName}</p>
<c:forEach items="${flagList}" var="flags">
  <p><a href="${pageContext.request.contextPath}/examOnline/findOnlineTest_Action?studentId=${student.id}&flag=${flags}">第${flags}次考试</a></p>
</c:forEach>
</div>
</body>
</html>
