package simple.note.adapters.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simple.note.adapters.storage.entity.NoteEntity;

public interface NoteEntityRepository extends JpaRepository<NoteEntity, Long> {
}
