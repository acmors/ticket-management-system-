package ticket.management.system.domain.usecase.comment;

import ticket.management.system.domain.entities.comment.Comment;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.comment.CommentRepositoryPort;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;
import ticket.management.system.domain.ports.user.UserRepositoryPort;

import java.time.LocalDate;

public class CreateCommentUseCase {

    private final CommentRepositoryPort repositoryPort;
    private final TicketRepositoryPort ticketRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    public CreateCommentUseCase(CommentRepositoryPort repositoryPort, TicketRepositoryPort ticketRepositoryPort, UserRepositoryPort userRepositoryPort) {
        this.repositoryPort = repositoryPort;
        this.ticketRepositoryPort = ticketRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
    }

    public Comment execute(int ticketNumber, String email,  String content){
        Ticket ticket = ticketRepositoryPort.findByTicketNumber(ticketNumber).orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        User user = userRepositoryPort.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setTicket(ticket);
        comment.setCreatedBy(user);
        return repositoryPort.save(comment);
    }
}
