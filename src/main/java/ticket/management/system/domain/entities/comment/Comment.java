package ticket.management.system.domain.entities.comment;

import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Comment {

    private Long id;
    private String content;
    private Ticket ticket;
    private User createdBy;
    private LocalDateTime createdAt;

    public Comment() {
    }

    public Comment(Long id, String content, Ticket ticket, User createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.ticket = ticket;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
