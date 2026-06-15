package ticket.management.system.domain.usecase.user;

import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

public class UpdateUserEmailUseCase {

    private final UserRepositoryPort repositoryPort;

    public UpdateUserEmailUseCase(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public User execute(Long id, String update){
        User user = repositoryPort.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setEmail(update);
        return repositoryPort.save(user);
    }
}
