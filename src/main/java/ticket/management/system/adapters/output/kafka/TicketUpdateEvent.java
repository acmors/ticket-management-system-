package ticket.management.system.adapters.output.kafka;

public class TicketUpdateEvent {
    private String userEmail;

    private Integer ticketNumber;

    private String ticketTitle;

    private String oldStatus;

    private String newStatus;

    public TicketUpdateEvent() {
    }

    public TicketUpdateEvent(String userEmail, Integer ticketNumber, String ticketTitle, String oldStatus, String newStatus) {
        this.userEmail = userEmail;
        this.ticketNumber = ticketNumber;
        this.ticketTitle = ticketTitle;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}
