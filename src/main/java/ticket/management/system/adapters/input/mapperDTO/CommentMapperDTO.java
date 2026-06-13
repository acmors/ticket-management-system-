package ticket.management.system.adapters.input.mapperDTO;

import org.springframework.stereotype.Component;
import ticket.management.system.adapters.input.dto.comment.CommentResponse;
import ticket.management.system.adapters.input.dto.comment.CreateCommentRequest;
import ticket.management.system.domain.entities.comment.Comment;

@Component
public class CommentMapperDTO {

    public static Comment toDomain(CreateCommentRequest request){
        Comment comment = new Comment();
        comment.setContent(request.getContent());
        return comment;
    }

    public static CommentResponse toResponse(Comment comment){
        return new CommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getTicket(),
                comment.getCreatedBy(),
                comment.getCreatedAt()
        );
    }
}
