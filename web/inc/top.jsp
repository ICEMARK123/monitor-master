<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/10/31
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%--https://o.qcloud.com/static_api/v3/bk/css/bk.css--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/head.jsp"%>
<link href="<%=contextpath%>/static/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=contextpath%>/static/css/bk.css" rel="stylesheet">
<link href="<%=contextpath%>/admin/css/bk1.css" rel="stylesheet">
<link href="<%=contextpath%>/admin/css/iconfont.css" rel="stylesheet">
<nav class="navbar navbar-default king-horizontal-nav3" role="navigation" id="nav3_demo1">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bk-example-navbar-collapse-3">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="javascript:;">
                <img src="<%=contextpath%>/photos/electric1.jpg" alt="" style="width:10%;height:200%;margin-top: -2%;">
                <label style="margin-left:15%;margin-top:-7%;">国家电网</label>
            </a>
        </div>
        <div class="collapse navbar-collapse navbar-responsive-collapse" style="margin-left:15%;" id="bk-example-navbar-collapse-3">
            <ul class="nav navbar-nav ">

                <li class="bk-cur"><a href="<%=contextpath%>/index.jsp">首页</a></li>
                <li><a href="<%=contextpath%>/login/login.jsp">登录</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text"  class="form-control" placeholder="请输入要搜索测量号">
                </div>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="javascript:;">
                        <img src="https://o.qcloud.com/static_api/v3/components/horizontal_nav3/images/avatar.png" class="avatar">
                        <span>管理者 ( admin )</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<input type="text" id="contextpath" value="<%=request.getContextPath()%>" hidden />