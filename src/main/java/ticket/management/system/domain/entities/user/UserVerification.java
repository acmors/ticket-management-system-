package ticket.management.system.domain.entities.user;

import java.time.LocalDateTime;

public class UserVerification {

    private String verificationCode;
    private boolean verified;
    private LocalDateTime expiresAt;

    public UserVerification() {
    }

    public UserVerification(String verificationCode, boolean verified, LocalDateTime expiresAt) {
        this.verificationCode = verificationCode;
        this.verified = verified;
        this.expiresAt = expiresAt;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
