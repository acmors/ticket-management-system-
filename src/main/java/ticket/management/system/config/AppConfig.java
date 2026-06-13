package ticket.management.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ticket.management.system.adapters.output.mapper.CommentMapper;
import ticket.management.system.adapters.output.mapper.TicketMapper;
import ticket.management.system.adapters.output.mapper.UserMapper;
import ticket.management.system.adapters.output.repository.comment.CommentRepositoryImpl;
import ticket.management.system.adapters.output.repository.comment.JpaCommentRepository;
import ticket.management.system.adapters.output.repository.ticket.JpaTicketRepository;
import ticket.management.system.adapters.output.repository.ticket.TicketRepositoryImpl;
import ticket.management.system.adapters.output.repository.user.JpaUserRepository;
import ticket.management.system.adapters.output.repository.user.UserRepositoryImpl;
import ticket.management.system.domain.ports.comment.CommentRepositoryPort;
import ticket.management.system.domain.ports.ticket.TicketRepositoryPort;
import ticket.management.system.domain.ports.user.UserRepositoryPort;
import ticket.management.system.domain.usecase.comment.CreateCommentUseCase;
import ticket.management.system.domain.usecase.comment.FindCommentById;
import ticket.management.system.domain.usecase.comment.ListAllCommentsUseCase;
import ticket.management.system.domain.usecase.ticket.CreateTicketUseCase;
import ticket.management.system.domain.usecase.ticket.FindTicketByNumberUseCase;
import ticket.management.system.domain.usecase.ticket.ListAllTicketsUseCase;
import ticket.management.system.domain.usecase.ticket.UpdateTicketStatusUseCase;
import ticket.management.system.domain.usecase.user.*;

@Configuration
public class AppConfig {

    //Ticket use case
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

    //user use case
    @Bean
    public CreateUserUseCase createUserUserCase(UserRepositoryPort userRepositoryPort){
        return new CreateUserUseCase(userRepositoryPort);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserRepositoryPort userRepositoryPort){
        return new DeleteUserUseCase(userRepositoryPort);
    }

    @Bean
    public FindAllUsersUseCase findAllUsersUseCase(UserRepositoryPort userRepositoryPort){
        return new FindAllUsersUseCase(userRepositoryPort);
    }

    @Bean
    public FindUserByIdUserCase findUserByIdUserCase(UserRepositoryPort userRepositoryPort){
        return new FindUserByIdUserCase(userRepositoryPort);
    }

    @Bean
    public UpdateUserEmailUseCase updateUserEmailUseCase(UserRepositoryPort userRepositoryPort){
        return new UpdateUserEmailUseCase(userRepositoryPort);
    }

    @Bean
    public UpdateUserPasswordUseCase updateUserPasswordUseCase(UserRepositoryPort userRepositoryPort){
        return new UpdateUserPasswordUseCase(userRepositoryPort);
    }

    //comment use case
    @Bean
    public CreateCommentUseCase createCommentUseCase(CommentRepositoryPort commentRepositoryPort, TicketRepositoryPort ticketRepositoryPort){
        return new CreateCommentUseCase(commentRepositoryPort, ticketRepositoryPort);
    }

    @Bean
    public ListAllCommentsUseCase listAllCommentsUseCase(CommentRepositoryPort commentRepositoryPort){
        return new ListAllCommentsUseCase(commentRepositoryPort);
    }

    @Bean
    public FindCommentById findCommentById(CommentRepositoryPort commentRepositoryPort){
        return new FindCommentById(commentRepositoryPort);
    }
    //repositories port configuration
    @Bean
    public TicketRepositoryPort ticketRepositoryPort(JpaTicketRepository jpaTicketRepository, TicketMapper ticketMapper){
        return new TicketRepositoryImpl(jpaTicketRepository, ticketMapper);
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        return new UserRepositoryImpl(jpaUserRepository, userMapper);
    }

    @Bean
    public CommentRepositoryPort commentRepositoryPort(JpaCommentRepository jpaCommentRepository){
        return new CommentRepositoryImpl(jpaCommentRepository);
    }

    @Bean
    public TicketMapper ticketMapper(){
        return new TicketMapper();
    }

    @Bean
    public UserMapper userMapper(){return new UserMapper();}

    @Bean
    public CommentMapper commentMapper(){return new CommentMapper();}
}
