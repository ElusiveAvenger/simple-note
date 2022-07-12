package simple.note.core.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import simple.note.core.domain.Note;
import simple.note.core.port.out.NoteStorage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NoteServiceImplementationTest {

    @Test
    void saveNote_calculateTextSize_getByStorageId() {
        var text = "17 character text";
        var noteId = 12345L;

        var noteStorage = mock(NoteStorage.class);
        var noteCaptor = ArgumentCaptor.forClass(Note.class);
        when(noteStorage.create(noteCaptor.capture())).thenReturn(noteId);
        var noteIdCaptor = ArgumentCaptor.forClass(Long.class);
        when(noteStorage.get(noteIdCaptor.capture())).thenReturn(null);

        var noteService = new NoteServiceImplementation(noteStorage);

        noteService.create(text);

        assertNotNull(noteCaptor.getValue());
        assertEquals(text, noteCaptor.getValue().text());
        assertEquals(17, noteCaptor.getValue().size());

        assertEquals(noteId, noteIdCaptor.getValue());
    }
}
