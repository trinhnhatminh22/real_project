<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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
    <title>Document</title>
</head>
<body>
<a href="/">Back to home</a>
<h3>Edit Employee</h3>

<div>
    <form action="/editEmployee" method="post" modelAttribute="employee">
        <input type="hidden" name="id" value="${employee.id}">
        <label for="fname">First Name</label>
        <input type="text" id="fname" name="name" value="${employee.name}"/>

        <label for="addres">Address</label>
        <input type="text" id="addres" name="address" value="${employee.address}">

        <label>Department</label>
        <input type="text" name="department" value="${employee.department}">

        <label>Age</label>
        <input type="number" name="age" value="${employee.age}">

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>