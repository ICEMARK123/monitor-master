<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2018/1/1
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/referDatatemplate.jsp"%>
<title>无功功率详情</title>
<script src="<%=contextpath%>/static/admin/devData/ReactivePower.js"></script>
<input type="button" id="show_Line_btn"  value="图形" style="margin-left:60px;"/>
<input type="button" id="show_table_btn" style="margin-left:60px;"  value="表格"/>
</div>
<hr/>
<div class="div_table_info">
    <table class="table table-out-bordered table-bordered table-hover" id="tableShowP">
        <tbody id="table_bodyInfo">
        <tr>
            <th>时间</th>
            <th>A相无功功率</th>
            <th>B相无功功率</th>
            <th>C相无功功率</th>
            <th>总无功功率</th>
        </tr>
        <%
            List<RealTimeData> list = (List<RealTimeData>) request.getAttribute("realTimeDatasList");
            for(int i = 0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getSampleTime()%></td>
            <td><%=list.get(i).getQa()%></td>
            <td><%=list.get(i).getQb()%></td>
            <td><%=list.get(i).getQc()%></td>
            <td><%=list.get(i).getQt()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <div style="height:500px;width:80%;float:left;" id="main"></div>
</div>
<%@include file="../../inc/bottom.jsp"%>
