package ticket.management.system.adapters.output.entities;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class UserVerificationEntity {

    private String verificationCode;
    private boolean verified;
    private LocalDateTime expiresAt;

    public UserVerificationEntity() {
    }

    public UserVerificationEntity(String verificationCode, Boolean verified, LocalDateTime expiresAt) {
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
