package de.tramotech.demospringbootgroupingproperties.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "myapp")
@Value
public class MyConfig {
    String port;
    String ip;
}
