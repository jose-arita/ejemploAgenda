<%-- 
    Document   : costumer_detail
    Created on : 8/02/2019, 08:41:28 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="CostumerUpdate">
            <input name="id" type="hidden" value="${costumer.id}">
            <input name="name" value="${costumer.name}" type="text" required minlength="2">
            <button>Actualizar</button>
        </form>
            
        <br>
        <a href="CostumerList">Volver a Lista</a>
        <br>
        <a href="AddPhone?costumerId=${costumer.id}&costumerName=${costumer.name}">Agregar Numero</a>
    </body>
</html>
