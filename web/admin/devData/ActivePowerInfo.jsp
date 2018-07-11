<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2018/1/1
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/referDatatemplate.jsp"%>
<script src="<%=contextpath%>/static/admin/devData/ActivePower.js"></script>
<title>有功功率详情</title>
<input type="button" id="show_Line_btn"  value="图形" style="margin-left:60px;"/>
<input type="button" id="show_table_btn" style="margin-left:60px;"  value="表格"/>
</div>
<hr/>
<div class="div_table_info">
    <table class="table table-out-bordered table-bordered table-hover" id="tableShowP">
        <tbody id="table_bodyInfo">
        <tr>
            <th>时间</th>
            <th>A相有功功率</th>
            <th>B相有功功率</th>
            <th>C相有功功率</th>
            <th>总有功功率</th>
        </tr>
        <%
            List<RealTimeData> list = (List<RealTimeData>) request.getAttribute("realTimeDatasList");
            for(int i = 0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getSampleTime()%></td>
            <td><%=list.get(i).getPa()%></td>
            <td><%=list.get(i).getPb()%></td>
            <td><%=list.get(i).getPc()%></td>
            <td><%=list.get(i).getPt()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <div style="height:500px;width:80%;float:left;" id="main"></div>
</div>
<%@include file="../../inc/bottom.jsp"%>
