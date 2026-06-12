package ticket.management.system.adapters.output.repository.ticket;
import org.springframework.stereotype.Component;
import ticket.management.system.adapters.output.mapper.TicketMapper;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TicketRepositoryImpl implements TicketRepositoryPort {

    private final JpaTicketRepository repository;
    private final TicketMapper mapper;

    public TicketRepositoryImpl(JpaTicketRepository repository, TicketMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Ticket save(Ticket ticket) {
        //DOMAIN -> ENTITY
        var ticketEntity = TicketMapper.toEntity(ticket);
        //SAVE ENTITY
        var savedEntity = repository.save(ticketEntity);
        //ENTITY -> DOMAIN
        return TicketMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return repository.findById(id).map(TicketMapper::toDomain);
    }

    @Override
    public List<Ticket> findAll() {
        return repository.findAll().stream()
                .map(TicketMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Ticket> findByTicketNumber(int ticketNumber) {
        return repository.findByTicketNumber(ticketNumber).map(TicketMapper::toDomain);
    }
}
