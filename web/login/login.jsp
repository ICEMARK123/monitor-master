<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/10/30
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/head.jsp"%>
    <title>电力检测管理平台登录</title>
    <link href="<%=contextpath%>/login/login.css" rel="stylesheet">
</head>
<body>
<div class="div_left">
    <img src="<%=contextpath%>/photos/electric.jpg"/>
</div>
<div class="div_right" style="">
    <form id="loginform" method="post">
        <div class="div_inner"></div>
        <h3 style="margin-left:20px;">账号登录</h3>
        <div class="div_inner">
            <label>账 号：</label>
            <input type="text" class="inputclass" id="account" name="account" />
        </div>
        <div class="div_inner">
            <label>密 码：</label>
            <input type="password" class="inputclass" id="passwd" name="passwd" />
        </div>
        <div class="div_inner">
            <label>验证码：</label>
            <input type="text"  class="inputclass" id="vercode" name="vercode"/>
            <div class="pictureCode">
                <img id="img" style="width:100px;height:40px;" src="<%=contextpath%>/pass/securityCode.power"/>

                <a href = "javascript:void(0);" style = "font-size: 13px;margin-left: 5px;" onclick = "myReload()">看不清换一张&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </div>
        </div>
        <div class="div_inner">
            <label>身 份：</label>
            <input type="radio" id="admin" name="ident" value="admin"/>管理员
            <input type="radio" id="user" name="ident" value="user"/>一般用户

        </div>
        <div class="div_inner">
            <input type="button" class="buttonlogin" id="login" name="login" value="登录"/>
        </div>
    </form>
    <script src="<%=contextpath%>/login/login.js"></script>
    <%--<script href="">--%>
    <input type="text" id="contextpath" value="<%=request.getContextPath()%>" hidden/>
</div>
</body>
</html>
