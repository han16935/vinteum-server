package com.aiia.Vinteum;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("test")
@SpringBootTest
public class IntegrationTestSupport {
    private static final String DATABASE_VERSION = "mysql:latest";

    @Container
    protected static final MySQLContainer MYSQL_CONTAINER = new MySQLContainer(DATABASE_VERSION);

    @DynamicPropertySource
    private static void dynamicConfiguration(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", MYSQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
    }
}
