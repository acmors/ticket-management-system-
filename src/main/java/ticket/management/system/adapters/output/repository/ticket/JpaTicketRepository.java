package ticket.management.system.adapters.output.repository.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ticket.management.system.adapters.output.entities.TicketEntity;
import ticket.management.system.domain.entities.ticket.enums.TicketPriority;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Query("""
        SELECT t
        FROM TicketEntity t
        WHERE t.createdBy.email =:email
            AND (:status IS NULL OR t.ticketStatus = :status)
            AND (:priority IS NULL OR t.ticketPriority = :priority)
            AND (CAST(:createdAfter AS timestamp) IS NULL OR t.createdAt >= :createdAfter)
    """)
    Page<TicketEntity> listByTicketFilter(
            @Param("email")String email,
            @Param("status") TicketStatus status,
            @Param("priority")TicketPriority priority,
            LocalDateTime createdAfter,
            Pageable pageable
    );

    @Query("""
        SELECT t
        FROM TicketEntity t
        WHERE t.assignedTo.email =:email
            AND (:status IS NULL OR t.ticketStatus = :status)
            AND (:priority IS NULL OR t.ticketPriority = :priority)
            AND (CAST(:createdAfter AS timestamp) IS NULL OR t.createdAt >= :createdAfter)
    """)
    Page<TicketEntity> listByTicketFilterForAnalyst(
            @Param("email") String email,
            @Param("status") TicketStatus status,
            @Param("priority")TicketPriority priority,
            LocalDateTime createdAfter,
            Pageable pageable
    );

}
