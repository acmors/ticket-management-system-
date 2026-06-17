package ticket.management.system.adapters.input.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UpdateUserEmailRequest {

    @Email
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    public UpdateUserEmailRequest() {
    }

    public UpdateUserEmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
