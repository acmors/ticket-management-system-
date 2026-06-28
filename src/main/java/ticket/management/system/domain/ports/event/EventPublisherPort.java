package ticket.management.system.domain.ports.event;

import ticket.management.system.domain.events.UserCreatedEvent;

public interface EventPublisherPort {

    void publishUserCreated(UserCreatedEvent event);
}
