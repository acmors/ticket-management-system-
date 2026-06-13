package ticket.management.system.adapters.input.dto.comment;

public class CreateCommentRequest {
    private String content;
    private Long ticketId;

    public CreateCommentRequest() {
    }

    public CreateCommentRequest(String content, Long ticketId) {
        this.content = content;
        this.ticketId = ticketId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
}
