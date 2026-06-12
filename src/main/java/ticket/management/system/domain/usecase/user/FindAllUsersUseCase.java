package ticket.management.system.domain.usecase.user;

import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

import java.util.List;

public class FindAllUsersUseCase {

    private UserRepositoryPort repositoryPort;

    public FindAllUsersUseCase(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public List<User> execute(){
        return repositoryPort.findAll();
    }
}
