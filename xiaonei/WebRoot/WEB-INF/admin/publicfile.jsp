<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>精品课堂管理后台</title>


  
  <script type="text/javascript"> 

      window.onbeforeunload = function(){
      return "必您确定要退出页面吗？";

       } 
</script>
  </head>
  
  <body>
  <jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
  <div class="bigright">
  <div style="margin-left:50px;float:left;width:900px;">
  <div style="float:left;margin-top:20px;width:800px;">
 <h3>1.请不要上传超过100M的文件<br>2.视频上传时间稍长，请耐心等待</h3>
 </div>
<div  style="margin-top:30px;float:left;width:800px;">
   <form action="${pageContext.request.contextPath}/test/upload_uploadppt.action" enctype="multipart/form-data" method="post">
    <label>类别</label>
   <select name="flag" >
   <option value="1">ppt</option>
   </select>
     <label >目录</label>
   <select name="newsTypeid" > 
   <option value="18">授课课件</option>
   <option value="20">实践教学</option>
   </select>
      <label >文件输入</label>
      <input type="file"  name="image"/>
   <input type="submit"  class="btn"  value="上传"/>
   </form>
</div>

<div style="float:left;margin-top:20px;width:800px;">
   <form action="${pageContext.request.contextPath}/test/upload_updateword.action" enctype="multipart/form-data" method="post" >
    <label>类别</label>
   <select name="flag">
   <option value="2">word/文档</option>
   </select>
       <label>目录</label>
   <select name="newsTypeid" >
   <option value="15">教学大纲</option>
   <option value="16">教学日历</option>
   <option value="31">教学公告</option>
   <option value="33">申报表</option>
   </select>
      <label>文件输入</label>
   <input type="file" name="image"/>
   <input type="submit"  class="btn"  value="上传"/>
   </form>
</div>

 <div style="float:left;margin-top:20px;width:800px;">
   <form action="${pageContext.request.contextPath}/test/upload_uploadvideo.action" enctype="multipart/form-data" method="post" >
  <label >类别</label>
<select name="flag" >
   <option value="3">video/视频</option>
   </select>
      <label>   目录</label>
<select name="newsTypeid" >
   <option value="19">教学录像</option>
   <option value="26">专题讲座库</option>
   </select>
      <label>文件输入</label>
   <input type="file" name="image"  />
   <input type="submit"  class="btn" value="上传"/>
   </form>
   </div>
<h1>${message}</h1>

   <div style="float:left;margin-top:20px;width:800px;">
    <form action="${pageContext.request.contextPath}/test/special_addone.action" enctype="multipart/form-data" method="post" >
      <label>   目录</label>
    <select name="newsTypeid">
   <option value="11">教学团队</option>
   <option value="9">教材与参考资料</option>
   </select>
  名称：<input type="text" class="dfinput"  name="teachername"/><br>
<textarea  name="intro" rows="10" cols="50"></textarea>
<br>
      <label >文件输入</label>
   <input type="file" name="image"  style="height:30px;"/><br>
 <input type="submit" class="btn"  value="添加"/>
  </form>
  </div>
  </div>
  </div>
  </body>
</html>
