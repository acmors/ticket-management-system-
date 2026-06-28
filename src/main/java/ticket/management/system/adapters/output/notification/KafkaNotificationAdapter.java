package ticket.management.system.adapters.output.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ticket.management.system.adapters.output.kafka.TicketCreatedEvent;
import ticket.management.system.adapters.output.kafka.TicketUpdateEvent;
import ticket.management.system.domain.ports.notification.NotificationPort;

import java.util.List;
import java.util.Map;


@Component
public class KafkaNotificationAdapter implements NotificationPort {
    private static final Logger log =
            LoggerFactory.getLogger(KafkaNotificationAdapter.class);

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public KafkaNotificationAdapter(
            KafkaTemplate<String,Object> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void notifyTicketCreated(
            String userEmail,
            List<String> analystsEmail,
            int ticketNumber,
            String ticketTitle
    ) {

        TicketCreatedEvent event =
                new TicketCreatedEvent(
                        userEmail,
                        analystsEmail,
                        ticketNumber,
                        ticketTitle
                );

        kafkaTemplate.send(
                "ticket-created",
                event
        );

        log.info("Evento enviado ao Kafka. Ticket {}", ticketNumber);

    }

    @Override
    public void notifyTicketStatusUpdated(
            String userEmail,
            int ticketNumber,
            String ticketTitle,
            String oldStatus,
            String newStatus
    ) {

        TicketUpdateEvent event =
                new TicketUpdateEvent(
                        userEmail,
                        ticketNumber,
                        ticketTitle,
                        oldStatus,
                        newStatus
                );

        kafkaTemplate.send(
                "ticket-updated",
                event
        );

        log.info("Evento enviado ao Kafka. Ticket {}", ticketNumber);

    }
}
