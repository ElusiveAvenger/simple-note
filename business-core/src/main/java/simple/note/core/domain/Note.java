package simple.note.core.domain;

import java.time.LocalDateTime;

public record Note(
    Long id,
    String text,
    Integer size,
    LocalDateTime created
) { }
