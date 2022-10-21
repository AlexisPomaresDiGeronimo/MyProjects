<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="loginStyle.css">
    <script type = "text/javascript" >
        function preventBack(){window.history.forward();}
        setTimeout("preventBack()", -1);
        window.onunload=function(){null};
    </script>
    <meta charset="UTF-8">
    <title>STAAAS | Log-in or Sign-in!</title>
    <link rel = "icon" href="Staaas%20logo.png"
          type = "image/x-icon">
</head>
<body>
<div>
    <a href="homePage.jsp"><img src="Staaas%20logo.png"></a>
    <form action="LoginServlet" method="post">
        <label style="color: red;">${NullError}</label><br>
        <label>Username</label><br>
        <input type="text" id="username" name="username"></label><br>
        <label>Password</label><br>
        <input type="password" id="password" name="password"><br>
        <button type="submit">Login!</button><br>
        Create new account? <a href="RegistPage.jsp">Regist!</a>
    </form>
</div>
</body>
</html>