<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
</head>
<body>
    <div class="container">
        <div class="mt-5">
            <div class="form-group">
                <label>${question.title}</label>
                <textarea class="form-control" rows="3" disabled>${question.content}</textarea>
            </div>
<%--            <button type="submit" class="btn btn-primary">Submit</button>--%>
        </div>
    </div>
</body>
</html>
