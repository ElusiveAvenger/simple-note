package simple.note;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import simple.note.adapters.storage.StorageIntegrationTest;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class SimpleNoteWebApplicationTestStorage extends StorageIntegrationTest {
}
