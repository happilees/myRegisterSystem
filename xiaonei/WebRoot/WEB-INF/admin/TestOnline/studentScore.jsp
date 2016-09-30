<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>水产学院精品课程</title>
   

    <script src="${pageContext.request.contextPath}/javascript/jquery-2.1.3.min.js"></script>

    <script type="text/javascript">
        function deleteAllStudent(){
            if(confirm("确定要删除所有学生及成绩吗?")){
                return true;
            }else{
                return false;
            }
        }
    </script>
    <style>
    .sel_btn{
            height: 32px;
            line-height: 32px;
            padding: 0 11px;
            background: #212121;
            border: 1px #26bbdb solid;
            color: #fff;
            font-weight:bold;
            display: inline-block;
            text-decoration: none;
            font-size: 14px;
            outline: none;
        }
        table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
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
<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="bigright">
 <div class="rightinfo">
 <div style="float:left;">
    <form method="post" action="${pageContext.request.contextPath}/examOnline/findClassName_Action?examId=${exam.id}">
<p>按班级搜索：<select name="className"  class="dfinput">
    <c:forEach items="${classList}" var="classes">
        <option>${classes}</option>
    </c:forEach>
</select>
    <input type="submit"  class="btn" value="搜索">
    </form>
    </div>
    <div style="float:left;margin-left:20px;">
    <a href="${pageContext.request.contextPath}/examOnline/pulloutTest_Action?examId=${exam.id}&className=${className}" class="sel_btn">
    将学生成绩导出execl表格</a>
    </div>
    <!--  
<form action=" ${pageContext.request.contextPath}/examOnline/deleteAllStudent_Action?exam.id=${exam.id}" method="post"  style="margin-top:50px;">
   <input type="submit" onclick="return deleteAllStudent()" class="btn" value="删除所有学生成绩">
</form>-->
<div  style="margin-top:50px;">


<table class="gridtable">
<tr>
	<th>学号</th><th>班级</th><th>姓名</th><th>成绩</th><th>成绩</th><th>成绩</th>
	<th>成绩</th><th>成绩</th><th>最高分</th><th>平均分</th>
</tr>
<c:set value="0" var="count2"></c:set>
<c:forEach items="${studentList}" var="student">
<c:set var="count" value="0"></c:set>
  <c:set var="count1" value="0"></c:set>
  <c:set var="sum" value="0"></c:set>
<tr>
	<td>${student.studentNo}</td><td>${student.className}</td><td>${student.studentName}</td>
	<c:forEach items="${eachAllScore[count2]}" var="s">
	        <td>第${count+1}次:${s}</td>
	<c:set var="count1" value="${count1+1}"></c:set>
    <c:set var="count" value="${count+1}"></c:set>
    <c:set var="sum" value="${sum+s}"></c:set>
	</c:forEach>
	<td>最高分:${eachMax[count2]}</td>
	<c:set var="count2" value="${count2+1}"></c:set>
    <c:set var="count" value="${count+1}"></c:set>
	<td>平均分:<fmt:formatNumber type="number" value="${sum/(count-1)} " maxFractionDigits="2"/></td>
</tr>
 </c:forEach>
</table>



<c:set value="0" var="count2"></c:set>
<c:forEach items="${studentList}" var="student">
  <c:set var="count" value="0"></c:set>
  <c:set var="count1" value="0"></c:set>
  <c:set var="sum" value="0"></c:set>
  <p>学号：${student.studentNo}&nbsp;&nbsp;&nbsp;
  班级：${student.className}&nbsp;&nbsp;&nbsp;
  学生姓名：${student.studentName}
      <br>
      <c:forEach items="${eachAllScore[count2]}" var="s">
        &nbsp;&nbsp;&nbsp;第${count+1}次成绩：${s}
          <c:if test="${(count+1)%5==0}">
              <br>
          </c:if>
        <c:set var="count1" value="${count1+1}"></c:set>
        <c:set var="count" value="${count+1}"></c:set>
        <c:set var="sum" value="${sum+s}"></c:set>
      </c:forEach>

      <br>
      &nbsp;&nbsp;&nbsp;<span style="color: RED">最高分：${eachMax[count2]}</span>
    <c:set var="count2" value="${count2+1}"></c:set>
    <c:set var="count" value="${count+1}"></c:set>
    &nbsp;&nbsp;&nbsp;<span style="color: RED">平均分：
      <fmt:formatNumber type="number" value="${sum/(count-1)} " maxFractionDigits="2"/>
          </span>
  </c:forEach>
      <br>
  </p>
</div>
</div>
</div>


</body>
</html>
