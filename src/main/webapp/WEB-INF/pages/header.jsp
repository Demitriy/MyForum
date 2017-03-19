<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-toggleable-md navbar-inverse bg-primary">
    <a class="navbar-brand" href="/MyForum/">MyForum</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/MyForum/">Home<span class="sr-only"></span></a>
            </li>
        </ul>
        <form class="input-group my-2 my-lg-0 pl-2" action="/MyForum/" method="get">
            <input class="form-control" type="text" placeholder="Search" id="search" name="search">
            <span class="input-group-btn">
                <button class="btn btn-secondary" type="submit">Go!</button>
            </span>
        </form>
       <span class="pl-5">
            <a href="registration" class="btn btn-secondary my-2 my-lg-0">Sign up</a>
        </span>
        <span class="px-3">
            <a href="#" class="btn btn-secondary my-2 my-lg-0">Sign in</a>
        </span>
    </div>
</nav>
</body>
</html>