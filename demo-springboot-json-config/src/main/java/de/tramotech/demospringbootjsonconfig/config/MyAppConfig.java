package de.tramotech.demospringbootjsonconfig.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Map;

@ConfigurationProperties
@Value
public class MyAppConfig {
    private String url;
    private String username;
    private String password;
    private Map<String, ?> identification;
}

