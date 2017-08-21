$(function(){
   $("#login_btn").click(function(){
       var $form = $("form");
       var url = $form.attr("action");
       var telephone = $("input[name=telephone]").val().trim();
       if(isEmpty(telephone)){
           error_dialog("手机不能为空");
           return;
       }
       var password = $("input[name=password]").val().trim();
       if(isEmpty(password)){
           error_dialog("密码不能为空");
           return;
       }
       $.post(url,{telephone: telephone, password: password}, function(data){
           if(data.code == 200){
                location.href="/";
           }else{
               error_dialog(data.error);
           }
       },"json");
      return false;
   });
});