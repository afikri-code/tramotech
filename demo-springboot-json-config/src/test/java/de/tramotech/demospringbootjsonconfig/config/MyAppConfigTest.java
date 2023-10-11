package de.tramotech.demospringbootjsonconfig.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MyAppConfigTest {
    @Autowired
    MyAppConfig config;

    @Test
    void readConfigurationFromTheCorrectFile() {
        assertThat(config.getUrl()).isEqualTo("jdbc:mysql://localhost:3306/mydb");
        assertThat(config.getUsername()).isEqualTo("root");
        assertThat(config.getPassword()).isEqualTo("password123");
        assertThat(config.getIdentification().get("env")).isEqualTo("test environmentx");
    }
}