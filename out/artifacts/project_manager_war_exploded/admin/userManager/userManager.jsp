<%@ page import="com.electric.beans.UserInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ICEMARK
  Date: 2017/11/26
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../inc/menubar.jsp"%>
    <title>用户管理</title>
<link href="<%=contextpath%>/admin/css/userManager.css" rel="stylesheet"/>

<script src="<%=contextpath%>/static/admin/userManager/userManager.js"></script>

<div class="titleset">
    <span>用户管理</span>
</div>
<div>
    <input type="button" class="addbtn" id="addBtn" value="添加"/>
    <input type="text" style="width:30%;margin-left: 10%;" id="searLoginUser" placeholder="请输入要搜索的用户登陆名"/>
    <input type="button" id="searchUser" value="搜索"/>
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
            List<UserInfo> userInfoList = (List<UserInfo>)request.getAttribute("UserList");
        %>
        <%
             for(int i = 0;i<userInfoList.size();i++){
        %>
    <tr  class="user_content">
        <td><%=userInfoList.get(i).getUserId()%></td>
        <td><%=userInfoList.get(i).getUserName()%></td>
        <%
            if(userInfoList.get(i).isRootUser()){
        %>
        <td>管理员</td>
        <%
            }else{
        %>
        <td>一般用户</td>
        <%
            }
            if(userInfoList.get(i).getLastLoginTime()==null){
                %>
        <td></td>
        <%
            }else{
        %>
        <td><%=userInfoList.get(i).getLastLoginTime()%></td>
        <%}%>
        <td><input type="button" onclick="modify(<%=userInfoList.get(i).getUserId()%>)" value="修改"/></td>
        <td><input type="button" onclick = "deleteUser(<%=userInfoList.get(i).getUserId()%>)" value="删除"/></td>
    </tr>
    <%}%>
    </tbody>
</table>
<%@include file="../../inc/bottom.jsp"%>