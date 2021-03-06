<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="./common/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/meta.jsp"%>
	<link href="/static/js/themes/default/style.css" rel="stylesheet"/>
	<link href="/static/js/themes/css/core.css" rel="stylesheet" />
	<link href="/static/js/uploadify/css/uploadify.css" rel="stylesheet" />
	<link href="/static/js/ztree/css/zTreeStyle.css" rel="stylesheet"/>
	<link href="/static/js/treeTable/themes/default/treeTable.css" />
	<link href="/static/js/ztree/css/keta.css" rel="stylesheet" />
</head>
<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<ul class="nav">
					<li><a href="loginOut">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div>
					</li>
					<li theme="green"><div>绿色</div>
					</li>
					<li theme="purple"><div>紫色</div>
					</li>
					<li theme="silver"><div>银色</div>
					</li>
					<li theme="azure"><div>天蓝</div>
					</li>
				</ul>
			</div>
		</div>
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>
             <%@ include file="./common/detail.jsp"%>
			</div>
		</div>

		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span> </span> </a>
							</li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<div class="tabsRight">right</div>
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a>
					</li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<p>
								<span>${sessionScope.admin_session.role.name}: <b>${sessionScope.admin_session.name}</b></span>
							</p>
						</div>
						<div>
						<img src="../../../static/img/welcome.jpg"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<%@ include file="./common/footer.jsp"%>
	</div>
	<%@ include file="./common/script.jsp"%>
</body>
</html>