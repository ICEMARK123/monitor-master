<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/11/4
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/top.jsp"%>
<title>测量点报表信息</title>
</head>
<%--style="overflow:-Scroll;overflow-x:hidden"不显示横向的滚动条，写在body里面--%>
<body>
<div style="margin-top:2%;" id="headshow">
<label style="font-size: large;margin-left:15%;">测量点报表信息:</label>
         <input type="button" class="king-btn-demo king-btn king-round king-success" onclick="exportExcel('Infotable')" style="margin-right:5%;margin-left:40%;"  value="生成Excel文件"/>
         <input type="button" id="choicePara" class="king-btn-demo king-btn king-round king-success" style="margin-right:5%;margin-left:40%;"  value="选择参数"/>
         <input type="button" class="king-btn-demo king-btn king-round king-success" id="tablePrint" hidden value="打印"/>
</div>

<hr/>
<div class="tableHeadInfo" style="width:100%;margin-left: 0%;">
    <label>使用客户：</label><input type="text" value="山西" readonly/>
    <label>设备编号：</label><input type="text" value="001" readonly/>
    <label>安装位置：</label><input type="text" value="1#变电站" readonly/>
    <label>数据时间：</label><input type="datetime-local" placeholder="起始时间"/>至<input type="datetime-local" placeholder="结束时间"/>
    <label>采集周期：</label>
    <%--对于时间的处理,和浏览器的兼容性相关--%>
    <select>
        <option selected>15分钟</option>
        <option>30分钟</option>
        <option>1小时</option>
        <option>1天</option>
    </select>
</div>
<hr style="width:100%;"/>
<table border="1" id="Infotable" align="center" style="height:80%;width:70%;page-break-after: always;">
    <tbody>
    <tr>
        <th>序号</th>
        <th>时间点</th>

        <th>A相电压(V)</th>
        <th>B相电压(V)</th>
        <th>C相电压(V)</th>
        <th>电压不平衡度(%)</th>

        <th>A相电流(A)</th>
        <th>B相电流(A)</th>
        <th>C相电流(A)</th>
        <th>零序电流(A)</th>
        <th>电流不平衡度(%)</th>

        <th>A相有功功率(KW)</th>
        <th>B相有功功率(KW)</th>
        <th>C相有功功率(KW)</th>
        <th>总有功功率(KW)</th>

        <th>A相无功功率(KW)</th>
        <th>B相无功功率(KW)</th>
        <th>C相无功功率(KW)</th>
        <th>总无功功率(KW)</th>

        <th>A相视在功率(KW)</th>
        <th>B相视在功率(KW)</th>
        <th>C相视在功率(KW)</th>
        <th>总视在功率(KW)</th>

        <th>A相功率因数(%)</th>
        <th>B相功率因数(%)</th>
        <th>C相功率因数(%)</th>
        <th>总功率因数(%)</th>

        <th>频率（Hz）</th>

        <%--<th>温度(℃)</th>--%>
    </tr>
    <%
        for(int i = 0;i<500;i++){
    %>
    <tr>
        <td><%=i+1%></td>
        <td>100.01</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>
        <td>99.99</td>

    </tr>
    <%
        }
    %>
    </tbody>
</table>
<span id="showwaychoice">
<%--<div align="center"  id="spanNoneprint" style="display: none;">--%>
    <%--<input class="bk-icon-button bk-info" type="button" value="首页"/>--%>
    <%--<input class="bk-icon-button bk-info" type="button" value="上一页"/>--%>
    <%--<input class="bk-icon-button bk-info" type="button" value="1"/>--%>
    <%--<input class="bk-icon-button bk-info" type="button" value="2"/>--%>
    <%--<input class="bk-icon-button bk-info" type="button" value="..."/>--%>
    <%--<input class="bk-icon-button bk-info" type="button" value="下一页"/>--%>
    <%--<input class="bk-icon-button bk-info" type="button" value="尾页"/>--%>
    <%--共<%=5%>页--%>
<%--</div>--%>
<hr/>
<div  class="bk-radio-group" style="margin-left:40%">
    <input class="bk-radio-button" type="button" id="turnLineshow" value="折线图"/>
    <input class="bk-radio-button  is-checked" type="button" value="报表"/>
</div>
    </span>
<script src="<%=contextpath%>/admin/js/turnLineShow.js"></script>
</body>
</html>
