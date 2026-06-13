package ticket.management.system.adapters.output.repository.comment;

import ticket.management.system.adapters.output.mapper.CommentMapper;
import ticket.management.system.domain.entities.comment.Comment;
import ticket.management.system.domain.ports.comment.CommentRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommentRepositoryImpl implements CommentRepositoryPort {

    private final JpaCommentRepository repository;

    public CommentRepositoryImpl(JpaCommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Comment save(Comment comment) {
        var commentEntity = CommentMapper.toEntity(comment);
        var savedEntity = repository.save(commentEntity);
        return CommentMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return repository.findById(id).map(CommentMapper::toDomain);
    }

    @Override
    public List<Comment> listAll() {
        return repository.findAll()
                .stream()
                .map(CommentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
