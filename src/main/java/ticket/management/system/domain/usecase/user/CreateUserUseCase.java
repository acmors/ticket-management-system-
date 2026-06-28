package ticket.management.system.domain.usecase.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.entities.user.UserVerification;
import ticket.management.system.domain.entities.user.enums.Roles;
import ticket.management.system.domain.events.UserCreatedEvent;
import ticket.management.system.domain.exceptions.UserAlreadyExistsException;
import ticket.management.system.domain.ports.event.EventPublisherPort;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

import java.time.LocalDateTime;
import java.util.Random;

public class CreateUserUseCase {

    private final UserRepositoryPort repositoryPort;
    private final PasswordEncoder encoder;
    private final EventPublisherPort eventPublisherPort;

    public CreateUserUseCase(UserRepositoryPort repositoryPort, PasswordEncoder encoder, EventPublisherPort eventPublisherPort) {
        this.repositoryPort = repositoryPort;
        this.encoder = encoder;
        this.eventPublisherPort = eventPublisherPort;
    }

    public User execute(User user){

        var find = repositoryPort.existsUserByEmail(user.getEmail());
        if(find) throw new UserAlreadyExistsException("Already exists an user using this email.");

        String verificationCode = generateVerificationCode();
        UserVerification verification = new UserVerification(verificationCode, false, LocalDateTime.now().plusMinutes(10));
        String encodedPassword = encoder.encode(user.getPassword());

        user.setVerification(verification);
        user.setRole(Roles.COMMON);
        user.setPassword(encodedPassword);

        eventPublisherPort.publishUserCreated(
                new UserCreatedEvent(user.getName(), user.getEmail(), verificationCode)
        );

        return repositoryPort.save(user);
    }

    private String generateVerificationCode() {
        Random random = new Random();

        return String.valueOf(1000 + random.nextInt(9000));
    }
}
