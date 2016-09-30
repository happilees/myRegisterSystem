<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2015/12/27
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath }/css/contentcomm.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .right a {
            cursor:pointer;
        }
    </style>
</head>
<body>
<script type="text/javascript">
    function readResult(id){
         var ele = document.getElementById(id);
         if(ele.style.display == 'none'){
         ele.style.display = 'block';
         }else{
         ele.style.display='none';
         }

    }
</script>
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
                您当前的位置:&nbsp;首页&nbsp;»&nbsp;在线测试&nbsp;»&nbsp;章节测试
            </div>
        </div>
        <form action="" method="post">
            <h3>${exam.examName}</h3>
            <br>
            <h4>一、选择题。</h4>
            <c:set var="count" value="1"></c:set>
            <c:forEach items="${choiceList}" var="choices">

                <p>${count}.${choices.choiceTitle}</p>
                <c:if test="${choices.keyA != ''}">
                    <label><p><input type="radio" value="A" name="answer${count}">&nbsp;&nbsp;A、${choices.keyA}</p></label>
                </c:if>
                <c:if test="${choices.keyB != ''}">
                    <label><p><input type="radio" value="B" name="answer${count}">&nbsp;&nbsp;B、${choices.keyB}</p></label>
                </c:if>
                <c:if test="${choices.keyC != ''}">
                    <label> <p><input type="radio" value="C" name="answer${count}">&nbsp;&nbsp;C、${choices.keyC}</p></label>
                </c:if>
                <c:if test="${choices.keyD != ''}">
                    <label>  <p><input type="radio" value="D" name="answer${count}">&nbsp;&nbsp;D、${choices.keyD}</p></label>
                </c:if>
                <c:if test="${choices.keyE != ''}">
                    <label> <p><input type="radio" value="E" name="answer${count}">&nbsp;&nbsp;E、${choices.keyE}</p></label>
                </c:if>
                <a onclick="readResult('choice_'+${choices.id})">查看答案</a>
                <p id="choice_${choices.id}" style="display: none">正确答案：${choices.result}</p>
                <br>
                <c:set var="count" value="${count+1}"></c:set>
            </c:forEach>
            <p>二、判断题。</p>
            <c:set var="count" value="1"></c:set>
            <c:forEach items="${torfquestionList}" var="torfquestions">
                <p>${count}.${torfquestions.question}</p>
                <label><p><input type="radio" value="1" name="trueOrFalses${count}">&nbsp;&nbsp;对</p></label>
                <label><p><input type="radio" value="0" name="trueOrFalses${count}">&nbsp;&nbsp;错</p></label>
                <a onclick="readResult('torf_'+${torfquestions.id})">查看答案</a>
                <p id="torf_${torfquestions.id}" style="display: none">正确答案：
                    <c:choose>
                        <c:when test="${torfquestions.result == 1}">
                            对
                        </c:when>
                        <c:when test="${torfquestions.result == 0}">
                            错
                        </c:when>
                    </c:choose>


                </p>
                <br>
                <c:set var="count" value="${count+1}"></c:set>
            </c:forEach>
            <p>三、填空题。</p>
            <c:set var="count" value="1"></c:set>
            <c:forEach items="${fillBlanksList}" var="fillblanks">
                <p>${count}.${fillblanks.question}</p>
                <input type="text"><br>
                <a onclick="readResult('fillBlank_'+${fillblanks.id})">查看答案</a>
                <p id="fillBlank_${fillblanks.id}" style="display: none">正确答案：${fillblanks.answer}</p>
                <br><br>
                <c:set var="count" value="${count+1}"></c:set>
            </c:forEach>
            <p>四、简答题。</p>
            <c:set var="count" value="1"></c:set>
            <c:forEach items="${essayList}" var="essays">
                <p>${count}.${essays.question}</p>
                <textarea cols="100" rows="5" name="essay|8"></textarea>
                <a onclick="readResult('essay_'+${essays.id})">查看答案</a>
                <p id="essay_${essays.id}" style="display: none">正确答案：${essats.answer}</p>
                <br><br>
                <c:set var="count" value="${count+1}"></c:set>
            </c:forEach>
        </form>
    </div>
</div>
<jsp:include page="/WEB-INF/public/foot.jsp"/>
<%--
<script type="javascript">
    function ll(id){
        alert("asdfa");
        /* var ele = document.getElementById('choice_'+id);
         if(ele.style.display == 'none'){
         ele.style.display = 'block';
         }else{
         ele.style.display='none';
         }*/
    }
</script>--%>
</body>
</html>

