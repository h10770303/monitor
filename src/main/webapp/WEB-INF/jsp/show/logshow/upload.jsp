<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>

<head>
    <title>studio日志上传</title>
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
    <!-- add css -->
	<link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="js/bootstrap/css/bootstrap-table.css">
	<link rel="stylesheet" href="js/jquery/css/jquery.datetimepicker.css" />
	<link rel="stylesheet" href="js/bootstrap/css/bootstrap-datepicker.css" />
	<!-- 页面logo替换 -->
	<link rel="icon" href="images/hh.png" type="image/x-icon" />
	<link rel="shortcut icon" href="images/hh.png" type="image/x-icon" />
	<link rel="bookmark" href="images/hh.png" type="image/x-icon" />
</head>

<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
        
            <!-- navbar-header -->
            <nav class="navbar navbar-default navbar-fixed-top navbar-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-expand-toggle">
                            <i class="fa fa-bars icon"></i>
                        </button>
                        <ol class="breadcrumb navbar-breadcrumb">
                            <!-- <li>avid反推</li> -->
                            <li class="active">studio日志</li>
                        </ol>
                        <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                            <i class="fa fa-th icon"></i>
                        </button>
                    </div>
                </div>
            </nav>
            <div class="side-menu sidebar-inverse">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="side-menu-container">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                <div class="icon fa fa-paper-plane"></div>
                                <div class="title">新闻共享系统监控</div>
                            </a>
                            <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                                <i class="fa fa-times icon"></i>
                            </button>
                        </div>
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="index.do">
                                    <span class="icon fa fa-tachometer"></span><span class="title">首页</span>
                                </a>
                            </li>
                            <li>
                                <a href="avidToXnews.do">
                                    <span class="icon fa fa-thumbs-o-up"></span><span class="title">avid反推</span>
                                </a>
                            </li>
                            <li>
                                <a href="logshow.do">
                                    <span class="icon fa fa-thumbs-o-down"></span><span class="title">studio日志</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>
            </div>
            
            <!-- Main Content -->
            <div class="container-fluid">
                <div class="side-body padding-top">
                	
                	<div class="row">
                    <div class="container-fluid " >
						<h1 align="center">avidstudio日志监控</h1>
						<div class="form-inline panel panel-default">
							<div class="panel-body" style="margin-right: 80px;">
								<!-- <label>开始时间：</label>
								<input id="startDt" class="form-control datepicker" type="text"  placeholder="开始时间"> 
								<label>结束时间：</label>
								<input id="endDt" class="form-control datepicker " type="text"  placeholder="结束时间"> 
								 -->
								 <label>时差间隔(秒)：</label>
								<input id="time" class="form-control" type="text" value="" ><span>-</span>
								<input id="time2" class="form-control" type="text" value="" >
								<button class="btn btn-default btn-sm" type="button"
									id="search_btn">
									<span class="glyphicon glyphicon-search"></span>
								</button>
								<div id="toolbar"></div>
							</div>
							</div> </div>
						<div class="col-xs-12">
                        <div class="card">
						<div class="card-body">
					
							  <table id="table1" class="table">  
						        <thead>  
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>  
						        </thead>  
						       <!--  <tbody id="tbody" >  
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						            <tr><th>id</th><th>时长</th><th>时差（毫秒）</th></tr>
						        </tbody>   -->
						    </table>  
						    <!-- 分页 -->
						    <div class="row" >
						    <a id="btn0"></a>
                <input id="pageSize" type="text" size="1" maxlength="2" value="getDefaultValue()"/><a> 条 </a> <a href="#" id="pageSizeSet">设置</a>&nbsp;
                <a id="sjzl"></a>&nbsp;
                <a  href="#" id="btn1">首页</a>
                <a  href="#" id="btn2">上一页</a>
                <a  href="#" id="btn3">下一页</a>
                <a  href="#" id="btn4">尾页</a>&nbsp;
                <a>转到&nbsp;</a>
                <input id="changePage" type="text" size="1" maxlength="4"/>
                <a>页&nbsp;</a>
                <a  href="#" id="btn5">跳转</a>
						    </div>
							
							</div> </div></div>
						</div>
						<!-- 日志安装时间进行分析 -->
						<div class="row no-margin-bottom">
						 	 <div class="container-fluid " >
							<div>
								<h2 align="center">数据分析</h2>
							</div>
							
							<div class="form-inline panel panel-default">
							<div class="panel-body" style="margin-right: 80px;">
								 <label>间隔(分钟)：</label>
								<input id="step" class="form-control" type="text" value="" >
								<button class="btn btn-default btn-sm" type="button"
									id="search_echart">
									<span class="glyphicon glyphicon-search"></span>
								</button>
								<div id="toolbar"></div>
							</div>
						</div> 
							<div class="row">
							 	<div id="kkEchart" class="col-xs-12" style="width:1400px;height: 1000px; margin-top: 4px">
							
							</div>
							</div>
							 
							</div>
						
						</div>
						
                </div>
            </div>
        </div>
        <footer class="app-footer">
            <div class="wrapper">
                <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span> © 2017 Copyright. 胡明伟 -上视技术科
            </div>
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
    <script type="text/javascript" src="show/js/app.js"></script>
    
 
 	<!-- add js -->
	<script type="text/javascript" src="js/jquery/jquery.datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap-datepicker-1.3.0.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap-table-zh-CN.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/export/bootstrap-table-export.js"></script>
	<script type="text/javascript" src="js/jquery/tableExport.js"></script>
	<script type="text/javascript" src="js/echart/echarts.js"></script>
	<script type="text/javascript" src="show/js/js/logshow/logshow.js"></script>
	<script type="text/javascript" src="js/util/dateUtil.js"></script>
	<script type="text/javascript" src="show/js/js/logshow/kkechart.js"></script>
		
</body>

</html>

