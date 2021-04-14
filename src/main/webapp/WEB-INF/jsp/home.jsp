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

        a:link, a:visited {
            background-color: white;
            color: black;
            border: 2px solid green;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            width: 100%;
        }

        a:hover, a:active {
            background-color: antiquewhite;
            color: white;
        }
    </style>
</head>
<body>
<div class="list">
    <c:forEach var="project" items="${listProject}">
        <div class="card">
            <h1>${project.name}</h1>
            <p class="customer">Customer: ${project.customerName}</p>
            <p>Start: ${project.start}</p>
            <p>Manager: ${project.incharge}</p>
            <p>Number: ${project.number}</p>
            <p>
                <a href="/listproject/${project.id}" >View Project</a>
            </p>
        </div>
    </c:forEach>
</div>

</body>

</html>