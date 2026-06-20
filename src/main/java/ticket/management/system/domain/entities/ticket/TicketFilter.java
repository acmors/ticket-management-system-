package ticket.management.system.domain.entities.ticket;

import ticket.management.system.domain.entities.ticket.enums.TicketPriority;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TicketFilter {
    private TicketStatus status;
    private TicketPriority priority;
    private LocalDateTime createdAfter;

    public TicketFilter() {
    }

    public TicketFilter(TicketStatus status, TicketPriority priority, LocalDateTime createdAfter) {
        this.status = status;
        this.priority = priority;
        this.createdAfter = createdAfter;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAfter() {
        return createdAfter;
    }

    public void setCreatedAfter(LocalDateTime createdAfter) {
        this.createdAfter = createdAfter;
    }
}
