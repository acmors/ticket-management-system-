package ticket.management.system.domain.usecase.ticket;

import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.exceptions.InputFieldsInvalidException;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

public class AssignTicketUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final TicketRepositoryPort ticketRepositoryPort;

    public AssignTicketUseCase(UserRepositoryPort userRepositoryPort, TicketRepositoryPort ticketRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.ticketRepositoryPort = ticketRepositoryPort;
    }

    public Ticket execute(String userEmail, int ticketNumber){

        Ticket ticket = ticketRepositoryPort.findByTicketNumber(ticketNumber).orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        User user = userRepositoryPort.findByEmail(userEmail).orElseThrow(() -> new ResourceNotFoundException("user not found"));

        if (ticket.getTicketStatus() == TicketStatus.CLOSED || ticket.getTicketStatus() == TicketStatus.RESOLVED) throw new InputFieldsInvalidException("Only open ticket can be assign to");

        ticket.setAssignedTo(user);
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        return ticketRepositoryPort.save(ticket);
    }
}
