<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<title>Hello, World</title>  
<style type="text/css">  
html{height:100%}  
body{height:100%;margin:0px;padding:0px}  
#container{height:100%}  
</style>  
<script type="text/javascript" src="http://api.map.baidu.com/getscript?v=2.0&ak=epWoVCqlhofczATzUN0gl4UT&services=&t=20141204161725">
/* <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"> */
//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
//v1.4版本及以前版本的引用方式：src="http://api.map.baidu.com/api?v=1.4&key=您的密钥&callback=initialize"
</script>
</head>  
 
<body>  
<div id="container"></div> 
<script type="text/javascript"> 
// 初始化地图
var map = new BMap.Map("container");          // 创建地图实例  
var point = new BMap.Point(121.471864,31.23406);  // 创建点坐标  
map.centerAndZoom(point, 15);                 // 初始化地图，设置中心点坐标和地图级别  

// 增加控件
var opts = {type: BMAP_NAVIGATION_CONTROL_SMALL}    
map.addControl(new BMap.NavigationControl(opts));
/* map.addControl(new BMap.NavigationControl());  */   
var opts = {offset: new BMap.Size(80, 600)}    
map.addControl(new BMap.ScaleControl(opts));
//map.addControl(new BMap.ScaleControl());    
map.addControl(new BMap.OverviewMapControl());    
map.addControl(new BMap.MapTypeControl());    
map.setCurrentCity("上海");

/* 
//定义一个控件类，即function    
function ZoomControl(){    
    // 设置默认停靠位置和偏移量  
    this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;    
    this.defaultOffset = new BMap.Size(80, 50);    
}    
// 通过JavaScript的prototype属性继承于BMap.Control   
ZoomControl.prototype = new BMap.Control();

//自定义控件必须实现initialize方法，并且将控件的DOM元素返回   
//在本方法中创建个div元素作为控件的容器，并将其添加到地图容器中   
ZoomControl.prototype.initialize = function(map){    
//创建一个DOM元素   
var div = document.createElement("div");    
//添加文字说明    
div.appendChild(document.createTextNode("放大2级"));    
// 设置样式    
div.style.cursor = "pointer";    
div.style.border = "1px solid gray";    
div.style.backgroundColor = "white";    
// 绑定事件，点击一次放大两级    
div.onclick = function(e){  
map.zoomTo(map.getZoom() + 2);    
}    
// 添加DOM元素到地图中   
map.getContainer().appendChild(div);    
// 将DOM元素返回  
return div;    
}
//创建控件实例    
var myZoomCtrl = new ZoomControl();
map.addControl(myZoomCtrl);


//标注
var marker = new BMap.Marker(point);        // 创建标注    
map.addOverlay(marker);                     // 将标注添加到地图中
marker.addEventListener("click", function(){    
	 alert("您点击了标注");    
	});
marker.enableDragging();    
marker.addEventListener("dragend", function(e){    
 alert("当前位置：" + e.point.lng + ", " + e.point.lat);    
})

 //释放资源
map.removeOverlay(marker);    
marker.dispose(); // 1.1 版本不需要这样调用 

var point2 = new BMap.Point(120.471864,39.23406);  // 创建点坐标  
//自定义标注
function addMarker(point2, index){  // 创建图标对象   
var myIcon = new BMap.Icon("images/markers.png", new BMap.Size(23, 25), {    
// 指定定位位置。   
// 当标注显示在地图上时，其所指向的地理位置距离图标左上    
// 角各偏移10像素和25像素。您可以看到在本例中该位置即是   
   // 图标中央下端的尖角位置。    
   offset: new BMap.Size(10, 25),    
   // 设置图片偏移。   
   // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您   
   // 需要指定大图的偏移位置，此做法与css sprites技术类似。    
   imageOffset: new BMap.Size(0, 0 - index * 25)   // 设置图片偏移    
 });      
// 创建标注对象并添加到地图   
 var marker = new BMap.Marker(point2, {icon: myIcon});    
 map.addOverlay(marker);    
}    
// 随机向地图添加10个标注    
var bounds = map.getBounds();    
var lngSpan = bounds.Fe - bounds.Ke;    
var latSpan = bounds.Ge - bounds.Le;    
for (var i = 0; i < 10; i ++) {    
 var point = new BMap.Point(bounds.Ke + lngSpan * (Math.random() * 0.7 + 0.15),    
                            bounds.Le + latSpan * (Math.random() * 0.7 + 0.15)); ;    
 addMarker(point, i);    
}

// 信息窗口
var opts = {    
		 width : 250,     // 信息窗口宽度    
		 height: 100,     // 信息窗口高度    
		 title : "Hello"  // 信息窗口标题   
		}    
var infoWindow = new BMap.InfoWindow("World", opts);  // 创建信息窗口对象    
//map.openInfoWindow(infoWindow, map.getCenter());      // 打开信息窗口
	
*/	

// 折线
var polyline = new BMap.Polyline([    
   new BMap.Point(116.399, 39.910),    
   new BMap.Point(416.405, 99.920)    
 ],    
 {strokeColor:"black", strokeWeight:16, strokeOpacity:0.5}    
);    
map.addOverlay(polyline);

</script>  
</body>  
</html>