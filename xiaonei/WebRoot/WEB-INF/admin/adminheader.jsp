       <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<link href="${pageContext.request.contextPath}/css/adminstyle.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>精品课程管理后台</div>
    
    <dl class="leftmenu">

     <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/images/leftico02.png" /></span>用户管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/test/login_goshouye.action">首页</a><i></i></li>
<li><cite></cite><a href="${pageContext.request.contextPath }/test/login_outlogin.action">退出</a><i></i></li>
        </ul>     
    </dd> 
        
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/images/leftico01.png" /></span>内容管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/test/upload_goloadppt.action?flag=2">文章发布</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/test/upload_goloadppt.action?flag=1">文件发布</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/test/content_gocontent.action">内容列表</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/images/leftico02.png" /></span>考试管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/examOnline/findOnlineTestStudent_Action">所有考生</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/examOnline/showExam_Action">试题列表 </a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/examOnline/submitList_Action">提交列表</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="${pageContext.request.contextPath}/images/leftico03.png" /></span>作业管理</div>
    <ul class="menuson">
        <li><cite></cite> <a href="${pageContext.request.contextPath}/test/seehomework_publishhw.action?flag=2">布置作业</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/test/seehomework_gohomework.action">作业列表</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/test/seehomework_gocheckhomework.action">验收作业</a><i></i></li>
    </ul>    
    </dd>  
    

    <dd><div class="title"><span><img src="${pageContext.request.contextPath}/images/leftico03.png" /></span>留言管理</div>
    <ul class="menuson">
        <li><cite></cite> <a href="${pageContext.request.contextPath }/test/liuyan_gomanagerliuyan.action">留言列表</a><i></i></li>
    </ul>    
    </dd>  
    
    
    </dl>
    
</body>
</html>