<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container">
    <form action="/editProject/${project.id}" modelAttribute="project" method="post">
        <div class="row">
            <div class="col-25">
                <label>Project Name</label>
            </div>
            <div class="col-75">
                <input type="text" id="fname" name="name" value="${project.name}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label>Customer Name</label>
            </div>
            <div class="col-75">
                <input type="text" name="customerName" value="${project.customerName}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label>Manager</label>
            </div>
            <div class="col-75">
                <input type="text" name="incharge" value="${project.incharge}">
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
</body>


</html>