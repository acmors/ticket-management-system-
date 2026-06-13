package ticket.management.system.domain.usecase.comment;

import jakarta.persistence.EntityNotFoundException;
import ticket.management.system.domain.entities.comment.Comment;
import ticket.management.system.domain.ports.comment.CommentRepositoryPort;

public class FindCommentById {

    private final CommentRepositoryPort repositoryPort;

    public FindCommentById(CommentRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Comment execute(Long id){
        return repositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));
    }
}
