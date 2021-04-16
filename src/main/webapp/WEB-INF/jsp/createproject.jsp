<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/createProject" method="post" modelAttribute="project">
    <label for="fname">Project Name:</label><br>
    <input type="text" id="fname" name="name" placeholder="Input project name"><br>
    <label for="cname">Customer Name:</label><br>
    <input type="text" id="cname" name="customerName" placeholder="Input customer name"><br>
    <label for="lname">Manager:</label><br>
    <input type="text" id="lname" name="incharge" placeholder="Input manager name"><br>
    <label>Start Date:</label><br>
    <input type="date" name="start"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>