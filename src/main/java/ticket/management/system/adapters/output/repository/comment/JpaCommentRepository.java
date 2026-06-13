package ticket.management.system.adapters.output.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket.management.system.adapters.output.entities.CommentEntity;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, Long> {
}
