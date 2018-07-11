<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<link href="<%=contextpath%>/static/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=contextpath%>/static/css/bk.css" rel="stylesheet">
<link href="<%=contextpath%>/admin/css/bk1.css" rel="stylesheet">
<link href="<%=contextpath%>/admin/css/iconfont.css" rel="stylesheet">
<link href="<%=contextpath%>/static/css/ui-dialog.css" rel="stylesheet"/>
<script src="<%=contextpath%>/static/js/dialog-min.js"></script>
<%--Echarts单文件引入--%>
<script src="<%=contextpath%>/admin/js/echarts2/echarts.js"></script>
<script src="<%=contextpath%>/admin/js/echarts2/echarts-all.js"></script>

<link href="<%=contextpath%>/inc/menubar.css" rel="stylesheet"/>
<script type="text/javascript">
    $(function(){
        for(var i = 0;i<10;i++){
            $(".info_situation"+i).hide();
        }
        //$(".showanother").hide();
    });
    function sysClick(){
        $(".UL21").show();
    }
    function sysHide() {
        $(".UL21").hide();
    }
    function ceClick(){
        $(".UL22").show();
    }
    function ceHide() {
        $(".UL22").hide();
    }
    function showInfo(a) {
//        alert(a.id);//显示其id属性的值
        for(var i = 0;i<10;i++){
            if(a.id=="location_options"+i){
                $(".info_situation"+i).toggle();
            }
        }
    }

</script>
</head>
<body>
<div>
<nav class="navbar navbar-default king-horizontal-nav2" role="navigation">
    <div class="container" style="width:100%;border:1px solid #afd9ee">
        <div class="navbar-header" style="width:45%;">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#king-example-navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <ul class="nav navbar-nav" style="margin-left:10%;">
                <li>
                    <h2 style="color:blue;vertical-align: inherit;margin-top:2%;">电力监测系统</h2>
                </li>
            </ul>
        </div>
        <div class="collapse navbar-collapse navbar-responsive-collapse" id="king-example-navbar-collapse-2">
            <ul class="nav navbar-nav">
                <li>
                    <a href="<%=contextpath%>/mainPage/messureList.power">
                        <span>主页</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:;">
                        <span>报警信息</span>
                    </a>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text"  class="form-control" placeholder="请输入要搜索机号">
                        </div>
            </form>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="javascript:;">
                        <%
                            String username = (String)request.getSession().getAttribute("USER");
                        %>
                        <span><%=username%></span>
                    </a>
                </li>
                <li>
                    <a href="<%=contextpath%>/login/logout.power">
                        <span>退出</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div style="width:100%;height:7%;background-color: #FAFAFA;margin-top:-2%;border:1px solid #afd9ee">
    <div class="dropdown">
        <button class="dropbtn">系统管理</button>
        <div class="dropdown-content">
            <a href="<%=contextpath%>/UserDeal/showUsers.power">用户管理</a>
            <%--<a href="#">权限管理</a>--%>
        </div>
    </div>

    <div class="dropdown">
        <button class="dropbtn">测量点管理</button>
        <div class="dropdown-content">
            <a href="<%=contextpath%>/messureSite/getMessureTypeList.power">设备类型</a>
            <a href="<%=contextpath%>/messureSite/getDeviceEquipment.power">设备台账</a>
        </div>
    </div>
    <div class="showanother">
        <div class="dropdown">
            <button class="dropbtn">设备参数</button>
            <div class="dropdown-content">
                <a href="<%=contextpath%>/devInfo/showDevInfoList.power">设备信息</a>
                <a href="<%=contextpath%>/devInfo/getComRefer.power">通讯参数</a>
            </div>
        </div>
        <div class="dropdown">
            <button class="dropbtn">设备控制</button>
            <div class="dropdown-content">
                <a href="#">停机</a>
                <a href="#">复位</a>
                <a href="#">对时</a>
                <a href="#">数据初始化</a>
                <a href="#">恢复出厂设置</a>
            </div>
        </div>
        <div class="dropdown">
            <button class="dropbtn">设备数据</button>
            <div class="dropdown-content">
                <%--<a href="#">电压功率因数</a>--%>
                <a href="<%=contextpath%>/vreferinfo/showAllRealTimeData.power">电压</a>
                <a href="<%=contextpath%>/areferInfo/showAllInfo.power">电流</a>
                <%--<a href="#">电流功率因数</a>--%>
                <a href="<%=contextpath%>/activePower/showAllActivePowerInfo.power">有功功率</a>
                <a href="<%=contextpath%>/reactivePower/showAllQInfo.power">无功功率</a>
                <a href="<%=contextpath%>/apparentPower/showAllSInfo.power">视在功率</a>
                <a href="<%=contextpath%>/showReferInfo/showAllPowerFactor.power">功率因数</a>
                <a href="<%=contextpath%>/showReferInfo/showAllVImbanlance.power">电压不平衡度</a>
                <a href="<%=contextpath%>/showReferInfo/showAllIImbalance.power">电流不平衡度</a>
                <a href="<%=contextpath%>/showReferInfo/showFrequency.power">频率</a>
                <a href="<%=contextpath%>/showReferInfo/showTemperature.power">温度</a>
            </div>
        </div>
        <div class="dropdown">
        <button class="dropbtn">设备统计数据</button>
        <div class="dropdown-content">
            <a href="<%=contextpath%>/equipStatistic/showInfo?choice=1">日运行时间</a>
            <a href="<%=contextpath%>/equipStatistic/showInfo?choice=2">日平均电压</a>
            <a href="<%=contextpath%>/equipStatistic/showInfo?choice=3">日平均电流</a>
            <a href="<%=contextpath%>/equipStatistic/showInfo?choice=4">日电压最大值、最小值</a>
            <a href="<%=contextpath%>/equipStatistic/showInfo?choice=5">日电流最大值、最小值</a>
            <a href="<%=contextpath%>/equipStatistic/showInfo?choice=6">日总有功</a>
            <a href="<%=contextpath%>/equipStatistic/showInfo?choice=7">日总无功</a>
        </div>
    </div>
        <div class="dropdown">
            <button class="dropbtn">导出Excel</button>
        </div>
</div>

</div>
<div >
    <div style="width:10%;height:87%;float:left;overflow:scroll;background-color: #FAFAFA;border:1px solid #afd9ee;text-align: center">
            <%
                for(int i = 0;i<10;i++){
            %>
        <div style="width:100%;margin-top:10px;">
            <a href="javascript:void(0);"id="location_options<%=i%>" onclick="showInfo(this);">西安<span class="caret"></span></a>
            <div  class="info_situation<%=i%>">
                <ul>
                    <li><a href="#">厂区1</a></li>
                    <li><a href="#">厂区1</a></li>
                    <li><a href="#">厂区1</a></li>
                    <li><a href="#">厂区1</a></li>
                </ul>
            </div>
        </div>
            <%}%>
    </div>
    <div>
        <div style="height:87%; overflow:scroll;width:90%;border:1px solid dimgrey;">
            <input type="text" id="contextpath" value="<%=request.getContextPath()%>" hidden />
