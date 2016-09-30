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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comment.css" type="text/css"/>
   <link href="${pageContext.request.contextPath }/css/contentcomm.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript">
  function check(form)
  {
  if((form.liuyan.value=='')||(form.liuyan.value=='留言...'))
  {
  alert("请输入留言！");
  return false;
  }
  return true;
  }
  </script> 
  
  <script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}

window.onload=function(){
	altRows('alternatecolor');
}
</script>


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
                <a href="${pageContext.request.contextPath}/test/liuyan_goliuyan.action">留言</a>
            </td>
        </tr>
    </table>
    </div>
    </div>
    </div>
    <div class="right"  style="float:left;text-align:left;">
    <div class="righttop">
    <div class="righttopmap">
        您当前的位置:&nbsp;首页&nbsp;»&nbsp;互动平台&nbsp;»&nbsp;留言
    </div>
    </div>
    <div class="commentbig">
    <div class="commentmiddle">
    
  <table>
  <c:forEach items="${list}" var="Comments">
  <tr><td class="studentname"><font class="font25">${Comments.student.className}&nbsp;${Comments.student.studentName}:</font></td><td class="studentcomment"><font class="font25">${Comments.comments}</font></td>
  <td class="studenttime"><font class="font25">${Comments.commentsTime}</font></td></tr>
  <c:choose>
  <c:when test="${Comments.replyornot==0}">
  <tr><td class="studentname">未回复:</td>
  </c:when>
  <c:otherwise>
  <tr><td class="studentname">已回复</td>
  <c:forEach items="${Comments.commentsreplies}" var="commentsreply" begin="0" end="0">
  <td class="studentcomment"><font class="font25">${commentsreply.reply}</font></td><td class="studenttime"><font class="font25">${commentsreply.replyTime}</font></td></tr>
  </c:forEach>
  </c:otherwise>
  </c:choose>
  </c:forEach>
  </table>
    <div class="fenye">
  <div class="manu">
    <a href="${pageContext.request.contextPath }/test/liuyan_goliuyan.action?pageNow=1" style="font-weight:normal;display:inline-block;">首页</a>
            <c:forEach var="i" begin="1" end="${pageCount}">
            <span style="font-weight:normal;display:inline-block;"><a href="${pageContext.request.contextPath }/test/liuyan_goliuyan.action?pageNow=${i}">${i}</a></span>
            </c:forEach>
    <a href="${pageContext.request.contextPath }/test/liuyan_goliuyan.action?pageNow=${pageCount}" style="font-weight:normal;display:inline-block;">尾页</a>
</div>
  </div>
    </div>
    <div class="commentbottom">
    <form action="${pageContext.request.contextPath }/test/liuyan_liuyan.action" method="post">
    <textarea class="mytextarea" rows="3" name="liuyan" cols="86"></textarea><br>
    <input type="submit" value="留言" class="liuyanbuttom" name="submit1" onclick="return check(this.form)"/>
    </form>
   </div>
    </div>
    </div>
    </div>
    <jsp:include page="/WEB-INF/public/foot.jsp"/>
    </div>
  </body>
</html>
