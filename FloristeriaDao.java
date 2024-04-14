package Floristeria;

import java.util.Collection;
import java.util.List;

public interface FloristeriaDao {
    void afegirArbre(Arbre arbre);
    void afegirFlor(Flor flor);
    void afegirDecoracio(Decoracio decoracio);
    void eliminarArbre(int index);
    void eliminarFlor(int index);
    void eliminarDecoracio(int index);
    List<Arbre> getArbres();
    List<Flor> getFlors();
    List<Decoracio> getDecoracions();
    // Más métodos relacionados con la gestión de tickets
    void registrarTicket(Ticket nuevoTicket);
    Collection<Ticket> getTickets();
}





