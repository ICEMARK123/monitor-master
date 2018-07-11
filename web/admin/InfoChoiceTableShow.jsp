<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/11/8
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/top.jsp"%>
<title>参量选择信息展示</title>
</head>
<body>
<div style="width:90%;float:left"></div>
<div style="width:10%;float:right;">

    <div><input type="checkbox" value="A电压"/>A相电压(V)</div>
    <div><input type="checkbox" value="B电压"/>B相电压(V)</div>
    <div><input type="checkbox" value="C电压"/>C相电压(V)</div>

    <div><input type="checkbox" value="A电流"/>A相电流(A)</div>
    <div><input type="checkbox" value="B电流"/>B相电流(A)</div>
    <div><input type="checkbox" value="C电流"/>C相电流(A)</div>

    <div><input type="checkbox" value="电压不平衡"/>电压不平衡度(%)</div>
    <div><input type="checkbox" value="电流不平衡"/>电流不平衡度(%)</div>

    <div><input type="checkbox" value="A相有功功率"/>A相有功功率(KW)</div>
    <div><input type="checkbox" value="B相有功功率"/>B相有功功率(KW)</div>
    <div><input type="checkbox" value="C相有功功率"/>C相有功功率(KW)</div>
    <div><input type="checkbox" value="总相有功功率"/>总有功功率(KW)</div>

    <div><input type="checkbox" value="A相无功功率"/>A相无功功率(KW)</div>
    <div><input type="checkbox" value="B相无功功率"/>B相无功功率(KW)</div>
    <div><input type="checkbox" value="C相无功功率"/>C相无功功率(KW)</div>
    <div><input type="checkbox" value="总相无功功率"/>总无功功率(KW)</div>

    <div><input type="checkbox" value="A相视在功率"/>A相视在功率(KW)</div>
    <div><input type="checkbox" value="B相视在功率"/>B相视在功率(KW)</div>
    <div><input type="checkbox" value="C相视在功率"/>C相视在功率(KW)</div>
    <div><input type="checkbox" value="总相视在功率"/>总视在功率(KW)</div>

    <div><input type="checkbox" value="A相功率因数"/>A相功率因数(%)</div>
    <div><input type="checkbox" value="B相功率因数"/>B相功率因数(%)</div>
    <div><input type="checkbox" value="C相功率因数"/>C相功率因数(%)</div>
    <div><input type="checkbox" value="总功率因数"/>总功率因数(%)</div>

    <div><input type="checkbox" value="频率"/>频率（Hz）</div>

</div>
</body>
</html>
