package Floristeria;



import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class FloristeriaDaoTxt implements FloristeriaDao{
    private static final String ARBRES_FILE = "src/main/java/Floristeria/arbres.dat";
    private static final String FLORS_FILE = "src/main/java/Floristeria/flors.dat";
    private static final String DECORACIONS_FILE = "src/main/java/Floristeria/decoracions.dat";
    private static final String TICKETS_FILE = "src/main/java/Floristeria/tickets.dat";

    // Método para añadir árboles
    public void afegirArbre(Arbre arbre) {
        List<Arbre> arbres = getArbres();
        arbres.add(arbre);
        try {
            SerializationUtil.serialize(arbres, ARBRES_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener árboles
    @SuppressWarnings("unchecked")
    public List<Arbre> getArbres() {
        try {
            return (List<Arbre>) SerializationUtil.deserialize(ARBRES_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Método para eliminar árboles
    public void eliminarArbre(int index) {
        List<Arbre> arbres = getArbres();
        if (index >= 0 && index < arbres.size()) {
            arbres.remove(index);
            try {
                SerializationUtil.serialize(arbres, ARBRES_FILE);
            } catch (IOException e) {
                System.err.println("Error al guardar la lista de árboles actualizada: " + e.getMessage());
            }
        }
    }
    // Método para añadir flores
    public void afegirFlor(Flor flor) {
        List<Flor> flors = getFlors();
        flors.add(flor);
        try {
            SerializationUtil.serialize(flors, FLORS_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     // Método para obtener flores
    @SuppressWarnings("unchecked")
    public List<Flor> getFlors() {
        try {
            return (List<Flor>) SerializationUtil.deserialize(FLORS_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    } 

    // Método para eliminar flores
    public void eliminarFlor(int index) {
        List<Flor> flors = getFlors();
        if (index >= 0 && index < flors.size()) {
            flors.remove(index);
            try {
                SerializationUtil.serialize(flors, FLORS_FILE); // Guarda la lista actualizada
            } catch (IOException e) {
                System.err.println("Error al guardar la lista de flores actualizada: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Índice fuera de rango: No se pudo eliminar la flor.");
        }
    }
    

    // Método para añadir decoraciones
    public void afegirDecoracio(Decoracio decoracio) {
        List<Decoracio> decoracions = getDecoracions();
        decoracions.add(decoracio);
        try {
            SerializationUtil.serialize(decoracions, DECORACIONS_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener decoraciones
    @SuppressWarnings("unchecked")
    public List<Decoracio> getDecoracions() {
        try {
            return (List<Decoracio>) SerializationUtil.deserialize(DECORACIONS_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Método para eliminar decoraciones
    public void eliminarDecoracio(int index) {
        List<Decoracio> decoracions = getDecoracions();
        if (index >= 0 && index < decoracions.size()) {
            decoracions.remove(index);
            try {
                SerializationUtil.serialize(decoracions, DECORACIONS_FILE); // Guarda la lista actualizada
            } catch (IOException e) {
                System.err.println("Error al guardar la lista de decoraciones actualizada: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Índice fuera de rango: No se pudo eliminar la decoración.");
        }
    }
    
    public void registrarTicket(Ticket ticket) {
        List<Ticket> tickets = getTickets();
        tickets.add(ticket);
        try {
            SerializationUtil.serialize(tickets, TICKETS_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public List<Ticket> getTickets() {
        try {
            return (List<Ticket>) SerializationUtil.deserialize(TICKETS_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}


