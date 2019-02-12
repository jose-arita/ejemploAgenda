<%-- 
    Document   : contacts
    Created on : 8/02/2019, 04:13:23 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>contactos</title>
    </head>
    <body>
        <h1>Contactos</h1>     
        <br>
        <a href="index.jsp"></a>
        <c:forEach items="${lista}" var="contact">
             <p>${contact.costumerName} ${contact.number} ${contact.typeName}</p>
        </c:forEach>
        
    </body>
</html>
