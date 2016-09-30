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
<title>精品课堂管理后台</title>

<style>
        .sel_btn,.sel_btn_important{
            height: 21px;
            line-height: 21px;
            padding: 0 11px;
            /*color: #fff;*/
            display: inline-block;
            text-decoration: none;
            font-size: 12px;
            outline: none;
        }
        .sel_btn_important{
            background: #FF211E;
            border: 1px #26bbdb solid;
        }
    </style>

  </head>
  
  <body>
 <jsp:include page="/WEB-INF/admin/adminheader.jsp"></jsp:include>
  <div class="bigright">
    <div class="rightinfo">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>班级</th><th>下载</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${classRoomArray}" var="classRoom">
        <tr>
	    <th>${classRoom}</th>
	    <th><a class="sel_btn" href="${pageContext.request.contextPath }/test/hwDownloadAction.action?classRoom=${classRoom}">下载该班级同学的作业</a></th>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    <div style="margin-top:50px;">
      <a class="sel_btn_important" href="${pageContext.request.contextPath }/test/seehomework_deleteALl.action" onClick="return confirm('确定要删除这一届所有的作业吗？')">
      删除这一届所有的作业</a>
    </div>
   </div>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
  </body>
</html>