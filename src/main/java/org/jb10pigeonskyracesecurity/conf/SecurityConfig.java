package org.jb10pigeonskyracesecurity.conf;

import lombok.extern.slf4j.Slf4j;
import org.jb10pigeonskyracesecurity.utils.enums.Role;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private static final String[] PUBLIC_URLS = {"/api/users/login", "/api/users/register"};
    private static final String[] USER_URLS = {"/api/breeders/**", "/api/pigeons/**"};
    private static final String[] ORGANIZER_URLS = {"/api/rankings/**", "/api/races/**", "api/competitions/**"};
    private static final String[] ADMIN_URLS = {"/api/users/update-role"};

    private void configureAuthorization(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(PUBLIC_URLS).permitAll()
                .requestMatchers(USER_URLS).hasRole(Role.USER.name())
                .requestMatchers(ORGANIZER_URLS).hasRole(Role.ORGANIZER.name())
                .requestMatchers(ADMIN_URLS).hasRole(Role.ADMIN.name())
                .anyRequest().authenticated()
                );
    }

    private void configureAuthentication(HttpSecurity http) throws Exception {
        http.httpBasic(withDefaults())
                .formLogin(withDefaults());
    }

    private void configureSessionManagement(HttpSecurity http) throws Exception {
        http.sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
    }

    private void configureExploits(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        configureAuthorization(http);
        configureAuthentication(http);
        configureSessionManagement(http);
        configureExploits(http);
        return http.build();
    }

    @Bean
    public ApplicationListener<AuthenticationSuccessEvent> authenticationSuccessListener() {
        return event -> {
            log.info("Authentication successful");
        };
    }
}
