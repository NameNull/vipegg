/* 判断非空*/
function isEmpty(val) {
	val = $.trim(val);
	if (val == null)
		return true;
	if (val == undefined || val == 'undefined')
		return true;
	if (val == "")
		return true;
	if (val.length == 0)
		return true;
	if (!/[^(^\s*)|(\s*$)]/.test(val))
		return true;
	return false;
}
//隐藏四位手机号
function hide_tel(old_tel){
	var tel=old_tel+"";
	var pos=tel.indexOf("@");
	if(pos!=-1){
		var str1=tel.substring(0,3);
		var str2=tel.substring(pos);
		return str1+"***"+str2;

	}else if(tel.length==11){
		var str1=tel.substring(0,3);
		var str2=tel.substring(7,11);
		return str1+"****"+str2;
	}else{
		var str1=tel.substring(0,3);
		return str1+"***";
	}
}

Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1,
		// 月份
		"d+" : this.getDate(),
		// 日
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
		// 小时
		"H+" : this.getHours(),
		// 小时
		"m+" : this.getMinutes(),
		// 分
		"s+" : this.getSeconds(),
		// 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		// 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	var week = {
		"0" : "/u65e5",
		"1" : "/u4e00",
		"2" : "/u4e8c",
		"3" : "/u4e09",
		"4" : "/u56db",
		"5" : "/u4e94",
		"6" : "/u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt
				.replace(
						RegExp.$1,
						((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
								: "/u5468")
								: "")
								+ week[this.getDay() + ""]);
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};

function getTimeFormat(startTime) {
	var startTimeMills = startTime.getTime();
	var endTimeMills = new Date().getTime();
	var diff = parseInt((endTimeMills - startTimeMills) / 1000);//秒
	var day_diff = parseInt(Math.floor(diff / 86400));//天
	var buffer = Array();
	if (day_diff < 0) {
		return "[error],时间越界...";
	} else {
		if (day_diff == 0 && diff < 60) {
			if (diff <= 0)
				diff = 1;
			buffer.push(diff + "秒前");
		} else if (day_diff == 0 && diff < 120) {
			buffer.push("1 分钟前");
		} else if (day_diff == 0 && diff < 3600) {
			buffer.push(Math.round(Math.floor(diff / 60)) + "分钟前");
		} else if (day_diff == 0 && diff < 7200) {
			buffer.push("1小时前");
		} else if (day_diff == 0 && diff < 86400) {
			buffer.push(Math.round(Math.floor(diff / 3600)) + "小时前");
		} else if (day_diff == 1) {
			buffer.push("1天前");
		} else if (day_diff < 7) {
			buffer.push(day_diff + "天前");
		} else if (day_diff < 30) {
			buffer.push(Math.round(Math.floor(day_diff / 7)) + " 星期前");
		} else if (day_diff >= 30 && day_diff <= 179) {
			buffer.push(Math.round(Math.floor(day_diff / 30)) + "月前");
		} else if (day_diff >= 180 && day_diff < 365) {
			buffer.push("半年前");
		} else if (day_diff >= 365) {
			buffer.push(Math.round(Math.floor(day_diff / 30 / 12)) + "年前");
		}
	}
	return buffer.toString();
};

function isPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = ["Android", "iPhone",
        "SymbianOS", "Windows Phone",
        "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}

//验证邮箱
function emailFormatCheck(email){
    if ((email.length > 128) || (email.length < 6)) {
    	return false;
    }
    var format = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    if (!email.match(format)) {
    	return false;
    }
    return true;
}
/*验证手机号*/
function mobilephoneFormatCheck(mobilephone){
    var format = /^1\d{10}$/;
    if (!mobilephone.match(format)) {
    	return false;
    }
    return true;
}
/*验证数字*/
function numCheck(num){
	var format=/^[0-9]+\.?[0-9]*$/;
	if(!num.match(format)){
		return false;
	}
	return true;
}
/*验证整数*/
function intCheck(num){
	var format=/^[0-9]*$/;
	if(!num.match(format)){
		return false;
	}
	return true;
}
/*验证日期 2015-11-11 11:11:11*/
function dateCheck(num){
	var format=/^(20\d{2})-(0?[1-9]|10|11|12)-([1-2]?[0-9]|0[1-9]|30|31) (1[0-9]|0?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])$/;
	if(!num.match(format)){
		return false;
	}
	return true;
}
/*居中窗体*/
function center_size(id){
	var $this=$("#"+id);
	var height=$this.height();
	var width=$this.width();
	var left=($(window).width()-width)/2;
	var top=($(window).height()-height)/2;
	$this.css({"top":top,"left":left});
}

function center_box(id){
	center_size(id);
	$(window).resize(function(){
		center_size(id);
	});
}