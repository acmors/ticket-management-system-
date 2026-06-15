package ticket.management.system.domain.usecase.comment;

import ticket.management.system.domain.entities.comment.Comment;
import ticket.management.system.domain.exceptions.ResourceNotFoundException;
import ticket.management.system.domain.ports.comment.CommentRepositoryPort;

public class FindCommentById {

    private final CommentRepositoryPort repositoryPort;

    public FindCommentById(CommentRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Comment execute(Long id){
        return repositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    }
}
