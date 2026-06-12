package ticket.management.system.domain.ports.ticket;

import ticket.management.system.domain.entities.ticket.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketServicePort {
    Ticket createTicket(Ticket ticket);
    Optional<Ticket> findTicketById(Long id);
    List<Ticket> returnAllTickets();
    Ticket updateTicket(Ticket ticket);
    void deleteTicket(Long id);
}
