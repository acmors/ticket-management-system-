package ticket.management.system.adapters.output.entities;
import jakarta.persistence.*;
import ticket.management.system.domain.entities.user.UserVerification;
import ticket.management.system.domain.entities.user.enums.Roles;

@Entity
@Table(name = "tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Embedded
    private UserVerificationEntity userVerification;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email, String password, Roles role, UserVerificationEntity userVerification) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.userVerification = userVerification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public UserVerificationEntity getUserVerification() {
        return userVerification;
    }

    public void setUserVerification(UserVerificationEntity userVerification) {
        this.userVerification = userVerification;
    }
}
