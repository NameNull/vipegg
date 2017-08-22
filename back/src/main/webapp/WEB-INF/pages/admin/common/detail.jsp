<%@ page pageEncoding="UTF-8"%>
<div class="accordion" fillSpace="sidebar">
	<shiro:hasPermission name="user">
		<div class="accordionHeader">
			<h2>
				<span>Folder</span>会员管理
			</h2>
		</div>
		<div class="accordionContent">
			<ul class="tree treeFolder">
				<shiro:hasPermission name="userList">
					<li><a href="userList" target="navTab"
						rel="userList">会员列表</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="userAuditList">
					<li><a href="userAuditList" target="navTab"
						rel="userAuditList">待审核会员列表</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="logList">
					<li><a href="logList" target="navTab"
						rel="logList">会员操作日志列表</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="entrustlogList">
					<li><a href="entrustlogList" target="navTab"
						rel="entrustlogList">会员交易记录列表</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="subscriptionList1">
					<li><a href="subscriptionList1" target="navTab"
						rel="subscriptionList1">人民币认购列表</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="subscriptionList">
					<li><a href="subscriptionList" target="navTab"
						rel="subscriptionList">换购列表</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="vouchersList">
					<li><a href="vouchersList" target="navTab"
						rel="vouchersList">会员代金券列表</a>
					</li>
				</shiro:hasPermission>
				<!-- <shiro:hasPermission name="vouchersList"> -->
					
				<!-- </shiro:hasPermission> -->
			</ul>
		</div>
	</shiro:hasPermission>
	<shiro:hasPermission name="system">
		<div class="accordionHeader">
			<h2>
				<span>Folder</span>系统管理
			</h2>
		</div>
		<div class="accordionContent">
			<ul class="tree treeFolder">
				<%--<shiro:hasPermission name="systemArgsList">--%>
					<li><a href="systemArgsList" target="navTab"
						rel="systemArgsList">系统参数列表</a>
					</li>
				<%--</shiro:hasPermission>
				<shiro:hasPermission name="securityTreeList">--%>
					<li><a
						href="goSecurityJSP?url=securityTreeList&treeId=1"
						target="navTab" rel="securityTreeList">权限列表</a>
					</li>
				<%--</shiro:hasPermission>--%>
				<%--<shiro:hasPermission name="roleList">--%>
					<li><a href="roleList" target="navTab"
						rel="roleList">角色列表</a>
					</li>
				<%--</shiro:hasPermission>--%>
				<%--<shiro:hasPermission name="adminList">--%>
					<li><a href="adminList" target="navTab"
						rel="adminList">管理员列表</a>
					</li>
				<%--</shiro:hasPermission>--%>
				<%--<shiro:hasPermission name="countLimitList">--%>
					<li><a href="countLimitList" target="navTab"
						rel="countLimitList">限制管理列表</a>
					</li>
				<%--</shiro:hasPermission>--%>
			</ul>
		</div>
	</shiro:hasPermission>
</div>