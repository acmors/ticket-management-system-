package ticket.management.system.domain.ports.ticket;

import ticket.management.system.domain.entities.page.PageRequest;
import ticket.management.system.domain.entities.page.PageResponse;
import ticket.management.system.domain.entities.ticket.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepositoryPort {

    Ticket save(Ticket ticket);
    Optional<Ticket> findById(Long id);
    PageResponse<Ticket> findByCreatedBy(String email, PageRequest pageRequest);
    List<Ticket> findAll();
    void deleteById(Long id);
    Optional<Ticket> findByTicketNumber(int ticketNumber);
    boolean existsByTicketNumber(int number);
    PageResponse<Ticket> findAll(PageRequest pageRequest);

}
