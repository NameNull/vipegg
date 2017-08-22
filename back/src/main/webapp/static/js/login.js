$(function(){
    $("#login_btn").click(function(){
        var telephone = $("input[name=telephone]").val().trim();
        if(isEmpty(telephone)){
            alert("手机不能为空");
            return;
        }
        var password = $("input[name=password]").val().trim();
        if(isEmpty(password)){
            alert("密码不能为空");
            return;
        }
        $.post("/loginAjax",{telephone: telephone, password: password}, function(data){
            if(data.code == 200){
                location.href="/";
            }else{
                alert(data.error);
            }
        },"json");
        return false;
    });
});