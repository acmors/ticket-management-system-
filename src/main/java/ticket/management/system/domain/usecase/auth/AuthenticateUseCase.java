package ticket.management.system.domain.usecase.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import ticket.management.system.adapters.output.security.JwtService;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

public class AuthenticateUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticateUseCase(UserRepositoryPort userRepositoryPort, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String execute(String email, String password){
        var user = userRepositoryPort.findByEmail(email).orElseThrow(()-> new RuntimeException("Invalid Credentials"));
        boolean passwordMatches = passwordEncoder.matches(password, user.getPassword());

        if(!passwordMatches) throw new RuntimeException("Wrong password");

        return jwtService.generateToken(user);
    }
}
