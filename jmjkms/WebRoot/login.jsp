<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<%@ page import="java.text.*"%>
<%
    String currentTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
			application.setAttribute("currentTime", currentTime);
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<title>社区健康服务站</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<!-- 引入封装了failback的接口--initGeetest -->
<script src="http://code.jquery.com/jquery-1.12.3.min.js"></script>
<script src="http://static.geetest.com/static/tools/gt.js"></script>
</head>
<body>
	<div
		style="background: url(images/login_bg.jpg); height: 855px; background-size: 100% 100%">
		<form method="post" action="LoginoutAction!check.action"
			class="signIn-box"
			style="width: 250px; height: 270px; border-radius: 6px; margin: 0px; position: relative; top: 24%; left: 60%; background-color: #fff">
			<div class="sign-inBox">
				<div style="text-align: center;" class="fenkuang">
					<span style="position: relative; left: -65px; top: 25px;">平台登录</span>
					<div>
						<input type="text" required="" placeholder="用户名" name="loginName"
							class="sumsumsum"
							style="width: 180px; margin: 50px 0 20px 0; display: inline-block">
					</div>
					<div>
						<input type="password" required="" placeholder="密码"
							name="password" class="sumsumsum"
							style="width: 180px; margin: 10px 0; display: inline-block">
					</div>

					<div class="z_radio" style="text-align: center;">
						<label><input name="identity" type="radio" value="staff"
							checked="checked" />医生</label>
					    <label><input name="identity"
							type="radio" value="admin" />社区负责人</label>

					</div>

					<input type="submit" value="登录" onclick="return subForm();"
						name="denglu" class="denglu"
						style="background-color: #ed6c00; color: #fff; width: 190px; margin: 20px 0 0 0px">
				</div>

			</div>
		</form>
	</div>

	<script type="text/javascript">
		$(function() {
			//0,初始,1,"密码错误"   2,"登录成功" 3,验证码错误  4.用户不存在 5.该用户被禁用
			var resultcode = ${resultcode};
			if (resultcode == 1) {
				alert("密码错误");
			}
			if (resultcode == 3) {
				alert("验证码错误");
			}
			if (resultcode == 4) {
				alert("用户不存在");
			}
			if (resultcode == 5) {
				alert("该用户被禁用");
			}
			/* var resultcode=${resultcode};
			alert(resultcode);  */
		})
	</script>

</body>
</html>

