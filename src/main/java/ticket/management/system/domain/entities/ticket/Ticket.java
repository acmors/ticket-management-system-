package ticket.management.system.domain.entities.ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketPriority;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;

import java.time.LocalDate;

public class Ticket {

    private Long id;
    private int ticketNumber;
    private String title;
    private String description;
    private TicketPriority ticketPriority;
    private TicketStatus ticketStatus;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String assignedTo;

    public Ticket() {
    }

    public Ticket(int ticketNumber, String title, String description) {
        this.ticketNumber = ticketNumber;
        this.title = title;
        this.description = description;
    }

    public Ticket(Long id, int ticketNumber, String title, String description, TicketPriority ticketPriority, TicketStatus ticketStatus, LocalDate createdAt, LocalDate updatedAt, String assignedTo) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.title = title;
        this.description = description;
        this.ticketPriority = ticketPriority;
        this.ticketStatus = ticketStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
