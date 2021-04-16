<!doctype html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>

        .info-table {
            border-collapse: collapse;
            text-align: left;
            width: 80%;
            margin: 50px;
        }
        .info-table th, td {
            border: 1px solid cornflowerblue;
        }

        ul {
            list-style-type: circle;
            width: 100%;
            padding: 0;
            margin-top: 0px;
            margin-bottom: 0px;
            margin-left: 20px;
        }

    </style>
</head>
<body>
<h2> List employee </h2>
<div>
    <table class="info-table">
        <tr>
            <td width="10%">Name</td>
            <td width="10%">Department</td>
            <td width="50%">List Task</td>
            <td>List Project</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="employee" items="${list}">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.department}</td>

                <td>
                    <ul><c:forEach var="task" items="${employee.listTask}">
                        <li>${task.nameTask}</li>
                    </c:forEach>
                    </ul>
                </td>
                <td>
                    <ul><c:forEach var="project" items="${employee.project}">
                        <li>${project.name}</li>
                    </c:forEach>
                    </ul>
                </td>
                <td><a href="/editEmployee/${employee.id}">Edit</a></td>
                <td><a href="/deleteEmployee/${employee.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="/createEmployee">Create Employee</a>
</div>
<div>
    <a href="/">Back to home</a>
</div>
</body>
</html>