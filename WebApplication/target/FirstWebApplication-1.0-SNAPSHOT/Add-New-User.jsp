<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="addNewUserStyle.css">
    <title>STAAAS | Add New User</title>
</head>
<body>
<div>
    <a href="AdminServlet"><img src="Staaas%20logo.png"></a>
    <form action="AddUserServlet" method="post">
        <label style="color: red">${NullError}${passwordError}</label><br>
        <label>Username</label><br>
        <input type="text" id="addUsername" name="addUsername"><br>
        <label>E-mail</label><br>
        <input type="email" id="addEmail" name="addEmail"><br>
        <label>Password</label><br>
        <input type="password" id="addPassword" name="addPassword"><br>
        <label>Confirm Password</label><br>
        <input type="password" id="ConfirmPassword" name="ConfirmPassword"><br>
        <button type="submit">Save!</button>
    </form>
</div>
</body>
</html>
