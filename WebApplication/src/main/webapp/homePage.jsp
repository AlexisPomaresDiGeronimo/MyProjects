<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 9/8/2021
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <script src="functions.js"></script>
    <link rel="stylesheet" href="HomeStyle.css">
    <title>STAAAS | Log-in or Sign-in!</title>
    <link rel = "icon" href="Staaas%20logo.png"
          type = "image/x-icon">
</head>
<body>
<nav class="nav1">
    <div class="logo">
        <img src="Sletter.png">
    </div>
    <ul class="nav-links">
        <li><a href="login.jsp">Login</a></li>
        <li><a href="RegistPage.jsp">Register</a></li>
    </ul>
</nav>
<nav class="nav2">
    <ul class="nav-links">
        <li><a onclick="Home_text()">Home</a></li>
        <li><a onclick="Services_text()">Services</a></li>
        <li><a onclick="Contacts_text()">Contacts</a></li>
    </ul>
</nav>
<ul class="resList">
    <li><a href="login.jsp">Login</a></li>
    <li><a href="RegistPage.jsp">Register</a></li>
    <li><a onclick="Home_text()">Home</a></li>
    <li><a onclick="Services_text()">Services</a></li>
    <li><a onclick="Contacts_text()">Contacts</a></li>
</ul>
<div class="div-text">
    <p class="text" id="text">
        The organisation of Staaas was an idea minded by Strouboulis Nikolaos.
    </p>
</div>
</body>
</html>
