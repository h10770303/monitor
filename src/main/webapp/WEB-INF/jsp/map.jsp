<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>  
<html lang="en"> 
<head> 
	<meta charset="utf-8" /> 
	<title>路书</title> 
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#map_canvas{width:100%;height:500px;}
		#result {width:100%}
	</style>
	<script src="js/jquery/jquery-1.11.2.min.js"></script>
	<script src="http://api.map.baidu.com/getscript?v=2.0&ak=epWoVCqlhofczATzUN0gl4UT&services=&t=20141204161725"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/LuShu/1.2/src/LuShu_min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
</head> 
<body> 
	<div id="map_canvas"></div> 
	<script> 
	var map = new BMap.Map('map_canvas');
	map.enableScrollWheelZoom();
	map.centerAndZoom(new BMap.Point(121.471864,31.23406), 15);
	var points=new Array();
	//从后台获取数据
	$.ajax({
		type:"GET",
		url:"findMap.do",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		success:function(response){
			//alert(response);
			var i=0;
			 response.forEach(function(value){
				//console.log(value);
				var pp=value.split(',')
				var point=new BMap.Point(pp[0],pp[1]);
				points.push(point);
				i++;
			}) 
			var curve = new BMapLib.CurveLine(points, {strokeColor:"blue", strokeWeight:7, strokeOpacity:0.5}); //创建弧线对象
			map.addOverlay(curve); //添加到地图中
			curve.enableEditing(); //开启编辑功能
		},
		error:function(response){
			alert(response);
		}
		
	})
	
	
	
	/*var beijingPosition=new BMap.Point(121.46072,31.2298),
	hangzhouPosition=new BMap.Point(121.46048,31.228968),
	taiwanPosition=new BMap.Point(121.46112,31.229183);
	taiwanPosition2=new BMap.Point(121.4624,31.229082);
	taiwanPosition3=new BMap.Point(121.4624,31.2289);
	taiwanPosition3=new BMap.Point(121.4624,31.2289);
var points = [beijingPosition,hangzhouPosition, taiwanPosition,taiwanPosition2,taiwanPosition3];
*/

</script> 
</body> 
</html> 

