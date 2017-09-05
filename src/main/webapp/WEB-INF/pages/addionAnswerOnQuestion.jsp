<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
</head>
<body class="bg-faded">
    <c:import url="header.jsp"/>
    <div class="container bg-faded">
        <div class="card-block mt-5">
            <h4 class="card-title mt-2">${question.getTitle()}</h4>
            <p class="card-text">${question.getContent()}</p>
        </div>
        <div class="card-block mt-3">
            <h4 class="card-title">Answers</h4>
            <div class="pt-3"></div>
            <%--<hr>--%>
            <c:forEach var="answer" items="${answers}">
                <div class="mt-0">
                    <div class="card-text mt-0">${answer.getComment()}</div>
                    <hr class="my-lg-0">
                    <small class="form-control-feedback">Sent by ${answer.getUser().getLogin()}</small>
                    <%--<label for="hr">${answer.getUser().getLogin()}</label>--%>
                </div>
            </c:forEach>
        </div>
        <form action="" method="post">
            <div class="mt-2">
                <div class="form-group">
                    <label for="answer">Comment</label>
                    <textarea class="form-control" id="answer" rows="3" name="answer" required></textarea>
                </div>
                <div class="ml-auto">
                        <button type="submit" class="btn btn-primary">Add Comment</button>
                </div>
            </div>
        </form>
    </div>
<%--    <c:import url="footer.jsp"/>--%>
</body>
</html>
