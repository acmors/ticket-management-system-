package ticket.management.system.domain.entities.ticket;

import ticket.management.system.domain.entities.ticket.enums.TicketPriority;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.entities.user.User;

import java.time.LocalDateTime;

public class Ticket {

    private Long id;
    private int ticketNumber;
    private String title;
    private String description;
    private TicketPriority ticketPriority;
    private TicketStatus ticketStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User createdBy;
    private User assignedTo;

    public Ticket() {
    }

    public Ticket(Long id, int ticketNumber, String title, String description, TicketPriority ticketPriority, TicketStatus ticketStatus, LocalDateTime createdAt, LocalDateTime updatedAt, User createdBy, User assignedTo) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.title = title;
        this.description = description;
        this.ticketPriority = ticketPriority;
        this.ticketStatus = ticketStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketPriority getTicketPriority() {
        return ticketPriority;
    }

    public void setTicketPriority(TicketPriority ticketPriority) {
        this.ticketPriority = ticketPriority;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }
}
