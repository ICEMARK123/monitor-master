<%@ page import="com.electric.beans.MesureSiteInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/menubar.jsp"%>
<title>设备台账</title>
<link href="<%=contextpath%>/admin/css/userManager.css" rel="stylesheet"/>
<link href="<%=contextpath%>/admin/css/devLedger.css" rel="stylesheet"/>
<script src="<%=contextpath%>/static/admin/messuresite/devLedger.js"></script>
<div class="titleset">
    <span>设备台账</span>
</div>
<div>
    <input type="button" class="addbtn"  value="添加"/>
    <input type="text" style="width:30%;margin-left: 10%;" placeholder="请输入要搜索的测量点位置" id="searchContent"/>
    <input type="button" value="搜索" id="searchLocation"/>
    <input type="button" class="exportBtn" value="导出"/>
</div>
<table   class="table table-out-bordered table-bordered table-hover">
    <tbody id="table_bodyInfoshow">
        <tr>
            <th>接线方式</th>
            <th>安装位置</th>
            <th>设备规格描述</th>
            <th>设备编码</th>
            <th>设备类型名称</th>
            <th>机号</th>
            <th>手机卡号</th>
            <th>保存时间</th>
            <th>修改操作</th>
            <%--<th>删除操作</th>--%>
        </tr>
    <%
        List<MesureSiteInfo> list = (List<MesureSiteInfo>) request.getAttribute("devLedgeList");
        for(int i = 0;i<list.size();i++){
    %>
    <tr>
        <td><%=list.get(i).getLineWay()%></td>
        <td><%=list.get(i).getLocation()%></td>
        <td><%=list.get(i).getDevDescript()%></td>
        <td><%=list.get(i).getDevCode()%></td>
        <td><%=list.get(i).getDevTypeInfo().getType_name()%></td>
        <td><%=list.get(i).getMachineNo()%></td>
        <td><%=list.get(i).getPhonenumber()%></td>
        <td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(list.get(i).getSaveTime())%></td>
        <td><input type="button" onclick="modifyMessureSite('<%=list.get(i).getMachineNo()%>')" value="修改"/></td>
        <%--<td><input type="button" onclick="deleteMessure('<%=list.get(i).getMachineNo()%>')" value="删除"/></td>--%>
    </tr>
    <%}%>
    </tbody>

</table>
<%@include file="../../inc/bottom.jsp"%>