package ticket.management.system.domain.usecase.comment;

import jakarta.persistence.EntityNotFoundException;
import ticket.management.system.domain.entities.comment.Comment;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.ports.comment.CommentRepositoryPort;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;

import java.time.LocalDate;

public class CreateCommentUseCase {

    private final CommentRepositoryPort repositoryPort;
    private final TicketRepositoryPort ticketRepositoryPort;

    public CreateCommentUseCase(CommentRepositoryPort repositoryPort, TicketRepositoryPort ticketRepositoryPort) {
        this.repositoryPort = repositoryPort;
        this.ticketRepositoryPort = ticketRepositoryPort;
    }

    public Comment execute(Long id, String content){
        Ticket ticket = ticketRepositoryPort.findById(id).orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setTicket(ticket);
        comment.setCreatedAt(LocalDate.now());
        return repositoryPort.save(comment);
    }
}
