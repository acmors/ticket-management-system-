package ticket.management.system.adapters.input.mapperDTO;

import org.springframework.stereotype.Component;
import ticket.management.system.adapters.input.dto.user.CreateUserRequest;
import ticket.management.system.adapters.input.dto.user.UserResponse;
import ticket.management.system.domain.entities.user.User;

@Component
public class UserMapperDTO {

    public static User toDomain(CreateUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return user;
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getName(),
                user.getEmail()
        );
    }
}
