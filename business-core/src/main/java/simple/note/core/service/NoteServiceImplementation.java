package simple.note.core.service;

import simple.note.common.UseCase;
import simple.note.core.domain.Note;
import simple.note.core.port.in.NoteService;
import simple.note.core.port.out.NoteStorage;

import java.time.LocalDateTime;
import java.util.List;

@UseCase
public class NoteServiceImplementation implements NoteService {

    private final NoteStorage noteStorage;

    public NoteServiceImplementation(NoteStorage noteStorage) {
        this.noteStorage = noteStorage;
    }

    @Override
    public Note create(String text) {
        var noteId = noteStorage.create(
                new Note(
                        null,
                        text,
                        text.length(),
                        LocalDateTime.now()
                )
        );

        return noteStorage.get(noteId);
    }

    @Override
    public List<Note> getAll() {
        return noteStorage.getAll();
    }
}
