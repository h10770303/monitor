<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>二维码</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
     <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/default/easyui.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/icon.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/css/main.css">
  <link rel="stylesheet" media="screen" href="login/css/style.css">
  <link rel="stylesheet" type="text/css" href="login/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="easyui/css/wxcode.css"/>
</head>
<body>

<div id="particles-js">
		
		<div class="wxcode">
			<img id="code" alt="微信扫一扫" src="" height="300" width="280">
		</div>
</div>

<!-- scripts -->
<script src="easyui/js/jquery-easyui-1.5.3/jquery.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script src="easyui/js/hh/applyWxCode.js"></script>
</body>
</html>