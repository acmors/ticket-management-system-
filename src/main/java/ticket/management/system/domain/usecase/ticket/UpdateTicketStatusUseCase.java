package ticket.management.system.domain.usecase.ticket;

import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.exceptions.InputFieldsInvalidException;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.notification.NotificationPort;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;

public class UpdateTicketStatusUseCase {

    private final TicketRepositoryPort repositoryPort;
    private final NotificationPort notificationPort;

    public UpdateTicketStatusUseCase(TicketRepositoryPort repositoryPort, NotificationPort notificationPort) {
        this.repositoryPort = repositoryPort;
        this.notificationPort = notificationPort;
    }

    public Ticket execute(int number, TicketStatus updateStatus){
        Ticket ticket = repositoryPort.findByTicketNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        String oldStatus = TicketStatus.OPEN.name();

        if(ticket.getTicketStatus() == TicketStatus.CLOSED || ticket.getTicketStatus() == TicketStatus.RESOLVED) throw new InputFieldsInvalidException("Only OPEN or IN PROGRESS Tickets can be changed");
        ticket.setTicketStatus(updateStatus);

        notificationPort.notifyTicketStatusUpdated(ticket.getCreatedBy().getEmail(), ticket.getTicketNumber(), ticket.getTitle(), oldStatus, ticket.getTicketStatus().name());

        return repositoryPort.save(ticket);
    }
}
