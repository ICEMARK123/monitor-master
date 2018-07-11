<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/10/30
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% String contextpath  = request.getContextPath();
    System.out.println(contextpath);%>
    <script src="<%=contextpath%>/static/js/jquery.min.js"></script>
    <input id="context_path" value="<%=request.getContextPath()%>" hidden/>
