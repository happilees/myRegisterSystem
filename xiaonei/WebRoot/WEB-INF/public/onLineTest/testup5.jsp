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
        您当前的位置:&nbsp;首页&nbsp;»&nbsp;在线测试
    </div>
    </div>
   <h3>${message}</h3>
    </div>
    </div>
    <jsp:include page="/WEB-INF/public/foot.jsp"/>
</body>
</html>
