<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17.09.2022
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/mentors/add_mentor">+studentqoshish</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">full_name</th>
        <th scope="col">Corse_name</th>

    </tr>
    </thead>
    <tbody>

<c:forEach items="${mentor}" var="mantors">
    <tr>
    <td scope="row">${mantors.id}</td>
    <td>${mantors.full_name}</td>
    <td>${mantors.course_name}</td>
<%--    <td>${mantor.mentor_name}</td>--%>
    <td>
<%--        <a href="/mentors/edit/${mentors.id}"> edit</a>--%>
<%--        <a href="/mentors/delete/${mentors.id}"> delete</a>--%>
        <a href="/mentors/delete/${mantors.id}">delete</a>

        <a href="/mentors/edit/${mantors.id}">edit</a>
    </td>
    </tr>
</c:forEach>

    </tbody>
</table>

</body>
</html>
