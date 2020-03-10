<%--
  Created by IntelliJ IDEA.
  User: А
  Date: 23.12.2019
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>
        <a class="w3-btn w3-round-large" href="/admin/add">+</a>
        <a class="w3-btn w3-round-large" href="/logout">Log out</a>
    </h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Users</h2>
        </div>
        <table class="w3-table">
            <c:if test="${not empty users}">
                <c:forEach var="user" items="${users}">
                    <!-- construct an "update" link with customer id -->
                    <c:url var="updateLink" value="/admin/update">
                        <c:param name="userId" value="${user.id}" />
                    </c:url>

                    <!-- construct an "delete" link with customer id -->
                    <c:url var="deleteLink" value="/admin/delete">
                        <c:param name="userId" value="${user.id}" />
                    </c:url>
                    <tr>
                        <th>${user.id}</th>
                        <th>${user.name}</th>
                        <th>${user.login}</th>
                        <th>${user.roles}</th>

                        <td>
                            <!-- display the update link --> <a href="${updateLink}">Update</a>
                            | <a href="${deleteLink}"
                                 onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty users}">
                <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
                    <span onclick="this.parentElement.style.display='none'" class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">X</span>
                    <h5>There are no users yet!</h5>
                </div>
            </c:if>
        </table>
    </div>
</div>
</body>

</html>
