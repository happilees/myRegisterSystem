<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加题目</title>
    <link href="${pageContext.request.contextPath}/css/adminexam.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .exambig a {
            cursor:pointer;
        }
    </style>
    <script src="${pageContext.request.contextPath}/javascript/jquery-2.1.3.min.js"></script>

    <script type="text/javascript">
        function addChoice(){
            $.post("${pageContext.request.contextPath}/choice/addChooses_Action",
                    {
                        "exam.id":$("#examId").val(),
                        "choice.choiceTitle":$("#choiceTitle").val(),
                        "choice.keyA":$("#keyA").val(),
                        "choice.keyB":$("#keyB").val(),
                        "choice.keyC":$("#keyC").val(),
                        "choice.keyD":$("#keyD").val(),
                        "choice.keyE":$("#keyE").val(),
                        "choice.result":$("#ChoiceResult").val()},
                    function(data){
                        //$("#choiceQuestion").html("");
                        //$.each(data.choiceList,function(i,item){
                        //item = data.choice;
                        if(data!=null){
                            $("#choiceQuestion").append(
                                    '<input type="hidden" name="'+data.choice.choiceNo+'" value="'+data.choice.choiceNo+'" id="'+data.choice.id+'_choiceNo">'+
                                    data.choice.choiceNo+'.'+'<input type="text"'+' class="inputStyle" name="'+data.choice.choiceTitle+'" value="'+data.choice.choiceTitle +'" id="'+data.choice.id+'_choiceTitle"><br>'+
                                    'A、<input type="text" class="answerStyle" value="'+data.choice.keyA+'" id="'+data.choice.id+'_keyA" name="choice.keyA"> &nbsp;&nbsp;&nbsp;&nbsp;'+
                                    'B、<input type="text" class="answerStyle" value="'+data.choice.keyB+'" id="'+data.choice.id+'_keyB" name="choice.keyB"><br>'+
                                    'C、<input type="text" class="answerStyle" value="'+data.choice.keyC+'" id="'+data.choice.id+'_keyC" name="choice.keyC"> &nbsp;&nbsp;&nbsp;&nbsp;'+
                                    'D、<input type="text" class="answerStyle" value="'+data.choice.keyD+'" id="'+data.choice.id+'_keyD" name="choice.keyB"><br>'+
                                    'E、<input type="text" class="answerStyle" value="'+data.choice.keyE+'" id="'+data.choice.id+'_keyE" name="choice.keyE"><br>'+
                                    '正确答案：<span id="'+data.choice.id+'_currentResult">'+data.choice.result+'</span>&nbsp;&nbsp;&nbsp;&nbsp;'+
                                    '修改为：<select name="choice.result" id="'+data.choice.id+'_choiceResult">'+
                                    '<option>A</option>'+
                                    '<option>B</option>'+
                                    '<option>C</option>'+
                                    '<option>D</option>'+
                                    '<option>E</option>'+
                                    '</select><br>'+
                                        /*item.choiceNo+"."+item.choiceTitle +
                                         "<br>"+"A、"+item.keyA+"&nbsp;&nbsp;&nbsp;&nbsp;"+
                                         "B、"+item.keyB+"<br>"+
                                         "C、"+item.keyC+"&nbsp;&nbsp;&nbsp;&nbsp;"+
                                         "D、"+item.keyD+"<br>"+
                                         "E、"+item.keyE+"<br>"+
                                         "正确答案："+item.result+*/
                                    '<a href="${pageContext.request.contextPath}/examOnline/deleteChoice_Action?examId='+$('#examId').val()+'&choiceNo='+data.choice.id+'">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;'+
                                        /*"<a href='${pageContext.request.contextPath}/examOnline/deleteChoice_Action?examId="+$('#examId').val()+"&choiceNo="+item.choiceNo+"'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;"+*/
                                    '<a onclick="updateChoice('+data.choice.id+')">修改</a><br>'
                                    /*"<a href='${pageContext.request.contextPath}/examOnline/forwardUpdateChoice_Action?examId="+$('#examId').val()+"&choiceId="+item.id+"'>修改</a><br>"*/
                            );
                            alert("添加成功");
                        }
                        else{
                            alert("添加失败");
                        }
                    });
        }
        function addFillBlank(){
            $.post("${pageContext.request.contextPath}/fillBlank/addFillBlank_Action",
                    {"exam.id":$("#examId").val(),
                        "fillblank.question":$("#fillblankQuestion").val(),
                        "fillblank.answer":$("#fillblankAnswer").val()
                    },
                    function(data) {
                        //$("#fillBlankQuestionList").html("");
                        //$.each(data.fillblankList, function (i, item) {
                        //item = data.fillblank;
                        if(data!=""){
                            $("#fillBlankQuestionList").append(
                            '<input type="hidden" value="'+data.fillblank.fillBlankNo+'" id="'+data.fillblank.id+'_fillBlankNo">'+
                            data.fillblank.fillBlankNo+'.<input class="inputStyle" type="text" value="'+data.fillblank.question+'" id="'+data.fillblank.id+'_fillBlankQuestion"><br>'+
                                    '正确答案：'+
                            '<input class="answerStyle" type="text" value="'+data.fillblank.answer+'" id="'+data.fillblank.id+'_fillBlankAnswer"><br>'+

                            '<a href="${pageContext.request.contextPath}/examOnline/deleteFillBlank_Action?examId='+data.fillblank.id+'&questionNo='+data.fillblank.id+'">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;'+
                            '<a onclick="updateFillBlank('+data.fillblank.id+')">修改</a><br>'
                            /*item.fillBlankNo + "." + item.question + "<br>" +
                             "正确答案：" + item.answer +
                             "<br><a href='${pageContext.request.contextPath}/examOnline/deleteFillBlank_Action?examId="+$('#examId').val()+"&questionNo="+item.id+"'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                             "<a href='${pageContext.request.contextPath}/examOnline/forwardUpdateFillBlank_Action?examId="+$('#examId').val()+"&questionNo="+item.id+"'>修改</a><br>"
                             */
                        );
                            alert("添加成功");}
                        else{
                            alert("添加失败");
                        }
                    });
        }
        function addEssayQuestion(){
            $.post("${pageContext.request.contextPath}/essay/addEssay_Action",
                    {"exam.id":$("#examId").val(),
                        "essay.question":$("#essayQuestion").val(),
                        "essay.answer":$("#essayAnswer").val()
                    },
                    function(data){
                        // $("#essayQuestionList").html("");
                        //$.each(data.essayList,function(i,item){
                        if(data!=null){
                            //item = data.essay;
                            $("#essayQuestionList").append(
                                    '<input type="hidden" id="'+data.essay.id+'_essayNo" name="essay.essayNo" value="'+data.essay.essayNo+'">'+
                                    data.essay.essayNo+'.<input type="text" class="inputStyle"  id="'+data.essay.id+'_essayQuestion" name="essay.question" value="'+data.essay.question+'"> <br>'+
                                    '正确答案：'+
                                    '<textarea  rows="5" id="'+data.essay.id+'_essayResult" name="essay.answer">'+data.essay.answer+'</textarea><br>'+
                                    '<a href="${pageContext.request.contextPath}/examOnline/deleteEssay_Action?examId='+data.essay.id+'&questionNo='+data.essay.id+'">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;'+
                                    '<a onclick="updateEssay('+data.essay.id+')">修改</a>'


                                    /*item.essayNo+"."+item.question+"<br>"+
                                    "正确答案："+item.answer+
                                    "<br><a href='${pageContext.request.contextPath}/examOnline/deleteEssay_Action?examId="+$('#examId').val()+"&questionNo="+item.essayNo+"'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                                    "<a href='${pageContext.request.contextPath}/examOnline/forwardUpdateEssay_Action?examId="+$('#examId').val()+"&questionNo="+item.id+"'>修改</a><br>"*/
                            );
                            alert("添加成功");}
                        else{
                            alert("添加失败");
                        }
                        // });
                    }
            );
        }
        function addTrueOrFalse(){
            $.post("${pageContext.request.contextPath}/tureOrFalse/addTrueOrFalse_Action",
                    {"exam.id":$("#examId").val(),
                        "torfquestions.question":$("#question").val(),
                        "torfquestions.result":$("#torfquestionResult").val()
                    },
                    function(data){

                        // $("#torfQuestion").html("");
                        // $.each(data.torfquestionses,function(i,item){
                        //item = data.torfquestions;
                        if(data!=""){
                            var str ;
                            //var trueOrFalse;

                            if(data.torfquestions.result == '1'){
                                str =' <option value="1">对</option><option value="0">错</option>';
                                //trueOrFalse = "错";
                            }else{
                                str =' <option value="0">错</option><option value="1">对</option>';
                                //trueOrFalse = "对";
                            }
                            $("#torfQuestion").append(
                                    '<input type="hidden" name="torfquestions.questionNo" value="'+data.torfquestions.questionNo+'" id="'+data.torfquestions.id+'_torfQuestionNo">'+
                                    data.torfquestions.questionNo+'.<input type="text" name="torfquestions.question" class="inputStyle" value="'+data.torfquestions.question+'" id="'+data.torfquestions.id+'_torfQuestion"> <br>'+
                                    '正确答案：'+
                                    '<select id="'+data.torfquestions.id+'_torfResult" name="torfquestions.result">'+
                                    str+
                                    '</select>'+
                                    "<br><a href='${pageContext.request.contextPath}/examOnline/deleteFillBlank_Action?examId="+$('#examId').val()+"&questionNo="+data.torfquestions.id+"'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                                    '<a onclick="updateTorF('+data.torfquestions.id+')">修改</a><br>'
                                    /* item.questionNo+"."+item.question+"<br>"+
                                     "正确答案："+trueOrFalse+
                                     "<br><a href='${pageContext.request.contextPath}/examOnline/deleteTrueOrFalse_Action?examId="+$('#examId').val()+"&questionNo="+item.questionNo+"'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<br>"+
                                     "<a href='${pageContext.request.contextPath}/examOnline/forwardUpdateTorF_Action?examId="+$('#examId').val()+"&questionNo="+item.id+"'>修改</a><br>"*/
                            );
                            alert("添加成功");}
                        else{
                            alert("添加失败");
                        }

                    }
            );
        }

        function updateChoice(id){
            var getChoiceTitle = document.getElementById(""+id+"_choiceTitle").value;
            var getKeyA = document.getElementById(id+"_keyA").value;
            var getKeyB = document.getElementById(id+"_keyB").value;
            var getKeyC = document.getElementById(id+"_keyC").value;
            var getKeyD = document.getElementById(id+"_keyD").value;
            var getKeyE = document.getElementById(id+"_keyE").value;
            var getChoiceNo = document.getElementById(id+"_choiceNo").value;
            var getChioceResult = document.getElementById(id+"_choiceResult").value;
            var getresultId = id+'_currentResult';
            var updateResult = document.getElementById(getresultId);

            $.post(
                    "${pageContext.request.contextPath}/choice/updateChoice_Action",
                    {
                        "exam.id":$("#examId").val(),
                        "choice.id":id,
                        "choice.choiceTitle":getChoiceTitle,
                        "choice.keyA":getKeyA,
                        "choice.keyB":getKeyB,
                        "choice.keyC":getKeyC,
                        "choice.keyD":getKeyD,
                        "choice.keyE":getKeyE,
                        "choice.result":getChioceResult,
                        "choice.choiceNo":getChoiceNo
                    },
                    function(data){
                        if(data.choice != null){
                            getChoiceTitle = data.choice.choiceTitle;
                            getKeyA = data.choice.keyA;
                            getKeyB = data.choice.keyB;
                            getKeyC = data.choice.keyC;
                            getKeyD = data.choice.keyD;
                            getKeyE = data.choice.keyE;
                            updateResult.innerHTML = data.choice.result;
                            alert("修改成功");
                        }
                        else{
                            alert("修改失败");
                        }
                    }

            );
        }
        function updateTorF(id){
            var getQuestion = document.getElementById(id+"_torfQuestion").value;
            var getResult = document.getElementById(id+"_torfResult").value;
            var getTorFNo = document.getElementById(id+"_torfQuestionNo").value;
            $.post(
                    "${pageContext.request.contextPath}/tureOrFalse/updateTrueOrFalse_Action",
                    {"exam.id":$("#examId").val(),
                        "torfquestions.question":getQuestion,
                        "torfquestions.result":getResult,
                        "torfquestions.questionNo":getTorFNo,
                        "torfquestions.id":id
                    },
                    function(data){
                        if(data.torfquestions != null){
                            getQuestion = data.torfquestions.question;
                            getResult = data.torfquestions.result;
                            getTorFNo = data.torfquestions.questionNo;
                            alert("修改成功");
                        }else{
                            alert("修改失败");
                        }

                    }
            );
        }
        function updateEssay(id){
            var getQuestion = document.getElementById(id+"_essayQuestion").value;
            var ess = id+"_essayResult";
            var getResult = document.getElementById(id+"_essayResult");
            var result = getResult.value;
            //alert(result);
            var getEssayNum = document.getElementById(id+"_essayNo").value;
            $.post(
                    "${pageContext.request.contextPath}/essay/updateEssay_Action",
                    {"exam.id":$("#examId").val(),
                        "essay.question":getQuestion,
                        "essay.answer":result,
                        "essay.essayNo":getEssayNum,
                        "essay.id":id
                    },
                    function(data){
                        if(data.essay != null){
                            result = data.essay.question;
                            getResult = data.essay.answer;
                            getEssayNum = data.essay.essayNo;
                            alert("修改成功");
                        }else{
                            alert("修改失败");
                        }

                    }
            );
        }
        function updateFillBlank(id){
            var getQuestion = document.getElementById(id+"_fillBlankQuestion").value;
            var getAnswer = document.getElementById(id+"_fillBlankAnswer").value;
            var getFillBlankNo = document.getElementById(id+"_fillBlankNo").value;
            $.post(
                    "${pageContext.request.contextPath}/fillBlank/updateFillBlank_Action",
                    {"exam.id":$("#examId").val(),
                        "fillblank.question":getQuestion,
                        "fillblank.answer":getAnswer,
                        "fillblank.fillBlankNo":getFillBlankNo,
                        "fillblank.id":id
                    },

                    function(data){
                        //item = data.fillblank;
                        if(data.fillblank != null){
                            getQuestion = data.fillblank.question;
                            getAnswer = data.fillblank.answer;
                            getFillBlankNo = data.fillblank.fillBlankNo;
                            alert("修改成功");
                        }else{
                            alert("修改失败");
                        }
                    }
            );

        }


    </script>

</head>
<body>

<jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="bigright">
    <input type="hidden" name="exam.id" id="examId" value="${exam.id}">

<h4>添加选择题</h4>
<form method="post">

  选择题题目：<input type="text" class="dfinput" id="choiceTitle" name="choice.choiceTitle">
    <p>选项A：<input type="text" class="dfinput" name="choice.keyA" id="keyA">&nbsp;&nbsp;&nbsp;&nbsp;
    选项B：<input type="text" class="dfinput" name="choice.keyB" id="keyB"></p>
    <p>选项C：<input type="text" class="dfinput" name="choice.keyC" id="keyC">&nbsp;&nbsp;&nbsp;&nbsp;
    选项D：<input type="text" class="dfinput" name="choice.keyD" id="keyD"></p>
    <p>选项E：<input type="text" class="dfinput" name="choice.keyE" id="keyE"></p>
    <p>正确答案:
  <select name="choice.result" id="ChoiceResult">
    <option>A</option>
    <option>B</option>
    <option>C</option>
    <option>D</option>
    <option>E</option>
  </select></p>
  <input type="button" value="添加" class="btn" onclick="addChoice()">

</form>


<h4>添加判断题</h4>
<form method="post">
  <input type="hidden" name="exam.id" value="${exam.id}">
  <p>判断题题目：<input type="text" class="dfinput" id="question" name="torfquestions.question"></p>
  <p>正确答案：
  <select id="torfquestionResult" name="torfquestions.result">
    <option value="1">对</option>
    <option value="0">错</option>
  </select></p>
  <input type="button" value="添加"  class="btn"  onclick="addTrueOrFalse()">
</form>


<h4>添加填空题</h4>
<form method="post">
    <input type="hidden" name="exam.id" value="${exam.id}">
 <p>问题：<input type="text" id="fillblankQuestion" class="dfinput" name="fillblank.question"></p>
    <p>答案：<input type="text" id="fillblankAnswer" class="dfinput" name="fillblank.answer"></p>
    <input type="button" value="添加" class="btn" onclick="addFillBlank()">
</form>

<h4>添加简答题</h4>
<form method="post">
  <p>简答题题目：<input type="text" id="essayQuestion" class="dfinput" name="essay.question"></p>
    <p>正确答案：<%--<input type="text" id="essayAnswer" class="inputStyle" name="essay.answer">--%></p>
<textarea rows="5" cols="100" id="essayAnswer" name="essay.answer"></textarea>
    <br>
    <input type="button" value="添加"   class="btn"  onclick="addEssayQuestion()">
</form>


<div>
    <h4>选择题</h4>
    <div id="choiceQuestion">
        <c:set var="choiceCount" value="1"></c:set>
        <c:forEach items="${choiceList}" var="choices">
            <input type="hidden" name="choice.choiceNo" value="${choices.choiceNo}" id="${choices.id}_choiceNo">
            ${choiceCount}.<input type="text" class="dfinput" name="choice.choiceTitle" value="${choices.choiceTitle }" id="${choices.id}_choiceTitle">
            <br>
                A、<input type="text" class="dfinput" value="${choices.keyA}" id="${choices.id}_keyA" name="choice.keyA"> &nbsp;&nbsp;&nbsp;&nbsp;
                B、<input type="text" class="dfinput" value="${choices.keyB}" id="${choices.id}_keyB" name="choice.keyB"><br>
                C、<input type="text" class="dfinput" value="${choices.keyC}" id="${choices.id}_keyC" name="choice.keyC"> &nbsp;&nbsp;&nbsp;&nbsp;
                D、<input type="text" class="dfinput" value="${choices.keyD}" id="${choices.id}_keyD" name="choice.keyD"><br>
                E、<input type="text" class="dfinput" value="${choices.keyE}" id="${choices.id}_keyE" name="choice.keyE"><br>

            正确答案：<span id="${choices.id}_currentResult">${choices.result}</span>&nbsp;&nbsp;&nbsp;&nbsp;
            修改为：<select name="choice.result" id="${choices.id}_choiceResult">
            <option>A</option>
            <option>B</option>
            <option>C</option>
            <option>D</option>
            <option>E</option>
            </select><br>
            <c:set var="choiceCount" value="${choiceCount+1}"></c:set>
            <a href="${pageContext.request.contextPath}/examOnline/deleteChoice_Action?examId=${exam.id}&choiceNo=${choices.id}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <%--<a href="${pageContext.request.contextPath}/examOnline/forwardUpdateChoice_Action?examId=${exam.id}&choiceId=${choices.id}">修改</a>--%>

            <a onclick="updateChoice(${choices.id})">修改</a>
            <br>
        </c:forEach>

    </div>

  <h4>判断题</h4>
<div id="torfQuestion">
<c:set var="torfQuestionCount" value="1"/>
  <c:forEach items="${torfquestionList}" var="torfquestions">
      <input type="hidden" name="torfquestions.questionNo" value="${torfquestions.questionNo}" id="${torfquestions.id}_torfQuestionNo">
    ${torfQuestionCount}.<input type="text" name="torfquestions.question" class="dfinput" value="${torfquestions.question}" id="${torfquestions.id}_torfQuestion"> <br>
    正确答案：
    <c:set var="answer" value="${torfquestions.result}"></c:set>
    <select id="${torfquestions.id}_torfResult" name="torfquestions.result">
      <c:choose>
      <c:when test="${answer==1}">
              <option value="1">对</option>
              <option value="0">错</option>
      </c:when>
      <c:when test="${answer==0}">
              <option value="0" >错</option>
              <option value="1" >对</option>
      </c:when>
    </c:choose>
    </select>
    <br>
      <a href="${pageContext.request.contextPath}/examOnline/deleteTrueOrFalse_Action?examId=${exam.id}&questionNo=${torfquestions.id}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a onclick="updateTorF(${torfquestions.id})">修改</a><br>
      <%--<a href="${pageContext.request.contextPath}/examOnline/forwardUpdateTorF_Action?examId=${exam.id}&questionNo=${torfquestions.id}">修改</a><br>--%>
  	<c:set var="torfQuestionCount" value="${torfQuestionCount+1}"/>
  </c:forEach>
</div>


  <h4>填空题</h4>
  <div id="fillBlankQuestionList">
  <c:set var="fillBlankQuestionCount" value="1"/>
    <c:forEach items="${fillBlanksList}" var="fillblanks">
        <input type="hidden" value="${fillblanks.fillBlankNo}" id="${fillblanks.id}_fillBlankNo">
      ${fillBlankQuestionCount}.<input class="dfinput" type="text" value="${fillblanks.question}" id="${fillblanks.id}_fillBlankQuestion"><br>
      正确答案：
      <input class="dfinput" type="text" value="${fillblanks.answer}" id="${fillblanks.id}_fillBlankAnswer">
      <br>
        <a href="${pageContext.request.contextPath}/examOnline/deleteFillBlank_Action?examId=${exam.id}&questionNo=${fillblanks.id}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%--<a href="${pageContext.request.contextPath}/examOnline/forwardUpdateFillBlank_Action?examId=${exam.id}&questionNo=${fillblanks.id}">修改</a>--%>
        <a onclick="updateFillBlank(${fillblanks.id})">修改</a><br>
        <c:set var="fillBlankQuestionCount" value="${fillBlankQuestionCount+1}"/>
    </c:forEach>
  </div>
  <br>
  <h4>简答题</h4>
  <div id="essayQuestionList">
  <c:set var="essayQuestionCount" value="1"/>
    <c:forEach items="${essayList}" var="essays">
        <input type="hidden" id="${essays.id}_essayNo" name="essay.essayNo" value="${essays.essayNo}">
      ${essayQuestionCount}.<input type="text" class="inputStyle"  id="${essays.id}_essayQuestion" name="essay.question" value="${essays.question}"> <br>
      正确答案：<%--
  Created by IntelliJ IDEA.
  User: zhanhengkitt
  Date: 2015/12/17
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
        <textarea  rows="5" id="${essays.id}_essayResult" name="essay.answer">${essays.answer}</textarea>
      <br>
        <a href="${pageContext.request.contextPath}/examOnline/deleteEssay_Action?examId=${exam.id}&questionNo=${essays.id}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%--<a href="${pageContext.request.contextPath}/examOnline/forwardUpdateEssay_Action?examId=${exam.id}&questionNo=${essays.id}">修改</a><br>--%>
        <a onclick="updateEssay(${essays.id})">修改</a>
        <%--<button onclick="updateEssay(${essays.id})">修改</button>--%><br>
        <c:set var="essayQuestionCount" value="${essayQuestionCount+1}"/>
    </c:forEach>
  </div>


</div>
</div>


</body>
</html>
