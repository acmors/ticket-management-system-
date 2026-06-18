package ticket.management.system.adapters.input.mapperDTO;
import org.springframework.stereotype.Component;
import ticket.management.system.adapters.input.dto.ticket.CreateTicketRequest;
import ticket.management.system.adapters.input.dto.ticket.TicketResponse;
import ticket.management.system.domain.entities.page.PageResponse;
import ticket.management.system.domain.entities.ticket.Ticket;

import java.util.List;

@Component
public class TicketMapperDTO {

    public static Ticket toDomain(CreateTicketRequest request){
        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setTicketPriority(request.getPriority());
        return ticket;
    }

    public static TicketResponse toResponse(Ticket ticket){

        return new TicketResponse(
                ticket.getId(),
                ticket.getTicketNumber(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getTicketPriority(),
                ticket.getTicketStatus(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt(),
                ticket.getCreatedBy(),
                ticket.getAssignedTo()
        );
    }

    public static PageResponse<TicketResponse> toPageResponse(PageResponse<Ticket> page){
        List<TicketResponse> content =
                page.content()
                        .stream()
                        .map(TicketMapperDTO::toResponse)
                        .toList();

        return new PageResponse<>(
                content,
                page.page(),
                page.size(),
                page.totalElements(),
                page.totalPages()
        );
    }
}
