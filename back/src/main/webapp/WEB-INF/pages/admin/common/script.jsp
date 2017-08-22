<%@ page pageEncoding="UTF-8"%>
<script src="/static/js/jquery/jquery-1.7.2.min.js"></script>
<script src="/static/js/jquery/jquery.cookie.js"></script>
<script src="/static/js/util/util.js"></script>
<script src="/static/js/verify.code.js"></script>
<script src="/static/js/jquery/jquery.validate.js"></script>
<script src="/static/js/jquery/jquery.bgiframe.js"></script>
<script src="/static/js/xheditor/xheditor-1.2.1.min.js"></script>
<script src="/static/js/xheditor/xheditor_lang/zh-cn.js"></script>
<script src="/static/js/uploadify/scripts/jquery.uploadify.js"></script>
<script  src="/static/js/chart/raphael.js"></script>
<script src="/static/js/chart/g.raphael.js"></script>
<script src="/static/js/chart/g.bar.js"></script>
<script src="/static/js/chart/g.line.js"></script>
<script src="/static/js/chart/g.pie.js"></script>
<script src="/static/js/dwz/dwz.core.js" ></script>
<script src="/static/js/dwz/dwz.util.date.js"></script>
<script src="/static/js/dwz/dwz.validate.method.js"></script>
<script src="/static/js/dwz/dwz.barDrag.js" ></script>
<script src="/static/js/dwz/dwz.drag.js" ></script>
<script src="/static/js/dwz/dwz.tree.js" ></script>
<script src="/static/js/dwz/dwz.accordion.js"></script>
<script src="/static/js/dwz/dwz.ui.js" ></script>
<script src="/static/js/dwz/dwz.theme.js" ></script>
<script src="/static/js/dwz/dwz.switchEnv.js"></script>
<script src="/static/js/dwz/dwz.alertMsg.js"></script>
<script src="/static/js/dwz/dwz.contextmenu.js"></script>
<script src="/static/js/dwz/dwz.navTab.js" ></script>
<script src="/static/js/dwz/dwz.tab.js" ></script>
<script src="/static/js/dwz/dwz.resize.js" ></script>
<script src="/static/js/dwz/dwz.dialog.js" ></script>
<script src="/static/js/dwz/dwz.dialogDrag.js"></script>
<script src="/static/js/dwz/dwz.sortDrag.js"></script>
<script src="/static/js/dwz/dwz.cssTable.js"></script>
<script src="/static/js/dwz/dwz.stable.js" ></script>
<script src="/static/js/dwz/dwz.taskBar.js" ></script>
<script src="/static/js/dwz/dwz.ajax.js" ></script>
<script src="/static/js/dwz/dwz.pagination.js"></script>
<script src="/static/js/dwz/dwz.database.js"></script>
<script src="/static/js/dwz/dwz.datepicker.js"></script>
<script src="/static/js/dwz/dwz.effects.js" ></script>
<script src="/static/js/dwz/dwz.panel.js" ></script>
<script src="/static/js/dwz/dwz.checkbox.js"></script>
<script src="/static/js/dwz/dwz.history.js" ></script>
<script src="/static/js/dwz/dwz.combox.js" ></script>
<script src="/static/js/dwz/dwz.print.js" ></script>
<script src="/static/js/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<script src="/static/js/ztree/js/keta.js" ></script>
<script src="/static/js/treeTable/jquery.treeTable.min.js"></script>
<!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)
<script src="bin/dwz/dwz.min.js" ></script>
-->
<script src="/static/js/dwz/dwz.regional.zh.js"></script>

<script >
    $(function() {
        DWZ.init("/static/js/dwz/dwz.frag.xml", {
            loginUrl : "login_dialog",
            loginTitle : "登录", // 弹出登录对话框
            //		loginUrl:"login",	// 跳到登录页面
            statusCode : {
                ok : 200,
                error : 300,
                timeout : 301
            }, //【可选】
            pageInfo : {
                pageNum : "pageNum",
                numPerPage : "numPerPage",
                orderField : "orderField",
                orderDirection : "orderDirection"
            }, //【可选】
            debug : false, // 调试模式 【true|false】
            callback : function() {
                initEnv();
                $("#themeList").theme({
                    themeBase : "static/js/themes"
                }); // themeBase 相对于index页面的主题base路径
            }
        });
    });
</script>
