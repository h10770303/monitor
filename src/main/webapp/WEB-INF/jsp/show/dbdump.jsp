<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>inews备份监控</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="show/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="show/lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="show/lib/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="show/lib/css/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="show/lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="show/lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="show/lib/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="show/lib/css/select2.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="show/css/style.css">
    <link rel="stylesheet" type="text/css" href="show/css/themes/flat-blue.css">
    <!-- 页面logo替换 -->
	<link rel="icon" href="images/hh.png" type="image/x-icon" />
	<link rel="shortcut icon" href="images/hh.png" type="image/x-icon" />
	<link rel="bookmark" href="images/hh.png" type="image/x-icon" />
</head>

<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
        
          <!-- navbar 第一行 -->
            <nav class="navbar navbar-default navbar-fixed-top navbar-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-expand-toggle">
                            <i class="fa fa-bars icon"></i>
                        </button>
                        <ol class="breadcrumb navbar-breadcrumb">
                            <li class="active">首页</li>
                        </ol>
                        <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                            <i class="fa fa-th icon"></i>
                        </button>
                    </div>
                </div>
            </nav>
            
            <!-- 左侧菜单栏 -->
            <div class="side-menu sidebar-inverse">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="side-menu-container">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                <div class="icon fa fa-paper-plane"></div>
                                <div class="title">xnews监控</div>
                            </a>
                            <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                                <i class="fa fa-times icon"></i>
                            </button>
                        </div>
                        
                        <ul class="nav navbar-nav">
                            <li class="active">
                                <a href="index.do">
                                    <span class="icon fa fa-tachometer"></span><span class="title">首页</span>
                                </a>
                            </li>
                             <li>
                                <a href="avidToXnews.do">
                                    <span class="icon fa fa-thumbs-o-up"></span><span class="title">avid反推</span>
                                </a>
                            </li>
                           <!--  <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#dropdown-element">
                                    <span class="icon fa fa-desktop"></span><span class="title">UI Kits</span>
                                </a>
                                Dropdown level 1
                                <div id="dropdown-element" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="ui-kits/theming.html">Theming</a>
                                            </li>
                                            <li><a href="ui-kits/grid.html">Grid</a>
                                            </li>
                                            <li><a href="ui-kits/button.html">Buttons</a>
                                            </li>
                                            <li><a href="ui-kits/card.html">Cards</a>
                                            </li>
                                            <li><a href="ui-kits/list.html">Lists</a>
                                            </li>
                                            <li><a href="ui-kits/modal.html">Modals</a>
                                            </li>
                                            <li><a href="ui-kits/alert.html">Alerts & Toasts</a>
                                            </li>
                                            <li><a href="ui-kits/panel.html">Panels</a>
                                            </li>
                                            <li><a href="ui-kits/loader.html">Loaders</a>
                                            </li>
                                            <li><a href="ui-kits/step.html">Tabs & Steps</a>
                                            </li>
                                            <li><a href="ui-kits/other.html">Other</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li> -->
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>
            </div>
            
            <!-- Main Content -->
            <div class="container-fluid">
                <div class="side-body padding-top">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                            <a href="#">
                                <div class="card red summary-inline">
                                    <div class="card-body">
                                        <i class="icon fa fa-inbox fa-4x"></i>
                                        <div class="content">
                                            <div class="title">
                                            <div id="logon" style="height: 100px"></div>
                                            </div>
                                            <div class="sub-title">当前在线人数</div>
                                        </div>
                                        <div class="clear-both"></div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                            <a href="#">
                                <div class="card yellow summary-inline">
                                    <div class="card-body">
                                        <i class="icon fa fa-comments fa-4x"></i>
                                        <div class="content">
                                            <div class="title"><div id="timeshow"></div></div>
                                            <div class="sub-title">当前时间</div>
                                        </div>
                                        <div class="clear-both"></div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                            <a href="#">
                                <div class="card green summary-inline">
                                    <div class="card-body">
                                        <i class="icon fa fa-tags fa-4x"></i>
                                        <div class="content">
                                            <div class="title">280</div>
                                            <div class="sub-title">Product View</div>
                                        </div>
                                        <div class="clear-both"></div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                            <a href="#">
                                <div class="card blue summary-inline">
                                    <div class="card-body">
                                        <i class="icon fa fa-share-alt fa-4x"></i>
                                        <div class="content">
                                            <div class="title">16</div>
                                            <div class="sub-title">Share</div>
                                        </div>
                                        <div class="clear-both"></div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="row  no-margin-bottom">
                        <div class="col-sm-6 col-xs-12">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="card primary">
                                        <div class="card-jumbotron no-padding">
                                            <canvas id="jumbotron-line-chart" class="chart no-padding"></canvas>
                                        </div>
                                        <div class="card-body half-padding">
                                            <h4 class="float-left no-margin font-weight-300">Profits</h4>
                                            <h2 class="float-right no-margin font-weight-300">$3200</h2>
                                            <div class="clear-both"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-sm-12">
                                    <div class="thumbnail no-margin-bottom">
                                        <img src="show/img/thumbnails/picjumbo.com_IMG_4566.jpg" class="img-responsive">
                                        <div class="caption">
                                            <h3 id="thumbnail-label">Thumbnail label<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
                                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <div class="thumbnail no-margin-bottom">
                                        <img src="show/img/thumbnails/picjumbo.com_IMG_3241.jpg" class="img-responsive">
                                        <div class="caption">
                                            <h3 id="thumbnail-label">Thumbnail label<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
                                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                            <p><a href="#" class="btn btn-success" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <div class="row">
                                <div class="col-md-6 col-sm-12">
                                    <div class="card primary">
                                        <div class="card-jumbotron no-padding">
                                            <canvas id="jumbotron-bar-chart" class="chart no-padding"></canvas>
                                        </div>
                                        <div class="card-body half-padding">
                                            <h4 class="float-left no-margin font-weight-300">Orders</h4>
                                            <div class="clear-both"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <div class="card primary">
                                        <div class="card-jumbotron no-padding">
                                            <canvas id="jumbotron-line-2-chart" class="chart no-padding"></canvas>
                                        </div>
                                        <div class="card-body half-padding">
                                            <h4 class="float-left no-margin font-weight-300">Pages view</h4>
                                            <div class="clear-both"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card card-success">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title"><i class="fa fa-comments-o"></i> Last Message</div>
                                    </div>
                                    <div class="clear-both"></div>
                                </div>
                                <div class="card-body no-padding">
                                    <ul class="message-list">
                                        <a href="#">
                                            <li>
                                                <img src="show/img/profile/profile-1.jpg" class="profile-img pull-left">
                                                <div class="message-block">
                                                    <div><span class="username">Tui2Tone</span> <span class="message-datetime">12 min ago</span>
                                                    </div>
                                                    <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                                </div>
                                            </li>
                                        </a>
                                        <a href="#">
                                            <li>
                                                <img src="show/img/profile/profile-1.jpg" class="profile-img pull-left">
                                                <div class="message-block">
                                                    <div><span class="username">Tui2Tone</span> <span class="message-datetime">15 min ago</span>
                                                    </div>
                                                    <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                                </div>
                                            </li>
                                        </a>
                                        <a href="#">
                                            <li>
                                                <img src="show/img/profile/profile-1.jpg" class="profile-img pull-left">
                                                <div class="message-block">
                                                    <div><span class="username">Tui2Tone</span> <span class="message-datetime">2 hour ago</span>
                                                    </div>
                                                    <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                                </div>
                                            </li>
                                        </a>
                                        <a href="#">
                                            <li>
                                                <img src="show/img/profile/profile-1.jpg" class="profile-img pull-left">
                                                <div class="message-block">
                                                    <div><span class="username">Tui2Tone</span> <span class="message-datetime">1 day ago</span>
                                                    </div>
                                                    <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                                </div>
                                            </li>
                                        </a>
                                        <a href="#" id="message-load-more">
                                            <li class="text-center load-more">
                                                <i class="fa fa-refresh"></i> load more..
                                            </li>
                                        </a>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- footer 版权声明 -->
        <footer class="app-footer">
            <div class="wrapper">
               © 2017 Copyright. 胡明伟 -上视技术科
              <!--   <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span> © 2015 Copyright. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
           -->  </div>
        </footer>
        <div>
            <!-- Javascript Libs -->
            <script type="text/javascript" src="show/lib/js/jquery.min.js"></script>
            <script type="text/javascript" src="show/lib/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="show/lib/js/Chart.min.js"></script>
            <script type="text/javascript" src="show/lib/js/bootstrap-switch.min.js"></script>
            <script type="text/javascript" src="show/lib/js/jquery.matchHeight-min.js"></script>
            <script type="text/javascript" src="show/lib/js/jquery.dataTables.min.js"></script>
            <script type="text/javascript" src="show/lib/js/dataTables.bootstrap.min.js"></script>
            <script type="text/javascript" src="show/lib/js/select2.full.min.js"></script>
            <script type="text/javascript" src="show/lib/js/ace/ace.js"></script>
            <script type="text/javascript" src="show/lib/js/ace/mode-html.js"></script>
            <script type="text/javascript" src="show/lib/js/ace/theme-github.js"></script>
            <!-- Javascript -->
            <script type="text/javascript" src="show/js/app.js"></script>
            <script type="text/javascript" src="show/js/index.js"></script>
            
            <!-- add js -->
		<script type="text/javascript" src="show2/js/js/bashbord.js"></script>
		<script type="text/javascript" src="show2/js/js/timeshow.js"></script>
</body>

</html>