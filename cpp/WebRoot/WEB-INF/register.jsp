<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>C++团队招新</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
    <link href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'> 
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>

	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/registerstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css.map"/>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" style="background-color:#2C2C2C">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>                        
				</button>
			</div>   
			<div class="single-page-nav sticky-wrapper" id="tmNavbar">
				<ul class="nav navbar-nav">
					<li><a href="#section1" style="background-color:#2C2C2C;border:none;"><img src="img/reallogo.png" style="height:20px;width:20px;"/></a></li>
					<li><a href="#section2" style="background-color:#2C2C2C;border:none;">团队介绍</a></li>
					<li><a href="#section3" style="background-color:#2C2C2C;border:none;">方向</a></li>
					<li><a href="#section4" style="background-color:#2C2C2C;border:none;">报名</a></li>
				</ul>
			</div>   
		</div>
	</nav>    

	<div id="section1">
		<header id="header-area" class="intro-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<div class="header-content">
						 <c:choose>
                          <c:when test="${success!=null}">
                           <h1>${success}</h1>
                             </c:when>
                             <c:otherwise>
                             <img src="img/type.png"/>		
                             </c:otherwise>
                             </c:choose>								
						</div>
					</div>
				</div>
			</div>
		</header>
	</div>
	<div id="section2">
		<!-- End Feature Area -->
        
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>

		<!-- Start Blog Area -->
		<section id="blog-area" style="background-color:#F2F2F2">
			<div class="container" >
				<div class="row text-left inner" >	
						<div class="col-lg-12">
						 <div class=" text-center inner" >	
						<h1>团队介绍</h1>	
						</div>	
								<p class="lead">
								<ul>
								<li style="line-height:36px;text-index:2em;font-size:20px;">广东海洋大学信息学院C++软件开发团队成立于2014年1月，由信息学院正院长谢仕义带领。团队成员发展的方向有三个，分别是产品，技术和UI设计。
								技术方向下又细分了前端、后台、安卓、iOS、C++六大发展方向。在短短的两年时间里，我们获得包括“魅族互联网编程大赛总决赛一等奖 （武汉决赛区第一名）”、
								“中国软件杯总决赛二等奖（全国36强）”在内的6项国家级证书、3项省级证书和2项国家软件著作权。同时我们与广深珠港等地大量的企业成功实现对接，
								成功开发包括香港信贷协会官方软件、湖北东风商务汽车厂管理系统在内的多个项目。团队每年都有成员进入腾讯、开源中国等数一数二的互联网公司。同时，
								团队负责人在深圳创办以智能软件开发与智能软件运维为主的网络科技有限公司并已成功实现盈利。</li>
                                <li style="line-height:36px;text-index:2em;font-size:20px;">正直，进取，合作，创新是我们的价值观。注重团队成员的个人发展，让每一位成员都成为具有影响力的人是我们的管理理念。不断倾听和满足对接企业需求，与合作伙伴共同创业，共同成长，是我们的立根之本。</li>
                                <li style="line-height:36px;text-index:2em;font-size:20px;">永不满足，不断对自己提出新的更高的要求。不断追求高目标是团队的原动力。适应新的环境变化，追求高目标，全身心的投入和努力，使得看似不可能的事情成为可能，将目标变成现实。</li>
                                <li style="line-height:36px;text-index:2em;font-size:20px;">我们是Cpp软件开发团队，我们希望最具影响力的软件开发团队，期待你的加入。</li>
                              </ul>
                               </p>
							</div>
						</div>
					</div>
				</section>
				<!-- End Blog Area -->
			</div>
			<div id="section3">
				<!-- Start Services Area -->
				<section id="services-area" class="services-section">
					<div class="container">
						<div class="row">
							<div class="col-sm-12 text-center inner our-service">
								<div class="service">
									<h1>方向选择</h1>
									<p>同学们知道各个方向的具体信息吗？</p>
									</div>
								</div>
							</div>
						</div>
					</section>
					<!-- End Services Area -->

					<!-- Start Testimornial Area -->
					<section id="testimornial-area ">
						<div class="container">
							<div class="row text-center">
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
									<div class="testimonial-content  portfolio-item">
									<div class="portfolio-hover">
										<a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
										<img src="img/portfolio/chanpin.png" style="margin-top:50px;" alt="Image">
										</a>
										<h2>产品</h2>
										<p>产品经理是企业中专门负责产品管理的职位，负责调查并根据用户的需求，确定开发何种产品，选择何种技术、商业模式等。</p>
										<br>
									</div>
									<div id="cover" class="cover"></div>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
									<div class="testimonial-content   portfolio-item">
										<a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
										<img src="img/portfolio/yunying.png" style="margin-top:50px;"  alt="Image">
										</a>
										<h2>运营</h2>
										<p>运营就是对运营过程的计划、组织、实施和控制，是与产品生产和服务创造密切相关的各项管理工作的总称。</p>
										<br>
										<p id="redd"></p>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
									<div class="testimonial-content ">
										<a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
										<img src="img/portfolio/Android.png" style="margin-top:50px;"  alt="Image">
										</a>
										<h2>Android</h2>
										<p>Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，由Google公司和开放手机联盟领导及开发。</p>
										<br>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
									<div class="testimonial-content ">
										<a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
										<img src="img/portfolio/iOS.png" style="margin-top:50px;"  alt="Image">
										</a>
										<h2>iOS</h2>
                                         <p>iOS是由苹果公司开发的移动操作系统。</p>
										<br>
										<p id="dets"></p>
									</div>
								</div>
							</div>
							<div class="row text-center">
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
									<div class="testimonial-content ">
										<a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
										<img src="img/portfolio/UI.png" style="margin-top:50px;"  alt="Image">
										</a>
										<h2>UI</h2>
										<p>“UI”的本义是用户界面，是英文User和interface的缩写。从事对软件的人机交互、操作逻辑、界面美观的整体设计工作。</p>
										<br>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
									<div class="testimonial-content ">
										<a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
										<img src="img/portfolio/qianduan.png" style="margin-top:50px;" alt="Image"></a>
										<h2>前端</h2>
										<p>Web前端开发是从网页制作演变而来的，主要内容都是静态的，用户使用网站的行为也以浏览为主。</p>
										<br>
										<p id="redd"></p>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
									<div class="testimonial-content ">
										<a href="#portfolioModal7" class="portfolio-link" data-toggle="modal">
										<img src="img/portfolio/huotai.png" style="margin-top:50px;" alt="Image">
										</a>
										<h2>后台</h2>
										<p>这个报名小小的系统就是后台做的，后台主要处理业务逻辑，管理数据。像这种小应用对后台来说也就几分钟的事。</p>
										<br>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
									<div class="testimonial-content classicon">
										<a href="#portfolioModal8" class="portfolio-link" data-toggle="modal">
										<img src="img/portfolio/cplusplus.png" style="margin-top:50px;" alt="Image">
										</a>
										<h2>C++</h2>
										<p>C++是在C语言的基础上开发的一种面向对象编程语言；C++支持多种编程范式 －－面向对象编程、泛型编程和过程化编程。</p>
										<br>
										<p id="dets"></p>
									</div>
								</div>
							</div>												
						</div>
					</section>
					<!-- End Testimornial Area -->
				</div>
			<div id="section4">
					<!-- Start Contact Area -->
					<section id="contact-area" class="contact-section">
					 <div class="container">
        <div class="row">
        <div class="col-sm-12 text-center inner">
									<div class="contact-content">
										<h1>报名 form</h1>			
										</div>
									</div>
            <div class="col-lg-10 col-lg-offset-1">
                <div class="page-header text-center">
                    <h4 style="color:#000;">同学们，带*为必填的信息，方向可以多选</h4>
                </div>

                <form id="defaultForm" enctype="multipart/form-data" method="post" class="form-horizontal" action="student_register.action">

                    <div class="form-group">
                        <label class="col-lg-4 control-label">*姓名</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="name" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-4 control-label">*性别</label>
                        <div class="col-lg-5">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="sex" value="男" /> I am a boy
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="sex" value="女" /> I am a girl
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-4 control-label">*班级(简称)</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="classname" placeholder="eg：计科1141"/>
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-lg-4 control-label">*联系方式</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="phone" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-4 control-label">*QQ</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" name="qq" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-4 control-label">*方向</label>
                        <div class="col-lg-5">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="flag" value="产品" />产品
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="flag" value="运营" /> 运营
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="flag" value="Android" /> Android
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="flag" value="IOS" />iOS
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="flag" value="UI" /> UI
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="flag" value="前端" /> 前端
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="flag" value="后台" /> 后台
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="flag" value="C++" /> C++
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-4 control-label">*个人简介</label>
                        <div class="col-lg-5">
                            <textarea  class="form-control" name="introduce" rows="5" placeholder="eg：我以前接触过简单的代码..."></textarea>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-lg-4 control-label">技术能力</label>
                        <div class="col-lg-5">
                            <textarea  class="form-control" name="power" rows="5"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-4 control-label">作品上传</label>
                        <div class="col-lg-5">
                            <input type="file" class="form-control" name="file" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-6 col-lg-offset-4">
                            <button type="submit" class="btn btn-primary" name="signup" value="Sign up">点击报名</button>             
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
						</section>
						<!-- End Contact Area -->
					</div>

					<!-- Start Footer Area -->
					<footer id="footer-area">
							<hr>
							<div class="container">
								<div class="row">
									<div class="col-sm-12 text-center">             
										<p class="copy">Copyright © 2015 深圳云创时代网络科技有限公司 All Right Reserved<br>
                                        | <a href="http://www.miitbeian.gov.cn/">粤ICP备15102169号-1</a></p>
									</div>
								</div>
							</div>
						</footer>
						<!-- End Footer Area -->

               

						<script src="${pageContext.request.contextPath }/js/jquery-1.11.2.min.js"></script>
						<script src="${pageContext.request.contextPath }/js/jquery.scrollUp.min.js"></script> <!-- https://github.com/markgoodyear/scrollup -->
						<script src="${pageContext.request.contextPath }/js/jquery.singlePageNav.min.js"></script> <!-- https://github.com/ChrisWojcik/single-page-nav -->
						<script src="${pageContext.request.contextPath }/js/parallax.js-1.3.1/parallax.js"></script> <!-- http://pixelcog.github.io/parallax.js/ -->
                        <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
                        <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrapValidator.js"></script>
                        <script type="text/javascript" src="${pageContext.request.contextPath }/js/registersign.js"></script>
						<script>

    // HTML document is loaded. DOM is ready.
    $(function() {  

    // Parallax
        $('.intro-section').parallax({
        	imageSrc: 'img/realbackground.jpg',
        	speed: 0.2
        });
        $('.services-section').parallax({
        	imageSrc: 'img/1.jpg',
        	speed: 0.2
    	});
        $('.contact-section').parallax({
         	imageSrc: 'img/myrealbackground.jpg',
        	speed: 0.2
        });    

        // jQuery Scroll Up / Back To Top Image
        $.scrollUp({
                scrollName: 'scrollUp',      // Element ID
		        scrollDistance: 300,         // Distance from top/bottom before showing element (px)
		        scrollFrom: 'top',           // 'top' or 'bottom'
		        scrollSpeed: 1000,            // Speed back to top (ms)
		        easingType: 'linear',        // Scroll to top easing (see http://easings.net/)
		        animation: 'fade',           // Fade, slide, none
		        animationSpeed: 300,         // Animation speed (ms)		        
		        scrollText: '', // Text for element, can contain HTML		        
		        scrollImg: true            // Set true to use image		        
            });

        // ScrollUp Placement
        $( window ).on( 'scroll', function() {

            // If the height of the document less the height of the document is the same as the
            // distance the window has scrolled from the top...
            if ( $( document ).height() - $( window ).height() === $( window ).scrollTop() ) {

                // Adjust the scrollUp image so that it's a few pixels above the footer
                $('#scrollUp').css( 'bottom', '80px' );

            } else {      
                // Otherwise, leave set it to its default value.
                $('#scrollUp').css( 'bottom', '30px' );        
            }
        });

        $('.single-page-nav').singlePageNav({
        	offset: $('.single-page-nav').outerHeight(),
        	speed: 1500,
        	filter: ':not(.external)',
        	updateHash: true
        });

        $('.navbar-toggle').click(function(){
        	$('.single-page-nav').toggleClass('show');
        });

        $('.single-page-nav a').click(function(){
        	$('.single-page-nav').removeClass('show');
        });
        
    });
</script>
</body>
</html>