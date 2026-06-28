package ticket.management.system.adapters.output.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ticket.management.system.adapters.output.kafka.dto.UserCreatedMessage;
import ticket.management.system.domain.events.UserCreatedEvent;
import ticket.management.system.domain.ports.event.EventPublisherPort;

@Component
public class KafkaEventPublisherAdapter implements EventPublisherPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaEventPublisherAdapter(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishUserCreated(UserCreatedEvent event) {
        UserCreatedMessage message = new UserCreatedMessage(
                event.getName(),
                event.getEmail(),
                event.getVerificationCode()
        );

        kafkaTemplate.send("user-created", message);
    }
}
