package ticket.management.system.domain.usecase.ticket;

import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.ports.TicketRepositoryPort;

import java.util.List;

public class ListAllTicketsUseCase {

    private final TicketRepositoryPort repositoryPort;

    public ListAllTicketsUseCase(TicketRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public List<Ticket> execute(){
        return repositoryPort.findAll();
    }
}
