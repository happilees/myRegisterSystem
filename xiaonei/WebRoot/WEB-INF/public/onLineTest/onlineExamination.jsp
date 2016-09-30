<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2015/12/26
  Time: 21:25
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

<script type="text/javascript">
  function checkRadio(TypeCount,type){
    var flag = new Array();
    var i = 1;
    for(i;i<=TypeCount;i++){
      flag[i-1]=false;
      var elementByName = document.getElementsByName(type+i);
      for(var k = 0;k<elementByName.length;k++){
        if(elementByName[k].checked == true){
          flag[i-1]=true;
        }
      }
      if(flag[i-1]==false){
        return false;
      }
    }


  }
  function checkTest(typeCount,type){

    var flag = new Array();
    var i =1;
    for(i;i<=typeCount;i++){
      flag[i-1]=false;
      var elementByName = document.getElementsByName(type+i);
      if(elementByName[0].value != ''){
        flag[i-1]=true;
      }
      if(flag[i-1]==false){
        return false;
      }
    }
  }


  function checkAll(){
    var torfCount = document.getElementById("trueOrFalsesCount").innerHTML;
    var fillBlanksCount = document.getElementById("fillBlanksCount").innerHTML;
    var essaysCount = document.getElementById("essaysCount").innerHTML;
    var  choiceCount = document.getElementById("choiceCount").innerHTML;
    if(checkRadio(choiceCount,"choice") == false){
      alert("请答完再提交！");
      return checkRadio(choiceCount,"choice");
    }else if(checkRadio(torfCount,"trueOrFalses")==false){
      alert("请答完再提交！");
      return checkRadio(torfCount,"trueOrFalses");
    }
    else if(checkTest(fillBlanksCount,"fillBlanks")==false){
      alert("请答完再提交！");
      return checkTest(fillBlanksCount,"fillBlanks");
    }
    else if(checkTest(essaysCount,"essays")==false){
      alert("请答完再提交！");
      return checkTest(essaysCount,"essays");
    }
    else{
      return true;
    }
  }

</script>
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
        您当前的位置:&nbsp;首页&nbsp;»&nbsp;在线测试&nbsp;»&nbsp;在线考试
    </div>
    </div>

<h3>在线考试</h3>
<form action="${pageContext.request.contextPath }/testOnline/showOnlineTestResult_Action" method="post">
  <h4>选择题</h4>
  <c:set var="count" value="1"/>
  <c:set var="count1" value="1"/><!--add-->
  <c:forEach items="${showChoice}" var="choices">
    <input type="hidden" value="${choices.id}" name="choiceId${count}">
    <p>${count}.${choices.choiceTitle}</p>
    <c:if test="${choices.keyA!=''}">
      <label><p><input type="radio" value="A" name="choice${count}">&nbsp;&nbsp;A、${choices.keyA}</p></label>
    </c:if>
    <c:if test="${choices.keyB!=''}">
      <label><p><input type="radio" value="B" name="choice${count}">&nbsp;&nbsp;B、${choices.keyB}</p></label>
    </c:if>
    <c:if test="${choices.keyC!=''}">
      <label><p><input type="radio" value="C" name="choice${count}">&nbsp;&nbsp;C、${choices.keyC}</p></label>
    </c:if>
    <c:if test="${choices.keyD!=''}">
      <label><p><input type="radio" value="D" name="choice${count}">&nbsp;&nbsp;D、${choices.keyD}</p></label>
    </c:if>
    <c:if test="${choices.keyE!=''}">
      <label><p><input type="radio" value="E" name="choice${count}">&nbsp;&nbsp;E、${choices.keyE}</p></label>
    </c:if>
    <c:set var="count" value="${count+1}"/>
    <br>
  </c:forEach>
  <c:set var="choiceCount" value="${count-1}"></c:set><!--add-->
  <p style="display: none" id="choiceCount">${count-1}</p><!--add-->
<h4>判断题</h4>
<c:set var="count" value="1"/>
<c:forEach items="${showTrueOrFalse}" var="trueOrFalses">
  <input type="hidden" value="${trueOrFalses.id}" name="trueOrFalsesId${count}">
  <p>${count}.${trueOrFalses.question}</p>
  <label><p><input type="radio" value="1" name="trueOrFalses${count}">&nbsp;&nbsp;对</p></label>
  <label><p><input type="radio" value="0" name="trueOrFalses${count}">&nbsp;&nbsp;错</p></label>
  <c:set var="count" value="${count+1}"/>
  <br>
</c:forEach>
  <c:set var="torfCount" value="${count-1}"></c:set><!--add-->
  <p style="display: none" id="trueOrFalsesCount">${count-1}</p><!--add-->

<h4>填空题</h4>
<c:set var="count" value="1"/>
<c:forEach items="${showFillBlank}" var="fillBlanks">
  <input type="hidden" value="${fillBlanks.id}" name="fillBlanksId${count}">
  <p>${count}.${fillBlanks.question}</p>
  <input type="text" name="fillBlanks${count}">
  <c:set var="count" value="${count+1}"/>
  <br><br>
</c:forEach>
  <c:set var="fillBlanksCount" value="${count-1}"></c:set><!--add-->
  <p style="display: none" id="fillBlanksCount">${count-1}</p><!--add-->
<h4>简答题</h4>
<c:set var="count" value="1"/>
<c:forEach items="${showEssay}" var="essays">
  <p>${count}.${essays.question}</p>
  <input type="hidden" value="${essays.id}" name="essaysId${count}">
  <textarea cols="100" rows="5" name="essays${count}"></textarea>
  <c:set var="count" value="${count+1}"/>
  <br>
  <br>
</c:forEach>
  <c:set var="essaysCount" value="${count-1}"></c:set><!--add-->
  <p style="display: none" id="essaysCount">${count-1}</p><!--add-->

  <p><input type="submit" onclick="return checkAll();" value="提交"></p>

</form>
</div>
</div>
<jsp:include page="/WEB-INF/public/foot.jsp"/>
</body>
</html>
