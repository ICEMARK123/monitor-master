<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/11/3
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/top.jsp"%>
<title>测量点信息折线图显示</title>
<link href="<%=contextpath%>/admin/css/InfoLineShow.css" rel="stylesheet"/>
<script src="<%=contextpath%>/admin/js/require.js"></script>
</head>
<body>
    <%--<h4 style="margin-left:10%;">参数选择:</h4>--%>
<%--<div  class="bk-radio-group" style="margin-left: 10%;;">--%>
    <%--<input class="bk-radio-button is-checked" type="button" value="电压"/>--%>
    <%--<input class="bk-radio-button" type="button" value="电流"/>--%>
    <%--<input class="bk-radio-button" type="button" value="功率因数"/>--%>
    <%--<input class="bk-radio-button" type="button" value="频率"/>--%>
    <%--<input class="bk-radio-button" type="button" value="温度"/>--%>
    <%--<input class="bk-radio-button" type="button" value="有功功率"/>--%>
    <%--<input class="bk-radio-button" type="button" value="无功功率"/>--%>
    <%--<input class="bk-radio-button" type="button" value="视在功率"/>--%>
    <%--<input class="bk-radio-button" type="button" value="电流电压不平衡度"/>--%>
<%--</div>--%>
<hr/>
<div style="height:400px;width:80%;float:left;" id="main"></div>
    <%--Echarts单文件引入--%>
    <script src="<%=contextpath%>/admin/js/echarts2/echarts.js"></script>
    <script src="<%=contextpath%>/admin/js/echarts2/echarts-all.js"></script>
    <script src="<%=contextpath%>/admin/js/lineShow.js"></script>
<div style="width:15%;float:right;margin-top: 10%">
    <div><input  class="king-btn-demo king-btn king-default"  type="button" value="日"/> </div>
    <div><input  class="king-btn-demo king-btn king-default"  type="button" value="周"/> </div>
    <div><input  class="king-btn-demo king-btn king-default"  type="button" value="月"/> </div>
</div>
<hr style="width:100%"/>
<div class="bk-radio-group" style="margin-left:35%">
    <input class="bk-radio-button is-checked"  type="button" value="折线图"/>
    <input class="bk-radio-button" id="turntable" type="button" value="报表"/>
</div>
</body>
</html>
