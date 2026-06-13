package ticket.management.system.domain.usecase.comment;

import ticket.management.system.domain.entities.comment.Comment;
import ticket.management.system.domain.ports.comment.CommentRepositoryPort;

import java.util.List;

public class ListAllCommentsUseCase {

    private final CommentRepositoryPort repositoryPort;

    public ListAllCommentsUseCase(CommentRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public List<Comment> execute(){
        return repositoryPort.listAll();
    }
}
