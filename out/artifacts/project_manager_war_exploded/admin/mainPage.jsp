<%@ page import="com.electric.beans.MesureSiteInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: ICEMARK
  Date: 2017/11/26
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/menubar.jsp"%>
    <title>主页</title>
<style>
    #table_bodyInfo{
        font-size:14px;
    }
    .addSite{
        width:100px;
        height:30px;
        background-color: #00c0ef;
    }
</style>
<%--<button class="addSite" id="addSitebtn">添加测量点</button>--%>
<table  class="table table-out-bordered table-bordered table-hover">
    <tbody id="table_bodyInfo">
    <tr>
        <th>序号</th>
        <th>接线方式</th>
        <th>安装位置</th>
        <th>设备描述</th>
        <th>机号</th>
        <th>设备编码</th>
        <th>设备类型名称</th>
        <th>在线情况</th>
        <th>离线时间</th>
        <th>上次通讯时间</th>
    </tr>
    <%
        List<MesureSiteInfo> list = (List<MesureSiteInfo>) request.getAttribute("messureList");
        for (int i = 0;i<list.size();i++){
    %>
    <%--<input type="text" class="siteId" value="<%=i%>" hidden />--%>
    <tr>
        <td><%=i+1%></td>
        <td><%=list.get(i).getLineWay()%></td>
        <td><%=list.get(i).getLocation()%></td>
        <td><%=list.get(i).getDevDescript()%></td>
        <td><%=list.get(i).getMachineNo()%></td>
        <td><%=list.get(i).getDevCode()%></td>
        <td><%=list.get(i).getDevTypeInfo().getType_name()%></td>
        <%
            if(list.get(i).isOnlineSituation()){
        %>
            <td>在线</td>
        <%
            }else{
        %>
        <td>离线</td>
        <%}%>
        <td><%=new Date().getTime() - list.get(i).getLastCommTime().getTime()%></td>
        <%--new Date().getTime() - list.get(i).getLastCommTime().getTime()--%>
        <%--把CST格式的时间转化为正常时间--%>
        <td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(list.get(i).getLastCommTime())%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%@include file="../inc/bottom.jsp"%>