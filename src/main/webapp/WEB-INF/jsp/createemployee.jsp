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
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
</head>
<body>
<div>
    <form action="/createEmployee" method="post" modelAttribute="employee">
        <label for="fname">Name</label>
        <input type="text" id="fname" name="name" placeholder="Input employee name" />

        <label for="addres">Address</label>
        <input type="text" id="addres" name="address" placeholder="Input employee address">

        <label>Department</label>
        <input type="text" name="department" placeholder="Input employee department">

        <label>Age</label>
        <input type="number" name="age" placeholder="Input employee age">

        <input type="submit" value="Submit">
    </form>
        <p style="color: red">${message}</p>
</div>
<a href="/">Back to home</a>
</body>
</html>