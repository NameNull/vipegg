(function ($) {
    var _ajax = $.ajax;
    $.ajax = function (opt) {
        var fn = {
            success: function (data, textStatus) {
            }
        };
        if (opt.success) {
            fn.success = opt.success;
        }
        var _opt = $.extend(opt, {
            success: function (data, textStatus,jqXHR) {
                if ((typeof(data) == "string" && $.trim(data) == '{"code":401}') || (data && data.code == 401)) {
                    exit();
                    $("#login").click();
                } else {
                    fn.success(data, textStatus,jqXHR);
                }
            }
        });
        return _ajax(_opt);
    };
    $.getError = function (error, url, data, success) {
        $.ajax({
            url: url,
            data: data,
            success: success,
            error: error,
            dataType: "json"
        });
    };
})(jQuery);
