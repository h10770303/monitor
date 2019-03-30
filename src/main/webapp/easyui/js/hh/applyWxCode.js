$(function(){
	$.ajax({
		type : "get",
		url : "getWxCode.do" ,
		dataType : 'json',
		async : true,
		success : function(data) {
			if (data.code == 0) {
				var showcode="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
				$("#code").attr("src",showcode+data.result);
				if(data.result.length>0){
					setInterval("ischkecked()",2000);
				}
			} else {
				toastr.warning("出现异常，请联系管理员！")
			}
		},
		error : function(data) {

		}
	});
});



function ischkecked(){
	$.ajax({
		type : "get",
		url : "hasChecked.do" ,
		dataType : 'json',
		async : true,
		success : function(data) {
			if (data.result == '1') {
				alert("感谢您的关注！")
			} else if (data.result == '0') {
				
			}
		},
		error : function(data) {

			toastr.warning("访问异常，请联系管理员！")
		}
	});
}