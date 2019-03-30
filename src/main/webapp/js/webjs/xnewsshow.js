$(function() { 
    var param={};
    param.startDt='2017-08-21';
    param.endDt='2017-08-22';
//	getNowClueCnt(param);
    
//    $("#test").click(function(){
//    	getNowClueCnt(param);
//    });
})  

function getNowClueCnt(param){
	$.ajax({
		type:"post",
		url:"getNowClueCnt.do",
		contentType : 'application/json;charset=UTF-8',
		dataType: 'json',
		data:JSON.stringify(param),
		async:true,
		success:function(data){
			alert(1)
		},
		error:function(data){
			alert(error);
		}
	});
}
  
 