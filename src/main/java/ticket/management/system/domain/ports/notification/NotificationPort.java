package ticket.management.system.domain.ports.notification;

import java.util.List;

public interface NotificationPort {
    void notifyTicketCreated(String useEmail, List<String> analystsEmail, int ticketNumber, String ticketTitle );
    void notifyTicketStatusUpdated(String userEmail, int ticketNumber, String ticketTitle, String oldStatus, String newStatus);
}
