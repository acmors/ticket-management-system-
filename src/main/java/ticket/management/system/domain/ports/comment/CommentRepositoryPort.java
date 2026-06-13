package ticket.management.system.domain.ports.comment;

import ticket.management.system.domain.entities.comment.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepositoryPort {

    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
    List<Comment> listAll();
    void deleteById(Long id);
}
