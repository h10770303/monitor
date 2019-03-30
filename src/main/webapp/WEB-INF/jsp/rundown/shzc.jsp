<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">             
<title>新闻早鸟辅助监控系统</title>
<link rel="stylesheet"
	href="js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/shzc.css" />

<script type="text/javascript" src="js/jquery/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/util/dateUtil.js"></script>
<script type="text/javascript" src="js/rundown/shzc.js"></script>
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
		<h1  align="center">新闻早鸟辅助系统</h1>
		<%-- <input id="checked" type="hidden" value="${checked }"> --%>
		<div class="form-inline panel panel-default">
			<div class="panel-body" style="margin-right: 80px;">
				<label>串联单类型：</label>
				<!-- <input id="cName" class="form-control" type="text" value="cctv1" > -->
				<select id="cName" name="cName"   class="selectpicker show-tick form-control" onchange="refresh('',1);" >
				  <option value="szzc"  selected="selected">上海早晨播串</option>
				  <option value="szzc0700">上海早晨编串700</option>
				  <option value="szzc0730">上海早晨编串730</option>
				  <option value="szzc0800">上海早晨编串800</option>
				  <option value="szzc0830">上海早晨编串830</option>
				  <option value="wjxwbb">午间新闻编串</option>
				  <option value="wxwbc">午新闻播串</option>
				  <option value="xxwfbf">新新闻坊备份串联单</option>
				  <option value="xwbdbf">新闻报道备份串联单</option>
				  <option value="xwyxbf">新闻夜线备份串联单</option>
				</select>
				<button class="btn btn-default btn-sm" type="button"
					id="search_btn">
					<span class="glyphicon glyphicon-refresh"></span>
				</button>
				<div id="toolbar"></div>
			       <div align="center"> 最新更新时间：<span id="timenow"></span> </div>
			</div>
		</div> 
		</div>
		
		<div class="panel-body " style="margin-right: 80px;">
			<div id="title"  style="float:left; width: 30%; position:absolute;height:500px; overflow:auto ">
			<!--  <table class="table table-hover" >
			 <tr onclick="getdetail()" ><td>1</td><td>343434343</td></tr>
			</table> -->
			 
			</div>
			<div id="content" class="well well-lg" style="float:right; width: 60%; e;height:500px; overflow:auto " >
				
			
				
			</div>
		</div>
		
		</div>
		
	</div>	

	
	<footer>
	<center style="color: green;"> Copyright © 2018 SMG-上视技术科 版权所有</center>
	</footer>
</body>
</html>