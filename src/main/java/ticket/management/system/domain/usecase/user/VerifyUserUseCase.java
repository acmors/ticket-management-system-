package ticket.management.system.domain.usecase.user;

import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.exceptions.InputFieldsInvalidException;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

import java.time.LocalDateTime;

public class VerifyUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public VerifyUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public void execute(String email, String code) {
        User user = userRepositoryPort.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if(user.getVerification().isVerified()) throw new InputFieldsInvalidException("User is already verified");
        if (!user.getVerification().getVerificationCode().equals(code)) throw new InputFieldsInvalidException("Invalid verification code");
        if (user.getVerification().getExpiresAt().isBefore(LocalDateTime.now())) throw new InputFieldsInvalidException("Verification expired");

        user.getVerification().setVerified(true);
        user.getVerification().setVerificationCode(null);
        user.getVerification().setExpiresAt(null);

        userRepositoryPort.save(user);
    }
}
