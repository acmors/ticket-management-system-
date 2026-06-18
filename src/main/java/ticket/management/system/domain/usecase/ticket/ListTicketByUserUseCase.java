package ticket.management.system.domain.usecase.ticket;

import ticket.management.system.domain.entities.page.PageRequest;
import ticket.management.system.domain.entities.page.PageResponse;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;

public class ListTicketByUserUseCase {

    private final TicketRepositoryPort repositoryPort;

    public ListTicketByUserUseCase(TicketRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public PageResponse<Ticket> execute(String email, PageRequest pageRequest){
        return repositoryPort.findByCreatedBy(email, pageRequest);
    }
}
