package ticket.management.system.adapters.output.mapper;

import ticket.management.system.adapters.output.entities.UserVerificationEntity;
import ticket.management.system.domain.entities.user.UserVerification;

public class UserVerificationMapper {
    public static UserVerificationEntity toEntity(UserVerification verification) {
        if (verification == null) {
            return null;
        }

        return new UserVerificationEntity(
                verification.getVerificationCode(),
                verification.isVerified(),
                verification.getExpiresAt()
        );
    }

    public static UserVerification toDomain(UserVerificationEntity entity) {
        if (entity == null) {
            return null;
        }

        return new UserVerification(
                entity.getVerificationCode(),
                entity.isVerified(),
                entity.getExpiresAt()
        );
    }
}
