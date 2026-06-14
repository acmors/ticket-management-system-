package ticket.management.system.domain.ports.user;

import ticket.management.system.domain.entities.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
    Optional<User> findByEmail(String email);
}
