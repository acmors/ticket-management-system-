package ticket.management.system.adapters.output.mapper;

import ticket.management.system.adapters.output.entities.UserEntity;
import ticket.management.system.domain.entities.user.User;

public class UserMapper {

    public static UserEntity toEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    public static User toDomain(UserEntity entity){
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole()
        );
    }
}
