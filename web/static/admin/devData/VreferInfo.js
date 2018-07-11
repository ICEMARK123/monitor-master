var contextPath = "";
$(function () {
    // 表格显示
    $("#show_table_btn").click(function () {
        $("#tableshowV").show();
        $("#main").hide();
        // $("#show_table_btn").hide();
        // $("#show_Line_btn").show();
        var starttime = $("#startTime").val();  //2017-12-15T12:12
        var endtime = $("#endTime").val();
        // alert(starttime);
        // alert(endtime);
        contextPath = $("#contextpath").val();
        var url = contextPath + "/vreferinfo/getInfoByTimespace.power";
        var data = {};
        data.starttime = starttime;
        data.endtime = endtime;
        $.ajaxSetup({
            async:true//设置同步
        });
        $.post(url, data, function (result,status) {
            if (status == "success"){
                if (result.message == "notNull" ){
                    var newtable = "<tr>" +
                        "<th>时间</th>" +
                        "<th>A相电压</th>" +
                        "<th>B相电压</th>" +
                        "<th>C相电压</th>" +
                        "</tr>";
                    for (var i = 0;i<result.realtimeDataList.length;i++){
                        newtable += "<tr>" +
                            "<td>"+result.realtimeDataList[i].sampleTime+"</td>" +
                            "<td>"+result.realtimeDataList[i].ua+"</td>" +
                            "<td>"+result.realtimeDataList[i].ub+"</td>" +
                            "<td>"+result.realtimeDataList[i].uc+"</td>" +
                            "</tr>";
                    }
                    $("#table_bodyInfo").html(newtable);
                }else{
                    alert(result.message);
                }

            }
        },"json");
    })
});
function lineShow() {
    $("#tableshowV").hide();
    $("#main").show();
    // $("#show_Line_btn").hide();
    // $("#show_table_btn").show();
    contextPath = $("#contextpath").val();
    var starttime = $("#startTime").val();  //2017-12-15T12:12
    var endtime = $("#endTime").val();
    var url = contextPath + "/vreferinfo/forLineShow.power";
    var data = {};
    data.starttime = starttime;
    data.endtime = endtime;
    $.ajaxSetup({
        async:true//设置同步
    });
    $.post(url, data, function (result,status) {
        if (status == "success") {
            // alert(result.realTimeDatasList.length);
            // 基于准备好的dom，初始化echarts图表
            var timeList = result.timeList;
            var UaList = result.UaList;
            var UbList = result.UbList;
            var UcList = result.UcList;
            var machineNo = result.machineNo;
            if (timeList.length>0){
                var myChart = echarts.init(document.getElementById('main'));
// 教程地址：http://echarts.baidu.com/echarts2/doc/doc.html

                // var url = location.search;//获取到url后面的字符串 ？siteId=
                // var siteId = url.substr(url.indexOf('=')+1);

                option = {
                    title: {
                        text: '测量点'+machineNo+'的电压图',
                    },
                    tooltip: {  //tooltip:气泡提示框，常用于展现更详细的数据
                        trigger: 'axis'   //axis坐标轴
                    },
                    legend: { //legend:图例，表述数据和图形的关联
                        data:['Ua','Ub','Uc']
                    },
                    toolbox: {   //toolbox:辅助工具箱，辅助功能，如添加标线，框选缩放等
                        show: true,
                        feature: {
                            dataZoom: {
                                yAxisIndex: 'none'
                            },
                            dataView: {readOnly: false},
                            magicType: {type: ['line', 'bar']},
                            restore: {},
                            saveAsImage: {}
                        }
                    },
                    xAxis:  {
                        type: 'category',
                        boundaryGap: false,
                        data: timeList
                    },
                    yAxis: {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} V'
                        }
                    },
                    series: [
                        {
                            name:'Ua',
                            type:'line',
                            data:UaList,
                            markPoint: {
                                data: [
                                    {type: 'max', name: '最大值'},
                                    {type: 'min', name: '最小值'}
                                ]
                            }
                        },
                        {
                            name:'Ub',
                            type:'line',
                            data:UbList,
                            markPoint: {
                                data: [
                                    // {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                                    {type:'max',name:'最大值'},
                                    {type:'min',name:'最小值'}
                                ]
                            }
                        },
                        {
                            name:'Uc',
                            type:'line',
                            data:UcList,
                            markPoint:{
                                data:[
                                    {type:'max',name:'最大值'},
                                    {type:'min',name:'最小值'}
                                ]
                            }
                        }
                    ]
                };
// 为echarts对象加载数据
                myChart.setOption(option);

            }else{
                alert("没有此段时间的数据！");
                window.location.href = contextPath + "/vreferinfo/showAllRealTimeData.power";
            }

        }
    },"json")
}