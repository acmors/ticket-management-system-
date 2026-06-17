package ticket.management.system.adapters.input.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class CommentResponse {

    private Long id;
    private String content;
    private Ticket ticket;
    private User createdBy;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdAt;

    public CommentResponse() {
    }

    public CommentResponse(Long id, String content, Ticket ticket, User createdBy, LocalDateTime createdAt) {
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
