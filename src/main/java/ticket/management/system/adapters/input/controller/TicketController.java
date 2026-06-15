package ticket.management.system.adapters.input.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ticket.management.system.adapters.input.dto.ticket.CreateTicketRequest;
import ticket.management.system.adapters.input.dto.ticket.TicketResponse;
import ticket.management.system.adapters.input.dto.ticket.UpdateTicketStatusRequest;
import ticket.management.system.adapters.input.mapperDTO.TicketMapperDTO;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.usecase.ticket.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final CreateTicketUseCase createUseCase;
    private final FindTicketByNumberUseCase findTicketByNumberUseCase;
    private final ListAllTicketsUseCase listAllTicketsUseCase;
    private final UpdateTicketStatusUseCase updateTicketStatusUseCase;
    private final AssignTicketUseCase assignTicketUseCase;

    public TicketController(CreateTicketUseCase createUseCase, FindTicketByNumberUseCase findTicketByNumberUseCase, ListAllTicketsUseCase listAllTicketsUseCase, UpdateTicketStatusUseCase updateTicketStatusUseCase, AssignTicketUseCase assignTicketUseCase) {
        this.createUseCase = createUseCase;
        this.findTicketByNumberUseCase = findTicketByNumberUseCase;
        this.listAllTicketsUseCase = listAllTicketsUseCase;
        this.updateTicketStatusUseCase = updateTicketStatusUseCase;
        this.assignTicketUseCase = assignTicketUseCase;
    }

    @PostMapping
    @PreAuthorize("hasRole('COMMON')")
    public ResponseEntity<TicketResponse> create(@RequestBody CreateTicketRequest request, Authentication authentication){
        String email = authentication.getName();
        Ticket ticket = TicketMapperDTO.toDomain(request);
        Ticket created = createUseCase.execute(ticket, email);

        return ResponseEntity.status(HttpStatus.CREATED).body(TicketMapperDTO.toResponse(created));
    }

    @GetMapping
    @PreAuthorize("hasRole('ANALYST')")
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

    @PatchMapping("/{number}")
    @PreAuthorize("hasRole('ANALYST')")
    public ResponseEntity<TicketResponse> updateTicketStatus(@PathVariable("number") int number, @RequestBody UpdateTicketStatusRequest request){
        Ticket ticket = updateTicketStatusUseCase.execute(number, request.getStatus());
        return ResponseEntity.ok(TicketMapperDTO.toResponse(ticket));
    }

    @PatchMapping("/{ticketNumber}/assign")
    @PreAuthorize("hasRole('ANALYST')")
    public ResponseEntity<TicketResponse> assignTicket(@PathVariable("ticketNumber") int ticketNumber, Authentication authentication){
        String email = authentication.getName();
        Ticket ticket = assignTicketUseCase.execute(email, ticketNumber);
        return ResponseEntity.ok(TicketMapperDTO.toResponse(ticket));
    }

}

