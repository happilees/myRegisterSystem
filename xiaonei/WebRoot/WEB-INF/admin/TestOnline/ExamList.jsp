<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'ExamList.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    
  </head>
  
  <body>
<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>

  <script src="${pageContext.request.contextPath}/javascript/jquery-2.1.3.min.js"></script>
  <script type="text/javascript">
    function addE(){
      var e ={"examName":$("#examName").val(),"isStart":$("#isStart").val(),
        "score":$("#score").val(),"time":$("#time").val()};
      var exam = eval(e);
      alert(exam);
    }

    function forwardpage(){

      $.post("${pageContext.request.contextPath}/exam/showExamByCurrentPage_Action?page="+document.getElementById("page").innerHTML,
      function(data){
        $.each(data.exams)
        $("#examlist").html("");
        $("#examlist").append(
                "success"
        );

      }
      );
    }
    function addExam() {
      $.post("${pageContext.request.contextPath}/exam/addExam_Action",
              {"exam.examName":$("#examName").val(),"exam.isStart":$("#isStart").val(),
                "exam.score":$("#score").val(),"exam.time":$("#time").val()},
              function(data) {
                var item = data.exam;
                var isStart;
                if(item.isStart == 1){
                  isStart = "是";
                }else{
                  isStart = "否";
                }
                $("#info").append(
                        "<tr>"+
                        "<td>" + item.id + "</td>" +
                        "<td>" + item.examName + "</td>"+
                        "<td><a href='${pageContext.request.contextPath}/examOnline/updateIsStartExam_Action?examId="+item.id+"&isStart="+item.isStart+"'>" + isStart + "</td>" +
                        "<td>" + item.score + "</td>" +
                        "<td>" + item.time + "</td>" +
                        "<td><a href='${pageContext.request.contextPath}/examOnline/forwardAddQuestion_Action?examId="+item.id+"'>" + "编辑" + "</a></td>"
                        +"</tr>"
                );
              });
    }
  </script>
<div class="bigright">
  <div class="exambig">
  <h3>添加试卷</h3>

  <form>
    考试名称:<input type="text" placeholder="考试名称"   class="dfinput" id="examName"/><br>开始考试：
    <select id="isStart">
      <option value="1">是</option>
      <option value="0">否</option>
    </select><br>
 总分:<input type="text" id="score"  class="dfinput" placeholder="总分:100"><br>
    考试时间分钟:<input type="text" id="time"   class="dfinput" placeholder="考试时间分钟" ><br>
    <input type="button"  class="btn"  value="添加" onclick="addExam()"><br>
  </form>

  <table id="info" style="margin-top:50px;">
    <tr>
      <td>考试序列</td>
      <td>名称</td>
      <td>开考</td>
      <td>总分</td>
      <td>时间</td>
      <td>编辑</td>
    </tr>


    <div id="examList">
      <c:set var="count" value="1"></c:set>
      <c:forEach items="${exams}" var="e">
        <tr>
          <td>${count}</td>
          <td>${e.examName}</td>
          <td>
            <c:set var="isStart" value="${e.isStart}"/>
            <c:choose>
              <c:when test="${e.isStart == 1}">
                <a href="/examOnline/updateIsStartExam_Action?examId=${e.id}&isStart=${isStart}">是</a>
              </c:when>
              <c:otherwise>
                <a href="/examOnline/updateIsStartExam_Action?examId=${e.id}&isStart=${isStart}">否</a>
              </c:otherwise>
            </c:choose>
          </td>
          <td>${e.score}</td>
          <td>${e.time}</td>
          <td>
            <a href="${pageContext.request.contextPath}/examOnline/forwardAddQuestion_Action?examId=${e.id}">编辑</a>
          </td>
        </tr>
        <c:set var="count" value="${count+1}"></c:set>
      </c:forEach>
    </div>

</table>
  </div>
   </div>
  </body>
</html>
