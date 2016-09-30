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
  <script type="text/javascript" language="javascript">
  function check(form)
  {
    var str=form.image.value;
  if(str=='')
  {
  alert("请选择文件！");
  form.image.focus();
  return false;
  }
  else{
      var strRegex = "(.doc)$";
      var re=new RegExp(strRegex);
     if (re.test(str.toLowerCase())){
        return true;
     } else{
        alert("请使用doc的文档格式！"); 
      return false;
  }
  }
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
    <div class="uploaddiv">
        ${student.className}&nbsp;${student.studentName}
    <form action="${pageContext.request.contextPath}/test/word_uploadhomework.action" enctype="multipart/form-data" method="post" >
          <input type="text" value="${tphw.hwname}" name="homeName" readonly="true"/>
   <input type="file" name="image"/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="submit" value="提交作业" onclick="return check(this.form)"/>
   </form>
   <h1 style="color:red;font-size:30px;">${message}</h1>
  作业要求：
 <br><font color="red">注意：上传格式必须为word文档(doc格式!,不要docx格式)</font><br>
 <texctarea class="hwtextarea" readonly="readonly" >${teacherphw.ewquire}</textarea>
    </div>
    </div>
    </div>
    </div>
    <jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
    </div>
  </body>
</html>


