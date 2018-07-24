<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2018/1/1
  Time: 19:59
  To change this template use File | Settings | File Templates.
  电流的页面实现
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/referDatatemplate.jsp"%>
<title>视在功率详情</title>
<script src="<%=contextpath%>/static/admin/devData/ApparentPower.js"></script>
<input type="button" id="show_Line_btn"  value="图形" style="margin-left:60px;"/>
<input type="button" id="show_table_btn" style="margin-left:60px;"  value="表格"/>
</div>
<hr/>
<div class="div_table_info">
    <table class="table table-out-bordered table-bordered table-hover" id="tableShowP">
        <tbody id="table_bodyInfo">
        <tr>
            <th>时间</th>
            <th>A相视在功率</th>
            <th>B相视在功率</th>
            <th>C相视在功率</th>
            <th>总视在功率</th>
        </tr>
        <%
            List<RealTimeData> list = (List<RealTimeData>) request.getAttribute("realTimeDatasList");
            for(int i = 0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getSampleTime()%></td>
            <td><%=list.get(i).getSa()%></td>
            <td><%=list.get(i).getSb()%></td>
            <td><%=list.get(i).getSc()%></td>
            <td><%=list.get(i).getSt()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <div style="height:500px;width:80%;float:left;" id="main"></div>
</div>
<%@include file="../../inc/bottom.jsp"%>
