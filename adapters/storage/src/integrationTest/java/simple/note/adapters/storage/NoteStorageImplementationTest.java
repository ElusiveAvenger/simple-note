package simple.note.adapters.storage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import simple.note.core.port.out.NoteStorage;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {
        NoteStorageImplementation.class
})
public class NoteStorageImplementationTest extends IntegrationTest {
    @Autowired
    private NoteStorage noteStorage;

    @Test
    void createNewNote() {
        var text = "note text";
        var size = 9;
        var created = LocalDateTime.now();

        var noteId = noteStorage.create(new simple.note.core.domain.Note(null, text, size, created));
        var note = noteStorage.get(noteId);

        assertNotNull(note);
        assertAll("note",
                () -> assertEquals(noteId, note.id()),
                () -> assertEquals(text, note.text()),
                () -> assertEquals(size, note.size()),
                () -> assertEquals(created, note.created())
        );
    }

    @Test
    void readExistsNote() {
        var noteId = 100L;

        var note = noteStorage.get(noteId);

        assertNotNull(note);
        assertAll("note",
                () -> assertEquals(noteId, note.id()));
    }
}
