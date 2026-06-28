package ticket.management.system.domain.entities.user;

import ticket.management.system.domain.entities.user.enums.Roles;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Roles role;
    private UserVerification verification;

    public User() {
    }

    public User(Long id, String name, String email, String password, Roles role, UserVerification verification) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.verification = verification;
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

    public UserVerification getVerification() {
        return verification;
    }

    public void setVerification(UserVerification verification) {
        this.verification = verification;
    }
}
