<%-- 
    Document   : lista
    Created on : 6/02/2019, 04:17:33 PM
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
        <h1>Nombres</h1>
        <form method="post" action="CreateCostumer">
            <input name="name" type="text" required minlength="2"/>
            <button>Guardar</button>
        </form>
        <br>
        <a href="index.jsp">Volver</a>
        <c:forEach items="${lista}" var="costumer">
             <p>${costumer.name}
                 <a href="CostumerById?id=${costumer.id}">Ver </a>
                 
                 <a href="DeleteCostumer?id=${costumer.id}">Borrar</a>
             </p>
        </c:forEach>
    </body>
</html>
