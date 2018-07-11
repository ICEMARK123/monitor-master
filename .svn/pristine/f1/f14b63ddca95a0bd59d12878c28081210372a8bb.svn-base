var account = "";
var passwd = "";
var vercode = "";
var ident = "";
var contextPath = "";
$(function () {
    $("#login").click(function () {
        contextPath = $("#contextpath").val();
        account = $("#account").val();
        passwd = $("#passwd").val();
        vercode = $("#vercode").val();
        ident = $("input[name='ident']:checked").val();
        if(IsNull()){
            if(checkSecuritycode()){
                $('title').text("请稍等...");
                checkCount();
            }
        }
    })
});
function checkCount(){
    var url = contextPath+"/login/checkAccount.power";
    var data = {};
    data.account = account;
    data.passwd = passwd;
    data.ident = ident;
    $.ajaxSetup({
        async:false//设置同步
    });
    $.post(url,data,function(result,status){
        // alert(result.checkResult);
        // alert(status);
        if(status=="success"){
            if(result.checkResult!=="success"){
                alert(result.checkResult);
                if(result.checkResult=="账户不存在！"){
                    location.reload(true);
                }
            }else{
                // alert("页面跳转");
                // window.open(contextPath+"/admin/mainPage.jsp");
                window.location.href=contextPath+"/mainPage/messureList.power";
                // window.navigate("/admin/mainPage.jsp");
                //location.href("/admin/mainPage.jsp");//页面跳转有问题，不能成功跳转
            }
        }
    },"json")
}
function myReload(){
    document.getElementById("img").src=document.getElementById("img").src+"?nocache="+new Date().getTime();
}
function checkSecuritycode(){
    var url=contextPath+"/login/check.power";
    // alert(url);
    var data = {};
    data.vercode = vercode;
    var returnresult = false;
    $.ajaxSetup({
        async:false//设置同步
    });
    $.post(url,data,function(resu,status){
        if(status=="success"){
            if(!resu.result_jieguo){
                alert("验证码输入有误！");
                myReload();
                returnresult = false;
            }else{
                returnresult = true;
            }
        }
    },"json")
    return returnresult;
}
function IsNull(){
    if(account==null||account==""){
        alert("登录账号不能为空！");
        return false;
    }
    if(passwd==null||passwd==""){
        alert("密码不能为空！");
        return false;
    }
    if(vercode==null||vercode==""){
        alert("验证码不能为空！");
        return false;
    }
    if(ident==null||ident==""){
        alert("请选择登录的身份！");
        return false;
    }
    return true;
}