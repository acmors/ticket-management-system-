package ticket.management.system.adapters.output.repository.ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ticket.management.system.adapters.output.entities.TicketEntity;
import ticket.management.system.adapters.output.mapper.TicketMapper;
import ticket.management.system.domain.entities.page.PageRequest;
import ticket.management.system.domain.entities.page.PageResponse;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.TicketFilter;
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

    @Override
    public boolean existsByTicketNumber(int number) {
        return repository.existsByTicketNumber(number);
    }

    @Override
    public PageResponse<Ticket> findAll(String email, TicketFilter filter, PageRequest pageRequest) {
        Pageable pageable = org.springframework.data.domain.PageRequest.of(pageRequest.page(), pageRequest.size());
        Page<TicketEntity> pageResult = repository.listAllTicketsFiltered(filter.getStatus(), filter.getPriority(), filter.getCreatedAfter(), pageable);

        return new PageResponse<>(
                pageResult.getContent().stream().map(TicketMapper::toDomain).toList(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages()
        );
    }

    @Override
    public PageResponse<Ticket> findByCreatedBy(String email, PageRequest pageRequest) {
        Pageable pageable =
                org.springframework.data.domain.PageRequest.of(
                        pageRequest.page(),
                        pageRequest.size());

        Page<TicketEntity> pageResult =
                repository.findByCreatedBy(email, pageable);

        return new PageResponse<>(
                pageResult.getContent()
                        .stream()
                        .map(TicketMapper::toDomain)
                        .toList(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages()
        );
    }

    @Override
    public PageResponse<Ticket> findByFilters(String email, TicketFilter filter, PageRequest pageRequest) {
        Pageable pageable = org.springframework.data.domain.PageRequest.of(pageRequest.page(), pageRequest.size());
        Page<TicketEntity> pageResult = repository.listByTicketFilter(email, filter.getStatus(), filter.getPriority(), filter.getCreatedAfter(), pageable);

        return new PageResponse<>(
                pageResult.getContent()
                        .stream()
                        .map(TicketMapper::toDomain)
                        .toList(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages()
        );
    }
}
