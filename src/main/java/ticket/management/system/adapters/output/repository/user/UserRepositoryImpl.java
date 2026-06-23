package ticket.management.system.adapters.output.repository.user;

import ticket.management.system.adapters.output.mapper.UserMapper;
import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.entities.user.enums.Roles;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepositoryPort {

    private final JpaUserRepository repository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(JpaUserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        var userEntity = UserMapper.toEntity(user);
        var savedEntity = repository.save(userEntity);
        return UserMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id).map(UserMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(UserMapper::toDomain);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return repository.existsUserByEmail(email);
    }

    @Override
    public List<String> findAllAnalystEmails() {
        return repository.findEmailsByRole(Roles.ANALYST);
    }
}
