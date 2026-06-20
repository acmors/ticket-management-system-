package ticket.management.system.domain.usecase.page;

import ticket.management.system.domain.entities.page.PageRequest;
import ticket.management.system.domain.entities.page.PageResponse;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.TicketFilter;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;

public class ListTicketsUseCase {

    private final TicketRepositoryPort ticketRepositoryPort;

    public ListTicketsUseCase(TicketRepositoryPort ticketRepositoryPort) {
        this.ticketRepositoryPort = ticketRepositoryPort;
    }

    public PageResponse<Ticket> execute(String email, TicketFilter filter,int page, int size){
        return ticketRepositoryPort.findAll(
                email,
                filter,
                new PageRequest(page, size)
        );
    }
}
