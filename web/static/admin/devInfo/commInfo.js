var contextPath = "";
function addComrefer() {
    contextPath = $("#contextpath").val();
    // var url1 = contextPath + "/devInfo/getAllMessureNo.power";  先保留
    var d = dialog({
        width: 400,
        title: '添加通讯参数',
        content:
        '<div>'+
        '<label style="width:60px;">主站IP:</label>' +
        '<input  type="text" id="mainIp"/>' +
        '<label style="width:60px;">主站端口:</label>' +
        '<input type="text" id="mainPort"/>' +
        '</div>' +
        '<div style="margin-top:10px;">'+
        '<label style="width:60px;">设备Ip:</label>' +
        '<input  type="text" id="devIp"/>' +
        '<label style="width:60px;">设备端口:</label>' +
        '<input type="text" id="devPort"/>' +
        '</div>' +
        '<div style="margin-top:10px;">'+
        '<label style="width:60px;">APN:</label>' +
        '<input type="text" id="apn">' +
        '<label style="width:60px;">SIM卡号:</label>' +
        '<input type="text" id="simNumber"/> '+
        '</div>' +
        '</div>' ,


        okValue: '确定',
        ok: function() {
                addComRefer();

        },
        cancelValue: '取消',
        cancel: function() {
            // do something
        }
    });
    d.showModal();
}
function addComRefer() {
    // alert("test");
    contextPath = $("#contextpath").val();
    var mainIp = $("#mainIp").val();
    var mainPort = $("#mainPort").val();
    var devPort = $("#devPort").val();
    var devIp = $("#devIp").val();
    var apn = $("#apn").val();
    var simNumber = $("#simNumber").val();
    var url = contextPath + "/devInfo/addComrefer.power";
    var data = {};
    data.mainIp = mainIp;
    data.mainPort = mainPort;
    data.devIp = devIp;
    data.devPort = devPort;
    data.apn = apn;
    data.simNumber = simNumber;
    $.ajaxSetup({
        async:false
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            alert(result.message);
            window.location.href = contextPath + "/devInfo/getComRefer.power";
        }
    },"json");
}
function modify(dev_ip) {
    var d = dialog({
        width: 400,
        title: '修改通讯参数',
        content:
        '<div>'+
        '<label style="width:60px;">主站IP:</label>' +
        '<input  type="text" id="mainIp"/>' +
        '<label style="width:60px;">主站端口:</label>' +
        '<input type="text" id="mainPort"/>' +
        '</div>' +
        '<div style="margin-top:10px;">'+
        '<label style="width:60px;">设备Ip:</label>' +
        '<input  type="text" id="devIp" value="'+dev_ip+'" readonly/>' +
        '<label style="width:60px;">设备端口:</label>' +
        '<input type="text" id="devPort"/>' +
        '</div>' +
        '<div style="margin-top:10px;">'+
        '<label style="width:60px;">APN:</label>' +
        '<input type="text" id="apn">' +
        '<label style="width:60px;">SIM卡号:</label>' +
        '<input type="text" id="simNumber"/> '+
        '</div>' +
        '<div style="margin-top:10px;">' +
        '<label>心跳时间(单位分钟):</label>' +
        '<input type="text" id="heartrate"/> ' +
        '</div>' +
        '</div>' ,


        okValue: '确定',
        ok: function() {
                modifyConrefer(dev_ip);

        },
        cancelValue: '取消',
        cancel: function() {
            // do something
        }
    });
    d.showModal();
}
function modifyConrefer(dev_ip) {
    contextPath = $("#contextpath").val();
    var mainIp = $("#mainIp").val();
    var mainPort = $("#mainPort").val();
    var devPort = $("#devPort").val();
    var apn = $("#apn").val();
    var simNumber = $("#simNumber").val();
    var heartrate = $("#heartrate").val();
    var url = contextPath + "/devInfo/modifyComrefer.power";
    var data = {};
    data.mainIp = mainIp;
    data.mainPort = mainPort;
    data.devIp = dev_ip;
    data.devPort = devPort;
    data.apn = apn;
    data.simNumber = simNumber;
    data.heartrate = heartrate;
    $.ajaxSetup({
        async:false
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            alert(result.message);
            window.location.href = contextPath + "/devInfo/getComRefer.power";
        }
    },"json");
}
function readInfo(dev_ip) {
    // alert(dev_ip);
    contextPath = $("#contextpath").val();
    var url = contextPath + "/devInfo/readComrefer.power";
    var data = {};
    data.dev_Ip = dev_ip;
    $.ajaxSetup({
        async:false
    });
    $.post(url,data,function (result,status) {
        if(status === "success"){
            var newTable = "<tr>" +
                "<th>测量点机号</th>" +
                "<th>心跳间隔</th>" +
                "<th>主站IP地址</th>" +
                "<th>主站端口</th>" +
                "<th>设备IP地址</th>" +
                "<th>设备通讯端口</th>" +
                "<th>APN</th>" +
                "<th>sim卡号</th>" +
                "<th>设置操作</th>" +
                "<th>读取操作</th>" +
                "</tr>" +
                "<tr>" +
                "<td>"+result.comRefer.machineNo+"</td>" +
                "<td>"+result.comRefer.heartrate+"</td>" +
                "<td>"+result.comRefer.main_ipAddr+"</td>" +
                "<td>"+result.comRefer.main_port+"</td>" +
                "<td>"+result.comRefer.dev_ip+"</td>" +
                "<td>"+result.comRefer.dev_commPort+"</td>" +
                "<td>"+result.comRefer.apn+"</td>" +
                "<td>"+result.comRefer.sim_number+"</td>" +
                "<td><input type='button' onclick='modify(\""+result.comRefer.dev_ip+"\")' value='设置'/></td>" +
                "<td><input type='button' onclick='readInfo(\""+result.comRefer.dev_ip+"\")' value='读取'/></td>" +
                "</tr>";
            $("#table_bodyInfo").html(newTable);
        }
    },"json")

}