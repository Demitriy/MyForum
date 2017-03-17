<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-toggleable-md navbar-inverse bg-primary">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/MyForum/">MyForum</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/MyForum/">Home<span class="sr-only"></span></a>
            </li>
        </ul>
        <form class="input-group my-2 my-lg-0" action="search" method="post">
            <input class="form-control" type="text" placeholder="Search" id="search" name="search">
            <span class="input-group-btn">
                <button class="btn btn-secondary" type="submit">Go!</button>
            </span>
        </form>
        <div style="width: 50px">

        </div>
<%--        <a href="#" class="btn btn-secondary my-2 my-sm-0">Sign in</a>
        <a href="#" class="btn btn-secondary my-2 my-sm-0">Sign out</a>--%>
    </div>
</nav>
</body>
</html>
