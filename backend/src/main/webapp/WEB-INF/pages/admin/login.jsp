<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/includes.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="../common/meta.jsp" %>
	<title>后台登录页</title>
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<%@include file="../common/left.jsp" %>
		<%@include file="../common/head.jsp" %>
		<div id="page-wrapper">
			<div class="main-page login-page ">
				<h3 class="title1">登录页面</h3>
				<div class="widget-shadow">
					<div class="login-top">
						<h4>欢迎登录</h4>
					</div>
					<div class="login-body">
						<form>
							<input type="text" class="user" name="telephone" placeholder="手机号" required="">
							<input type="text" name="password" class="lock" placeholder="密码">
							<input type="submit" name="Sign In" value="Sign In">
						</form>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../common/foot.jsp" %>
	</div>
	<%@include file="../common/script.jsp" %>
<scrip src="/static/js/service/login.js"></scrip>
</body>
</html>