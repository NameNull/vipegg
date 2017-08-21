<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/includes.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="../common/meta.jsp" %>
	<title>后台主页</title>
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<%@include file="../common/left.jsp" %>
		<%@include file="../common/head.jsp" %>
		<div id="page-wrapper">
			<div class="main-page">
				<div class="row-one">
					<div class="col-md-4 widget">
						<div class="stats-left ">
							<h5>今日</h5>
							<h4>访问量</h4>
						</div>
						<div class="stats-right">
							<label>45</label>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="col-md-4 widget states-mdl">
						<div class="stats-left">
							<h5>今日</h5>
							<h4>订单量</h4>
						</div>
						<div class="stats-right">
							<label> 80</label>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="col-md-4 widget states-last">
						<div class="stats-left">
							<h5>今日</h5>
							<h4>订单额</h4>
						</div>
						<div class="stats-right">
							<label>51</label>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<%@include file="../common/foot.jsp" %>
	</div>
	<%@include file="../common/script.jsp" %>
</body>
</html>