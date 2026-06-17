package ticket.management.system.domain.usecase.ticket;

import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.exceptions.InputFieldsInvalidException;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;

public class UpdateTicketStatusUseCase {

    private final TicketRepositoryPort repositoryPort;

    public UpdateTicketStatusUseCase(TicketRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Ticket execute(int number, TicketStatus updateStatus){
        Ticket ticket = repositoryPort.findByTicketNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        if(ticket.getTicketStatus() == TicketStatus.CLOSED || ticket.getTicketStatus() == TicketStatus.RESOLVED) throw new InputFieldsInvalidException("Only OPEN or IN PROGRESS Tickets can be changed");

        ticket.setTicketStatus(updateStatus);
        return repositoryPort.save(ticket);
    }
}
