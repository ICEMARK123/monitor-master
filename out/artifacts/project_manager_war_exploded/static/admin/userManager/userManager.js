var contextPath = "";
$(function () {
   $("#addBtn").click(function () {
       // alert("添加用户！");
           var d = dialog({
               width: 300,
               title: '添加用户',
               content:
               '<div>'+
                     '<label>账号：</label>' +
                     '<input style="float:right;margin-right:30px;" type="text" id="user_account"/>' +
               '</div>' +
               '<div style="margin-top:5px;">'+
                      '<label>用户名：</label>' +
                      '<input style="float:right;margin-right:30px;" type="text" id="user_name"/>' +
               '</div>' +
               '<div style="margin-top:5px;">'+
                      '<label>密码:</label>' +
                      '<input style="float:right;margin-right:30px;" type="password" id="user_passwd"/>' +
               '</div>' +
               '<div style="margin-top:5px;">'+
                      '<label>身份:</label>' +
                      '<select style="float:right;margin-right:30px;" id="user_ident">' +
                             '<option value="admin">管理员</option>' +
                             '<option value="user">一般用户</option>' +
                      '</select>' +
               '</div>' ,


               okValue: '确定',
               ok: function() {
                   if (ISNull()){
                       addUser();
                   }

               },
               cancelValue: '取消',
               cancel: function() {
                   // do something
               }
           });
           d.showModal();
   }) ;
    $("#searchUser").click(function () {
        var searLoginUser = $("#searLoginUser").val();
        if(searLoginUser==null||searLoginUser==""){
            alert("请输您要查找的用户名！");
        }else{
            contextPath = $("#contextpath").val();
            var url = contextPath +"/UserDeal/userSearch.power";
            var data = {};
            data.userName = searLoginUser;
            $.ajaxSetup({
                async:true//设置同步
            });
            $.post(url,data,function (resu,status) {
                if(status == "success"){
                    //如果用户存在，则在下面的区域显示搜索的用户的信息
                    if(resu.info=="用户存在！"){
                        // $(".user_content").hide();
                        var newtable = "<tr>" +
                            "<th>账号</th>" +
                            "<th>登录名</th>" +
                            "<th>角色</th>" +
                            "<th>最后登录时间</th>" +
                            "<th>修改</th>" +
                            "<th>删除</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>" +resu.user.userId+"</td>" +
                            "<td>"+resu.user.userName+"</td>";
                        if(resu.user.isRootUser){
                            newtable += "<td>管理员</td>";
                        }else{
                            newtable += "<td>一般用户</td>"
                        }
                        if(resu.user.lastLoginTime==null){
                            newtable+="<td></td>";
                        }else{
                            newtable += "<td>"+resu.user.lastLoginTime+"</td>";
                        }
                        newtable += "<td><input type='button' onclick='modify("+resu.user.userId+")' value='修改'/></td>" +
                            "<td><input type='button' onclick='deleteUser("+resu.user.userId+")' value='删除'/></td>" +
                            "</tr>"
                       $("#table_bodyInfo").html(newtable);

                    }else{
                        alert(resu.info);
                    }
                }
            },"json");
        }
    });
});
function ISNull() {
    var user_account = $("#user_account").val();
    var user_name = $("#user_name").val();
    var user_passwd = $("#user_passwd").val();
    // var user_ident = $("#user_ident option:selected").val();
    if (user_account==""||user_account==null){
        alert("账号不能为空！");
        return false;
    }
    if (user_name==""||user_name==null){
        alert("用户名不能为空！");
        return false;
    }
    if (user_passwd==""||user_passwd==null){
        alert("密码不能为空！");
        return false;
    }
    // if (user_ident==""||user_ident==null){
    //     alert("身份不能为空！");
    //     return false;
    // }
    return true;
}
function addUser(){  //点击确定后提交添加的用户信息
    contextPath = $("#contextpath").val();
    var user_account = $("#user_account").val();
    var user_name = $("#user_name").val();
    var user_passwd = $("#user_passwd").val();
    var user_ident = $("#user_ident option:selected").val();
    $.ajaxSetup({
        async:true//设置同步
    });
    var url = contextPath+"/UserDeal/addUser.power";
    // alert(url);
    var data = {};
    data.user_account = user_account;
    data.user_name = user_name;
    data.user_passwd = user_passwd;
    data.user_ident = user_ident;
    $.post(url,data,function (result,status) {//show not found
        // alert(status);
        if(status=="success"){
            // alert("添加成功");
            alert(result.message);
            window.location.href = contextPath +"/UserDeal/showUsers.power";
        }
    },"json");
}
//修改
function modify(userId) {
    var d = dialog({
        width: 300,
        title: '修改用户',
        content:
        '<div>'+
        '<label>账号：</label>' +
        '<input style="float:right;margin-right:30px;" value ="'+userId+'" readonly type="text" id="user_account"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>用户名：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="user_name"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>密码:</label>' +
        '<input style="float:right;margin-right:30px;" type="password" id="user_passwd"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>身份:</label>' +
        '<select style="float:right;margin-right:30px;" id="user_ident">' +
        '<option value="admin">管理员</option>' +
        '<option value="user">一般用户</option>' +
        '</select>' +
        '</div>' ,


        okValue: '确定',
        ok: function() {
            if(ISNull()){
                modifyUser(userId);
            }

        },
        cancelValue: '取消',
        cancel: function() {
            // do something
        }
    });
    d.showModal();
}
function modifyUser(userId) {
    contextPath = $("#contextpath").val();
    var user_account = $("#user_account").val();
    var user_name = $("#user_name").val();
    var user_passwd = $("#user_passwd").val();
    var user_ident = $("#user_ident option:selected").val();
    var url = contextPath + "/UserDeal/modifyUser.power";
    var data = {};
    data.user_account = user_account;
    data.user_name = user_name;
    data.user_passwd = user_passwd;
    data.user_ident = user_ident;
    $.post(url,data,function (result,status) {//show not found
        // alert(status);
        if(status=="success"){
            // alert("添加成功");
            alert(result.message);
            window.location.href = contextPath +"/UserDeal/showUsers.power";
        }
    },"json");
    
}
function deleteUser(userId) {
    // alert(userId);
    var d = dialog({
        width: 260,
        quickClose: true,
        title:'删除用户',
        content: '您确定要删除该用户！',
        ok: function() {
            delUser(userId);
        },
        cancelValue: '取消',
        cancel: function() {
            console.log(this)
            // do something
        },
        onshow: function() {
            console.log(this)
            // do something
        }
    });
    d.show();
}
function delUser(userId) {
    contextPath = $("#contextpath").val();
    var url = contextPath +"/UserDeal/deleteUser.power";
    var data = {};
    data.userId = userId;
    // alert("您确定要删除该用户！")
    $.ajaxSetup({
        async:true//设置同步
    });
    $.post(url,data,function(resu,status){
        // alert(status);
        if(status =="success"){
            alert(resu.message);
            window.location.href = contextPath +"/UserDeal/showUsers.power";
        }
    },"json")
}