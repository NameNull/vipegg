<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/includes.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="../common/meta.jsp" %>
	<title>后台登录页</title>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

	<link href="/static/css/style.css" rel='stylesheet' type='text/css' />
	<link href="/static/css/font-awesome.css" rel="stylesheet">
	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/modernizr.custom.js"></script>
	<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
	<link href="/static/css/animate.css" rel="stylesheet" type="text/css" media="all">
	<script src="/static/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
	<script src="/static/js/metisMenu.min.js"></script>
	<script src="/static/js/custom.js"></script>
	<link href="/static/css/custom.css" rel="stylesheet">
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
							<input type="text" class="user" name="email" placeholder="Enter your email" required="">
							<input type="text" name="password" class="lock" placeholder="password">
							<input type="submit" name="Sign In" value="Sign In">
							<div class="forgot-grid">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Remember me</label>
								<div class="forgot">
									<a href="#">forgot password?</a>
								</div>
								<div class="clearfix"> </div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../common/foot.jsp" %>
	</div>
	<script src="/static/js/classie.js"></script>
	<script>
		var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
			showLeftPush = document.getElementById( 'showLeftPush' ),
			body = document.body;

		showLeftPush.onclick = function() {
			classie.toggle( this, 'active' );
			classie.toggle( body, 'cbp-spmenu-push-toright' );
			classie.toggle( menuLeft, 'cbp-spmenu-open' );
			disableOther( 'showLeftPush' );
		};

		function disableOther( button ) {
			if( button !== 'showLeftPush' ) {
				classie.toggle( showLeftPush, 'disabled' );
			}
		}
	</script>
	<script src="/static/js/jquery.nicescroll.js"></script>
	<script src="/static/js/scripts.js"></script>
	<%@include file="../common/script.jsp" %>
</body>
</html>