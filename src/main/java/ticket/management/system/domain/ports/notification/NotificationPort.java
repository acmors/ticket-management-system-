package ticket.management.system.domain.ports.notification;

public interface NotificationPort {
    void notifyTicketCreated(String useEmail, String analystEmail, int ticketNumber, String ticketTitle );
}
