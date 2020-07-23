<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">

<head>
    <title>Books</title>
    <meta charset="UTF-8">
</head>

<body>
<form action="/mvc14" method="get">
    <label>
        Title:
        <input type="text" name="title">
    </label>
    <label>
        Author:
        <input type="text" name="author">
    </label>
    <label>
        ISBN:
        <input type="text" name="isbn">
    </label>
    <input type="submit">
</form>
    <c:out value="${number}"/>
</body>
</html>
