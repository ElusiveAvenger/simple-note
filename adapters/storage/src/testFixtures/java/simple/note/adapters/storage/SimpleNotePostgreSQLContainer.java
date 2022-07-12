package simple.note.adapters.storage;

import org.testcontainers.containers.PostgreSQLContainer;

public class SimpleNotePostgreSQLContainer extends PostgreSQLContainer<SimpleNotePostgreSQLContainer> {
    private static final String IMAGE_VERSION = String.format(
            "%s:%s",
            PostgreSQLContainer.IMAGE,
            PostgreSQLContainer.DEFAULT_TAG
    );
    private static SimpleNotePostgreSQLContainer container;

    private SimpleNotePostgreSQLContainer() {
        super(IMAGE_VERSION);
    }

    public static SimpleNotePostgreSQLContainer getInstance() {
        if (container == null) {
            container = new SimpleNotePostgreSQLContainer();
        }

        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }
}
