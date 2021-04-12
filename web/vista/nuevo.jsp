<%-- 
    Document   : nuevo
    Created on : 12-abr-2021, 11:04:31
    Author     : Intel i5
--%>

<%@page import="com.emergentes.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Producto item=(Producto) request.getAttribute("item");
        %>
        <h1>Editar libro</h1>
        
        <form action="Principal?op=guardar" method="post">
            Id:<input type="text" name="id" value="<%= item.getId() %>" size="2" pattern="[1-9]{1}[0-9]*"/>
            <input type="hidden" name="tipo" value="-1" />
            <br>
            Producto: <input type="text" name="producto" value="<%= item.getProducto() %>" required/>
            <br>
            Precio: <input type="text" name="precio" value="<%= item.getPrecio()%>" />
            <br>
            Cantidad: <input type="text" name="cantidad" value="<%= item.getCantidad()%>" />
            
            <br>
            <input type="submit" value="Enviar" />
        </form>
            
    </body>
</html>
