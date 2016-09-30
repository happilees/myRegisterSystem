<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  

</head>
<body>
<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="bigright">
<p>学生：${student.studentName}</p>
<p>选择题和判断题总分：${sum}</p>
<h3>选择题</h3>
<c:set var="studentChoice" value="${studentChoice}"></c:set>
<c:set var="count" value="0"></c:set>
<c:forEach items="${choiceList}" var="choices">
  <p>${count+1}.${choices.choiceTitle}</p>
  <p>
    <c:if test="${choices.keyA!=''}">
      A、${choices.keyA}
    </c:if>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <c:if test="${choices.keyB!=''}">
      B、${choices.keyB}
    </c:if>
  </p>

  </p>
  <p><c:if test="${choices.keyC!=''}">
    C、${choices.keyC}
  </c:if>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <c:if test="${choices.keyD!=''}">
      D、${choices.keyD}
    </c:if></p>
  <c:if test="${choices.keyE!=''}">
    <p>E、${choices.keyE}</p>
  </c:if>


  <p>正确答案:${choices.result} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    学生答案:${studentChoice[count]}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    结果:
    <c:choose>
      <c:when test="${choices.result==studentChoice[count]}">
        对
      </c:when>
      <c:when test="${choices.result!=studentChoice[count]}">
        错
      </c:when>
    </c:choose>

  </p>
  <c:set var="count" value="${count+1}"></c:set>
</c:forEach>

<h3>判断题</h3>
<c:set var="studentTorf" value="${studentTorf}"></c:set>
<c:set var="count" value="0"></c:set>
<c:forEach items="${torfList}" var="torfs">
  <p>${count+1}.${torfs.question}</p>
  <p>正确答案:
    <c:choose>
      <c:when test="${torfs.result==1}">
        对
      </c:when>
      <c:when test="${torfs.result==0}">
        错
      </c:when>
    </c:choose>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    学生答案:
    <c:choose>
      <c:when test="${studentTorf[count]==1}">
        对
      </c:when>
      <c:when test="${studentTorf[count]==0}">
        错
      </c:when>
    </c:choose>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  结果:
    <c:choose>
      <c:when test="${studentTorf[count]==torfs.result}">
        对
      </c:when>
      <c:when test="${studentTorf[count]!=torfs.result}">
        错
      </c:when>
    </c:choose>
  </p>
  <c:set var="count" value="${count+1}"></c:set>
</c:forEach>

<h3>填空题</h3>
<c:set var="studentFillBlank" value="${studentFillBlank}"></c:set>
<c:set var="count" value="0"></c:set>
<c:forEach items="${fillBlankList}" var="fillBlanks">
  <p>${count+1}.${fillBlanks.question}</p>
  <p>正确答案:${fillBlanks.answer}
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    学生答案:
    ${studentFillBlank[count]}
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </p>
  <c:set var="count" value="${count+1}"></c:set>
</c:forEach>

<h3>简答题</h3>
<c:set var="studentEssay" value="${studentEssay}"></c:set>
<c:set var="count" value="0"></c:set>
<c:forEach items="${essayList}" var="essays">
  <p>${count+1}.${essays.question}</p>
  <p>正确答案:${essays.answer}</p>

    <p>学生答案:
      ${studentEssay[count]}

  </p>
  <c:set var="count" value="${count+1}"></c:set>
</c:forEach>

</div>
</body>
</html>
