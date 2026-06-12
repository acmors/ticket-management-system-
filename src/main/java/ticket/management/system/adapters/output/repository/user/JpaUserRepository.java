package ticket.management.system.adapters.output.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket.management.system.adapters.output.entities.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
