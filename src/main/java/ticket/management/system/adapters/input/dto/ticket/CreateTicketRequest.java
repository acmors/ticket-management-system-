package ticket.management.system.adapters.input.dto.ticket;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ticket.management.system.domain.entities.ticket.enums.TicketPriority;

public class CreateTicketRequest {

    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 10, message = "Title must be more than 10 characters")
    private String title;
    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 20, message = "Description must be more than 20 characters")
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
