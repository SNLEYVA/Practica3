
package com.emergentes.modelo;

import java.util.ArrayList;

public class ProductoDAO {
    private int correlativo;
    private ArrayList<Producto> productos;

    public ProductoDAO() {
        productos =new ArrayList<Producto>();
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public void insertar(Producto item){
        productos.add(item);
    }
    public void modificar(int id, Producto item){
        int pos = posicion(id);
        productos.set(pos, item);
    }
    public void eliminar(int id){
        int pos=posicion(id);
        productos.remove(pos);
    }
    public int posicion(int id){
        int i=-1;
        if(productos.size()>0){
            for(Producto item : productos){
                ++i;
                if(item.getId() == id){
                    break;
                }
            }
        }
        return i;
    }    
}
