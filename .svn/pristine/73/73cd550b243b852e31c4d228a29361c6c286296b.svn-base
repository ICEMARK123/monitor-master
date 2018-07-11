<%--
  Created by IntelliJ IDEA.
  User: ICEMARK
  Date: 2017/11/26
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/menubar.jsp"%>
    <title>用户管理</title>
<link href="<%=contextpath%>/admin/css/userManager.css" rel="stylesheet"/>
<div class="titleset">
    <span>用户管理</span>
</div>
<div>
    <input type="button" class="addbtn" value="添加"/>
    <input type="text" style="width:30%;margin-left: 10%;" placeholder="请输入要搜索的用户登陆名"/>
    <input type="button" value="搜索"/>
</div>
<table  class="table table-out-bordered table-bordered table-hover">
    <tbody id="table_bodyInfo">
        <tr>
            <th>账号</th>
            <th>登录名</th>
            <th>角色</th>
            <th>最后登录时间</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <%
            for(int i = 0;i<100;i++){
        %>
    <tr>
        <td>12345</td>
        <td>cherry</td>
        <td>管理员</td>
        <td>2017-11-26 11：59</td>
        <td><input type="button" value="修改"/></td>
        <td><input type="button" value="删除"/></td>
    </tr>
    <%}%>
    </tbody>
</table>
<%@include file="../inc/bottom.jsp"%>