<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Company List</title>
</head>
<body>

<h1>Company List</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="company" items="${companies}">
        <tr>
            <td>${company.getId()}</td>
            <td>${company.getName()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>