package ticket.management.system.adapters.output.mapper;
import ticket.management.system.adapters.output.entities.TicketEntity;
import ticket.management.system.domain.entities.ticket.Ticket;

public class TicketMapper {

    public static TicketEntity toEntity(Ticket ticket){

        if (ticket == null) return null;

        return new TicketEntity(
                ticket.getId(),
                ticket.getTicketNumber(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getTicketPriority(),
                ticket.getTicketStatus(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt(),
                UserMapper.toEntity(ticket.getCreatedBy()),
                UserMapper.toEntity(ticket.getAssignedTo())
        );
    }

    public static Ticket toDomain(TicketEntity entity){
        if (entity == null) return null;
        return new Ticket(
                entity.getId(),
                entity.getTicketNumber(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getTicketPriority(),
                entity.getTicketStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                UserMapper.toDomain(entity.getCreatedBy()),
                UserMapper.toDomain(entity.getAssignedTo())
        );
    }
}
