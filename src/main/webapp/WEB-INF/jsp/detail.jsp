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
        .container {
            width: 100%;
        }

        .content-left {
            width: 25%;
            float: left;
        }

        .content-right {
            width: 75%;
            float: right;
        }

        .content-left table tr td {
            border: none;

        }

        .content-right table {
            border-collapse: collapse;
            text-align: center;
        }

        .content-right td, th {
            border: black solid 1px;

        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="content-left">
        <table>
            <tbody>
            <tr>
                <td>Project Name:</td>
                <td>${project.name}</td>
            </tr>
            <tr>
                <td>Customer Name:</td>
                <td>${project.customerName}</td>
            </tr>
            <tr>
                <td>Manager:</td>
                <td>${project.incharge}</td>
            </tr>
            <tr>
                <td>Start:</td>
                <td>${project.start}</td>
            </tr>
            <tr>
                <td>Number of employee:</td>
                <td>${project.number}</td>
            </tr>
            </tbody>
        </table>
        <a href="/editProject/${project.id}">Edit Project</a>
        <a href="/deleteProject/${project.id}">Delete Project</a>
    </div>

    <a href="/createTask/${project.id}">Create Task</a>
    <div class="content-right">
        <table style="width:100%">

            <tbody>
            <tr>
                <th style="width:30%">Task</th>
                <th style="width:30%">Employee incharge that task</th>
                <th style="width:10%">Status</th>
                <th style="width:15%">Edit Task</th>
                <th>Done/Undone</th>
                <th>Delete Task</th>
            </tr>
            <c:forEach items="${project.listTask}" var="task">
                <tr>
                    <td>${task.nameTask}</td>
                    <td>${task.employee.name}</td>
                    <c:if test="${task.status == 1}">
                        <td>Done</td>
                    </c:if>
                    <c:if test="${task.status == 0}">
                        <td>Doing</td>
                    </c:if>
                    <td><a href="/editTask/${task.id}">Edit</a></td>
                    <td><a href="/editTaskStatus/${task.id}">Done/Undone</a></td>
                    <td><a href="/deleteTask/${task.id}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
<div>
    <a href="/">Back to home</a>
</div>

</body>
</html>