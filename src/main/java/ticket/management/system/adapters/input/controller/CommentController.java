package ticket.management.system.adapters.input.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ticket.management.system.adapters.input.dto.comment.CommentResponse;
import ticket.management.system.adapters.input.dto.comment.CreateCommentRequest;
import ticket.management.system.adapters.input.mapperDTO.CommentMapperDTO;
import ticket.management.system.domain.entities.comment.Comment;
import ticket.management.system.domain.usecase.comment.CreateCommentUseCase;
import ticket.management.system.domain.usecase.comment.ListAllCommentsUseCase;
import java.util.List;


@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CreateCommentUseCase createCommentUseCase;
    private final ListAllCommentsUseCase listAllCommentsUseCase;

    public CommentController(CreateCommentUseCase createCommentUseCase, ListAllCommentsUseCase listAllCommentsUseCase) {
        this.createCommentUseCase = createCommentUseCase;
        this.listAllCommentsUseCase = listAllCommentsUseCase;
    }

    @PostMapping("/{number}/comment")
    public ResponseEntity<CommentResponse> create(@PathVariable("number") int number, Authentication authentication, @RequestBody CreateCommentRequest request){
        String email = authentication.getName();
        Comment created = createCommentUseCase.execute(number, email,request.getContent());

        return ResponseEntity.status(HttpStatus.CREATED).body(CommentMapperDTO.toResponse(created));
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> listAll(){
        List<CommentResponse> list = listAllCommentsUseCase.execute()
                .stream()
                .map(CommentMapperDTO::toResponse)
                .toList();

        return ResponseEntity.ok(list);
    }
}
