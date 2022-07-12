package simple.note.adapters.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple.note.adapters.rest.model.CreateNoteView;
import simple.note.adapters.rest.model.NoteView;
import simple.note.core.domain.Note;
import simple.note.core.port.in.NoteService;

import java.util.List;

@RestController
@RequestMapping("/api/note")
@Tag(name = "Заметки")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    @Operation(summary = "Создать заметку")
    public ResponseEntity<NoteView> create(@RequestBody CreateNoteView request) {
        return ResponseEntity.ok(map(noteService.create(request.text())));
    }

    @GetMapping
    @Operation(summary = "Список заметок")
    public ResponseEntity<List<NoteView>> getAll() {
        return ResponseEntity.ok(noteService.getAll().stream().map(this::map).toList());
    }

    private NoteView map(Note note) {
        return new NoteView(note.id(), note.text(), note.size(), note.created());
    }
}
