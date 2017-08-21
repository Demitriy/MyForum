<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
</head>
<body class="bg-faded">
    <div class = "container" style="display: block">
        <div class="card w-50 mx-auto mt-5">
            <div class="card-block">
                <h3 class="card-title">Registration is successful</h3>
                <p class="card-text">Congratulation!<cite title="Source Title"> ${text} </cite>shouldn`t tell anyone your login and password.</p>
                <a href="/MyForum/" class="btn btn-primary">Go Home</a>
                <a href="/MyForum/login" class="btn btn-primary">Sign in</a>
            </div>
        </div>
    </div>
</body>
</html>
