<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2015/12/30
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    
</head>
<body>
<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-9" style="margin-top:50px;">
<c:forEach items="${exams}" var="examList">
  <p><a href="${pageContext.request.contextPath}/examOnline/studentsScore_Action?examId=${examList.id}">${examList.examName}</a> </p>
</c:forEach>
</div>
</div>

</body>
</html>
