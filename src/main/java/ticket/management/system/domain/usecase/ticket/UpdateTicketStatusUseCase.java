package ticket.management.system.domain.usecase.ticket;

import jakarta.persistence.EntityNotFoundException;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;

public class UpdateTicketStatusUseCase {

    private final TicketRepositoryPort repositoryPort;

    public UpdateTicketStatusUseCase(TicketRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Ticket execute(Long id, TicketStatus updateStatus){
        Ticket ticket = repositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        ticket.setTicketStatus(updateStatus);
        return repositoryPort.save(ticket);
    }
}
