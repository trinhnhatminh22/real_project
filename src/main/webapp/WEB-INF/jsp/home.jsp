<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="<c:url value="../../../resources/static/home.css"/>" rel="stylesheet">
    <style>
        * {
            box-sizing: border-box;
        }


        .list {
            display: block;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: rgba(168, 132, 255, 0.6);
        }

        li {
            float: left;
        }

        .menu li a {
            display: block;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* Change the link color to #111 (black) on hover */
        li a:hover {
            background-color: rgb(106, 90, 205);
        }


        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            /*max-width: 300px;*/
            margin: auto;
            font-family: arial;
            float: left;
            width: 300px;
            margin: 20px 20px;
        }

        .customer {
            color: grey;
            font-size: 22px;
        }

        .list a:link, a:visited {
            background-color: white;
            color: black;
            border: 2px solid green;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            width: 100%;
        }

        .list a:hover, a:active {
            background-color: antiquewhite;
            color: white;
        }
    </style>
</head>
<body>
<div class="menu">
    <ul>
        <li><a href="/createProject">Create Project</a></li>
        <li><a href="/employee">List Employee</a></li>
    </ul>
</div>
<div class="list">
    <c:forEach var="project" items="${listProject}">
        <div class="card">
            <h1>${project.name}</h1>
            <p class="customer">Customer: ${project.customerName}</p>
            <p>Start: ${project.start}</p>
            <p>Manager: ${project.incharge}</p>
            <p>Number: ${project.number}</p>
            <p>
                <a href="/listproject/${project.id}">View Project</a>
            </p>
        </div>
    </c:forEach>
</div>

</body>

</html>