<%-- 
    Document   : addNumber
    Created on : 8/02/2019, 04:46:23 PM
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
        <h1>${costumerName}</h1>
        <a href="index.jsp">Volver</a>
        <form action="CreatePhone" method="post">
            <input type="hidden" name="costumerId" value="${costumerId}">
            <input type="text" name="number"/>
            <select name="typeId">
            <c:forEach items="${list}" var="type">
                <option value="${type.id}">${type.type}</option>
            </c:forEach>
            </select>
            <button>Guardar</button>
        </form>
    </body>
</html>
