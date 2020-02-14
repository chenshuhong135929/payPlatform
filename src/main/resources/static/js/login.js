$(function () {
    //登录
    $("#userLogin").click(function () {
        var adminNumber = $("#adminNumber").val();
        var adminPassword = $("#adminPassword").val();
        if(payPlatform.checkIsNullOrEmpty(adminNumber)){
            layer.alert("用户账号不能为空!")
            return;
        }
        if(payPlatform.checkIsNullOrEmpty(adminPassword)){
            layer.alert("用户密码不能为空!")
            return;
        }
        var call = function(data){
            if(data.code != 200){
                layer.alert(data.message);
            }else{
                location.href = REQUEST_URL +  "/index.html";
            }
        }
        payPlatform.api_request("admin/loginIn",{number : adminNumber, password:adminPassword},call);
    });

});