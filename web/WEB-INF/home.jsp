<%-- 
    Document   : home
    Created on : 6-Oct-2022, 2:36:41 PM
    Author     : levan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <p><b>Hello ${username}</b></p>
        <p>${message}</p>
        <p><a href="login?logout">Log out</a></p>
      
        
    </body>
</html>
