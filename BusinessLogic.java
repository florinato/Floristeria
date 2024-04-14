package Floristeria;

import java.util.List;

public class BusinessLogic {
    TicketManager ticketManager = new TicketManager();

    public void processSale(List<Producto> productos) {
        Ticket newTicket = new Ticket();
        productos.forEach(newTicket::afegirProducte);
        ticketManager.addTicket(newTicket);
    }

    public List<Ticket> getAllTickets() {
        return ticketManager.getTickets();
    }
}

