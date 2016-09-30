<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2015/12/26
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath }/css/contentcomm.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"/>
 <link href="${pageContext.request.contextPath}/css/adminexam.css" rel="stylesheet" type="text/css">
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
        </tr>
    </table>
    </div>
    </div>
    </div>
    <div class="right" style="text-align:left;float:left;">
    <div class="righttop">
    <div class="righttopmap">
        您当前的位置:&nbsp;首页&nbsp;»&nbsp;在线测试&nbsp;»&nbsp;章节测试
    </div>
    </div>
<h3>章节测试</h3>
<h4>章节测试结果</h4>
<table>
  <tr>
    <td>章节名称</td>
    <td>最高分</td>
    <td>测试</td>
  </tr>
    <c:set var="count" value="0"></c:set>

    <c:forEach items="${exams}" var="e">
  <tr>
      <td>${e.examName}&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td><c:choose>
          <c:when test="${max[count]!=null}">
              最高分:${max[count]}
          </c:when>
          <c:otherwise>
             未测试
          </c:otherwise>
      </c:choose>&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td><a href="${pageContext.request.contextPath}/testOnline/showCapterQuestion_Action?examId=${e.id}">点击测试</a><br></td>
 </tr>
        <c:set var="count" value="${count+1}"></c:set>
    </c:forEach>

</table>
<h4>课程测试结果</h4>
<table>
    <tr>
        <td>平均分:${average}
        <c:if test="${average==null}">
            未测试
        </c:if>
            &nbsp;&nbsp;&nbsp;&nbsp;
        </td>
        <td>已经测试次数:${havedTest}
            <c:if test="${havedTest==null}">
                0
            </c:if>
            &nbsp;&nbsp;&nbsp;&nbsp;
        </td>
        <td>最高分:${maxCourse}
            <c:if test="${maxCourse==null}">
                未测试
            </c:if>
            &nbsp;&nbsp;&nbsp;&nbsp;
        </td>
        <td><a href="${pageContext.request.contextPath}/testOnline/courseTest_Action">点击测试</a></td>
    </tr>
    <tr>
    <c:set var="count" value="1"></c:set>
    <c:forEach items="${courseTestScore}" var="score">
        <td>第${count}次成绩：${score.score}</td>
        <c:set var="count" value="${count+1}"></c:set>
    </c:forEach>
    </tr>
</table>
</div>
</div>
<jsp:include page="/WEB-INF/public/foot.jsp"/>
</body>
</html>
