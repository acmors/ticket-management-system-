package ticket.management.system.domain.usecase.ticket;

import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.ports.TicketRepositoryPort;

import java.time.LocalDate;

public class CreateTicketUseCase {

    private final TicketRepositoryPort repository;

    public CreateTicketUseCase(TicketRepositoryPort repository) {
        this.repository = repository;
    }

    public Ticket execute(Ticket ticket){
        ticket.setCreatedAt(LocalDate.now());
        ticket.setTicketStatus(TicketStatus.OPEN);
        return repository.save(ticket);
    }
}
