package ticket.management.system.domain.usecase.ticket;

import ticket.management.system.domain.entities.page.PageRequest;
import ticket.management.system.domain.entities.page.PageResponse;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.TicketFilter;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;

public class TicketFilterUseCase {

    private final TicketRepositoryPort repositoryPort;

    public TicketFilterUseCase(TicketRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public PageResponse<Ticket> execute(String email, TicketFilter filter, PageRequest request){
        return repositoryPort.findByFilters(email, filter, request);
    }
}
