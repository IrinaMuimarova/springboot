<%--
  Created by IntelliJ IDEA.
  User: А
  Date: 26.12.2019
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UserCard</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue w3-opacity w3-right-align">
    <h1>
        <a class="w3-btn w3-round-large" href="/logout">Log out</a>
    </h1>
</div>
<div class="w3-card-4">
    <header class="w3-container w3-blue">
        <h1>${user.name}</h1>
    </header>

    <div class="w3-container">
        <p>Login: ${user.login}</p>
        <p>Role: ${user.roles}</p>
    </div>
    <c:if test="${user.roles.contains(0)}">
        <div class="w3-container w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-blue w3-round-large" onclick="location.href='/admin'">Admin</button>
        </div>
    </c:if>
</div>
</body>
</html>
