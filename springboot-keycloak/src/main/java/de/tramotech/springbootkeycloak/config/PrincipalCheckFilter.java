package de.tramotech.springbootkeycloak.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class PrincipalCheckFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Get the current authentication (Principal)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        /*
        System.out.println("ahmed + " + authentication);

        if(authentication != null) {
            DefaultOidcUser p = (DefaultOidcUser) authentication.getPrincipal();
            System.out.println("toto toto " +p.getUserInfo().getClaims());
        System.out.println(String.format("name %s", authentication.getName()));
            System.out.println(String.format("isAuthenticated %s", authentication.isAuthenticated()));
            System.out.println(String.format("principal %s", authentication.getPrincipal()));
            System.out.println(String.format("credential %s", authentication.getPrincipal()));

        }
*/


        // Continue the filter chain for other requests
        filterChain.doFilter(request, response);
    }
}

