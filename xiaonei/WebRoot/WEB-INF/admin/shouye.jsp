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


</head>

<body>


    <jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
<div class="rightdiv">
<div style="margin-top:50px;margin-left:50px;float:left;">
<p style="line-height:30px;">

后台使用说明书<br><br>



1.文件发布可以发布ppt、视频、word文档（<font style="color:red;">只支持doc，不支持docx</font>），和教师个人资料、教材与参考资料；<br>
2.进入文章发布界面后，在文字编辑器的下面一行又目录的选择框，可以发布选择框内任意目录的内容；<br>
3.内容列表包含所有的内容，可对任何内容进行修改（<font style="color:red;">视频，ppt不能修改，word文档可以预览，若要修改内容，请先删除后再在文件发布中重新上传</font>）和删除。<br>
4.布置作业可以不知给学生的作业，布置的作业将是网站作业提交系统的作业。<br>
5.作业列表中显示各种作业的名称，点击某个作业的查看详情会显示某个作业名称的所有学生的作业，可以预览。<font style="color:red;">注：学生的作业格式为word文档doc格式</font><br>

6.试题列表包含所有的试卷，可以在上面一行添加新的试卷，也可以对已有的试卷进行编辑，进入编辑后，可以修改试题、删除试题、添加试题等等；<br>
7.提交列表是学生课程测试和章节测试的提交的试卷。点击某张试卷后，会显示该试卷下学生的成绩；<br>
8.所有考生显示顾名思义，显示出所有考试学生的名字。<br>

9.留言管理显示所有留言学生的留言和老师的回复，若显示未回复，可点击未回复进行回复学生的留言。<br>
10.退出后台管理系统。<br>
</p>

</div>

</div>
</body>

</html>