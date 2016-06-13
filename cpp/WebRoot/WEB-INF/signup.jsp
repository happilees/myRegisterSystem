<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>C++</title>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath }/css/register.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath }/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://fonts.useso.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href='http://fonts.useso.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Open+Sans:400,400italic,700,600,600italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrapValidator.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css.map"/>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">


<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
   <div class="navbar-header page-scroll">
      <button type="button" class="navbar-toggle" data-toggle="collapse" 
         data-target="#example-navbar-collapse">
         <span class="sr-only">切换导航</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
      </button>
      
   </div>
   <div class="collapse navbar-collapse page-scroll" id="example-navbar-collapse">
      <ul class="nav navbar-nav">
         <li><a href="#page-top"><img src="img/111111.png" style="height:28px;width:28px;"/></a></li>
         <li><a href="#portfolio">各个方向</a></li>
         <li><a href="#contact">快来报名</a></li>
      </ul>
   </div>
</nav>


<!-- Header -->
<header>
  <div class="container">
    <div class="intro-text">
      <div class="intro-lead-in">Welcome To C++ team!</div>
      <c:choose>
      <c:when test="${success!=null}">
      <div class="intro-heading">${success}</div>
      </c:when>
      <c:otherwise>
      <div class="intro-heading">我 们 等 你 好 久 了</div>
      </c:otherwise>
      </c:choose>
      </div>
  </div>
</header>


<!-- Portfolio Grid Section -->
<section id="portfolio" class="bg-light-gray">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h2 class="section-heading">各个方向</h2>
        <div class="line"></div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-3 col-sm-6 portfolio-item"> <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
        <div class="portfolio-hover">
          <div class="portfolio-hover-content"> <i class="fa fa-search-plus fa-3x"></i> </div>
        </div>
        <img src="img/portfolio/4_0007s_0001_产品.png" class="img-responsive" alt="" > </a>
        <div class="portfolio-caption">
          <h4>产品</h4>
          <p class="text-muted">Claritas est etiam processus dynamicus</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 portfolio-item"> <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
        <div class="portfolio-hover">
          <div class="portfolio-hover-content"> <i class="fa fa-search-plus fa-3x"></i> </div>
        </div>
        <img src="img/portfolio/4_0006s_0001_运营.png" class="img-responsive" alt="" > </a>
        <div class="portfolio-caption">
          <h4>运营</h4>
          <p class="text-muted">Claritas est etiam processus dynamicus</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 portfolio-item"> <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
        <div class="portfolio-hover">
          <div class="portfolio-hover-content"> <i class="fa fa-search-plus fa-3x"></i> </div>
        </div>
        <img src="img/portfolio/4_0005s_0000_Android.png" class="img-responsive" alt="" > </a>
        <div class="portfolio-caption">
          <h4>Android</h4>
          <p class="text-muted">Claritas est etiam processus dynamicus</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 portfolio-item"> <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
        <div class="portfolio-hover">
          <div class="portfolio-hover-content"> <i class="fa fa-search-plus fa-3x"></i> </div>
        </div>
        <img src="img/portfolio/4_0004s_0000_iOS.png" class="img-responsive" alt="" > </a>
        <div class="portfolio-caption">
          <h4>ios</h4>
          <p class="text-muted">Claritas est etiam processus dynamicus</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 portfolio-item"> <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
        <div class="portfolio-hover">
          <div class="portfolio-hover-content"> <i class="fa fa-search-plus fa-3x"></i> </div>
        </div>
        <img src="img/portfolio/4_0003s_0000_UI.png" class="img-responsive" alt="" > </a>
        <div class="portfolio-caption">
          <h4>UI</h4>
          <p class="text-muted">Claritas est etiam processus dynamicus</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 portfolio-item"> <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
        <div class="portfolio-hover">
          <div class="portfolio-hover-content"> <i class="fa fa-search-plus fa-3x"></i> </div>
        </div>
        <img src="img/portfolio/4_0002s_0001_css.png" class="img-responsive" alt="" > </a>
        <div class="portfolio-caption">
          <h4>前端</h4>
          <p class="text-muted">Claritas est etiam processus dynamicus</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 portfolio-item"> <a href="#portfolioModal7" class="portfolio-link" data-toggle="modal">
        <div class="portfolio-hover">
          <div class="portfolio-hover-content"> <i class="fa fa-search-plus fa-3x"></i> </div>
        </div>
        <img src="img/portfolio/4_0001s_0001_后台.png" class="img-responsive" alt="" > </a>
        <div class="portfolio-caption">
          <h4>后台</h4>
          <p class="text-muted">无私地为各个方向提供数据，支撑项目的建设</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 portfolio-item"> <a href="#portfolioModal8" class="portfolio-link" data-toggle="modal">
        <div class="portfolio-hover">
          <div class="portfolio-hover-content"> <i class="fa fa-search-plus fa-3x"></i> </div>
        </div>
        <img src="img/portfolio/4_0000s_0001_t01086a75f21c139aa4.png" class="img-responsive" alt="" > </a>
        <div class="portfolio-caption">
          <h4>C++</h4>
          <p class="text-muted">Claritas est etiam processus dynamicus</p>
        </div>
      </div>
    </div>
  </div>
</section>



<!-- Team Section -->
<section id="contact">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h2 class="section-heading">快来报名</h2>
        <div class="line"></div>
      </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
                <form id="defaultForm" enctype="multipart/form-data" method="post" class="form-horizontal" action="student_register.action">
                    <div class="panel-group" id="steps">
                    <!-- Step 1 -->
                        <div class="panel panel-default">
                            <div class="panel-heading text-left">
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">基本信息</a></h4>
                            </div>
                            <div id="stepOne" class="panel-collapse collapse in">
                                <div class="panel-body">
                                                                
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">姓名:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="name" />
                                        </div>                                
                                    </div>
                                     <div class="form-group">
                                        <label class="col-lg-3 control-label">班级:</label>
                                         <div class="col-lg-9">
                                            <input type="text" class="form-control" name="classname" />
                                        </div>
                                    </div>
                                      <div class="form-group">
                                        <label class="col-lg-3 control-label">联系方式(长号):</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="phone" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">性别:</label>
                                        <div class="col-lg-9">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="sex" value="男" /> I am a boy
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="sex" value="女" />I am a girl
                                                </label>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">个人简介:</label>
                                        <div class="col-lg-9">
                                            <textarea class="form-control" name="introduce" rows="5"></textarea>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <!-- Step 2 -->
                        <div class="panel panel-default">
                            <div class="panel-heading text-left">
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepTwo"> 方向选择</a></h4>
                            </div>
                            <div id="stepTwo" class="panel-collapse collapse">
                            <div class="panel-body">

              <div class="form-group text-left">
                        
                        <div class="col-lg-4">
                            <div class="checkbox  text-left">
                                <label>
                                    <input type="checkbox" name="flag" value="产品" /> 产品
                                </label>
                            </div>
                            <div class="checkbox  text-left">
                                <label>
                                    <input type="checkbox" name="flag" value="运营" /> 运营
                                </label>
                            </div>
                            <div class="checkbox  text-left">
                                <label>
                                    <input type="checkbox" name="flag" value="Android" /> Android
                                </label>
                            </div>
                            <div class="checkbox  text-left">
                                <label>
                                    <input type="checkbox" name="flag" value="IOS" /> IOS
                                </label>
                            </div>
                            <div class="checkbox  text-left">
                                <label>
                                    <input type="checkbox" name="flag" value="UI" /> UI
                                </label>
                            </div>
                            <div class="checkbox  text-left">
                                <label>
                                    <input type="checkbox" name="flag" value="前端" /> 前端
                                </label>
                            </div>
                            <div class="checkbox  text-left">
                                <label>
                                    <input type="checkbox" name="flag" value="后台" /> 后台
                                </label>
                            </div>
                            <div class="checkbox  text-left">
                                <label>
                                    <input type="checkbox" name="flag" value="C++" /> C++
                                </label>
                            </div>
                        </div>
                    </div>         
                                </div>
                            </div>
                        </div>
            
                        <!-- Step 3 -->
                        <div class="panel panel-default">
                            <div class="panel-heading text-left">
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepThree">技术展示(可填可不填)</a></h4>
                            </div>
                            <div id="stepThree" class="panel-collapse collapse">
                                <div class="panel-body">
                                  

                                      <div class="form-group">
                                        <label class="col-lg-3 control-label">技术能力</label>
                                        <div class="col-lg-9">
                                            <textarea class="form-control" name="power" rows="5"></textarea>
                                        </div>
                                    </div>
                                    
                                      <div class="form-group">
                                        <label class="col-lg-3 control-label">作品上传</label>
                                        <div class="col-lg-9">
                                            <input type="file" name="file"  />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                          <div class="form-group">
                             <div class="col-lg-12">
                               <button type="submit" class="btn col-lg-12" name="signup" value="Sign up" style="background-color:#222222;color:#E7E7E7">点击报名</button>
                              </div>
                         </div>
                    </div>
                </form>
            </div>
    </div>
  </div>
</section>
<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-12"> <span class="copyright">Copyright © 2015 深圳云创时代网络科技有限公司 All Right Reserved<br><a href="http://www.miitbeian.gov.cn/">粤ICP备15102169号-1</a></span> </div>
    </div>
  </div>
</footer>

<!-- Portfolio Modals --> 
<!-- Use the modals below to showcase details about your portfolio projects! --> 

<!-- Portfolio Modal 1 -->
<div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="close-modal" data-dismiss="modal">
      <div class="lr">
        <div class="rl"> </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="modal-body "> 
            <!-- Project Details Go Here -->
            <h2>PM</h2>
            <p class="item-intro text-muted"> 传说中的产品经理</p>
            <img class="img-responsive img-centered" src="img/portfolio/portfolio1.jpg" alt="">
            <p class="text-left">产品经理（Product Manager）是企业中专门负责产品管理的职位，产品经理负责调查并根据用户的需求，确定开发何种产品，选择何种技术、商业模式等。并推动相应产品的开发组织，他还要根据产品的生命周期，协调研发、营销、运营等，确定和组织实施相应的产品策略，以及其他一系列相关的产品管理活动。</p>
            <p class="text-left"> 产品经理角色其实就是对一个产品负根本责任的管理者。比如说老板是对公司负责，设计师是对他的设计负责，那产品经理就是对某个产品线/产品/或者是某一产品下的部分（可以看成子产品）负根本责任。那怎么个负责法呢？就是你需要根据上头的公司战略，协调多方资源，推动这个产品达到计划中的目标。</p>
            <ul class="list-inline">
               <li>Date: summer 2014</li>
              <li>Client: 小浩</li>
              <li>Category: 产品</li>
            </ul>
            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i>关闭小窗</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Portfolio Modal 2 -->
<div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="close-modal" data-dismiss="modal">
      <div class="lr">
        <div class="rl"> </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="modal-body">
            <h2>运营</h2>
            <p class="item-intro text-muted">项目的收尾</p>
            <img class="img-responsive img-centered" src="img/portfolio/2c1a6532f657f301306580e03fd75ead_b.jpg" alt="">
            <p class="text-left">运营就是对运营过程的计划、组织、实施和控制，是与产品生产和服务创造密切相关的各项管理工作的总称。从另一个角度来讲，运营管理也可以指为对生产和提供公司主要的产品和服务的系统进行设计、运行、评价和改进的管理工作。</p>
            <ul class="list-inline">
               <li>Date: summer 2014</li>
              <li>Client: 小浩</li>
              <li>Category: 运营</li>
            </ul>
            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> 关闭小窗</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Portfolio Modal 3 -->
<div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="close-modal" data-dismiss="modal">
      <div class="lr">
        <div class="rl"> </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="modal-body"> 
            <!-- Project Details Go Here -->
            <h2>Android</h2>
            <p class="item-intro text-muted">最大数量得移动开发</p>
            <img class="img-responsive img-centered" src="img/portfolio/portfolio2.jpg" alt="">
            <p class="text-left">Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。尚未有统一中文名称，中国大陆地区较多人使用“安卓”或“安致”。
            Android操作系统最初由Andy Rubin开发，主要支持手机。2005年8月由Google收购注资。2007年11月，Google与84家硬件制造商、软件开发商及电信营运商组建开放手机联盟共同研发改良Android系统。
            随后Google以Apache开源许可证的授权方式，发布了Android的源代码。第一部Android智能手机发布于2008年10月。Android逐渐扩展到平板电脑及其他领域上，如电视、数码相机、游戏机等。2011年第一季度，
            Android在全球的市场份额首次超过塞班系统，跃居全球第一。 2013年的第四季度，Android平台手机的全球市场份额已经达到78.1%。[1]  2013年09月24日谷歌开发的操作系统Android在迎来了5岁生日，全世界采用这款系统的设备数量已经达到10亿台。</p>
            <ul class="list-inline">
              <li>Date: summer 2014</li>
              <li>Client: 小浩</li>
              <li>Category: Android</li>
            </ul>
            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> 关闭小窗</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Portfolio Modal 4 -->
<div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="close-modal" data-dismiss="modal">
      <div class="lr">
        <div class="rl"> </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="modal-body"> 
            <!-- Project Details Go Here -->
            <h2>IOS</h2>
            <p class="item-intro text-muted">优雅的移动开发</p>
            <img class="img-responsive img-centered" src="img/portfolio/430a0ea6e4f9af4837e28b9ff7e4b424.jpg" alt="">
            <p class="text-left">iOS是由苹果公司开发的移动操作系统[1]  。苹果公司最早于2007年1月9日的Macworld大会上公布这个系统，最初是设计给iPhone使用的，后来陆续套用到iPod touch、iPad以及Apple TV等产品上。iOS与苹果的Mac OS X操作系统一样，属于类Unix的商业操作系统。原本这个系统名为iPhone OS，因为iPad，iPhone，iPod touch都使用iPhone OS，所以2010WWDC大会上宣布改名为iOS（iOS为美国Cisco公司网络设备操作系统注册商标，苹果改名已获得Cisco公司授权）。</p>
            <ul class="list-inline">
              <li>Date: summer 2014</li>
              <li>Client: 小浩</li>
              <li>Category: Ios</li>
            </ul>
            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> 关闭小窗</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Portfolio Modal 5 -->
<div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="close-modal" data-dismiss="modal">
      <div class="lr">
        <div class="rl"> </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="modal-body"> 
            <!-- Project Details Go Here -->
            <h2>UI</h2>
            <p class="item-intro text-muted">最具审美的程序开发者</p>
            <img class="img-responsive img-centered" src="img/portfolio/3685c1ee6b3e293304e9777f86384fcb.png" alt="">
            <p class="text-left">“UI”的本义是用户界面，是英文User和interface的缩写。UI设计师简称UID（User Interface Designer），指从事对软件的人机交互、操作逻辑、界面美观的整体设计工作的人。</p>
            <ul class="list-inline">
              <li>Date: summer 2014</li>
              <li>Client: 小浩</li>
              <li>Category: Android</li>
            </ul>
            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> 关闭小窗</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Portfolio Modal 6 -->
<div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="close-modal" data-dismiss="modal">
      <div class="lr">
        <div class="rl"> </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="modal-body"> 
            <!-- Project Details Go Here -->
            <h2> 前端</h2>
            <p class="item-intro text-muted"> 大前端时代来临了</p>
            <img class="img-responsive img-centered" src="img/portfolio/portfolio5.jpg" alt="">
            <p class="text-left">Web前端开发工程师是一个很新的职业，在国内乃至国际上真正开始受到重视的时间不超过10年。Web前端开发是从网页制作演变而来的，名称上有很明显的时代特征。在互联网的演化进程中，网页制作是Web 1.0时代的产物，那时网站的主要内容都是静态的，用户使用网站的行为也以浏览为主。</p>
            <ul class="list-inline">
              <li>Date: summer 2014</li>
              <li>Client: 小浩</li>
              <li>Category: Android</li>
            </ul>
            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> 关闭小窗</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Portfolio Modal 7 -->
<div class="portfolio-modal modal fade" id="portfolioModal7" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="close-modal" data-dismiss="modal">
      <div class="lr">
        <div class="rl"> </div>
      </div>
    </div>
    <div class="container">
      <div class="row">Close Project
        <div class="col-lg-8 col-lg-offset-2">
          <div class="modal-body"> 
            <!-- Project Details Go Here -->
            <h2>后台</h2>
            <p class="item-intro text-muted">默默无闻的牺牲者</p>
            <img class="img-responsive img-centered" src="img/portfolio/81c0f748635a627bd2c90b78b49b9708.png" alt="">
            <p class="text-left">当你打开一个网站、打开一个App，看得见的不是后台，看不见的就是后台。后台涉猎广泛，包括各种逻辑，数据，配置。作为一个后端开发者，除了会掌握一点点前端技术外，更需要学习数据库，各种web框架，服务器配置部署（linux）。开发后台的编程语言有很多:Java,C++,C#,Php,python...
            小编最最最喜欢Java，高效，安全，并发，分布式，多线程...这个报名系统就是用java web（后端）+bootstarp（前端）做的，后台采用mybatis3.2.7+struts2.1.8。再这里鼓励同学们多多包后台，你不会后悔的！</p>
            <ul class="list-inline">
              <li>Date: summer 2014</li>
              <li>Client: 小浩</li>
              <li>Category: Android</li>
            </ul>
            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> 关闭小窗</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Portfolio Modal 8 -->
<div class="portfolio-modal modal fade" id="portfolioModal8" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="close-modal" data-dismiss="modal">
      <div class="lr">
        <div class="rl"> </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="modal-body"> 
            <!-- Project Details Go Here -->
            <h2>C++</h2>
            <p class="item-intro text-muted">一门日不落语言</p>
            <img class="img-responsive img-centered" src="img/portfolio/730e0cf3d7ca7bcba0c4642cbc096b63f624a872.jpg" alt="">
            <p class="text-left">C++是在C语言的基础上开发的一种面向对象编程语言，应用广泛；C++支持多种编程范式 －－面向对象编程、泛型编程和过程化编程。最新正式标准C++于2014年8月18日公布。[1]  其编程领域众广，常用于系统开发，引擎开发等应用领域，是至今为止最受广大程序员受用的最强大编程语言之一,支持类：类、封装、重载等特性!</p>     
            <ul class="list-inline">
              <li>Date: summer 2014</li>
              <li>Client: 小浩</li>
              <li>Category: Android</li>
            </ul>
            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> 关闭小窗</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- jQuery --> 
<script src="${pageContext.request.contextPath }/js/jquery-2.2.0.min.js"></script> 

<!-- Bootstrap Core JavaScript --> 
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script> 

<!-- Plugin JavaScript --> 
<script src="${pageContext.request.contextPath }/js/jquery.easing.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/classie.js"></script> 
<script src="${pageContext.request.contextPath }/js/cbpAnimatedHeader.js"></script> 
<!-- Contact Form JavaScript --> 
<script src="${pageContext.request.contextPath }/js/jqBootstrapValidation.js"></script> 
<!-- Custom Theme JavaScript --> 
<script src="${pageContext.request.contextPath }/js/register.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/signup.js"></script>
</body>
</html>