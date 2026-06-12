package ticket.management.system.adapters.input.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ticket.management.system.adapters.input.dto.user.CreateUserRequest;
import ticket.management.system.adapters.input.dto.user.UpdateUserEmailRequest;
import ticket.management.system.adapters.input.dto.user.UpdateUserPasswordRequest;
import ticket.management.system.adapters.input.dto.user.UserResponse;
import ticket.management.system.adapters.input.mapperDTO.UserMapperDTO;
import ticket.management.system.domain.entities.user.User;
import ticket.management.system.domain.usecase.user.CreateUserUseCase;
import ticket.management.system.domain.usecase.user.UpdateUserEmailUseCase;
import ticket.management.system.domain.usecase.user.UpdateUserPasswordUseCase;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserEmailUseCase updateUserEmailUseCase;
    private final UpdateUserPasswordUseCase updateUserPasswordUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UpdateUserEmailUseCase updateUserEmailUseCase, UpdateUserPasswordUseCase updateUserPasswordUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserEmailUseCase = updateUserEmailUseCase;
        this.updateUserPasswordUseCase = updateUserPasswordUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody CreateUserRequest request){
        User user = UserMapperDTO.toDomain(request);
        User created = createUserUseCase.execute(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapperDTO.toResponse(created));
    }

    @PatchMapping("/{id}/update-email")
    public ResponseEntity<UserResponse> updateEmail(@PathVariable("id") Long id, UpdateUserEmailRequest request){
        User user = updateUserEmailUseCase.execute(id, request.getEmail());
        return ResponseEntity.ok(UserMapperDTO.toResponse(user));
    }

    @PatchMapping("/{id}/update-password")
    public ResponseEntity<UserResponse> updatePassword(@PathVariable("id") Long id, UpdateUserPasswordRequest request){
        User user = updateUserPasswordUseCase.execute(id, request.getCurrentPassword(), request.getNewPassword(), request.getConfirmPassword());
        return ResponseEntity.ok(UserMapperDTO.toResponse(user));
    }
}
