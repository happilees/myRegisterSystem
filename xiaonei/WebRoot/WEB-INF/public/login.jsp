<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>水产学院精品课程学生登录</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/jquery1.42.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/jquery.md5.js"></script>
<link href="${pageContext.request.contextPath }/css/login2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">

  </script>
</head>
<body>
<h1>水产学院欢迎同学们</h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" tabindex="7">快速登录</a>
        <a class="switch_btn" id="switch_login" href="${pageContext.request.contextPath}/test/login_goregister.action" tabindex="8">还未注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 285px;">    

            <!--登录-->
            <div class="web_login" id="web_login">
               
               
               <div class="login-box">
    
            
			<div class="login_form">
				<form action="${pageContext.request.contextPath }/test/login_checklogin.action?flag=${flag}"  name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post"><input type="hidden" name="did" value="0"/>
               <input type="hidden" name="to" value="log"/>
               <div id="userCue" class="cue">如果无法登录，请用不同的密码再次注册</div>
                <div class="uinArea" id="uinArea">
                <label class="input-tips" for="u">学号：</label>
                <div class="inputOuter" id="uArea">
                    
                    <input type="text" id="u" name="username" class="inputstyle"/>
                </div>
                </div>
                <div class="pwdArea" id="pwdArea">
               <label class="input-tips" for="p">密码：</label> 
               <div class="inputOuter" id="pArea">
                    
                    <input type="password" id="p" name="password" class="inputstyle"/>
                </div>
                </div>
               
                <div style="padding-left:50px;margin-top:20px;"><input type="submit" id="reg"  value="登 录" style="width:200px;" class="button_blue"/></div>
               <br><div style="width:240px;height:30px;text-align:center;border:0;margin-top:20px;color:red;">${message}</div>
              </form>
           </div>
           
            	</div>
               
            </div>
            <!--登录end-->
  </div>
</div>
<script type="text/javascript" language="javascript">
	$('#reg').click(function() {

		if ($('#u').val() == "") {
			$('#u').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
			return false;
		}
		if ($('#p').val() == "") {
			$('#p').focus();
			$('#userCue').html("<font color='red'><b>×密码不能为空</b></font>");
			return false;
		}
	});
  </script>
</body></html>