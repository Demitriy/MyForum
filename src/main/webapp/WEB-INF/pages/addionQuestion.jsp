<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
</head>
<body class="bg-faded">
    <c:import url="header.jsp"/>
    <div class="container">
        <form class="mt-5" action="/MyForum/" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <c:if test="${flag}">
                    <c:set var="style" value="border-color: red; border-width: 2px"/>
                </c:if>
                <input type="text" class="form-control" style="${style}" id="title" aria-describedby="emailHelp"
                       placeholder="Question`s title" name="title" value="${value}" required>
                <c:if test="${flag}">
                    <div class="form-control-feedback" style="color: red">Sorry, that title's taken. Try another?</div>
                </c:if>
            </div>
            <div class="form-group">
                <label for="content">Question</label>
                <textarea class="form-control" id="content" rows="3" name="content" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
<%--    <c:import url="footer.jsp"/>--%>
</body>
</html>
