package de.tramotech.demospringbootconfiguration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "myapp")
@Data
public class MyAppProperties {
    private String property1;
    private int property2;
}
