package ticket.management.system.adapters.input.dto.user;

import jakarta.validation.constraints.Size;

public class UpdateUserPasswordRequest {

    @Size(min = 6, message = "Password must be more then 6 characters")
    private String currentPassword;
    @Size(min = 6, message = "Password must be more then 6 characters")
    private String newPassword;
    @Size(min = 6, message = "Password must be more then 6 characters")
    private String confirmPassword;

    public UpdateUserPasswordRequest(String currentPassword, String newPassword, String confirmPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public UpdateUserPasswordRequest() {
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
