<%@ page import="javax.sound.midi.MidiDeviceReceiver" %>
<%@ page import="com.electric.beans.DevTypeInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/menubar.jsp"%>
<title>设备类型</title>
<link href="<%=contextpath%>/admin/css/userManager.css" rel="stylesheet"/>

<div class="titleset">
    <span>设备类型</span>
</div>
<div>
    <input type="button" class="addbtn" onclick="addDevType()" value="添加"/>
    <input type="text" style="width:30%;margin-left: 10%;" id="searchTypeName" placeholder="请输入要搜索的类型名称"/>
    <input type="button" onclick="searchByName()" value="搜索"/>
</div>
<table  class="table table-out-bordered table-bordered table-hover">
    <tbody id="table_bodyInfo">
        <tr>
            <th>类型序号</th>
            <th>类型名称</th>
            <th>是否使用</th>
            <th>设备名称自定义</th>
            <th>修改操作</th>
            <th>删除操作</th>
        </tr>
    <%
        List<DevTypeInfo> devTypeInfoList = (List<DevTypeInfo>) request.getAttribute("DevTypeList");
        for(int i = 0;i<devTypeInfoList.size();i++){
    %>
    <tr>
        <td><%=devTypeInfoList.get(i).getType_id()%></td>
        <td><%=devTypeInfoList.get(i).getType_name()%></td>
        <%
            if(devTypeInfoList.get(i).isIsused()){
         %>
        <td>是</td>
        <%
            }else{
        %>
        <td>否</td>
        <%}%>
        <td><%=devTypeInfoList.get(i).getDev_selfName()%></td>
        <td><input type="button" onclick="modify(<%=devTypeInfoList.get(i).getType_id()%>,'<%=devTypeInfoList.get(i).getType_name()%>')" value="修改"/></td>
        <td><input type="button" onclick="deleteDevType(<%=devTypeInfoList.get(i).getType_id()%>)" value="删除"/></td>
    </tr>
    <%}%>
    </tbody>
</table>
<script src="<%=contextpath%>/static/admin/messuresite/devTypePage.js"></script>
<%@include file="../../inc/bottom.jsp"%>