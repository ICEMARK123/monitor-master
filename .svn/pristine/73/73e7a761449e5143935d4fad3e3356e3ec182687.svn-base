<%@ page import="com.electric.beans.ComRefer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/menubar.jsp"%>
<script src="<%=contextpath%>/static/admin/devInfo/commInfo.js"></script>
<title>通讯参数</title>
<link href="<%=contextpath%>/admin/css/userManager.css" rel="stylesheet"/>
<%
    List<ComRefer> list = (List<ComRefer>) request.getAttribute("comreferList");
    if(list.size()==0){
%>
<div>
    <input type="button" onclick="addComrefer()" value="添加" class="addbtn"/>
</div>
<%
    }
%>
<table class="table table-out-bordered table-bordered table-hover">
    <tbody id="table_bodyInfo">
    <%--添加   修改   查询   功能还没做--%>
        <tr>
            <th>测量点机号</th>
            <th>心跳间隔</th>
            <th>主站IP地址</th>
            <th>主站端口</th>
            <th>设备IP地址</th>
            <th>设备通讯端口</th>
            <th>APN</th>
            <th>sim卡号</th>
            <th>设置操作</th>
            <th>读取操作</th>
        </tr>
    <%

        for(int i = 0;i<list.size();i++){
    %>
    <tr>
        <td><%=list.get(i).getMachineNo()%></td>
        <td><%=list.get(i).getHeartrate()%>分钟</td>
        <td><%=list.get(i).getMain_ipAddr()%></td>
        <td><%=list.get(i).getMain_port()%></td>
        <td><%=list.get(i).getDev_ip()%></td>
        <td><%=list.get(i).getDev_commPort()%></td>
        <td><%=list.get(i).getApn()%></td>
        <td><%=list.get(i).getSim_number()%></td>
        <%--注意传递参数如果是String类型，注意加''--%>
        <td><input type="button" value="设置" onclick="modify('<%=list.get(i).getDev_ip()%>')"/></td>
        <td><input type="button" value="读取" onclick="readInfo('<%=list.get(i).getDev_ip()%>')"/></td>
    </tr>
    <%}%>
    </tbody>
</table>
<%@include file="../../inc/bottom.jsp"%>