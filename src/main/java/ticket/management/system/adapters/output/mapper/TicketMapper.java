package ticket.management.system.adapters.output.mapper;
import ticket.management.system.adapters.output.entities.TicketEntity;
import ticket.management.system.domain.entities.ticket.Ticket;

public class TicketMapper {

    public static TicketEntity toEntity(Ticket ticket){
        return new TicketEntity(
                ticket.getId(),
                ticket.getTicketNumber(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getTicketPriority(),
                ticket.getTicketStatus(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt(),
                ticket.getAssignedTo()
        );
    }

    public static Ticket toDomain(TicketEntity entity){
        return new Ticket(
                entity.getId(),
                entity.getTicketNumber(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getTicketPriority(),
                entity.getTicketStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getAssignedTo()
        );
    }
}
