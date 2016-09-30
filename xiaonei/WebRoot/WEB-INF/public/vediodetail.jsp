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
    <link href="${pageContext.request.contextPath }/css/contentcomm.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"/>
   <link href="${pageContext.request.contextPath }/css/vediodetail.css" rel="stylesheet" type="text/css"/>
  
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
  <c:forEach items="${al}" var="newsType">
    <tr>
           <td class="leftbottomtd1">
           <c:choose>
           <c:when test="${newsType.id==11||newsType.id==9}">  
    
                <a href="${pageContext.request.contextPath }/test/word_getteacher.action?newsTypeid=${newsType.id}&navigationbarid=${newsType.navigationbar.id}">${newsType.newsTypeName}</a>

        </c:when>
           <c:when test="${newsType.templet=='1'}">
                <a href="${pageContext.request.contextPath }/test/word_getword.action?newsTypeid=${newsType.id}&navigationbarid=${newsType.navigationbar.id}">${newsType.newsTypeName}</a>
           </c:when>      
           <c:otherwise>
                <a href="${pageContext.request.contextPath }/test/go_getthirdbar.action?newsTypeid=${newsType.id}&navigationbarid=${newsType.navigationbar.id}&templet=${newsType.templet}">${newsType.newsTypeName}</a>
           </c:otherwise>
           </c:choose>
            </td>
        </tr>
        </c:forEach>
    </table>
    </div>
    </div>
    </div>
    <div class="right">
    <div class="righttop">
    <div class="righttopmap">
         您当前的位置:&nbsp;首页&nbsp;»&nbsp;${newstype.navigationbar.navigation}&nbsp;»&nbsp;${newstype.newsTypeName}
    </div>
    </div>
    <div class="vediodetailbig">
    <div class="vediodetailcenter">
<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="490" height="390">

<param name="movie" value="${pageContext.request.contextPath}/uploadvideo/Flvplayer.swf">

<param name="quality" value="high">

<param name="allowFullScreen" value="true" />

<param name="FlashVars" value="vcastr_file=${pageContext.request.contextPath}/uploadvideo/${vedio.news.id}.flv" />

<embed src="${pageContext.request.contextPath}/uploadvideo/Flvplayer.swf" allowFullScreen="true" FlashVars="vcastr_file=${pageContext.request.contextPath}/uploadvideo/${vedio.news.id}.flv" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="490" height="390"></embed>

</object>

</div></div></div></div>
 <jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
 </div>
</body>
</html>

 
