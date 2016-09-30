<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/header.css" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/javascript/common.js"></script>
  <style type="text/css"> 
* { 
padding:0; 
margin:0; 
} 

#navigation, #navigation li ul { 
list-style-type:none; 
} 
#navigation { 
border-top:3px solid #6495ED;
border-left:2px solid #6495ED;
border-right:2px solid #6495ED;
} 
#navigation li { 
float:left; 
text-align:center;
position:relative; 
} 
#navigation li a:link { 
display:block; 
text-decoration:none; 
color:#000; 
width:92px; 
height:30px; 
line-height:30px; 
/*border:1px solid #fff;*/ 
border-width:1px 1px 0 0; 
/*background:#ffffff;*/
padding-left:0px; 
} 
#navigation li a:visited{
display:block; 
text-decoration:none; 
color:#000; 
width:90px; 
height:30px; 
line-height:30px; 
/*border:1px solid #fff;*/ 
border-width:1px 1px 0 0; 
background:#6495ED;
padding-left:0px; 
}
#navigation li a:hover { 
color:#ff0000;
background:#ffffff; 
} 
#navigation li ul li a:link{ 
color:#ffffff; 
background:#0484f1; 
}
#navigation li ul li a:visited{ 
color:#ffffff; 
background:#0484f1; 
}
#navigation li ul li a:hover{ 
color:#ffffff; 
background:#ff7f50; 
} 
#navigation li ul { 
display:none; 
position:absolute; 
top:30px; 
left:0; 
width:120px; 
} 
#navigation li ul li ul { 
display:none; 
position:absolute; 
top:0px; 
left:130px; 
margin-top:0; 
margin-left:1px; 
width:120px; 
} 
</style> 
<script type="text/javascript"> 
function displaySubMenu(li) { 
var subMenu = li.getElementsByTagName("ul")[0]; 
subMenu.style.display = "block"; 
} 
function hideSubMenu(li) { 
var subMenu = li.getElementsByTagName("ul")[0]; 
subMenu.style.display = "none"; 
} 
</script>
  </head>
  <body>
  <div class="headerdiv">
  <div class="loginornot">
  <div class="message">
  <c:choose>
  <c:when test="${student!=null}">
  <font color="blue">欢迎&nbsp;${student.studentName}&nbsp;同学</font>|
  <a href="${pageContext.request.contextPath}/test/login_killlogin.action">注销</a>
  </c:when>
  <c:otherwise>
  <font color="red">您还未登录!</font>|<a href="${pageContext.request.contextPath}/test/login_gologin.action">登录</a>|
  <a href="${pageContext.request.contextPath}/test/login_goregister.action">注册</a>
  </c:otherwise>
  </c:choose>
  </div>
  </div>
  <div class="header"></div>
    <div class="daohang"> 
<ul id="navigation"> 
<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"  style="margin-left:7px;"> 
<a href="${pageContext.request.contextPath}/test/goshouye_gotoshouye.action">首页</a> 
</li>  
<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
<a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=2&navigationbarid=1">课程介绍</a> 
<ul> 
 <li>
 <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=1&navigationbarid=1">课程简介</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=2&navigationbarid=1">历史沿革</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=3&navigationbarid=1">课程特色</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=4&navigationbarid=1">授课对象</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=5&navigationbarid=1">教学目标</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=6&navigationbarid=1">教学内容</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=7&navigationbarid=1">教学方法与手段</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=8&navigationbarid=1">教学效果</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getteacher.action?newsTypeid=9&navigationbarid=1">教材与参考资料</a>
            </li>
</ul> 
</li> 
<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
<a href="${pageContext.request.contextPath }/test/word_getteacher.action?newsTypeid=10&navigationbarid=2">教学队伍</a> 
<ul> 
<li>
                <a href="${pageContext.request.contextPath }/test/word_getteacher.action?newsTypeid=10&navigationbarid=2">课程负责人</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getteacher.action?newsTypeid=11&navigationbarid=2">教学团队</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=12&navigationbarid=2&templet=1">教师培养</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=13&navigationbarid=2&templet=1">教学改革与研究</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=14&navigationbarid=2&templet=1">教改论文</a>
            </li>
</ul> 
</li>  
<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
<a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=15&navigationbarid=3&templet=3">教学资源</a> 
<ul> 
<li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=15&navigationbarid=3&templet=3">教学大纲</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=16&navigationbarid=3&templet=3">教学日历</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=17&navigationbarid=3">授课教案</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=18&navigationbarid=3&templet=1">授课课件</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=19&navigationbarid=3&templet=4">教学录像</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=20&navigationbarid=3&templet=1">实践教学</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=21&navigationbarid=3">重点难点</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=23&navigationbarid=3&templet=1">课外作业</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=24&navigationbarid=3&templet=6">资格考试</a>
            </li>
</ul> 
</li> 
<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
<a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=25&navigationbarid=4&templet=1">拓展资源</a> 
<ul> 
<li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=25&navigationbarid=4&templet=1">案例库</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=26&navigationbarid=4&templet=4">专题讲座库</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=27&navigationbarid=4&templet=6">网络资源</a>
            </li>
</ul> 
</li> 
<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
<a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=29&navigationbarid=5&templet=1">教学评价</a> 
<ul> 
<li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=29&navigationbarid=5&templet=1">校内专家评价</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=30&navigationbarid=5&templet=1">校外专家评价</a>
            </li>
</ul> 
</li> 
<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
<a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=31&navigationbarid=6&templet=1">咨询中心</a> 
<ul> 
 <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=31&navigationbarid=6&templet=1">课程公告</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=32&navigationbarid=1">教学活动</a>
            </li>
</ul> 
</li> 
<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
<a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=33&navigationbarid=7&templet=3">申报材料</a> 
<ul> 
 <li>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=33&navigationbarid=7&templet=3">申报表</a>
            </li>
</ul> 
</li> 

</ul> 
    </div>
    </div>
  </body>
</html>
