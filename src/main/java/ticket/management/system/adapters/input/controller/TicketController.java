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
import ticket.management.system.domain.entities.page.PageRequest;
import ticket.management.system.domain.entities.page.PageResponse;
import ticket.management.system.domain.entities.ticket.Ticket;
import ticket.management.system.domain.entities.ticket.TicketFilter;
import ticket.management.system.domain.entities.ticket.enums.TicketPriority;
import ticket.management.system.domain.entities.ticket.enums.TicketStatus;
import ticket.management.system.domain.usecase.page.ListTicketsUseCase;
import ticket.management.system.domain.usecase.ticket.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final CreateTicketUseCase createUseCase;
    private final FindTicketByNumberUseCase findTicketByNumberUseCase;
    private final ListTicketsUseCase listTicketsUseCase;
    private final UpdateTicketStatusUseCase updateTicketStatusUseCase;
    private final AssignTicketUseCase assignTicketUseCase;
    private final ListTicketByUserUseCase listTicketByUserUseCase;
    private final TicketFilterUseCase listTicketsByFilter;

    public TicketController(CreateTicketUseCase createUseCase, FindTicketByNumberUseCase findTicketByNumberUseCase, ListTicketsUseCase listTicketsUseCase, UpdateTicketStatusUseCase updateTicketStatusUseCase, AssignTicketUseCase assignTicketUseCase, ListTicketByUserUseCase listTicketByUserUseCase, TicketFilterUseCase listTicketsByFilter) {
        this.createUseCase = createUseCase;
        this.findTicketByNumberUseCase = findTicketByNumberUseCase;
        this.listTicketsUseCase = listTicketsUseCase;
        this.updateTicketStatusUseCase = updateTicketStatusUseCase;
        this.assignTicketUseCase = assignTicketUseCase;
        this.listTicketByUserUseCase = listTicketByUserUseCase;
        this.listTicketsByFilter = listTicketsByFilter;
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
    public ResponseEntity<PageResponse<TicketResponse>> listAllTicketsAnalyst(
            Authentication authentication,
            TicketFilter filter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){

        String email = authentication.getName();
        var result = listTicketsUseCase.execute(email, filter,page, size);

        return ResponseEntity.ok(TicketMapperDTO.toPageResponse(result));
    }

    @GetMapping("/my-tickets")
    public ResponseEntity<PageResponse<TicketResponse>> findMyTickets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) TicketStatus status,
            @RequestParam(required = false) TicketPriority priority,
            @RequestParam(required = false) LocalDateTime createdAfter,
            Authentication authentication) {

        String email = authentication.getName();

        PageResponse<Ticket> tickets =
                listTicketsByFilter.execute(
                        email,
                        new TicketFilter(status, priority, createdAfter),
                        new PageRequest(page, size));

        return ResponseEntity.ok(
                TicketMapperDTO.toPageResponse(tickets));
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

