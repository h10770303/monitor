<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>技术登录</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="login/css/style.css">
  <link rel="stylesheet" type="text/css" href="login/css/reset.css"/>
</head>
<body>

<div id="particles-js">
		<div class="login">
			<div class="login-top">
				登录
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="login/img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" name="" value="" id="userName" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="login/img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" name=""value="" id="userPwd" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-button">
				登陆
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="login/js/particles.min.js"></script>
<script src="login/js/app.js"></script>
<script type="text/javascript">
	 
		document.querySelector(".login-button").onclick = function(){
			var userName=$("#userName").val();
			if(userName==''){
				alert("请输入用户名!");
				return false;
			}
			if(userPwd==''){
				alert("请输入密码!");
				return false;
			}
			$.ajax({
				type:"get",
				url:"chec2ndkVotor.do?userName="+userName+"&userPwd="+userPwd,
				cache: false,
				async:true,
				success:function(data){
					if (data.code==0) {
						if(data.result.length<=0){
							toastr.warning("您不符合投票权限，请联系管理员!");
//							swal('您不符合投票权限，请联系管理员!');
						}else{
							alert("用户名或密码错误");
						}
					}
				},
				error:function(data){
					toastr.warning("您不符合投票权限，请联系管理员!");
				}
				});
				
		}
</script>
</body>
</html>