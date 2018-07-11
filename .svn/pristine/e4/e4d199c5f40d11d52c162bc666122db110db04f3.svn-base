<%@ page import="com.electric.beans.DevInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/menubar.jsp"%>
<title>设备信息</title>
<link href="<%=contextpath%>/admin/css/userManager.css" rel="stylesheet"/>
<%
    List<DevInfo> list = (List<DevInfo>) request.getAttribute("devInfoList");
    if(list.size()==0){
%>
<div>
    <input type="button" class="addbtn" onclick="adddevInfo()" value="添加"/>
</div>
<%}
%>
<table class="table table-out-bordered table-bordered table-hover">
    <tbody id="table_bodyInfo">
        <tr>
            <th>使用单位</th>
            <th>安装位置</th>
            <th>设备编号</th>
            <th>软件版本</th>
            <th>硬件版本</th>
            <th>生产日期</th>
            <th>设置操作</th>
            <th>读取操作</th>
        </tr>
    <%

        for(int i = 0;i<list.size();i++){
    %>
    <tr>
        <td><%=list.get(i).getUse_company()%></td>
        <td><%=list.get(i).getInstall_location()%></td>
        <td><%=list.get(i).getMachineNo()%></td>
        <td><%=list.get(i).getSoft_version()%></td>
        <td><%=list.get(i).getHard_version()%></td>
        <td><%=list.get(i).getProduction_date()%></td>
        <td><input type="button" onclick="modify(<%=list.get(i).getDev_id()%>)" value="设置"/></td>
        <td><input type="button" onclick="readInfo(<%=list.get(i).getDev_id()%>)" value="读取"/></td>
    </tr>
    <%}%>
    </tbody>
</table>
<script src="<%=contextpath%>/static/admin/devInfo/devInfoMess.js"></script>