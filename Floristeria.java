package Floristeria;

import java.util.List;

public class Floristeria {
    private String nom="Floristeria ultimo suspiro";
    private FloristeriaDao dao; // Referencia al DAO que maneja la persistencia

    // Constructor que inyecta la dependencia del DAO
    public Floristeria(String nom, FloristeriaDao dao) {
        this.nom = nom;
        this.dao = dao;
    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Métodos que delegan la operación de añadir productos al DAO
    public void afegirArbre(Arbre arbre) {
        dao.afegirArbre(arbre);
    }

    public void afegirFlor(Flor flor) {
        dao.afegirFlor(flor);
    }

    public void afegirDecoracio(Decoracio decoracio) {
        dao.afegirDecoracio(decoracio);
    }

    // Métodos para gestionar la eliminación de productos
    public void eliminarArbre(int index) {
        dao.eliminarArbre(index);
    }

    public void eliminarFlor(int index) {
        dao.eliminarFlor(index);
    }

    public void eliminarDecoracio(int index) {
        dao.eliminarDecoracio(index);
    }

    // Métodos para obtener información del stock
    public List<Arbre> getArbres() {
        return dao.getArbres();
    }

    public List<Flor> getFlors() {
        return dao.getFlors();
    }

    public List<Decoracio> getDecoracions() {
        return dao.getDecoracions();
    }

    // Método para calcular el valor total del stock
    public double calcularValorTotalStock() {
        double total = 0;
        for (Arbre arbre : getArbres()) {
            total += arbre.getPrecio();
        }
        for (Flor flor : getFlors()) {
            total += flor.getPrecio();
        }
        for (Decoracio decoracio : getDecoracions()) {
            total += decoracio.getPrecio();
        }
        return total;
    }

    // Método para crear y registrar un ticket de venta
    public Ticket crearTicketDeCompra(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos para crear el ticket.");
            return null;
        }

        Ticket nuevoTicket = new Ticket();
        for (Producto producto : productos) {
            nuevoTicket.afegirProducte(producto);  // Añadir productos al ticket
        }

        try {
            dao.registrarTicket(nuevoTicket);  // Intentar registrar el ticket
            // Eliminar productos del inventario solo si el ticket se registra exitosamente
            for (Producto producto : productos) {
                int index;
                if (producto instanceof Arbre) {
                    index = getArbres().indexOf(producto);
                    if (index != -1) eliminarArbre(index);
                } else if (producto instanceof Flor) {
                    index = getFlors().indexOf(producto);
                    if (index != -1) eliminarFlor(index);
                } else if (producto instanceof Decoracio) {
                    index = getDecoracions().indexOf(producto);
                    if (index != -1) eliminarDecoracio(index);
                }
            }
            return nuevoTicket;
        } catch (Exception e) {
            System.err.println("No se pudo registrar el ticket: " + e.getMessage());
            return null;
        }
    }
    

    public FloristeriaDaoTxt getDao() {
        dao.getTickets();
        return (FloristeriaDaoTxt) dao;
    }


    public void registrarTicket(Ticket nuevoTicket) {
        dao.registrarTicket(nuevoTicket);
    }

    
    
}
