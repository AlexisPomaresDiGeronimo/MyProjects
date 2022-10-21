<%@ page import="jdk.internal.icu.impl.CharacterIteratorWrapper" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.security.KeyStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type = "text/javascript" >
        function preventBack(){window.history.forward();}
        setTimeout("preventBack()", -1);
        window.onunload=function(){null};
    </script>
    <script src="functions.js"></script>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="adminStyle.css">
    <title>STAAAS | Admin</title>
    <link rel = "icon" href="Staaas%20logo.png"
          type = "image/x-icon">
</head>
<body>
<nav class="nav1">
    <div class="logo">
        <img src="Sletter.png">
    </div>
    <ul class="nav-links">
        <li><a href="Add-New-User.jsp">Add New User</a></li>
        <li> <a href="login.jsp">Log-out</a></li>
    </ul>
</nav>
<nav class="nav2">
    <ul class="nav-links">
        <li><a onclick="Home_text()">Home</a></li>
        <li><a onclick="Services_text()">Services</a></li>
        <li><a onclick="Contacts_text()">Contacts</a></li>
        <li><a href="AdminServlet">Users</a></li>
    </ul>
</nav>
<ul class="resList">
    <li><a href="Add-New-User.jsp">Add New User</a></li>
    <li><a onclick="Home_text()">Home</a></li>
    <li><a onclick="Services_text()">Services</a></li>
    <li><a onclick="Contacts_text()">Contacts</a></li>
    <li><a href="AdminServlet">Users</a></li>
    <li><a href="login.jsp">Log-out</a></li>
</ul>
<div class="div-text">
    <table class="text" id="text">
        <tr><th>Username</th><th>Email</th><th>Password</th><th>Edit</th><th>Delete</th></tr>
        <% ArrayList<ArrayList<String>> usersList = (ArrayList<ArrayList<String>>) request.getAttribute("usersList");
            if(usersList!=null){ for(int i=0;i<usersList.size();i++){
        %>
        <tr>
            <form action="EditServlet" method="post">
                <td><input type="text" id="editUsername" name="editUsername" value="<%=usersList.get(i).get(0)%>" readonly></td>
                <td><input type="text" id="editEmail" name="editEmail" value="<%=usersList.get(i).get(1)%>" readonly></td>
                <td><input type="text" id="editPass" name="editPass" value="<%=usersList.get(i).get(2)%>" readonly></td>
                <td><a href="editPage.jsp"><button type="submit">Edit</button></a></td>
            </form>
            <form action="DeleteUserServlet" method="post">
                <input type="text" id="DeleteUsername" name="DeleteUsername" value="<%=usersList.get(i).get(0)%>" hidden>
                <td><button type="submit">Delete</button></td>
            </form>
        </tr>
        <%}
        }%>
    </table>
</div>
</body>
</html>
