package ticket.management.system.domain.usecase.ticket;

import jakarta.persistence.EntityNotFoundException;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.ports.TicketRepositoryPort;

public class FindTicketByNumberUseCase {

    private final TicketRepositoryPort repositoryPort;

    public FindTicketByNumberUseCase(TicketRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Ticket execute(int ticketNumber){
        return repositoryPort.findByTicketNumber(ticketNumber)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found."));
    }
}
