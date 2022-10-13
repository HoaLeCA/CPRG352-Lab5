<%-- 
    Document   : login
    Created on : 6-Oct-2022, 2:30:39 PM
    Author     : levan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            
        <div>
            <label>Username:</label>
            <input type="text" name="username" value="${user.username}">  
        </div>
        
        <div>
            <label>Password:</label>
            <input type="password" name="password" value="${user.password}">  
        </div>
         <div>
             <input type="submit" value="Log in"  >
        </div>
        </form>
           <c:if test="${error == true}">
                     <p>Wrong username or password</p>
            </c:if>
             <c:if test="${logOutMessage == true}">
                     <p>You have successfully logged out!</p>
            </c:if>
    </body>
    
</html>
