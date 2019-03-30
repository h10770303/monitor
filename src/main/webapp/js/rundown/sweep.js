$(function() {
	getWeixinParams();

});



function getWeixinParams(){
	var curPath = location.href.split('#')[0];
	$.ajax({
		type : "post",
		url : "getSign.do" ,
		data:{"url":curPath},
		dataType : 'json',
		async : true,
		success : function(data) {
			var timestamp=data.weixin.timestamp;
			var noncestr=data.weixin.nonceStr;
			var signature=data.weixin.signature;
			getWeixinParamsCallBack(timestamp,noncestr,signature);
		},
		error : function(data) {

			alert("访问异常，请联系管理员！")
		}
	});
}

function getWeixinParamsCallBack(_timestamp,_noncestr,_signature){
	wx.config({
		debug: false,
		appId:"wxf11b137709e3d1e1",
		timestamp:_timestamp,
		nonceStr:_noncestr,
		signature:_signature,
		jsApiList:[ "scanQRCode" ]
	});
	
	wx.ready(function(){
//		alert("配置成功微信JS");
	});
	wx.error(function(res){
		alert("失败："+res);
	});
	
}


function getWeixinResult(){
	wx.scanQRCode({
		needResult:1,
		desc:'scanQRCode desc',
		success:function(res){
			var url=res.resultStr;
			if(url.indexOf(',')>=0){
				var tempArry=url.split(',');
				var temNum=tempArry[1];
				$("#id_securityCode_input").val(temNum);
			}else{
				$("#id_securityCode_input").val(url);
			}
			
			var myResult=$("#id_securityCode_input").val();
			getWeixinReultCallBack(myResult);
		}
	})
}

function getWeixinReultCallBack(_myResult){
	alert(_myResult)
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




