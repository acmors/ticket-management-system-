package ticket.management.system.adapters.input.dto.user.verify_user;

public class VerifyUserRequest {

    private String email;
    private String verificationCode;

    public VerifyUserRequest() {
    }

    public VerifyUserRequest(String email, String verificationCode) {
        this.email = email;
        this.verificationCode = verificationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
