<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- <meta  name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"  />
 -->
<title>xnews流程监控系统</title>
<link rel="stylesheet"
	href="js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="js/bootstrap/css/bootstrap-table.css">
	<link rel="stylesheet" href="js/jquery/css/jquery.datetimepicker.css" />
<link rel="stylesheet" href="js/bootstrap/css/bootstrap-datepicker.css" />
<!-- <link rel="stylesheet" href="timeline/css/history.css" /> -->

<script type="text/javascript" src="js/jquery/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap-datepicker-1.3.0.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap-table.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/export/bootstrap-table-export.js"></script>
<script type="text/javascript" src="js/jquery/tableExport.js"></script>
<script type="text/javascript" src="js/echart/echarts.js"></script>
<script type="text/javascript" src="js/webjs/toxnews_user.js"></script>
<script type="text/javascript" src="js/util/dateUtil.js"></script>
<style type="text/css">
 .fixed-table-body{
   height:auto;
 }
 .fixed-table-container {
 	height: 20px !important;
 }
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<header>

</header>




<!--页面内容  -->
<div id="myTabContent" class="tab-content">
   	<div class=" tab-pane fade in active" id="flowInfo">
	<div class="container-fluid " >
		<h1 align="center">xnews业务监控系统</h1>
		<div class="form-inline panel panel-default">
			<div class="panel-body" style="margin-right: 80px;">
				<label>开始时间：</label>
				<input id="startDt" class="form-control datepicker" type="text"  placeholder="开始时间"> 
				<label>结束时间：</label>
				<input id="endDt" class="form-control datepicker " type="text"  placeholder="结束时间"> 
				<label>任务名：</label>
				<input id="programTitle" class="form-control" type="text" value="" >
				<button class="btn btn-default btn-sm" type="button"
					id="search_btn">
					<span class="glyphicon glyphicon-search"></span>
				</button>
				<div id="toolbar"></div>
			</div>
		</div> </div>
		<table id="empUserList" data-method="post"
			data-query-params="queryParams" 
			data-toolbar="#toolbar"
			data-pagination="true" 
			data-search="false" 
			data-show-refresh=""
			data-show-toggle="false" 
			data-show-columns="true"
			 data-page-size="5">
		</table>
		</div>
		
</div>	

<!-- bootstrap modal 弹出框 --> 
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
 <div class="modal-dialog" style="z-index: 10000;" role="document">
 <div class="modal-content">
 <div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
  <h4 class="modal-title" id="myModalLabel" >详细流程节点</h4>
 </div>
 <div  id ="modal-body" class="modal-body">
 
 </div>
 </div>
 </div>
</div>

	
</body>
</html>