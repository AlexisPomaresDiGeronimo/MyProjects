<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 8/23/2021
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="editStyle.css">
    <title>STAAAS | Edit User</title>
</head>
<body>
<div>
    <a href="AdminServlet"><img src="Staaas%20logo.png"></a>
    <form action="EditFormServlet" method="post">
        <label style="color: red">${NullError}${Error}</label>
        <input type="text" id="Username" name="Username" value="${editUsername}" hidden><br>
        <label>Username</label><br>
        <input type="text" id="editFormUser" name="editFormUser" value="${editUsername}"><br>
        <label>E-mail</label><br>
        <input type="email" id="editFormEmail" name="editFormEmail" value="${editEmail}"><br>
        <label>Password</label><br>
        <input type="text" id="editFormPass" name="editFormPass" value="${editPass}"><br>
        <button type="submit">Save!</button>
    </form>
</div>
</body>
</html>
