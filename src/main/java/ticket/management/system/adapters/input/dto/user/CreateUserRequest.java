package ticket.management.system.adapters.input.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ticket.management.system.adapters.output.mapper.UserMapper;

public class CreateUserRequest {


    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Email
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @Size(min = 6, message = "Password must be more then 6 characters")
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
