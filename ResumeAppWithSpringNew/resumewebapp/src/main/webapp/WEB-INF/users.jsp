<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script>
        function setIdForDelete(id){
            var elem = document.getElementById("idForDelete");
            elem.value = id;
        }
    </script>

</head>
<body>
<div class="container">
    <div class="row mb-5">
        <div class="col-lg-5">
            <f:form method="GET" action="users" modelAttribute="user">
                <div class="form-group">
                    <label for="name">Name</label>
                    <f:input type="text" class="form-control" id="exampleInputEmail1" path="name"></f:input>
                </div>
                <div class="form-group">
                    <label for="surname">Surname</label>
                    <f:input type="text" class="form-control" id="exampleInputPassword1" path="surname"></f:input>
                </div>
                <f:button type="submit" class="btn btn-primary">Search</f:button>
            </f:form>
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
                <c:forEach items="${users}" var="u" >
                    <tr>
                        <td>${u.name}</td>
                        <td>${u.surname}</td>
                        <td>${u.nationality.name}</td>
                        <td style="width:5px">

                            <input type="hidden" name="id" value="${u.id}"/>
                            <input type="hidden" name="action" value="delete"/>
                            <button class="btn btn-danger" type="submit" value="delete"
                                    data-toggle="modal" data-target="#exampleModal"
                                    onclick="setIdForDelete(${u.id})">
                                <i class="fas fa-trash-alt"></i>
                            </button>
                        </td>
                        <td style="width:5px">
                            <form action="userdetail" method="GET">
                                <input type="hidden" name="id" value="${u.id}"/>
                                <input type="hidden" name="action" value="update"/>
                                <button class="btn btn-secondary" type="submit" value="update">
                                    <i class="fas fa-pen-square"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="user-detail" method="GET">
                    <input type="hidden" id="idForDelete" name="id" value="">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" name="action" value="delete" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/08ad95816c.js" crossorigin="anonymous"></script>
</body>
</html>
