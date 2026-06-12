package ticket.management.system.adapters.input.dto.ticket;

import ticket.management.system.domain.entities.ticket.enums.TicketPriority;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;

public class TicketResponse {

    private Long id;
    private Integer ticketNumber;
    private String title;
    private String description;
    private TicketPriority priority;
    private TicketStatus status;
    private String assignedTo;

    public TicketResponse() {
    }

    public TicketResponse(Long id, Integer ticketNumber, String title, String description, TicketPriority priority, TicketStatus status, String assignedTo) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
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

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
