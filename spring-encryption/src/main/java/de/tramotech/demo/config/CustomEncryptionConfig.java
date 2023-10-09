package de.tramotech.demo.config;

import de.tramotech.demo.security.CustomEncryptionUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomEncryptionConfig {

    @Bean
    public CustomEncryptionUtil customEncryptionUtil() {
        return new CustomEncryptionUtil("0CB9ED3771B3B99A63D93D8F31692C46");
    }
}

