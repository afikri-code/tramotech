package de.tramotech.demospringbootgroupingproperties.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myapp.properties")
public class Config {
}
