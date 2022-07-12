package simple.note.adapters.rest.model;

import java.time.LocalDateTime;

public record NoteView(
        Long id,
        String text,
        Integer size,
        LocalDateTime created
) {

}
