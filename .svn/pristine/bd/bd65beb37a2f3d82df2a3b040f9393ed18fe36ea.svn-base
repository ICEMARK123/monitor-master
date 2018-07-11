<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/menubar.jsp"%>
<title>设备台账</title>
<link href="<%=contextpath%>/admin/css/userManager.css" rel="stylesheet"/>
<link href="<%=contextpath%>/admin/css/devLedger.css" rel="stylesheet"/>
<div class="titleset">
    <span>设备台账</span>
</div>
<div>
    <input type="button" class="addbtn" value="添加"/>
    <input type="text" style="width:30%;margin-left: 10%;" placeholder="请输入要搜索的测量点名称"/>
    <input type="button" value="搜索"/>
    <input type="button" class="exportBtn" value="导出"/>
</div>
<table   class="table table-out-bordered table-bordered table-hover">
    <tbody id="table_bodyInfo">
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
            <th>删除操作</th>
        </tr>
    <%
        for(int i = 1;i<50;i++){
    %>
    <tr>
        <td>三相四线</td>
        <td>WSPB-50/0.4</td>
        <td>Ap010100150910448</td>
        <td>TXAAk</td>
        <td>WSPB</td>
        <td>MK71C00036</td>
        <td>1064883153593</td>
        <td>2017-11-15 16:11</td>
        <td><input type="button" value="修改"/></td>
        <td><input type="button" value="删除"/></td>
    </tr>
    <%}%>
    </tbody>

</table>
<%@include file="../inc/bottom.jsp"%>