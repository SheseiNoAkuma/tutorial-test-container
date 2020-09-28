package eu.microbo.testcontainers.testcontainers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@Slf4j
public class TestContainerDemoIT {

    @Container
    private final PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>()
            .withDatabaseName("foo")
            .withUsername("foo")
            .withPassword("secret");


    @Test
    void test() {
        assertTrue(postgresqlContainer.isRunning());
        log.info(postgresqlContainer.getJdbcUrl());
    }

}
