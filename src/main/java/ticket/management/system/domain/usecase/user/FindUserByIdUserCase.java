package ticket.management.system.domain.usecase.user;

import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

public class FindUserByIdUserCase {

    private final UserRepositoryPort repositoryPort;

    public FindUserByIdUserCase(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public User execute(Long id){
        return repositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
