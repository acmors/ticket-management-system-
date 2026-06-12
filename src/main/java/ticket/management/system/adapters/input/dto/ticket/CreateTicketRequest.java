package ticket.management.system.adapters.input.dto.ticket;

import ticket.management.system.domain.entities.ticket.enums.TicketPriority;

public class CreateTicketRequest {

    private String title;
    private String description;
    private TicketPriority priority;

    public CreateTicketRequest() {
    }

    public CreateTicketRequest(String title, String description, TicketPriority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
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
}
