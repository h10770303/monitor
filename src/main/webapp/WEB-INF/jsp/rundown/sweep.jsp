<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信扫一扫</title>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="js/jquery/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/rundown/sweep.js"></script>
</head>
<body>
<input id="timestamp" type="hidden" value="${timestamp}" />
<input id="noncestr" type="hidden" value="${nonceStr}" />
<input id="signature" type="hidden" value="${signature}" />
<input id="id_securityCode_input" type="text">
<button id="scanQRCode" onclick="getWeixinResult()">扫码</button>
</body>
<script type="text/javascript">
</script>
</html>