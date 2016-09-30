<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2016/1/5
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="${pageContext.request.contextPath }/css/contentcomm.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/WEB-INF/public/header.jsp"></jsp:include>
  <div class="big">
    <div class="left">
    <div class="lefttop">
    </div>
    <div class="leftbottom">
    <div class="leftbottom12">
    <table>
  <tr>
           <td class="leftbottomtd1">
                <a href="${pageContext.request.contextPath }/testOnline/showExamList_Action">习题练习</a>
            </td>
        </tr>
         <tr>
           <td class="leftbottomtd1">
                <a href="${pageContext.request.contextPath }/testOnline/showOnlineTestQuestion_Action">在线考试</a>
            </td>
        </tr>
         <tr>
           <td class="leftbottomtd1">
                <a href="${pageContext.request.contextPath }/testOnline/courseTest_Action">课程测试</a>
            </td>
        </tr>
         <tr>
           <td class="leftbottomtd1">
                <a href="${pageContext.request.contextPath }/testOnline/showCapterList_Action">章节测试</a>
            </td>
        </tr>
    </table>
    </div>
    </div>
    </div>
    <div class="right" style="text-align:left;float:left;">
    <div class="righttop">
    <div class="righttopmap">
        您当前的位置:&nbsp;首页&nbsp;»&nbsp;在线测试&nbsp;»&nbsp;在线考试
    </div>
    </div>
<h2 style="color: RED;">选择题和判断题总分：${sum}</h2>
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
        <p>
          <c:if test="${choices.keyC!=''}">
            C、${choices.keyC}
          </c:if>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <c:if test="${choices.keyD!=''}">
            D、${choices.keyD}
          </c:if>
        </p>
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
        <br>
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
  <br>
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
  <br>
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
  <br>
</c:forEach>

<%--<p>${choiceList}</p>
<p>${studentChoice}</p>
<p>${torfList}</p>
<p>${studentTorf}</p>
<p>${fillBlank}</p>
<p>${studentFillBlank}</p>
<p>${essayList}</p>
<p>${studentEssay}</p>--%>

</div>
</div>
</body>
</html>
