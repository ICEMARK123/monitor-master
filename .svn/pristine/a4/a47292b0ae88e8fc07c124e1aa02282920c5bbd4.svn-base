var contextPath = "";
$(function () {
    $(".addbtn").click(function () {
        contextPath = $("#contextpath").val();
        var url = contextPath + "/messureSite/getAllDevTypeName.power";
        var data = {};
        $.ajaxSetup({
            async:false
        });
        $.post(url, data, function (result,status) {
            if (status == "success"){
                var con = '<div>'+
                    '<label style="width:60px;">接线方式:</label>' +
                    '<input  type="text" style="width:140px;" id="lineWay"/>' +
                    '<label style="width:60px;">安装位置:</label>' +
                    '<input type="text" style="width:140px;" id="installLocation"/>' +
                    '</div>' +
                    '<div style="margin-top:10px;">'+
                    '<label style="width:60px;">设备描述:</label>' +
                    '<input  type="text" style="width:140px;" id="devDescript" />' +
                    '<label style="width:60px;">设备编码:</label>' +
                    '<input type="text" style="width:140px;" id="devCode"/>' +
                    '</div>' +
                    '<div style="margin-top:10px;">'+
                    '<label style="width:80px;">设备类型名称:</label>' +
                    '<select id="devTypeName" style="width:120px;">' ;
                for (var i = 0;i<result.devTypeNameList.length;i++){
                    con += '<option value="'+result.devTypeNameList[i]+'">'+ result.devTypeNameList[i]+'</option>';
                }
                con += '</select>' +
                    '<label style="width:60px;">机&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>' +
                    '<input type="text"  id="machineNo" style="width:140px;" /> ' +
                    '</div>' +
                    '<div style="margin-top:10px;">' +
                    '<label style="width:60px;">手机卡号:</label>' +
                    '<input type="text" id="phonenumber" style="width:140px;"/> ' +
                    '</div>' +
                    '</div>' ;
                var d = dialog({
                    width: 400,
                    title: '添加设备台账',
                    content:
                    con,
                    okValue: '确定',
                    ok: function() {
                        if (notNull()){
                            addDevLedger();
                        }
                        
                    },
                    cancelValue: '取消',
                    cancel: function() {
                        // do something
                    }
                });
                d.showModal();
            }
        },"json");
    });
    $("#searchLocation").click(function () {
        contextPath = $("#contextpath").val();
        var searchContent = $("#searchContent").val();
        var url = contextPath + "/messureSite/searchMessureInfo.power";
        var data =  {};
        data.searchContent = searchContent;
        $.ajaxSetup({
            async:false
        });
        $.post(url, data, function (result,status) {
            alert(status);
            if (status === "success"){
                if (result.getMessureSiteList.length>0){
                    alert(result.getMessureSiteList.length);
                    var newtable = "<tr>" +
                        "<th>接线方式</th>" +
                        "<th>安装位置</th>" +
                        "<th>设备规格描述</th>" +
                        "<th>设备编码</th>" +
                        "<th>设备类型名称</th>" +
                        "<th>机号</th>" +
                        "<th>手机卡号</th>" +
                        "<th>保存时间</th>" +
                        "<th>修改操作</th>" +
                        "</tr>";
                    for (var i = 0;i<result.getMessureSiteList.length;i++){
                        newtable += "<tr>" +
                            "<td>"+result.getMessureSiteList[i].lineWay+"</td>"+
                            "<td>"+result.getMessureSiteList[i].location+"</td>"+
                            "<td>"+result.getMessureSiteList[i].devDescript+"</td>"+
                            "<td>"+result.getMessureSiteList[i].devCode+"</td>"+
                            "<td>"+result.getMessureSiteList[i].devTypeInfo.type_name+"</td>"+
                            "<td>"+result.getMessureSiteList[i].machineNo+"</td>"+
                            "<td>"+result.getMessureSiteList[i].phonenumber+"</td>"+
                            "<td>"+result.getMessureSiteList[i].saveTime+"</td>"+
                            "<td><input type='button' onclick='modifyMessureSite('"+result.getMessureSiteList[i].machineNo+"')' value='修改'/></td>" +
                            "</tr>";
                    }
                    $("#table_bodyInfoshow").html(newtable);

                }else{
                    alert("没有合适的结果！");
                    window.location.href = contextPath + "/messureSite/getDeviceEquipment.power";
                }
            }
        },"json");
    })
});
function notNull() {
    var machineNo = $("#machineNo").val();
    if (machineNo==""||machineNo==null){
        alert("机号不能为空！");
        return false;
    }
    return true;
}
function addDevLedger() {
    contextPath = $("#contextpath").val();
    var lineWay = $("#lineWay").val();
    var installLocation = $("#installLocation").val();
    var devDescript = $("#devDescript").val();
    var devCode = $("#devCode").val();
    var devTypeName = $("#devTypeName option:selected").val();
    var machineNo = $("#machineNo").val();
    var phonenumber = $("#phonenumber").val();
    var url = contextPath + "/messureSite/addDevLedger.power";
    var data = {};
    data.lineWay = lineWay;
    data.installLocation = installLocation;
    data.devDescript = devDescript;
    data.devCode = devCode;
    data.devTypeName = devTypeName;
    data.machineNo = machineNo;
    data.phonenumber = phonenumber;
    $.ajaxSetup({
        async:false
    });
    $.post(url, data, function (result,status) {
        if (status == "success") {
            alert(result.message);
            window.location.href = contextPath + "/messureSite/getDeviceEquipment.power";
        }
    },"json");
}

// 修改测量点信息
function modifyMessureSite(machineNo) {
    contextPath = $("#contextpath").val();
    var url = contextPath + "/messureSite/getAllDevTypeName.power";
    var data = {};
    $.ajaxSetup({
        async:false
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            var con = '<div>'+
                '<label style="width:60px;">接线方式:</label>' +
                '<input  type="text" id="lineWay" style="width:140px;"/>' +
                '<label style="width:60px;">安装位置:</label>' +
                '<input type="text" id="installLocation" style="width:140px;"/>' +
                '</div>' +
                '<div style="margin-top:10px;">'+
                '<label style="width:60px;">设备描述:</label>' +
                '<input  type="text" id="devDescript" style="width:140px;"/>' +
                '<label style="width:60px;">设备编码:</label>' +
                '<input type="text" id="devCode" style="width:140px;"/>' +
                '</div>' +
                '<div style="margin-top:10px;">'+
                '<label style="width:80px;">设备类型名称:</label>' +
                '<select id="devTypeName" style="width:120px;">' ;
            for (var i = 0;i<result.devTypeNameList.length;i++){
                con += '<option value="'+result.devTypeNameList[i]+'">'+ result.devTypeNameList[i]+'</option>';
            }
            con += '</select>' +
                '<label style="width:60px;">机&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>' +
                '<input type="text"  id="machineNo" value="'+machineNo+'" style="width:140px;" readonly/> ' +
                '</div>' +
                '<div style="margin-top:10px;">' +
                '<label style="width:60px;">手机卡号:</label>' +
                '<input type="text" id="phonenumber" style="width:140px;"/> ' +
                '</div>' +
                '</div>' ;
            var d = dialog({
                width: 400,
                title: '修改设备台账',
                content:
                con,
                okValue: '确定',
                ok: function() {
                    modifyMessure();
                },
                cancelValue: '取消',
                cancel: function() {
                    // do something
                }
            });
            d.showModal();
        }
    },"json");
}
function modifyMessure() {
    contextPath = $("#contextpath").val();
    var lineWay = $("#lineWay").val();
    var installLocation = $("#installLocation").val();
    var devDescript = $("#devDescript").val();
    var devCode = $("#devCode").val();
    var devTypeName = $("#devTypeName option:selected").val();
    var machineNo = $("#machineNo").val();
    var phonenumber = $("#phonenumber").val();
    var url = contextPath + "/messureSite/modifyMessure.power";
    var data = {};
    data.lineWay = lineWay;
    data.installLocation = installLocation;
    data.devDescript = devDescript;
    data.devCode = devCode;
    data.devTypeName = devTypeName;
    data.machineNo = machineNo;
    data.phonenumber = phonenumber;
    $.ajaxSetup({
        async:false
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            alert(result.message);
            window.location.href = contextPath +"/messureSite/getDeviceEquipment.power";
        }
    },"json")
}

