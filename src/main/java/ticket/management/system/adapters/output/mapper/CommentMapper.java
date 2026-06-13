package ticket.management.system.adapters.output.mapper;

import ticket.management.system.adapters.output.entities.CommentEntity;
import ticket.management.system.domain.entities.comment.Comment;

public class CommentMapper {

    public static CommentEntity toEntity(Comment comment){
        return new CommentEntity(
                comment.getId(),
                comment.getContent(),
                TicketMapper.toEntity(comment.getTicket()),
                UserMapper.toEntity(comment.getCreatedBy()),
                comment.getCreatedAt()
        );
    }

    public static Comment toDomain(CommentEntity entity){
        return new Comment(
                entity.getId(),
                entity.getContent(),
                TicketMapper.toDomain(entity.getTicket()),
                UserMapper.toDomain(entity.getCreatedBy()),
                entity.getCreatedAt()
        );
    }
}
