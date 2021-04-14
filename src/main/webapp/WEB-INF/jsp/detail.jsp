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
            display: inline;
        }

        .content-left {
            width: 25%;
        }
        .content-left table tr td {
            border: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="content-left">
        <div id="about" class="container-fluid">
            <div class="row">
                <div class="col-sm-8">
                    <table>
                        <tbody>
                        <tr>
                            <td>Project Name</td>
                            <td>${project.name}</td>
                        </tr>
                        <tr>
                            <td>Customer Name</td>
                            <td>${project.customerName}</td>
                        </tr>
                        <tr>
                            <td>Manager</td>
                            <td>${project.incharge}</td>
                        </tr>
                        <tr>
                            <td>Start</td>
                            <td>${project.start}</td>
                        </tr>
                        <tr>
                            <td>Number of employee</td>
                            <td>${project.number}</td>
                        </tr>
                        </tbody>
                    </table>
                    <p></p>
                    <br>
                    <button class="btn btn-default btn-lg">Get in Touch</button>
                </div>
                <div class="col-sm-4">
                    <span class="glyphicon glyphicon-signal logo"></span>
                </div>
            </div>
        </div>
    </div>
    <div class="content-right">
        <h1>Hello</h1>
    </div>
</div>
</body>
</html>