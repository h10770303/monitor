<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">             
<title>北京电视串联单监控</title>
<link rel="stylesheet"
	href="js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="js/bootstrap/css/bootstrap-table.css">
	<link rel="stylesheet" href="js/jquery/css/jquery.datetimepicker.css" />
<link rel="stylesheet" href="js/bootstrap/css/bootstrap-datepicker.css" />
<!-- <link rel="stylesheet" href="timeline/css/history.css" /> -->

<script type="text/javascript" src="js/jquery/jquery-2.1.1.js"></script>
<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> -->
<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap-datepicker-1.3.0.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap-table.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/export/bootstrap-table-export.js"></script>
<!-- <script type="text/javascript" src="http://rawgit.com/hhurz/tableExport.jquery.plugin/master/tableExport.js"></script> -->
<script type="text/javascript" src="js/jquery/tableExport.js"></script>
<script type="text/javascript" src="js/echart/echarts.js"></script>
<script type="text/javascript" src="js/util/dateUtil.js"></script>
<script type="text/javascript" src="js/rundown/rundown.js"></script>
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



<!-- tab nav页 -->
	<ul id="myTab" class="nav nav-tabs">
	<li class="active">
		<a href="#flowInfo" data-toggle="tab">
			 CCTV电视节目单
		</a>
	</li>
	<!-- <li><a href="#dataInfo" data-toggle="tab">CCTV13</a></li> -->
</ul>

<!--页面内容  -->
<div id="myTabContent" class="tab-content">
   	<div class=" tab-pane fade in active" id="flowInfo">
	<div class="container-fluid " >
		<h1 align="center">央视电视节目播出串联单</h1>
		<div class="form-inline panel panel-default">
			<div class="panel-body" style="margin-right: 80px;">
				<label>频道名：</label>
				<!-- <input id="cName" class="form-control" type="text" value="cctv1" > -->
				<select id="cName" name="cName"   class="selectpicker show-tick form-control" >
				  <option value="cctv1" selected="selected">cctv1</option>
				  <option value="cctv13">cctv13</option>
				</select>
				<button class="btn btn-default btn-sm" type="button"
					id="search_btn">
					<span class="glyphicon glyphicon-search"></span>
				</button>
				<div id="toolbar"></div>
			</div>
		</div> 
		</div>
		<table id="empUserList" data-method="post"
			data-query-params="queryParams" 
			data-toolbar="#toolbar"
			data-pagination="true" 
			data-search="false" 
			data-show-refresh=""
			data-show-toggle="true" 
			data-show-columns="true"
			 data-page-size="5">
		</table>
		</div>
		
		<!-- <div class="tab-pane fade" id="dataInfo">
		   
		   <div class="container-fluid " >
			<div >
				<h2 align="center">CCTV13</h2>
			</div>
			<div style="">
			<table id="hitcount" 
			data-method="post" 
			data-show-refresh="true"
			data-show-columns="true"
			 data-page-size="5">
			</table>
			</div>
			
			<div class="form-inline panel panel-default">
			<div class="panel-body" style="margin-right: 80px;">
				<button type="button" id="today" class="btn btn-primary">当天</button>
				<button type="button" id="yesteday" class="btn btn-success">昨天</button>
				<button type="button" id="week" class="btn btn-info">当周</button>
				<button type="button" id="month" class="btn btn-warning">当月</button>
			</div>
		</div> 
			<div class="row">
			<div id="kkEchart" class="col-xs-6" style="width: 600px;height: 500px; margin-top: 4px">
			
			</div>
			<div id="txwsCntEchart" class="col-xs-6" style="width: 600px;height: 500px; margin-top: 4px">
			
			</div>
			</div>
		</div> </div> -->
		
</div>	

	
	<footer>
	<h1></h1>	
	</footer>
</body>
</html>