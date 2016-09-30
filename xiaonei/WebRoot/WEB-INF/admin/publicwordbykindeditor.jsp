<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>精品课堂管理后台</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/kindeditor/kindeditor-min.js" charset="UTF-8"></script>  
    <script type="text/javascript">  
        KE.show({  
             id : "editor",  
             width : "725px",  
             height : "200px",            
             resizeMode : 1,  
             allowFileManager : true,  
             /*图片上传的SERVLET路径*/  
             imageUploadJson : "${pageContext.request.contextPath}/uploadImage.html",   
             /*图片管理的SERVLET路径*/       
             fileManagerJson : "${pageContext.request.contextPath}/uploadImgManager.html",  
             /*允许上传的附件类型*/  
             accessoryTypes : "doc|xls|pdf|txt|ppt|rar|zip",  
             /*附件上传的SERVLET路径*/  
             accessoryUploadJson : "${pageContext.request.contextPath}/uploadAccessory.html"  
        });  
    </script>  
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/test/kindeditor_testkindeditor.action" method="post">
   <textarea id="editor" name="content" style="width: 800px; height: 200px; visibility: hidden;"></textarea> 
  <input type="submit" value="handin"/>
  </form>
  </body>
</html>
