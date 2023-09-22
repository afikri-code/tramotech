package de.tramotech.springbootkeycloakdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Configuration class for security settings in the Spring Boot Keycloak Demo Application.
 * This class defines security-related beans and configurations for the application.
 *
 * @author Ahmed Fikri
 */
@Configuration
public class SecurityConfig {

    private static final String REALM_ACCESS_CLAIM = "realm_access";
    private static final String ROLES_CLAIM = "roles";

    /**
     * Creates a session authentication strategy bean.
     *
     * @return A SessionAuthenticationStrategy bean using RegisterSessionAuthenticationStrategy
     *         with a SessionRegistryImpl.
     */
    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    /**
     * Defines a custom GrantedAuthoritiesMapper for Keycloak-based user authorities.
     *
     * @return A GrantedAuthoritiesMapper that extracts roles from the Keycloak claims.
     */
    @Bean
    @SuppressWarnings("unchecked")
    public GrantedAuthoritiesMapper userAuthoritiesMapperForKeycloak() {
        return authorities -> {
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            var authority = authorities.iterator().next();

            if (authority instanceof OidcUserAuthority) {
                var oidcUserAuthority = (OidcUserAuthority) authority;
                var userInfo = oidcUserAuthority.getUserInfo();

                if (userInfo.hasClaim(REALM_ACCESS_CLAIM)) {
                    var realmAccess = userInfo.getClaimAsMap(REALM_ACCESS_CLAIM);
                    var roles = (Collection<String>) realmAccess.get(ROLES_CLAIM);
                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
                }
            }
            return mappedAuthorities;
        };
    }

    /**
     * Generates GrantedAuthorities from a collection of roles.
     *
     * @param roles A collection of role names.
     * @return A collection of SimpleGrantedAuthority objects with "ROLE_" prefix.
     */
    Collection<GrantedAuthority> generateAuthoritiesFromClaim(Collection<String> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    }

    /**
     * Configures security filters and rules using HttpSecurity.
     *
     * @param http The HttpSecurity object to configure.
     * @return A SecurityFilterChain with defined security rules.
     * @throws Exception If an exception occurs during configuration.
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .oauth2Client()
                .and()
                .oauth2Login()
                .tokenEndpoint()
                .and()
                .userInfoEndpoint();

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

        http
                .authorizeHttpRequests()
                .requestMatchers("/authenticated").authenticated()
                .requestMatchers("/api").hasRole("api_users")
                .anyRequest()
                .permitAll();

        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("http://localhost:8081/realms/springbootdemo/protocol/openid-connect/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true);

        return http.build();
    }
}
