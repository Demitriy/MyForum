<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
</head>
<body class="bg-faded">
    <%--<c:import url="header.jsp"/>--%>
    <div class="container">
        <form class="mt-5" method="post" action="">
            <div class="form-group row">
                <label for="login" class="col-2 col-form-label">Login</label>
                <c:if test="${flag == 1}">
                    <c:set var="style1" value="border-color: red; border-width: 2px"/>
                </c:if>
                <div class="col-8">
                    <input class="form-control" style="${style1}" type="text" placeholder="login" id="login" name="login" value="${val_login}" required>
                    <c:if test="${flag == 1}">
                        <small class="form-control-feedback" style="color: red">${error}</small>
                    </c:if>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-2 col-form-label">Password</label>
                <c:if test="${flag == 2}">
                    <c:set var="style2" value="border-color: red; border-width: 2px"/>
                </c:if>
                <div class="col-8">
                    <input class="form-control" style="${style2}" type="password" placeholder="password" id="password" name="password" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="confirm" class="col-2 col-form-label">Confirm password</label>
                <div class="col-8">
                    <input class="form-control" style="${style2}" type="password" placeholder="password" id="confirm" name="confirm" required>
                    <c:if test="${flag == 2}">
                        <small class="form-control-feedback" style="color: red">${error}</small>
                    </c:if>
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-2 col-form-label">Email</label>
                <c:if test="${flag == 3}">
                    <c:set var="style3" value="border-color: red; border-width: 2px"/>
                </c:if>
                <div class="col-8">
                    <input class="form-control" style="${style3}" type="text" placeholder="myForum@example.com" id="email" name="email" value="${val_email}" required>
                    <c:if test="${flag == 3}">
                        <small class="form-control-feedback" style="color: red">${error}</small>
                    </c:if>
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-2 col-form-label">Name</label>
                <div class="col-8">
                    <input class="form-control" type="text" placeholder="Your name" id="name" name="name"  value="${val_name}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-2 col-form-label"></label>
                <div class="col-8">
                    <button type="submit" class="btn btn-primary mt-3">Ok</button>
                    <a href="/MyForum/" class="btn btn-primary ml-2 mt-3">Cancel</a>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
