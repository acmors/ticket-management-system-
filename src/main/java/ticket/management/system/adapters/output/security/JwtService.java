package ticket.management.system.adapters.output.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import ticket.management.system.domain.entities.user.User;
import java.time.Instant;


@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(User user){
        Instant now = Instant.now();

        var claims = JwtClaimsSet.builder()
                .issuer("ticket.management.system")
                .subject(user.getEmail())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(3600))
                .claim("roles", user.getRole().name())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
