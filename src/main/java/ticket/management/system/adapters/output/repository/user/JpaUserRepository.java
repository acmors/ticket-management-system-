package ticket.management.system.adapters.output.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket.management.system.adapters.output.entities.UserEntity;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
