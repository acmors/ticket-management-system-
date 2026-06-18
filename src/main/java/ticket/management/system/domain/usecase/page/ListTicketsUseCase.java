package ticket.management.system.domain.usecase.page;

import ticket.management.system.domain.entities.page.PageRequest;
import ticket.management.system.domain.entities.page.PageResponse;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;

public class ListTicketsUseCase {

    private final TicketRepositoryPort ticketRepositoryPort;

    public ListTicketsUseCase(TicketRepositoryPort ticketRepositoryPort) {
        this.ticketRepositoryPort = ticketRepositoryPort;
    }

    public PageResponse<Ticket> execute(int page, int size){
        return ticketRepositoryPort.findAll(
                new PageRequest(page, size)
        );
    }
}
