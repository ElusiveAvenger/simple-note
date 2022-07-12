package simple.note.core.port.out;

import simple.note.core.domain.Note;

import java.util.List;

public interface NoteStorage {
    long create(Note note);
    Note get(long id);
    List<Note> getAll();
}
