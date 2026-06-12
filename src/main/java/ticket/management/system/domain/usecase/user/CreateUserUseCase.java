package ticket.management.system.domain.usecase.user;

import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.entities.user.enums.Roles;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

public class CreateUserUseCase {

    private final UserRepositoryPort repositoryPort;

    public CreateUserUseCase(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public User execute(User user){
        user.setRole(Roles.COMMON);
        return repositoryPort.save(user);
    }
}
