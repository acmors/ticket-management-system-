package ticket.management.system.adapters.output.repository.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ticket.management.system.adapters.output.entities.TicketEntity;

import java.util.Optional;

public interface JpaTicketRepository extends JpaRepository<TicketEntity, Long> {
    Optional<TicketEntity> findByTicketNumber(int ticketNumber);
    boolean existsByTicketNumber(int number);
    @Query("""
        SELECT t
        FROM TicketEntity t
        WHERE t.createdBy.email = :email
    """)
    Page<TicketEntity> findByCreatedBy(String email, Pageable pageable);
}
