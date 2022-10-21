<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type = "text/javascript" >
        function preventBack(){window.history.forward();}
        setTimeout("preventBack()", -1);
        window.onunload=function(){null};
    </script>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="HomeStyle.css">
    <title>STAAAS | ${username}</title>
    <link rel = "icon" href="Staaas%20logo.png"
          type = "image/x-icon">
</head>
<body>
<nav class="nav1">
    <div class="logo">
        <img src="Sletter.png">
    </div>
    <ul class="nav-links">
        <li><a href="">${username}</a></li>
        <li><a href="login.jsp">Log-out</a></li>
    </ul>
</nav>
<nav class="nav2">
    <ul class="nav-links">
        <li><a href="Welcome.jsp">Home</a></li>
        <li><a href="">Services</a></li>
        <li><a href="">Contacts</a></li>
    </ul>
</nav>
<ul class="resList">
    <li><a href="">${username}</a></li>
    <li><a href="Welcome.jsp">Home</a></li>
    <li><a href="">Services</a></li>
    <li><a href="">Contacts</a></li>
    <li><a href="login.jsp">Log-out</a></li>
</ul>
<div class="div-text">
    <p class="text">
        Welcome ${username}
    </p>
</div>
</body>
</html>

