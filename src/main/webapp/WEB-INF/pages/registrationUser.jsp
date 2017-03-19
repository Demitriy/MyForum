<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
</head>
<body class="bg-faded">
    <c:import url="header.jsp"/>
    <div class="container">
        <form class="mt-5" method="post" action="#">
            <div class="form-group row">
                <label for="login" class="col-2 col-form-label">Login</label>
                <div class="col-8">
                    <input class="form-control" type="text" placeholder="login" id="login" name="login" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-2 col-form-label">Password</label>
                <div class="col-8">
                    <input class="form-control" type="password" placeholder="password" id="password" name="password" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="confirm" class="col-2 col-form-label">Confirm password</label>
                <div class="col-8">
                    <input class="form-control" type="password" placeholder="password" id="confirm" name="confirm" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-2 col-form-label">Email</label>
                <div class="col-8">
                    <input class="form-control" type="text" placeholder="myForum@example.com" id="email" name="email" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-2 col-form-label">Name</label>
                <div class="col-8">
                    <input class="form-control" type="text" placeholder="Your name" id="name">
                </div>
            </div>
            <button type="submit" class="btn btn-primary ">Submit</button>
        </form>
    </div>
</body>
</html>
