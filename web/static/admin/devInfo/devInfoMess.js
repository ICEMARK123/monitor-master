contextPath = "";
// 设置设备信息
function modify(dev_id) {
    var d = dialog({
        width: 300,
        title: '设置设备信息',
        content:
        '<div>'+
        '<label>使用单位：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="useCompany"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>安装位置:</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="installLocation"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>软件版本：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="softVersion"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>硬件版本：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="hardVersion"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>生产日期：</label>' +
        '<input style="float:right;margin-right:30px;" type="date" id="produceDate"/>' +
        '</div>' +
        '</div>' ,
        okValue: '确定',
        ok: function() {
            modifyDevInfo(dev_id);
        },
        cancelValue: '取消',
        cancel: function() {
            // do something
        }
    });
    d.showModal();
}
function modifyDevInfo(dev_id) {
    contextPath = $("#contextpath").val();
    var useCompany = $("#useCompany").val();
    var installLocation = $("#installLocation").val();
    var softVersion = $("#softVersion").val();
    var hardVersion = $("#hardVersion").val();
    var produceDate = $("#produceDate").val();
    // alert(produceDate);
    var url = contextPath + "/devInfo/modifyDevInfo.power";
    var data = {};
    data.devId = dev_id;
    data.useCompany = useCompany;
    data.softVersion = softVersion;
    data.installLocation = installLocation;
    data.hardVersion = hardVersion;
    data.produceDate = produceDate;
    $.ajaxSetup({
        async:false
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            alert(result.message);
            window.location.href = contextPath + "/devInfo/showDevInfoList.power";
        }
    },"json")

}
// 增加设备信息
function adddevInfo() {
    // alert("test");
    var d = dialog({
        width: 300,
        title: '增加设备信息',
        content:
        '<div>'+
        '<label>使用单位：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="useCompany"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>安装位置:</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="installLocation"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>软件版本：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="softVersion"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>硬件版本：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="hardVersion"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>生产日期：</label>' +
        '<input style="float:right;margin-right:30px;" type="date" id="produceDate"/>' +
        '</div>' +
        '</div>' ,


        okValue: '确定',
        ok: function() {
           addDevInfo();
        },
        cancelValue: '取消',
        cancel: function() {
            // do something
        }
    });
    d.showModal();
}
function addDevInfo() {
    contextPath = $("#contextpath").val();
    var useCompany = $("#useCompany").val();
    // alert(useCompany);
    var installLocation = $("#installLocation").val();
    var softVersion = $("#softVersion").val();
    var hardVersion = $("#hardVersion").val();
    var produceDate = $("#produceDate").val();
    var url = contextPath + "/devInfo/addDevInfo.power";
    var data = {};
    data.useCompany = useCompany;
    data.softVersion = softVersion;
    data.installLocation = installLocation;
    data.hardVersion = hardVersion;
    data.produceDate = produceDate;
    $.ajaxSetup({
        async:false
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            alert(result.message);
            window.location.href = contextPath + "/devInfo/showDevInfoList.power";
        }
    },"json")
}
//读取设备信息
function readInfo(dev_Id) {
    // alert(dev_Id);
    contextPath = $("#contextpath").val();
    var url = contextPath + "/devInfo/readDevInfo.power";
    // alert(url);
    var data = {};
    data.devId = dev_Id;
    $.ajaxSetup({
        async:false
    });
    $.post(url,data,function (result,status) {
        // alert(status);
        if(status === "success"){
            var newTable = "<tr>" +
                "<th>使用单位</th>" +
                "<th>安装位置</th>" +
                "<th>设备编号</th>" +
                "<th>软件版本</th>" +
                "<th>硬件版本</th>" +
                "<th>生产日期</th>" +
                "<th>设置操作</th>" +
                "<th>读取操作</th>" +
                "</tr>";
            newTable += "<tr>" +
                "<td>"+result.devInfo.use_company+"</td>"+
                "<td>"+result.devInfo.install_location+"</td>"+
                "<td>"+result.devInfo.dev_id+"</td>"+
                "<td>"+result.devInfo.soft_version+"</td>"+
                "<td>"+result.devInfo.hard_version+"</td>"+
                "<td>"+result.devInfo.production_date+"</td>" +
                "<td><input type='button' onclick='modify("+result.devInfo.dev_id+")' value='设置'/> </td>" +
                "<td><input type='button' onclick='readInfo("+result.devInfo.dev_id+")' value='读取'/> </td>";
            $("#table_bodyInfo").html(newTable);
        }
    },"json");
}