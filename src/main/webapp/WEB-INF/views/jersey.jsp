<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Product List </title><meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>

        .table {
            background-color: red;
            color: white;
        }

    </style>

</head>

<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href='/admin' title='admin'>Admin</a>

    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href='/logout' title='login'>Login Out</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                Items    </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="/Jerseys">Items</a>
                <a class="dropdown-item" href="/addJersey">CreateItem</a>
                <a class="dropdown-item" href="/deleteJersey">Delete Item</a>
                <a class="dropdown-item" href="/updateJersey">Update Item</a>
            </div>
        </li>
    </ul>
</nav>
<br><br>


<%--
<div class='card-2 topnav' id='topnav'>
    <div style="overflow:auto;">
        <div class="bar left" style="width:100%;overflow:hidden;height:44px">
            <a class="active" href='/admin' title='admin'>Admin</a>
            <a class="act" href="/cells">Items</a>
            <a class="act" href="/addCell">CreateItem</a>
            <a class="act" href="/deleteCell">Delete Item</a>
            <a class="act" href="/updateCell">Update Item</a>
            <div class="log">
                <a class="active" href='/logout' title='login'>Logout</a>
            </div>
            <div class="search-container">
                <input type="text" placeholder="Search.." name="search">
                <button type="submit">Submit</button>
            </div>
        </div>
    </div>
</div><br>
--%>
<h1>Manchester United </h1>


<div> <table class="table table-red table-black">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Edit Product</th>
        <th>Delete Product</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="jersey" items="${jersey}">
        <tr>
            <td>${jersey.id}</td>
            <td>${jersey.productname}</td>
            <td>${jersey.price}</td>
            <td><a href="/update?id=${jersey.id}">Edit</a></td>
            <td><a href="/del?id=${jersey.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</div>
</body>
</html>

