<%@ page import="com.electric.beans.RealTimeData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/referDatatemplate.jsp"%>
<title>电压详情</title>
<script src="<%=contextpath%>/static/admin/devData/VreferInfo.js"></script>
    <input type="button" id="show_Line_btn" onclick="lineShow()" value="图形" style="margin-left:60px;"/>
    <input type="button" id="show_table_btn" style="margin-left:60px;"  value="表格" />
</div>
<hr/>
<div class="div_table_info">
    <table class="table table-out-bordered table-bordered table-hover" id="tableshowV">
        <tbody id="table_bodyInfo">
        <tr>
            <th>时间</th>
            <th>A相电压</th>
            <th>B相电压</th>
            <th>C相电压</th>
        </tr>
        <%
            List<RealTimeData> list = (List<RealTimeData>) request.getAttribute("realTimeDataList");
            for(int i = 0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getSampleTime()%></td>
            <td><%=list.get(i).getUa()%></td>
            <td><%=list.get(i).getUb()%></td>
            <td><%=list.get(i).getUc()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <div style="height:500px;width:80%;float:left;" id="main"></div>
</div>
<%--<div class="div_select_choose" hidden>--%>
    <%--<div class="div_inner">--%>
        <%--<input type="checkbox" value="A"/>A相电压--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<input type="checkbox" value="B"/>B相电压--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<input type="checkbox" value="C"/>C相电压--%>
    <%--</div>--%>
<%--</div>--%>

<%@include file="../../inc/bottom.jsp"%>