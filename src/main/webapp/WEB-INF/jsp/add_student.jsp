<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17.09.2022
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/students"><label for="full_name" >full_name</label>
    <input id="full_name" name="full_name" type="text">

    <label for="course_name" >course_name</label>
    <input id="course_name" name="course_name" type="text">
    <label for="mentor">mentors</label>
    <select name="mentor_id" id="mentor"><c:forEach var="mentorl" items="${mentor}">
        <option value="${mentorl.id}">
                ${mentorl.full_name}

        </option>
    </c:forEach></select>
    <button type="submit">saqlash</button>
</form>

</body>
</html>
