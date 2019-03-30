$(function() {


	$("#submit").click(function(){
		islogin();
	})
});

/**
 * 是否验证
 */

function islogin(){
	var userName=encodeURI($("#userName").val());
	$.ajax({
		type : "get",
		url : "islogin.do?userName="+encodeURI(userName) ,
		dataType : 'json',
		async : true,
		success : function(data) {
			window.location.href="http://222.66.35.91/monitor/shzc.do"
//			if (data.result == '1') {
//				window.location.href="http://222.66.35.91/monitor/shzc.do"
//				window.location.href="http://localhost:8080/monitor/shzc.do"
//			} else if(data.result =='0'){
//				window.location.href="http://222.66.35.91/monitor/nopermit.do"
//			}
		},
		error : function(data) {

			alert("访问异常，请联系管理员！")
		}
	});
}




