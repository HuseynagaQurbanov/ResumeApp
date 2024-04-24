<%@page import="com.main.Context" %>
<%@page import="com.entity.User" %>
<%@page import="com.dao.inter.UserDaoInter" %>
<%@ page import="com.dao.inter.CountryDaoInter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Country" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<%
    User u = (User) request.getAttribute("user");

    CountryDaoInter countryDao = Context.instanceCountryDao();
    List<Country> countries = countryDao.getAllCountry();
%>
<div class="container">
    <div class="row">
        <form method="POST" action="user-detail">
            <input type="hidden" name="id" value="<%=u.getId()%>"/>
            <div class="form-group mb-3">
                <label for="name">Name</label>
                <input type="text" name="name" value="<%=u.getName()%>" class="form-control" placeholder="Name">
            </div>
            <div class="form-group mb-3">
                <label for="surname">Surname</label>
                <input type="text" name="surname" value="<%=u.getSurname()%>" class="form-control" placeholder="Name">
            </div>
            <div class="form-group mb-3">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" name="email" value="<%=u.getEmail()%>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
            </div>
            <div class="form-group mb-3">
                <label for="phone">Phone</label>
                <input type="text" name="phone" value="<%=u.getPhone()%>" class="form-control" placeholder="Enter Phone">
            </div>
            <div class="form-group mb-3">
                <label for="profileDescription">Profile description</label>
                <textarea name="profileDescription" class="form-control" id="exampleFormControlTextarea1" rows="3"><%=u.getProfileDesc()%></textarea>
            </div>
            <div class="form-group mb-3">
                <label for="address">Adress</label>
                <input type="text" name="address" value="<%=u.getAddress()%>" class="form-control" placeholder="Enter Address">
            </div>
            <div class="form-group mb-3">
                <label for="birthdate">Birthdate (yyyy-mm-dd)</label>
                <input type="text" name="birthdate" value="<%=u.getBirthDate().toString()%>" class="form-control" placeholder="Enter Address">
            </div>
            <div class="form-group mb-3">
                <label for="country">Country</label>
                <select class="form-control">
                    <%for (Country country : countries){%>
                        <option><%=country.toString()%></option>
                    <%}%>
                </select>
            </div>
            <div class="form-group mb-3">
                <label for="nationality">Nationality</label>
                <select class="form-control">
                    <%for (Country nationality : countries){%>
                    <option><%=nationality.toString()%></option>
                    <%}%>
                </select>
            </div>
            <input type="submit" class="btn btn-primary mb-5" name="save" value="Save">
        </form>
    </div>
</div>
</body>
</html>
