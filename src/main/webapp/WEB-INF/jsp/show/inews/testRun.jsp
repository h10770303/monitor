<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>电视制作部上视技术科日常试机记录信息</title>

    <!-- Bootstrap Core CSS -->
    <link href="datashow/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="datashow/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="datashow/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="datashow/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="datashow/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="js/jquery/css/jquery.datetimepicker.css" />
	<link rel="stylesheet" href="js/bootstrap/css/bootstrap-datepicker.css" />

    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
   <style type="text/css">
    
    a:focus, a:hover {
    color: #ffffff;
    text-decoration: none;
}
a {
    color: #ffffff;
    text-decoration: none;
}
    
    </style>

</head>

<body>

    <div id="">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">上视技术科试机信息记录</a>
            </div>
            <!-- /.navbar-header -->
        </nav>

        <div id="">
            <div class="row" style="padding: 20px">
                <!-- <div class="col-lg-12">
                    <h1 class="page-header">详细信息</h1>
                </div> -->
                <!--  选择时间 -->
                 <div class="row">
              	  <div class="col-lg-12">
                    <div class="form-inline panel panel-default">
						<div class="panel-body" style="margin-right: 80px;">
							<label>选择日期：</label>
							<input id="startDt" class="form-control datepicker" type="text"  placeholder="开始时间"> 
							<input id="endDt"  class="form-control  " type="hidden"   placeholder="结束时间"> 
						<!-- 	<button class="btn btn-default btn-sm" type="button"
								id="search_btn">
								<span class="glyphicon glyphicon-search"></span>
							</button> -->
							<div id="toolbar"></div>
						</div>
					</div>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-file-text-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                	<a href="#inews">
                                		 <div class="huge" id="load_inewscnt">26</div>
                                    <div>传统演播室装载测试</div>
                                	</a>
                                   
                                </div>
                            </div>
                        </div>
                      
                    </div>
                </div>
                
                 <div class="col-lg-3 col-md-3">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-1">
                                    <i class="glyphicon glyphicon glyphicon-sound-6-1 fa-5x"></i>
                                </div>
                                <div class="col-xs-4 text-right">
                              	  <a href="#interplay">
                                    <div class="huge" id="checkInterplays_cnt">12</div>
                                    <div>非编技术晨检</div>  
                                    </a>
                                </div>
                                
                                 <div class="col-xs-1">
                                    <div class="huge" id="checkInterplays_cnt"></div>
                                </div>
                                 <div class="col-xs-1">
                                    <i class="glyphicon glyphicon-off fa-5x"></i>
                                </div>
                                <div class="col-xs-5 text-right">
                                	<a href="#sp_div">
                                    <div class="huge" id="restart_spcnt">12</div>
                                    <div>非编技术下午巡检</div> </a>
                                </div>
                            </div>
                        </div>
                      
                    </div>
                </div>
                
                 <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa  fa-warning fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                  	<a href="#msg_div">
                                    <div class="huge" id="warning_cnt">13</div>
                                    <div>报警数据量</div> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            
            </div>
            <!-- /.row -->
            <div class="row">
                <div  class="col-lg-8" id="inews">
                   
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-th-list   fa-fw"></i> 传统演播室装载测试
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                   <!--  <th>day</th> -->
                                                    <th>试机栏目</th>
                                                    <th>操作时间</th>
                                                    <!-- <th>inews服务器</th> -->
													<th>操作人</th>
													<th>操作队列</th>
                                                </tr>
                                            </thead>
                                            <tbody class="inews">
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                   
                </div>
                <div  class="col-lg-8" id="interplay">
                   
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             <i class="fa fa-desktop   fa-fw"></i> 非编技术晨检 
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                               <tr>
                                                  <th>检查类型</th>
                                                  <th>操作人</th>
                                                  <th>操作时间</th>
                                                  <th>备注</th>
                                              </tr>
                                          </thead>
                                          <tbody class="interplay">
                                          </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                   
                </div>
                
               
                
                <!-- /.col-lg-8 -->
                <div class="col-lg-4" id="sp_div">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-rotate-right fa-fw"></i>非编技术下午巡检
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group" id="sp">
                                <a href="#" class="list-group-item">
                                    <i class="fa  fa-fw"></i> SP01
                                    <span class="pull-right text-muted small"><em>10.27.137.11</em>
                                    </span>
                                </a>
                               <a href="#" class="list-group-item">
                                    <i class="fa  fa-fw"></i> SP01
                                    <span class="pull-right text-muted small"><em>10.27.137.11</em>
                                    </span>
                                </a> <a href="#" class="list-group-item">
                                    <i class="fa  fa-fw"></i> SP01
                                    <span class="pull-right text-muted small"><em>10.27.137.11</em>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    
                    <div class="chat-panel panel panel-default" id="msg_div">
                        <div class="panel-heading">
                            <i class="fa fa-exclamation-triangle fa-fw"></i> 异常信息
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="chat" id="message">
                               
                                <li class="right clearfix">
                                   <span class="chat-img pull-left">
                                        <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                       
                                        <p>
                                           《新闻透视》没有串联单装载测试
                                        </p>
                                    </div>
                                </li>
								  <li class="right clearfix">
                                   
                                    <div class="chat-body clearfix">
                                       
                                        <p>
                                           《新闻透视》没有串联单装载测试
                                        </p>
                                    </div>
                                </li>
								  <li class="right clearfix">
                                   
                                    <div class="chat-body clearfix">
                                       
                                        <p>
                                           《新闻透视》没有串联单装载测试
                                        </p>
                                    </div>
                                </li>
                              
                            </ul>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel .chat-panel -->
                </div>
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>

    <!-- jQuery -->
    <script src="datashow/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="datashow/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap-datepicker-1.3.0.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="datashow/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="datashow/vendor/raphael/raphael.min.js"></script>
    <script src="datashow/vendor/morrisjs/morris.min.js"></script>
    <script src="datashow/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="datashow/dist/js/sb-admin-2.js"></script>
    
    <script src="js/rundown/testRun.js"></script>
    <script type="text/javascript" src="js/util/dateUtil.js"></script>

</body>

</html>