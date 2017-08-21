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
						<form action="/loginAjax" method="post">
							<input type="text" class="user" name="telephone" placeholder="手机号" autocomplete="off" required="required">
							<input type="text" name="password" class="lock" placeholder="密码" autocomplete="off" required="required">
							<input type="submit" value="登录" id="login_btn">
						</form>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../common/foot.jsp" %>
	</div>
	<%@include file="../common/script.jsp" %>
	<script src="/static/js/service/login.js"></script>
</body>
</html>