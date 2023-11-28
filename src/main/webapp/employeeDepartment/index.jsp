<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Department List</title>
</head>
<body>

<h1>Employee Department List</h1>

<table border="1">
    <thead>
    <tr>
        <th>Employee_id</th>
        <th>Department_id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employeeDepartment" items="${employeeDepartments}">
        <tr>
            <td>${employeeDepartment.getEmployee().getId()}</td>
            <td>${employeeDepartment.getDepartment().getId()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
