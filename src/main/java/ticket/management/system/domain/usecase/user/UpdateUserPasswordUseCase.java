package ticket.management.system.domain.usecase.user;

import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.exceptions.InvalidCredentialsException;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

public class UpdateUserPasswordUseCase {

    private final UserRepositoryPort repositoryPort;

    public UpdateUserPasswordUseCase(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public User execute(Long id, String currentPassword, String newPassword, String confirmPassword){
        User user = repositoryPort.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(currentPassword)) throw new InvalidCredentialsException("Current password is wrong");
        if (!newPassword.equals(confirmPassword)) throw new InvalidCredentialsException("Passwords dont matches");

        user.setPassword(newPassword);
        return repositoryPort.save(user);
    }
}
