<%@page import="com.main.Context"%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.inter.UserDaoInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <%
            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getById(1);
        %>
        <form method="POST" action="UserController">


            <input type="hidden" name="id" value="<%out.println(u.getId());%>"

                   <label for="name">Name:</label>
            <input type="type" name="name" value="<%out.println(u.getName());%>">
            <label for="surname">Surname:</label>
            <input type="type" name="surname" value="<%out.println(u.getSurname());%>">

            <input type="submit" name="save" value="Save">
        </form>
    </body>
</html>
