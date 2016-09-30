<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>水产学院精品课程</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homework.css" type="text/css"/>
   <link href="${pageContext.request.contextPath }/css/contentcomm.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"/>
 
 <style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	margin-top:30px;
	text-align:center;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>

  
  </head>
  
  <body>
  <div class="bigbigdiv">
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
                <a href="${pageContext.request.contextPath}/test/word_gohomework.action">作业提交系统</a>
            </td>
        </tr>
       
    </table>
    </div>
    </div>
    </div>
    <div class="right"  style="float:left;text-align:left;">
    <div class="righttop">
    <div class="righttopmap">
        您当前的位置:&nbsp;首页&nbsp;»&nbsp;教学资源&nbsp;»&nbsp;授课课件
    </div>
    </div>
    <div class="homeworkbig">
    <!-- CSS goes in the document HEAD or added to your external stylesheet -->

<!-- Table goes in the document BODY -->
<table class="gridtable">
<tr>
	<th>作业名称</th><th>前往提交作业</th>
</tr>
 <c:forEach items="${hwlist}" var="homework">
<tr>
	<td>${homework.hwname}</td><td><a href="${pageContext.request.contextPath }/test/word_gohandinhw.action?hwid=${homework.id}">前往提交作业</a></td>
</tr>
 </c:forEach>
</table>
   <div class="manu">
    <a href="${pageContext.request.contextPath }/test/word_gohomework.action?pageNow=1" style="font-weight:normal">首页</a>
            <c:forEach var="i" begin="1" end="${pageCount}">
            <span style="font-weight:normal"><a href="${pageContext.request.contextPath }/test/word_gohomework.action?pageNow=${i}">${i}</a></span>
            </c:forEach>
    <a href="${pageContext.request.contextPath }/test/word_gohomework.action?pageNow=${pageCount}" style="font-weight:normal">尾页</a>
</div>
    </div>
    </div>
    </div>
    <jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
    </div>
  </body>
</html>

