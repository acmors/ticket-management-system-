package ticket.management.system.adapters.input.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ticket.management.system.adapters.input.dto.ticket.CreateTicketRequest;
import ticket.management.system.adapters.input.dto.ticket.TicketResponse;
import ticket.management.system.adapters.input.dto.ticket.UpdateTicketStatusRequest;
import ticket.management.system.adapters.input.mapperDTO.TicketMapperDTO;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.usecase.ticket.CreateTicketUseCase;
import ticket.management.system.domain.usecase.ticket.FindTicketByNumberUseCase;
import ticket.management.system.domain.usecase.ticket.ListAllTicketsUseCase;
import ticket.management.system.domain.usecase.ticket.UpdateTicketStatusUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final CreateTicketUseCase createUseCase;
    private final FindTicketByNumberUseCase findTicketByNumberUseCase;
    private final ListAllTicketsUseCase listAllTicketsUseCase;
    private final UpdateTicketStatusUseCase updateTicketStatusUseCase;

    public TicketController(CreateTicketUseCase createUseCase, FindTicketByNumberUseCase findTicketByNumberUseCase, ListAllTicketsUseCase listAllTicketsUseCase, UpdateTicketStatusUseCase updateTicketStatusUseCase) {
        this.createUseCase = createUseCase;
        this.findTicketByNumberUseCase = findTicketByNumberUseCase;
        this.listAllTicketsUseCase = listAllTicketsUseCase;
        this.updateTicketStatusUseCase = updateTicketStatusUseCase;
    }

    @PostMapping
    public ResponseEntity<TicketResponse> create(@RequestBody CreateTicketRequest request){
        Ticket ticket = TicketMapperDTO.toDomain(request);
        Ticket created = createUseCase.execute(ticket);

        return ResponseEntity.status(HttpStatus.CREATED).body(TicketMapperDTO.toResponse(created));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> listAllTickets(){
        List<TicketResponse> response = listAllTicketsUseCase.execute()
                .stream()
                .map(TicketMapperDTO::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<TicketResponse> findTicketByNumber(@PathVariable("number") int number){
        Ticket ticket = findTicketByNumberUseCase.execute(number);

        return ResponseEntity.ok(TicketMapperDTO.toResponse(ticket));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TicketResponse> updateTicketStatus(@PathVariable("id") Long id, @RequestBody UpdateTicketStatusRequest request){
        Ticket ticket = updateTicketStatusUseCase.execute(id, request.getStatus());
        return ResponseEntity.ok(TicketMapperDTO.toResponse(ticket));
    }
}

