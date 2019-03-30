$(function() {

	query();
	
	setInterval("ischkecked()",2000);

});

/**
 * 是否验证
 */

function ischkecked(){
	$.ajax({
		type : "get",
		url : "hasChecked.do" ,
		dataType : 'json',
		async : true,
		success : function(data) {
			if (data.result == '1') {
//				http://monitor.smgtech.net/monitor/wxcode.do
				window.location.href="http://monitor.smgtech.net/monitor/shzc.do"
//				window.location.href="/monitor/shzc.do"
			} else if (data.result == '0') {
				window.location.href="http://monitor.smgtech.net/monitor/nopermit.do"
			}
		},
		error : function(data) {

			alert("访问异常，请联系管理员！")
		}
	});
}

/**
 * 获取ticket
 * 
 * @param cName
 * @param current
 */
function query() {

	$.ajax({
		type : "get",
		url : "getWxCode.do" ,
		dataType : 'json',
		async : true,
		success : function(data) {
			if (data.code == 0) {
				var showcode="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
				$("#code").attr("src",showcode+data.result);
			} else {
				alert("出现异常，请联系管理员！")
			}
		},
		error : function(data) {

		}
	});
}




