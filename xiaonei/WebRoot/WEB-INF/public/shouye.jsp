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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shouye.css" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/javascript/jquery1.42.min.js"></script>
  <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/javascript/jquery.SuperSlide.2.1.1.js"></script>
  <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/javascript/common.js"></script>
  <script type="text/javascript">
  window.onload=function()
{
    var myScroll=new Scroll();
    myScroll.toScroll();
};

function Scroll()
{
    this.oScroll=document.getElementById("Scroll");
    this.oList=document.getElementById("imgList");
    this.Li=this.oList.getElementsByTagName("li")[0];
    this.timer=null;

    //this.Width=1350;
    this.Width=this.Li.offsetWidth*5;
}

Scroll.prototype.toScroll=function()
{
    var _this=this;
    this.move();
    this.loop();
    this.oScroll.onmousemove=function(){
        _this.stopMove();
    };
    this.oScroll.onmouseout=function(){
        _this.move();
    };
}

Scroll.prototype.move=function()
{
    var _this=this;
    this.timer=setInterval( function(){ _this.loop(); },20 )/*通过闭包获得当前作用域*/
}

Scroll.prototype.stopMove=function()
{
    var _this=this;
    clearInterval(_this.timer);
}

Scroll.prototype.loop=function()
{
    this.oList.style.left=this.oList.offsetLeft-0.5+"px";
    if(this.oList.offsetLeft<=-(this.Width))
    {
        this.oList.style.left=0;
    }
}



</script>


  </head>
  
  <body>
  <div class="bigbigdiv">
  <jsp:include page="/WEB-INF/public/header.jsp"></jsp:include>
    <div class="shouye">
    <div class="left">
    <table class="tablenews">
    <tr><td class="tablenewstr1"></td><td class="tablenewstr2"><a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=31&navigationbarid=6&templet=1"><img src="${pageContext.request.contextPath}/images/more.jpg" border="0"></a></td></tr>
     <c:forEach items="${kecheng}" var="news">
    <tr><td class="tablenewstr1"><div class="text1"><a  class="tablenewstr1a" href="${pageContext.request.contextPath}/test/gotofourth_gotofourth.action?flag=${news.flag}&newsid=${news.id}&newsTypeid=${news.newstype.id}&navigationbarid=${news.newstype.navigationbar.id}">${news.newsTitle}</a></div></td>
    <td class="tablenewstr2"><div class="text2"><font class="font1">${news.addtime}</font></div></td></tr>
    </c:forEach>
    </table>
    <div class="jianli">
    <table>
    <tr><td class="tablenewstr1"></td><td class="tablenewstr2"><a href="${pageContext.request.contextPath }/test/word_getteacher.action?newsTypeid=10&navigationbarid=2"><img src="${pageContext.request.contextPath}/images/more.jpg" border="0"></a></td></tr>
    </table>
    <table>
    <tr><td class="tablejianlitd3"> <a href="${pageContext.request.contextPath }/test/word_gooneteacher.action?teacherid=1&navigationbarid=2&newstypeid=11"><img src="${pageContext.request.contextPath}/images/李广丽222.jpg"/></a></td>
    <td class="tablejianlitd4"><font class="font1">个人简介：李广丽，吉林省延边人，理学博士，教授，博士研究生导师，广东省“千百十”工程省级培养...</font></td><tr>
    </table>
    </div>
    <div class="lianjie">
    <table>
    <tr><td class="tablejianlitd5"><a href="${pageContext.request.contextPath}/test/liuyan_goliuyan.action?flag=1"><img src="${pageContext.request.contextPath }/images/l_608.jpg"></a></td><tr>
    <tr><td class="tablejianlitd5"><a href="${pageContext.request.contextPath}/testOnline/login_Action?flag=2"><img src="${pageContext.request.contextPath }/images/l_609.png"></a></td><tr>
    <tr><td class="tablejianlitd5"><a href="${pageContext.request.contextPath}/test/word_gohomework.action?flag=3"><img src="${pageContext.request.contextPath }/images/l_610.jpg"></a></td><tr>
    <tr><td class="tablejianlitd5"><a href="${pageContext.request.contextPath}/test/login_gologin.action?flag=4"><img src="${pageContext.request.contextPath }/images/l_6094.png"></a></td><tr>
    </table>
    </div>
    </div>
    <div class="right">
    <div class="right12">
    <div class="right121">
    <div class="right1211">
    <table> 
    <tr><td class="tablejianlitd6"></td><td class="tablejianlitd7"><a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=1&navigationbarid=1"><img src="${pageContext.request.contextPath}/images/more.jpg" border="0"></a></td></tr>
    </table>
    <div class="right1211jianjie">
    <font class="font1">
    <p>&nbsp;&nbsp;&nbsp;&nbsp;《水产动物生理学》是研究水产动物机体生命活动规律的科学，是水产养殖专业的重要专业基础课程，分理论教学和实验教学两部分。理论教学主要以水产动物，特别是鱼类的器官生理系统为主线，包括血液、循环、呼吸、消化、代谢、排泄、神经系统、内分泌、生殖等，重点介绍各系统的主要生理功能、
       活动规律、调节及有关机理，并适当使学生了解相关研究成果的发展历史，了解学科发展动态，跟进学科的最新进展以及未来前景。实验教学主要结合理论教学内容，通过实验验证生理学的基本原理，或根据基本的概念和原理，进行一些生理学问题的探究。本部分的教学有助于锻炼学生的实际操作能力、解决在科学研究实验中随时出现的问题的能力。...
       <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=1&navigationbarid=1" style="color:#FF0000">更多&gt;&gt;</a></p>
    </font>
    </div>
    </div>
     <div class="right1212">
     <table>
     <tr class="tablejianlitd89"><td class="tablejianlitd8"><a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=15&navigationbarid=3&templet=3">一、课程概况</a></td><td class="tablejianlitd9"><font class="font1">2015-05-19</font></td></tr>
          <tr class="tablejianlitd89"><td class="tablejianlitd8"><a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=1&navigationbarid=1">二、课程简介</a></td><td class="tablejianlitd9"><font class="font1">2015-05-19</font></td></tr>
     
          <tr class="tablejianlitd89"><td class="tablejianlitd8"><a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=3&navigationbarid=1">三、课程特色</a></td><td class="tablejianlitd9"><font class="font1">2015-05-19</font></td></tr>
     
          <tr class="tablejianlitd89"><td class="tablejianlitd8"><a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=5&navigationbarid=1">四、教学目标</a></td><td class="tablejianlitd9"><font class="font1">2015-05-19</font></td></tr>
     
          <tr class="tablejianlitd89"><td class="tablejianlitd8"><a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=6&navigationbarid=1">五、教学内容</a></td><td class="tablejianlitd9"><font class="font1">2015-05-19</font></td></tr>
     </table>
     </div>
    </div>
    <div class="right122">
    <table>
    <tr><td class="tablenewstr10"></td><td class="tablenewstr11"><a href="${pageContext.request.contextPath }/test/word_getteacher.action?newsTypeid=11&navigationbarid=2"><img src="${pageContext.request.contextPath}/images/more.jpg" border="0"></a></td></tr>
    </table>
<div class="jslunbotu">
    <div class="zhujiangjiaoshi">
    <div class="zhujiangdiv">
    <a href="${pageContext.request.contextPath }/test/word_gooneteacher.action?teacherid=5&navigationbarid=2&newstypeid=11"><img src="${pageContext.request.contextPath }/images/师尚丽身份证.jpg"/></a>
    </div><br><br><br>&nbsp;姓名：师尚丽<br>&nbsp;出生...</div>
    <div class="zhujiangjiaoshi"><div class="zhujiangdiv">
    <a href="${pageContext.request.contextPath }/test/word_gooneteacher.action?teacherid=2&navigationbarid=2&newstypeid=11"><img src="${pageContext.request.contextPath }/images/邓思平照片.jpg"/></a>
    </div><br><br><br>&nbsp;姓名：邓思平<br>&nbsp;出生...</div>
    <div class="zhujiangjiaoshi"><div class="zhujiangdiv">
    <a href="${pageContext.request.contextPath }/test/word_gooneteacher.action?teacherid=3&navigationbarid=2&newstypeid=11"><img src="${pageContext.request.contextPath }/images/吴天利身份证照.jpg"/></a>
    </div><br><br><br>&nbsp;姓名：吴天利<br>&nbsp;出生...</div>
    </div>
    </div>
    </div>
    <div class="right13">
    <table>
    <tr><td class="tablenewstr12"></td><td class="tablenewstr13"><a href="${pageContext.request.contextPath }/test/word_getteacher.action?newsTypeid=9&navigationbarid=1"><img src="${pageContext.request.contextPath}/images/more.jpg" border="0"></a></td></tr>
    </table>
    <div class="sblunbotu">
    
		<div class="picMarquee-left">
			<div class="bd">
				<ul class="picList">
				<c:forEach items="${carousel}" var="carousel">
					<li>
						<div class="pic"><a href="${pageContext.request.contextPath }/test/word_gooneteacher.action?teacherid=${carousel.id}&navigationbarid=${carousel.newstype.navigationbar.id}&newstypeid=${carousel.newstype.id}">
    <img src="${pageContext.request.contextPath }/images/${carousel.pictureurl}"/></a></div>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<script type="text/javascript">
		jQuery(".picMarquee-left").slide({mainCell:".bd ul",autoPlay:true,effect:"leftMarquee",vis:6,interTime:50});
		</script>
    </div>
    </div>                            
    </div>
    </div>
    <jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
    </div>
  </body>
</html>