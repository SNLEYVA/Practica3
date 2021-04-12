

<%@page import="com.emergentes.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Producto item=(Producto) request.getAttribute("item");
        %>
        <h1>Modificar Producto</h1>
        <form action="Principal?op=guardar" method="POST">
            Id:<input type="text" name="id" value="<%= item.getId() %>" size="2" pattern="[1-9]{1}[0-9]*"/>
            <input type="hidden" name="tipo" value="<%= item.getId() %>" />
            <br>
            Producto: <input type="text" name="producto" value="<%= item.getProducto() %>" required/>
            <br>
            Precio: <input type="text" name="precio" value="<%= item.getPrecio()%>" />
            <br>
            Estado: <input type="text" name="cantidad" value="<%= item.getCantidad()%>" />
            
            <br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
