<%@page import="com.main.Context" %>
<%@page import="com.entity.User" %>
<%@page import="com.dao.inter.UserDaoInter" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUserDao();

    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String nationalityIdStr = request.getParameter("nid");
    Integer nationalityId = null;
    if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
        nationalityId = Integer.parseInt(nationalityIdStr);
    }

    List<User> list = userDao.getAll(name, surname, nationalityId);
%>

<div class="container">
    <div class="row mb-5">
        <div class="col-lg-5">
            <form method="GET" action="users.jsp">
                <input type="hidden" name="id" value="">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="surname">Surname</label>
                    <input type="text" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" name="search" class="btn btn-primary">Search</button>
            </form>
        </div>

    </div>

    <div class="row">
        <div class="col-lg-12">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Nationality</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <%for (User u : list) {%>
                <tr>
                    <td><%=u.getName()%>
                    </td>
                    <td><%=u.getSurname()%>
                    </td>
                    <td><%=u.getNationality().getName() == null ? "N/A" : u.getNationality().getName()%>
                    </td>
                    <td>
                        <form action="user-detail" method="GET">
                            <button class="btn btn-warning" name="action" value="edit" type="submit">
                                <input type="hidden" name="id" value="<%=u.getId()%>">
                                <i class="fa-solid fa-pen"></i>
                            </button>
                            <button class="btn btn-danger" name="action" value="delete" type="submit">
                                <input type="hidden" name="id" value="<%=u.getId()%>">
                                <i class="fa-solid fa-trash"></i>
                            </button>
                        </form>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>

</div>


<script src="https://kit.fontawesome.com/08ad95816c.js" crossorigin="anonymous"></script>
</body>
</html>
