

<%@page import="com.emergentes.modelo.Producto"%>
<%@page import="com.emergentes.modelo.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos</h1>
        <%
            ProductoDAO lista = (ProductoDAO) session.getAttribute("gestor");
        %>
        <h1>Listado</h1>
        <p><a href="../Principal?op=nuevo">Nuevo</a></p>
        <%
            if(lista.getProductos().size()>0){
        %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th></th>
                <th></th>
            </tr>
            <%
                for(Producto item : lista.getProductos()){
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getProducto()%></td>
                <td><%= item.getPrecio()%></td>
                <td><%= item.getCantidad() %></td>
                <td><a href="../Principal?op=modificar&id=<%= item.getId() %>">Modificar</a></td>
                <td><a href="../Principal?op=eliminar&id=<%= item.getId() %>">Eliminar</a></td>
            </tr>
            <%
            }
            %>
        </table>
            <%
                }
                else{
                    out.println("<p>No existe Producto");
                }
            %>
    </body>
</html>
