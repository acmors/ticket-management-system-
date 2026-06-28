package ticket.management.system.domain.usecase.ticket;

import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.exceptions.InputFieldsInvalidException;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.notification.NotificationPort;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

import java.util.List;
import java.util.Random;

public class CreateTicketUseCase {

    private final TicketRepositoryPort repository;
    private final UserRepositoryPort userRepositoryPort;
    private final NotificationPort notificationPort;

    public CreateTicketUseCase(TicketRepositoryPort repository, UserRepositoryPort userRepositoryPort, NotificationPort notificationPort) {
        this.repository = repository;
        this.userRepositoryPort = userRepositoryPort;
        this.notificationPort = notificationPort;
    }

    public Ticket execute(Ticket ticket, String userEmail){
        if (ticket.getTitle().length() < 10) throw new InputFieldsInvalidException("Title length must be more than 10 characters");
        if (ticket.getTitle().isBlank() || ticket.getTitle().isEmpty()) throw  new InputFieldsInvalidException("Title cannot be null.");

        if (ticket.getDescription().length() < 10) throw new InputFieldsInvalidException("Description length must be more than 50 characters");
        if (ticket.getDescription().isBlank() || ticket.getDescription().isEmpty()) throw  new InputFieldsInvalidException("Description cannot be null.");

        User user = userRepositoryPort.findByEmail(userEmail).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        int ticketNumber = generateTicketNumber();

        while (repository.existsByTicketNumber(ticketNumber)) {
            ticketNumber = generateTicketNumber();
        }

        ticket.setTicketNumber(ticketNumber);
        ticket.setCreatedBy(user);
        ticket.setTicketStatus(TicketStatus.OPEN);

        List<String> analystsEmail = userRepositoryPort.findAllAnalystEmails();

        notificationPort.notifyTicketCreated(
                user.getEmail(),
                analystsEmail,
                ticket.getTicketNumber(),
                ticket.getTitle()
        );

        return repository.save(ticket);
    }

    public int generateTicketNumber(){
        Random random = new Random();
        return random.nextInt(900000) + 100000;
    }
}
