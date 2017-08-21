function tm_dialog(options){
    var width = 460;
    var defaults = {
        title:"<i class='icon c_orange'>&#xe602;</i>&nbsp;" + "提示",
        content:"请输入内容 ！",
        bg_color: "#3aa1f1",
        hover_bg_color: "#288ede",
        width:width,
        sureText:"确定",
        cancelText:"取消",
        showDoubleButton:true,
        showSingleButton:false
    };

    var opts = $.extend({},defaults,options);
    if($("#dialogbox").length==1){
        return;
    }
    $("body").append("<div class='b_l w460' id='dialogbox'>"+
        "	<div class='bcom_ti'>"+
        "		<a href='javascript:void(0);' class='bide layer_icon icon close fr'>&#xe62e;</a><span>" + opts.title + "</span>" +
        "	</div>"+
        "	<div class='bcom_cent'>"+
        "		<p class='bcomti'>"+opts.content+"</p>"+
        "		<p class='bcoma double'>"+
        "			<a href='javascript:void(0);' class='bc_abut1 sure'>"+opts.sureText+"</a>"+
        "			<a href='javascript:void(0);' class='bc_abut2 close'>"+opts.cancelText+"</a>"+
        "		</p>"+
        "		<p class='bcoma single'>"+
        "			<a href='javascript:void(0);' class='bc_abut1 sure' style='margin:30px 0 0 50px;'>"+opts.sureText+"</a>"+
        "		</p>"+
        "	</div>"+
        "</div>").append("<div class='tmui-overlay' style='height:"+$(window).height()+"px'></div>");
    var $dialog = $("#dialogbox");
    if(!opts.showDoubleButton)$dialog.find(".double").remove();
    if(!opts.showSingleButton)$dialog.find(".single").remove();
    var contentHeight = opts.height-200;
    $dialog.find(".bcomti").css({"height":contentHeight,"lineHeight":contentHeight+"px"});
    $dialog.width(opts.width);
    $dialog.height(opts.height);
    $(".bc_abut1").css({background: opts.bg_color});
    $(".bcom_ti .close").hover(function () {
        $(this).css({color: opts.bg_color});
    }, function () {
        $(this).css({color: "#444"});
    });
    $(".bc_abut1").hover(function () {
        $(this).css({background: opts.hover_bg_color});
    }, function () {
        $(this).css({background: opts.bg_color});
    });
    center_box("dialogbox");
    //关闭按钮绑定点击事件
    $dialog.find(".close").click(function(){
        $dialog.next().remove();//删除遮罩层
        $dialog.remove();
        if(opts.reload){
            location.reload();
        }
    });
    $dialog.find(".sure").click(function(){
        $dialog.next().remove();//删除遮罩层
        $dialog.remove();
        if(opts.callback){
            opts.callback(true);
        }else if(opts.reload){
            location.reload();
        }
    });
}

window.error_dialog = function(){
    var callback = arguments[1];
    tm_dialog({
        title: "错误提示",
        content:arguments[0],
        bg_color: "#fd0202",
        hover_bg_color: "#fe6f6f",
        showDoubleButton:false,
        showSingleButton:true,
        callback:function(){
            callback && callback();
        }
    })
};

window.success_dialog = function () {
    var callback = arguments[1];
    var opts = {
        title: "操作成功",
        content: arguments[0],
        bg_color: "#1f963d",
        hover_bg_color: "#50ad67",
        showDoubleButton: false,
        showSingleButton: true,
        reload:1
    };
    if(callback){
        opts['callback'] = callback;
    }
    tm_dialog(opts);
};

window.confirm_dialog = function(){
    var callback = arguments[1];
    tm_dialog({
        title: "提示",
        content:arguments[0],
        callback:function(){
            callback && callback();
        }
    })
};