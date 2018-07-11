var contextpath = "";
$(function () {
    // 图形显示
    $("#show_Line_btn").click(function () {
        // alert("点击图形");
        $("#tableShowP").hide();
        $("#main").show();
        contextpath = $("#contextpath").val();
        // alert(contextpath);
        var starttime = $("#startTime").val();
        var endtime = $("#endTime").val();
        // alert(endtime);
        var url = contextpath + "/apparentPower/lineShowByTimeSpace.power";
        // alert(url);
        var data = {};
        data.starttime = starttime;
        data.endtime = endtime;
        // alert(starttime);
        $.ajaxSetup({
            async:false//设置同步
        });
        $.post(url,data,function (result,status) {
            // alert(status);
            if(status=="success"){//"success".equals(status)
                var machineNo = result.machineNo;
                var timeList = result.timeList;
                var SaList = result.SaList;
                var SbList = result.SbList;
                var ScList = result.ScList;
                var StList = result.StList;
                if(timeList.length>0){
                    var myChart = echarts.init(document.getElementById('main'));
// 教程地址：http://echarts.baidu.com/echarts2/doc/doc.html

                    // var url = location.search;//获取到url后面的字符串 ？siteId=
                    // var siteId = url.substr(url.indexOf('=')+1);

                    option = {
                        title: {
                            text: '测量点'+machineNo+'的无功功率图',
                        },
                        tooltip: {  //tooltip:气泡提示框，常用于展现更详细的数据
                            trigger: 'axis'   //axis坐标轴
                        },
                        legend: { //legend:图例，表述数据和图形的关联
                            data:['Sa','Sb','Sc','St']
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
                                name:'Sa',
                                type:'line',
                                data:SaList,
                                markPoint: {
                                    data: [
                                        {type: 'max', name: '最大值'},
                                        {type: 'min', name: '最小值'}
                                    ]
                                }
                            },
                            {
                                name:'Sb',
                                type:'line',
                                data:SbList,
                                markPoint: {
                                    data: [
                                        // {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                                        {type:'max',name:'最大值'},
                                        {type:'min',name:'最小值'}
                                    ]
                                }
                            },
                            {
                                name:'Sc',
                                type:'line',
                                data:ScList,
                                markPoint:{
                                    data:[
                                        {type:'max',name:'最大值'},
                                        {type:'min',name:'最小值'}
                                    ]
                                }
                            },
                            {
                                name:'St',
                                type:'line',
                                data:StList,
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
                    window.location.href = contextpath + "/apparentPower/showAllActivePowerInfo.power";
                }
            }
        },"json");

    });
    // 表格显示
    $("#show_table_btn").click(function () {
        $("#main").hide();
        $("#tableShowP").show();
        var starttime = $("#startTime").val();  //2017-12-15T12:12
        var endtime = $("#endTime").val();
        // alert(starttime);
        contextpath = $("#contextpath").val();
        var url = contextpath + "/apparentPower/tableShowByTimeSpace.power";
        var data = {};
        data.starttime = starttime;
        data.endtime = endtime;
        $.ajaxSetup({
            async:true//设置同步
        });
        $.post(url, data, function (result,status) {
            if (status == "success"){
                if (result.realTimeDatasList.length>0 ){
                    var newtable = "<tr>" +
                        "<th>时间</th>" +
                        "<th>A相有功功率</th>" +
                        "<th>B相有功功率</th>" +
                        "<th>C相有功功率</th>" +
                        "<th>总有功功率</th>" +
                        "</tr>";
                    for (var i = 0;i<result.realTimeDatasList.length;i++){
                        newtable += "<tr>" +
                            "<td>"+result.realTimeDatasList[i].sampleTime+"</td>" +
                            "<td>"+result.realTimeDatasList[i].sa+"</td>" +
                            "<td>"+result.realTimeDatasList[i].sb+"</td>" +
                            "<td>"+result.realTimeDatasList[i].sc+"</td>" +
                            "<td>"+result.realTimeDatasList[i].st+"</td>" +
                            "</tr>";
                    }
                    $("#table_bodyInfo").html(newtable);
                }else{
                    alert("查询该段时间的数据不存在！");
                    window.location.href = contextpath +"/apparentPower/showAllActivePowerInfo.power";
                }

            }
        },"json");
    });
});