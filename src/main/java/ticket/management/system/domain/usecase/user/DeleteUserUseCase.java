package ticket.management.system.domain.usecase.user;

import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

public class DeleteUserUseCase {

    private final UserRepositoryPort repositoryPort;

    public DeleteUserUseCase(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public void execute(Long id){
        repositoryPort.deleteById(id);
    }
}
