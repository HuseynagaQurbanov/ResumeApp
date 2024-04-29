<%--
  Created by IntelliJ IDEA.
  User: Soft
  Date: 4/22/2024
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String msg = request.getParameter("msg");
    %>
    <%=msg%>
</body>
</html>
