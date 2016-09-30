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

</head>
<body>
<div class="login" style="margin-top:50px;">
    
     <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" tabindex="7">快速注册</a>
        <a class="switch_btn" id="switch_login" href="${pageContext.request.contextPath}/test/login_gologin.action" tabindex="8">返回登录</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
      <div class="web_qr_login" id="web_qr_login" style="display: block; height: 435px;">    

            <!--注册-->
            <div class="web_login" id="web_login">
               
               
               <div class="login-box">
    
            
			<div class="login_form">
			<!--  -->
				<form name="form2" id="regUser" accept-charset="utf-8"  action="${pageContext.request.contextPath }/test/register_register.action" method="post">
	      <input type="hidden" name="to" value="reg"/>
		      		       <input type="hidden" name="did" value="0"/>
        <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">*请先阅读下面注册事项</div>
                <li>
                    <label for="user"  class="input-tips2">姓名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="username" class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="password" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="password2" maxlength="16" class="inputstyle2" />
                    </div>
                    
                </li>
                
                <li>
                 <label for="classnumber" class="input-tips2">学号：</label>
                    <div class="inputOuter2">
                       
                        <input type="text" id="classnumber" name="studentNo" maxlength="15" class="inputstyle2"/>
                    </div>
                   
                </li>
               <li>
                 <label for="classname" class="input-tips2">班级：</label>
                    <div class="inputOuter2">
                       
                        <input type="text" id="classname" name="classname" maxlength="20" class="inputstyle2"/>
                    </div>
                   
                </li>
                
                <li>
                    <div class="inputArea">
                        <input type="submit" id="reg"  style="margin-top:10px;margin-left:85px;width:210px;"  class="button_blue"  value="注册"/>
                    </div>
                    
                </li><div class="cl"></div>
            </ul></form>
           </div>
           
            	</div>
               
            </div>
            <!--注册end-->
  </div>
    
</div>
<div class="jianyi"><h3>（1）注册班级时请使用简称，例如：生物工程1141的同学就写生工1141</h3></div>
<div class="jianyi"><h3>（2）若出现注册成功登录不了或者忘记密码，请使用不同的密码再注册一次</h3></div>
<div class="jianyi"><h3>（3）有极少数的浏览器不能支持输入中文，若出现这种情况，请到其它同学的电脑注册</h3></div>

<script type="text/javascript" language="javascript">
	$('#reg').click(function() {

		if ($('#user').val() == "") {
			$('#user').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
			return false;
		}
		if ($('#passwd').val() == "") {
			$('#passwd').focus();
			$('#userCue').html("<font color='red'><b>×密码不能为空</b></font>");
			return false;
		}
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		}
                if ($('#classnumber').val() == "") {
			$('#classnumber').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×学号不能为空</b></font>");
			return false;
		}
               if ($('#classname').val() == "") {
			$('#classname').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×班级不能为空</b></font>");
			return false;
		}
	});
  </script>

</body></html>