<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="./common/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/meta.jsp"%>
	<link href="/static/js/themes/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="login">
		<div id="login_content">
			<div class="loginForm">
				<p>
					<label>手机号：</label>
					<input id="mobile" type="text" name="telephone" size="20" class="login_input" />
				</p>
				<p>
					<label>密码：</label>
					<input type="password" name="password" size="20" class="login_input" />
				</p>
				<div class="login_bar">
					<input class="sub" type="submit" value="" id="login_btn"/>
				</div>
			</div>
			<div class="login_banner"><img src="/static/js/themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
				<div class="login_inner">
					<p>实时短信提醒，确保用户账户和资金安全</p>
					<p>比特币钱包多层加密，离线存储，保障资产安全 </p>
					<p>HTTPS高级安全加密协议，客户资料全加密传输，防止通过网络泄漏 ……</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			<%@ include file="./common/footer.jsp"%>
		</div>
	</div>
	<%@ include file="./common/script.jsp"%>
	<script src="/static/js/login.js"></script>
</body>
</html>
