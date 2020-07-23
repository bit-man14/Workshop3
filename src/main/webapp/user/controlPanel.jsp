<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">

<head>
    <title>Users</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>List of users in DB</h2>

<table>
    <c:forEach items="${users}" var="item">
        <tr>
            <td><c:out value="${item}"/></td>
        </tr>
    </c:forEach>
</table>

<h2>Add user to DB</h2>
<form action="/user/add" method="post">
    <pre>
        <input type="text" test name="userName" placeholder="enter user name">
        <input type="text" test name="userEmail" placeholder="enter e-mail">
        <input type="password" test name="userPass" placeholder="enter password">

        <button type="submit">Add</button>
    </pre>

    <h2>Edit user data</h2>
</form>
<form action="/user/edit" method="get">
    <pre>
        <input type="text" test name="userId" placeholder="Enter id of user to be changed">
        <input type="text" test name="userName" placeholder="New Name">
        <input type="text" test name="userEmail" placeholder="New e-mail address">
        <input type="password" test name="userPass" placeholder="no change in password">

        <button type="submit">Update</button>
    </pre>

    <h2>Delete user from DB</h2>
</form>
<form action="/user/delete" method="post">
    <pre>
        <input type="text" test name="userId" placeholder="Id of user to be deleted">

        <button type="submit">Delete</button>
    </pre>

</form>
<p><a href="/user/index.html">Home</a></p>
</body>
</html>
