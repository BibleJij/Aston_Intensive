<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Department List</title>
</head>
<body>

<h1>Department List</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Company_id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.getId()}</td>
            <td>${department.getName()}</td>
            <td>${department.getCompany().getId()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
