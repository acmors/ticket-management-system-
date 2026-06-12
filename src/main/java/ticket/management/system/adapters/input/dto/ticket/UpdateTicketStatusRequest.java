package ticket.management.system.adapters.input.dto.ticket;

import ticket.management.system.domain.entities.ticket.enums.TicketStatus;

public class UpdateTicketStatusRequest {
    private TicketStatus status;

    public UpdateTicketStatusRequest() {
    }

    public UpdateTicketStatusRequest(TicketStatus status) {
        this.status = status;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
