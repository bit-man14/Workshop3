<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">

<head>
    <title>Books</title>
    <meta charset="UTF-8">
</head>
<body>
<c:forEach var="book" items="${books}">
    <c:out value="${book.title} "/>
    <c:out value="${book.author} "/>
    <c:out value="${book.isbn} "/>

</c:forEach>
</body>
</html>
