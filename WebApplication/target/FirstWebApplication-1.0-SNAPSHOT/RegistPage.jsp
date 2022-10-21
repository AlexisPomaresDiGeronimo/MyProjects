<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="registStyle.css">
    <title>STAAAS | Register</title>
</head>
<body>
<div>
    <a href="homePage.jsp"><img src="Staaas%20logo.png"></a>
    <form action="RegisterServlet" method="post">
        <label style="color: red">${NullError}${passwordError}</label><br>
        <label>Username</label><br>
        <input type="text" id="newUsername" name="newUsername"><br>
        <label>E-mail</label><br>
        <input type="email" id="newEmail" name="newEmail"><br>
        <label>Password</label><br>
        <input type="password" id="newPassword" name="newPassword"><br>
        <label>Confirm Password</label><br>
        <input type="password" id="ConfirmPassword" name="ConfirmPassword"><br>
        <button type="submit">Regist!</button><br>
        Already have an account? <a href="login.jsp">Login!</a>
    </form>
</div>
</body>
</html>