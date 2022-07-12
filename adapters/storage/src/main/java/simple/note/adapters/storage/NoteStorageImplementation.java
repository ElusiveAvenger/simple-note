package simple.note.adapters.storage;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simple.note.adapters.storage.entity.NoteEntity;
import simple.note.adapters.storage.repository.NoteEntityRepository;
import simple.note.core.domain.Note;
import simple.note.core.port.out.NoteStorage;

import java.util.List;

@Component
public class NoteStorageImplementation implements NoteStorage {

    private final NoteEntityRepository repository;

    public NoteStorageImplementation(NoteEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public long create(Note note) {
        var entity = repository.save(NoteEntity.builder()
                .text(note.text())
                .size(note.size())
                .created(note.created())
                .build());

        return entity.getId();
    }

    @Override
    public Note get(long id) {
        return map(repository.getReferenceById(id));
    }

    @Override
    public List<Note> getAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private Note map(NoteEntity entity) {
        return new Note(
                entity.getId(),
                entity.getText(),
                entity.getSize(),
                entity.getCreated()
        );
    }
}
