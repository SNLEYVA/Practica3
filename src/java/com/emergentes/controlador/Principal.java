
package com.emergentes.controlador;

import com.emergentes.modelo.Producto;
import com.emergentes.modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        ProductoDAO gestor=(ProductoDAO) ses.getAttribute("gestor");
        if(gestor==null){
            ProductoDAO auxi=new ProductoDAO();
            ses.setAttribute("gestor", auxi);
        }
        String op=request.getParameter("op");
        if(op==null){
            op="";
        }
        if(op.trim().equals("")){
            response.sendRedirect("vista/listado.jsp");
        }
        if(op.trim().equals("nuevo")){
            ses=request.getSession();
            Producto obj=new Producto();
            obj.setId(gestor.getCorrelativo()+1);
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/nuevo.jsp").forward(request, response);
        }
        if(op.trim().equals("modificar")){
            int pos=gestor.posicion(Integer.parseInt(request.getParameter("id")));
            Producto obj =gestor.getProductos().get(pos);
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/modificar.jsp").forward(request, response);
        }
        if(op.trim().equals("eliminar")){
            int pos=gestor.posicion(Integer.parseInt(request.getParameter("id")));
            gestor.getProductos().remove(pos);
            response.sendRedirect("vista/listado.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        
        ProductoDAO gestor =(ProductoDAO) ses.getAttribute("gestor");
        Producto obj =new Producto ();
        gestor.setCorrelativo(gestor.getCorrelativo()+1);
        
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setProducto(request.getParameter("producto"));
        obj.setPrecio(Double.parseDouble(request.getParameter("precio")));
        obj.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        
        String tipo = request.getParameter("tipo");
        
        if(tipo.equals("-1")){
            obj.setId(gestor.getCorrelativo());
            gestor.insertar(obj);
        } else{
            gestor.modificar(obj.getId(), obj);
        }
        response.sendRedirect("vista/listado.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
