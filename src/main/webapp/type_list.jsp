<%-- 
    Document   : type_list
    Created on : 8/02/2019, 02:18:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tipos de telefonos</h1>
        
        <form action="CreatePhoneType" method="post">
            <input type="text" name="type" required minlength="2"/>
            <button>Guardar</button>
        </form>
        <br>
        <a href="index.jsp">Volver</a>
         <c:forEach items="${lista}" var="type">
             <p>${type.type}</p>
        </c:forEach>
    </body>
</html>
