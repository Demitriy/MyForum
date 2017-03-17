<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
   <%-- <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>

    <!-- Bootstrap CSS -->
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container">
    <div class="d-flex mt-4">
        <div class="ml-auto p-2 pb-4">
            <a class="btn btn-success" href="NewQuestion" role="button">Add question</a>
        </div>
    </div>

    <div>
        <c:forEach var="tmp" items="${listTitle}">
            <div class="alert alert-info">
                <a href="question/${tmp.id}"><strong>${tmp.title}</strong></a>
            </div>
        </c:forEach>
    </div>
</div>
<%--<c:import url="footer.jsp"/>--%>
<!-- jQuery first, then Tether, then Bootstrap JS. -->
<%--<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>--%>
</body>
</html>