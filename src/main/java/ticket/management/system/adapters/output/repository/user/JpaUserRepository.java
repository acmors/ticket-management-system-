package ticket.management.system.adapters.output.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ticket.management.system.adapters.output.entities.UserEntity;
import ticket.management.system.domain.entities.user.enums.Roles;

import java.util.List;
import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    boolean existsUserByEmail(String email);

    @Query("select u.email from UserEntity u where u.role = :role")
    List<String> findEmailsByRole(@Param("role") Roles role);
}
