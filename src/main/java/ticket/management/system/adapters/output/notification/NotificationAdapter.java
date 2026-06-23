package ticket.management.system.adapters.output.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ticket.management.system.domain.ports.notification.NotificationPort;

import java.util.List;
import java.util.Map;


@Component
public class NotificationAdapter implements NotificationPort {
    private static final Logger log = LoggerFactory.getLogger(NotificationAdapter.class);
    private final RestTemplate restTemplate;
    private final String notificationUrl;

    public NotificationAdapter(RestTemplate restTemplate, @Value("${notification.service.url}") String notificationUrl) {
        this.restTemplate = restTemplate;
        this.notificationUrl = notificationUrl;
    }


    @Override
    public void notifyTicketCreated(String useEmail, List<String> analystsEmail, int ticketNumber, String ticketTitle) {
        try{
            Map<String, Object> request = Map.of(
                    "userEmail", useEmail,
                    "analystEmail", analystsEmail,
                    "ticketNumber", ticketNumber,
                    "ticketTitle", ticketTitle
            );

            restTemplate.postForEntity(notificationUrl + "/api/notification/ticket-created", request, Void.class);
            log.info("Notificação enviada: Ticket #{} criado com sucesso", ticketNumber);

        }catch (Exception e) {
            log.error("Falha ao notificar criação do ticket #{}: {}", ticketNumber, e.getMessage());
        }
    }

    @Override
    public void notifyTicketStatusUpdated(String userEmail, int ticketNumber, String ticketTitle, String oldStatus, String newStatus) {
        try{
            Map<String, Object> request = Map.of(
                    "userEmail", userEmail,
                    "ticketNumber", ticketNumber,
                    "ticketTitle", ticketTitle,
                    "oldStatus", oldStatus,
                    "newStatus", newStatus
            );

            restTemplate.postForEntity(notificationUrl + "/api/notification/ticket-updated", request, Void.class);
            log.info("Notificação enviada: Ticket #{} atualizado de {} pra {}", ticketNumber, oldStatus, newStatus);
        }catch (Exception e){
            log.error("Falha ao notificar update do ticket #{}: {}", ticketNumber, e.getMessage());
        }
    }
}
