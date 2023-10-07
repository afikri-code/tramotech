package de.tramotech.demobackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        authz -> {
                            try {
                                authz.antMatchers("/api/users/**").hasRole("ADMIN")

                                .anyRequest().authenticated()
                                        .and().csrf().disable();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }

                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        UserDetails demo = User.withDefaultPasswordEncoder()
                .username("demo")
                .password("password")
                .roles("DEMO")
                .build();

        return new InMemoryUserDetailsManager(admin, demo);
    }
}
