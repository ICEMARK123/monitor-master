var contextPath = "";
function addDevType() {
    // alert("添加设备类型信息");
    var d = dialog({
        width: 300,
        title: '添加设备类型',
        content:
        '<div>'+
        '<label>类型名称：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="typename"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>设备名称自定义:</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="selfname"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>是否使用：</label>' +
        '<select style="float:right;margin-right:30px;" id="whetheruser">' +
        '<option value="yes">使用</option>' +
        '<option value="no">未使用</option>' +
        '</select>' +
        '</div>' +
        '</div>' ,


        okValue: '确定',
        ok: function() {
            if (noNull()){
                addDev();
            }

        },
        cancelValue: '取消',
        cancel: function() {
            // do something
        }
    });
    d.showModal();
}
function noNull() {
    var typename = $("#typename").val();
    // var selfname = $("#selfname").val();
    // var whetheruse = $("#whetheruser option:selected").val();
    if (typename==""||typename==null){
        alert("类型名称是不能为空！");
        return false;
    }
    return true;
    // if (selfname==""||selfname==null){
    //     alert("自定义名称是不能为空！");
    //     return false;
    // }
    // if (typename==""||typename==null){
    //     alert("类型名称是不能为空！");
    //     return false;
    // }
}
function addDev() {
    contextPath = $("#contextpath").val();
    var typename = $("#typename").val();
    var selfname = $("#selfname").val();
    var whetheruse = $("#whetheruser option:selected").val();
    var url = contextPath+"/messureSite/addDevType.power";
    // alert(url);
    var data = {};
    data.typename = typename;
    data.selfname = selfname;
    data.whetheruse = whetheruse;
    $.ajaxSetup({
        async:true//设置同步
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            alert(result.message);
            window.location.href = contextPath+"/messureSite/getMessureTypeList.power";
        }
    },"json");
}
function modify(devId,devType_name) {
    // alert(devType_name);
    var d = dialog({
        width: 300,
        title: '修改设备类型',
        content:
        '<div>'+
        '<label>类型名称：</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="typename" placeholder="'+devType_name+'" />' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>设备名称自定义:</label>' +
        '<input style="float:right;margin-right:30px;" type="text" id="selfname"/>' +
        '</div>' +
        '<div style="margin-top:5px;">'+
        '<label>是否使用：</label>' +
        '<select style="float:right;margin-right:30px;" id="whetheruser">' +
        '<option value="yes">使用</option>' +
        '<option value="no">未使用</option>' +
        '</select>' +
        '</div>' +
        '</div>' ,


        okValue: '确定',
        ok: function() {
            if (noNull()){
                ModifyDev(devId);
            }

        },
        cancelValue: '取消',
        cancel: function() {
            // do something
        }
    });
    d.showModal();
}
function ModifyDev(devId) {
    contextPath = $("#contextpath").val();
    var typename = $("#typename").val();
    var selfname = $("#selfname").val();
    var whetheruse = $("#whetheruser option:selected").val();
    var url = contextPath +"/messureSite/modifyDeal.power";
    var data = {};
    data.type_id = devId;
    data.typename = typename;
    data.selfname = selfname;
    data.whetheruse = whetheruse;
    $.ajaxSetup({
        async:true//设置同步
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            alert(result.message);
            window.location.href = contextPath+"/messureSite/getMessureTypeList.power";
        }
    },"json");
}
function deleteDevType(devId) {
    var d = dialog({
        width: 260,
        quickClose: true,
        title:'删除设备类型',
        content: '您确定要删除该设备类型！',
        ok: function() {
            deleteDev(devId);
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
function deleteDev(devId) {
    contextPath = $("#contextpath").val();
    var url = contextPath+"/messureSite/deleteDeal.power";
    var data = {};
    data.devType_id = devId;
    $.ajaxSetup({
        async:true//设置同步
    });
    $.post(url, data, function (result,status) {
        if (status == "success"){
            alert(result.message);
            window.location.href = contextPath+"/messureSite/getMessureTypeList.power";
        }
    },"json");
}
function searchByName() {
    contextPath = $("#contextpath").val();
    var searchTypeName = $("#searchTypeName").val();
    var url = contextPath+"/messureSite/searchByName.power";
    var data = {};
    data.searchTypeName = searchTypeName;
    $.ajaxSetup({
        async:true//设置同步
    });
    $.post(url, data, function (result,status) {
        if (status === "success"){
            if (result.message==="notNull"){
                var newMassage = "<tr>" +
                    "<th>类型序号</th>"+
                    "<th>类型名称</th>"+
                    "<th>是否使用</th>"+
                    "<th>设备名称自定义</th>"+
                    "<th>修改操作</th>"+
                    "<th>删除操作</th>" ;
                for (var i = 0;i<result.seachedList.length;i++){
                    newMassage += "<tr>" +
                        "<td>"+result.seachedList[i].type_id+"</td>" +
                        "<td>"+result.seachedList[i].type_name+"</td>";
                    if (result.seachedList[i].isused){
                        newMassage +="<td>使用</td>";
                    }else{
                        newMassage +="<td>未使用</td>";
                    }
                    var typeName = result.seachedList[i].type_name+"";
                    newMassage += "<td>"+result.seachedList[i].dev_selfName+"</td>" +    //注意如果在js里面写html代码并写onclick传递字符串注意转义
                        "<td><input type='button' onclick='modify("+result.seachedList[i].type_id+",\""+typeName+"\")' value='修改'/></td>" +
                        "<td><input type='button' onclick='deleteDevType("+result.seachedList[i].type_id+")' value='删除'/></td>" +
                        "</tr>";
                }
                $("#table_bodyInfo").html(newMassage);
            }else{
                alert(result.message);
                window.location.href = contextPath +"/messureSite/getMessureTypeList.power";
            }
        }
    },"json");
}