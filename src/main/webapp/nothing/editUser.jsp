<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">

<head>
    <title>Users</title>
    <meta charset="UTF-8">
</head>
<body>

<table>
    <c:forEach items="${users}" var="item">
        <tr>
            <td><c:out value="${item}" /></td>
        </tr>
    </c:forEach>
</table>
<form action="/user/edit" method="get">
    <pre>
    Enter id of user to be changed       <input type="text" test name="userId" value="0">
    New Name                             <input type="text" test name="userName">
    New e-mail:                          <input type="text" test name="userEmail">
    User password:                       <input type="password" test name="userPass" value="not changed">
    <button type="submit">Update</button>
    </pre>

</form>

<p><a href="/user/index.html">Home</a></p>
</body>
</html>
