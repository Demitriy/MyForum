<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
     <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
</head>
<body class = "bg-faded">
<div class="container mt-5">
    <form method="post" action="">
        <div class="form-group row">
            <label for="login" class="col-sm-2 col-form-label">Login/Email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="login" name="login" placeholder="Login/Email">
            </div>
        </div>
        <div class="form-group row">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                <c:if test="${flag}">
                    <small class="form-control-feedback" style="color: red">${error}</small>
                </c:if>
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
            <a href="/MyForum/" class="btn btn-primary">Go Home</a>
        </div>
    </form>
</div>
</body>
</html>