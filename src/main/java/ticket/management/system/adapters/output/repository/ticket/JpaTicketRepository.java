package ticket.management.system.adapters.output.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket.management.system.adapters.output.entities.TicketEntity;

import java.util.Optional;

public interface JpaTicketRepository extends JpaRepository<TicketEntity, Long> {
    Optional<TicketEntity> findByTicketNumber(int ticketNumber);
}
