<%--电流页面的表结构--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/referDatatemplate.jsp"%>
<title>电流详情</title>
<link href="<%=contextpath%>/static/css/devData/referInfo.css" rel="stylesheet"/>
<script src = "<%=contextpath%>/static/admin/devData/AreferInfo.js"></script>
    <input type="button" id="show_Line_btn"  value="图形" style="margin-left:60px;"/>
    <input type="button" id="show_table_btn" style="margin-left:60px;"  value="表格"/>
</div>
<hr/>
<div class="div_table_info">
    <table class="table table-out-bordered table-bordered table-hover" id="tableShowA">
        <tbody id="table_bodyInfo">
        <tr>
            <th>时间</th>
            <th>A相电流</th>
            <th>B相电流</th>
            <th>C相电流</th>
        </tr>
        <%
            List<RealTimeData> list = (List<RealTimeData>) request.getAttribute("realTimeDataList");
            for(int i = 0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getSampleTime()%></td>
            <td><%=list.get(i).getIa()%></td>
            <td><%=list.get(i).getIb()%></td>
            <td><%=list.get(i).getIc()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <div style="height:500px;width:80%;float:left;" id="main"></div>
</div>
<%--<div class="div_select_choose">--%>
    <%--<div class="div_inner">--%>
        <%--<input type="checkbox" value="A"/>A相电流--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<input type="checkbox" value="B"/>B相电流--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<input type="checkbox" value="C"/>C相电流--%>
    <%--</div>--%>
<%--</div>--%>

<%@include file="../../inc/bottom.jsp"%>