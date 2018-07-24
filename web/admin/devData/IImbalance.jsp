<%--
  Created by IntelliJ IDEA.
  User: ICEMARK
  Date: 2018/1/2
  Time: 15:48
  To change this template use File | Settings | File Templates.
  电流的平衡度
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/referDatatemplate.jsp"%>
<script src="<%=contextpath%>/static/admin/devData/IImbalance.js"></script>
<title>电流不平衡度详情</title>
<input type="button" id="show_Line_btn"  value="图形" style="margin-left:60px;"/>
<input type="button" id="show_table_btn" style="margin-left:60px;"  value="表格"/>
</div>
<hr/>
<div class="div_table_info">
    <table class="table table-out-bordered table-bordered table-hover" id="tableShowP">
        <tbody id="table_bodyInfo">
        <tr>
            <th>时间</th>
            <th>电流不平衡度</th>
        </tr>
        <%
            List<RealTimeData> list = (List<RealTimeData>) request.getAttribute("realTimeDatasList");
            for(int i = 0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getSampleTime()%></td>
            <td><%=list.get(i).getYi()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <div style="height:500px;width:80%;float:left;" id="main"></div>
</div>
<%@include file="../../inc/bottom.jsp"%>
