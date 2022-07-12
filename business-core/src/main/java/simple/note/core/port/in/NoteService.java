package simple.note.core.port.in;

import simple.note.core.domain.Note;

import java.util.List;

public interface NoteService {
    Note create(String text);
    List<Note> getAll();
}
