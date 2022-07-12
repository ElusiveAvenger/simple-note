package simple.note.adapters.storage;

import org.junit.ClassRule;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class StorageIntegrationTest {
    @ClassRule
    @Container
    public static SimpleNotePostgreSQLContainer dbContainer = SimpleNotePostgreSQLContainer.getInstance();
}
