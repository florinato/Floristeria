package Floristeria;

import java.io.Serializable;

abstract class Producto implements Serializable{
    protected double precio;
    public Producto(){
        
    }
    public Producto(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto [precio=" + precio + "]";
    }
    
}