// 基于准备好的dom，初始化echarts图表
var myChart = echarts.init(document.getElementById('main'));
// 教程地址：http://echarts.baidu.com/echarts2/doc/doc.html

var url = location.search;//获取到url后面的字符串 ？siteId=
var siteId = url.substr(url.indexOf('=')+1);

option = {
    title: {
        text: '测量点'+siteId+'的电压图',
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
        data: ['周一','周二','周三','周四','周五','周六','周日']
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
            data:[11, 11, 15, 13, 12, 13, 10],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            }
        //     markLine: {
        //     data: [
        //         {type: 'average', name: '平均值'}
        //     ]
        // }
        },
        {
            name:'Ub',
            type:'line',
            data:[1, -2, 2, 5, 3, 2, 0],
            markPoint: {
                data: [
                    // {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                    {type:'max',name:'最大值'},
                    {type:'min',name:'最小值'}
                ]
            }
            // markLine: {
            //     data: [
            //         {type: 'average', name: '平均值'},
            //         [{
            //             symbol: 'none',
            //             x: '90%',
            //             yAxis: 'max'
            //         }, {
            //             symbol: 'circle',
            //             label: {
            //                 normal: {
            //                     position: 'start',
            //                     formatter: '最大值'
            //                 }
            //             },
            //             type: 'max',
            //             name: '最高点'
            //         }]
            //     ]
            // }
        },
        {
            name:'Uc',
            type:'line',
            data:[4, 5, 2, 7, 9, 0, -1],
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
