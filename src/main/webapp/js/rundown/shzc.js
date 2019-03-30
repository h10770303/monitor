$(function() { 
	
	setInterval("refresh(cName,current)",60000);
	refresh(cName,current);
	
	$("#search_btn").click(function(){
		refresh(cName,current);
	});
    
    
});  
  
var result="";
var current=1;
var cName="";
function getdetail(param){
	current=param;
	var textRunDown=result;
	$("#content").html("");
	var content=textRunDown[param-1].txt;
	var content2=content.replace(/<a.*?>(.*?)<\/a>/ig,"");
	
	 $(" <div>" +
			" <div >"+
		"<center ><h2 style=\"color: blue;\">"+textRunDown[param-1].title+"</h2></center>"+
		"<div class=\"row\">  "+
		"<div class=\"col-md-4\">作者："+textRunDown[param-1].createby+"</div>"+
		 "<div class=\"col-md-4\">最后修改人："+textRunDown[param-1].modifyby+"</div>"+
		 " <div class=\"col-md-4\">最后修改时间:"+fmtDate(parseInt(textRunDown[param-1].modifydate+""+"000"))+"</div>"+
		"</div> "+
	"</div>"+
	" <div class=\"form-inline panel panel-default\">"+
	"</div>"+
	"	<div class=\"panel-body\"> "+content2+"</div> "
	 ).appendTo("#content");
	
}
	
	
	/**
	 * 自动刷新
	 * @param cName
	 * @param current
	 */
function refresh(cName,current){
	
	var mytime=new Date();
	$("#timenow").html(fmtDate(mytime.getTime()));
	
	cName=$("#cName").val();
	$.ajax({
		type:"get",
		url:"getshzc.do?cName="+cName,
		dataType: 'json',
		async:true,
		success:function(data){
			if(data.code==0){
				result=data.result.textRunDowns;
				$("#title").html("");
				var html=" <table class=\"table table-hover\">";
				var tr="  ";
				$.each(result, function(i) { 
					tr=tr+"<tr onclick=\"getdetail("+result[i].num+");\"><td>"+i+"</td><td>"+result[i].title+"</td></tr> "
				});
				$(html+tr).appendTo("#title");
				getdetail(current);
			}else{
				$("#title").html("");
				$("#content").html("当前没有数据更新！");
			}
		},
		error:function(data){
			
			}
	});
}

	
	





 