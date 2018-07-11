<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/10/31
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/inc/top.jsp"%>
<link href="<%=contextpath%>/admin/css/surePoint.css" rel="stylesheet"/>
<title>主页</title>
</head>
<body>
<h3 align="left"S>测量点信息显示表</h3>
<table border="1" align="center" cellspacing="1">
  <tbody id="table_bodyInfo">
  <tr>
    <th>测量点ID</th>
    <th>接线方式</th>
    <th>安装位置</th>
    <th>设备描述</th>
    <th>机号</th>
    <th>设备编码</th>
    <th>使用单位</th>
    <th>设备类型名称</th>
    <th>在线情况</th>
    <th>离线时间</th>
    <th>上次通讯时间</th>
  </tr>
  <%
    for (int i = 1;i<=20;i++){
  %>
  <%--<input type="text" class="siteId" value="<%=i%>" hidden />--%>
  <tr>
    <td><a href="<%=contextpath%>/admin/InfoLineShow.jsp?siteId=<%=i%>"><%=i%></a></td>
    <td>三相四线</td>
    <td>福建漳州市华安县三洋</td>
    <td>AVQC4-30/0.4</td>
    <td>DN17050318</td>
    <td>Ap010100170627010</td>
    <td>上海高简电力</td>
    <td>WSPB</td>
    <td>离线</td>
    <td>69118</td>
    <td>2017-09-14 15:27</td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>
<hr/>
<div align="center">
  <input class="bk-icon-button bk-info" type="button" value="首页"/>
  <input class="bk-icon-button bk-info" type="button" value="上一页"/>
  <input class="bk-icon-button bk-info" type="button" value="1"/>
  <input class="bk-icon-button bk-info" type="button" value="2"/>
  <input class="bk-icon-button bk-info" type="button" value="..."/>
  <input class="bk-icon-button bk-info" type="button" value="下一页"/>
  <input class="bk-icon-button bk-info" type="button" value="尾页"/>
  共<%=5%>页
</div>
</body>
</html>
