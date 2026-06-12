package ticket.management.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ticket.management.system.adapters.output.mapper.TicketMapper;
import ticket.management.system.adapters.output.repository.JpaTicketRepository;
import ticket.management.system.adapters.output.repository.TicketRepositoryImpl;
import ticket.management.system.domain.ports.TicketRepositoryPort;
import ticket.management.system.domain.usecase.ticket.CreateTicketUseCase;
import ticket.management.system.domain.usecase.ticket.FindTicketByNumberUseCase;
import ticket.management.system.domain.usecase.ticket.ListAllTicketsUseCase;
import ticket.management.system.domain.usecase.ticket.UpdateTicketStatusUseCase;

@Configuration
public class AppConfig {

    @Bean
    public CreateTicketUseCase createTicketUseCase(TicketRepositoryPort ticketRepositoryPort){
        return new CreateTicketUseCase(ticketRepositoryPort);
    }

    @Bean
    public FindTicketByNumberUseCase findTicketByNumberUseCase(TicketRepositoryPort ticketRepositoryPort){
        return new FindTicketByNumberUseCase(ticketRepositoryPort);
    }

    @Bean
    public ListAllTicketsUseCase listAllTicketsUseCase(TicketRepositoryPort ticketRepositoryPort){
        return new ListAllTicketsUseCase(ticketRepositoryPort);
    }

    @Bean
    public UpdateTicketStatusUseCase updateTicketStatusUseCase(TicketRepositoryPort ticketRepositoryPort){
        return new UpdateTicketStatusUseCase(ticketRepositoryPort);
    }

    @Bean
    public TicketRepositoryPort ticketRepositoryPort(JpaTicketRepository jpaTicketRepository, TicketMapper ticketMapper){
        return new TicketRepositoryImpl(jpaTicketRepository, ticketMapper);
    }

    @Bean
    public TicketMapper ticketMapper(){
        return new TicketMapper();
    }
}
