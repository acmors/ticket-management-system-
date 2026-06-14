package ticket.management.system.domain.usecase.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.entities.user.enums.Roles;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

public class CreateUserUseCase {

    private final UserRepositoryPort repositoryPort;
    private final PasswordEncoder encoder;

    public CreateUserUseCase(UserRepositoryPort repositoryPort, PasswordEncoder encoder) {
        this.repositoryPort = repositoryPort;
        this.encoder = encoder;
    }

    public User execute(User user){
        String encodedPassword = encoder.encode(user.getPassword());
        user.setRole(Roles.COMMON);
        user.setPassword(encodedPassword);

        return repositoryPort.save(user);
    }
}
