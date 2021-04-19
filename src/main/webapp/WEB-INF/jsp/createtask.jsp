<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/jquery-1.8.3.js" type="text/javascript" ></script>
    <script src="js/jquery-ui.js" type="text/javascript" ></script>
    <title>Document</title>
</head>
<body>
<form action="/createTask" method="post" >
    <input type="hidden" name="projectId" value="${projectId}">
    <label for="fname">Task Name:</label><br>
    <input type="text" id="fname" name="name" placeholder="Input task name"><br>
    <label for="lname">Employee Name:</label><br>
    <input type="text" id="lname" name="employee" placeholder="Input employee name"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>