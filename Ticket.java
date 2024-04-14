package Floristeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Producto> productos = new ArrayList<>();

    public void afegirProducte(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        return productos.stream()
                        .mapToDouble(Producto::getPrecio)
                        .sum();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Ticket:\n");
        for (Producto p : productos) {
            builder.append(p).append("\n");  // Asegúrate de que Producto también tenga un toString() adecuado
        }
        builder.append("Total: ").append(calcularTotal());
        return builder.toString();
    }

    public List<Producto> getProductos() {
        // Devolver un array de Producto con los productos actuales en el ticket
        return productos;
    }
}



