<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2015/12/29
  Time: 19:50
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
        您当前的位置:&nbsp;首页&nbsp;»&nbsp;在线测试&nbsp;»&nbsp;测试答案
    </div>
    </div>
    <h2 style="color: RED;">当前分数:${score}</h2><br>
        <h3>一、选择题</h3>
        <c:set var="answers" value="${answer}"></c:set>
        <c:set var="count" value="0"></c:set>
        <c:forEach items="${choiceList}" var="choices">
            <p>${count+1}.${choices.choiceTitle}</p>
            <p>
            <c:if test="${choices.keyA!=''}">
                A、${choices.keyA}
            </c:if> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

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
  <p>正确答案：${choices.result} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  学生答案：${answers[count]}</p>
  <c:set var="count" value="${count+1}"></c:set>
            <br>
</c:forEach>
</div>
    </div>
    <jsp:include page="/WEB-INF/public/foot.jsp"/>
</body>
</html>
