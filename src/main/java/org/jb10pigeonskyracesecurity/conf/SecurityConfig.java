package org.jb10pigeonskyracesecurity.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] PUBLIC_URLS = {"/api/users/login", "/api/users/register"};
    private static final String[] USER_URLS = {"/api/breeders/**", "/api/pigeons/**"};
    private static final String[] ORGANIZER_URLS = {"/api/rankings/**", "/api/races/**", "api/competitions/**"};
    private static final String[] ADMIN_URLS = {"/api/users/update-role"};

    private static final String ADMIN_ROLE = "ADMIN";
    private static final String USER_ROLE = "USER";
    private static final String ORGANIZER_ROLE = "ORGANIZER";

    private void configureAuthorization(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(PUBLIC_URLS).permitAll()
                .requestMatchers(USER_URLS).hasRole(USER_ROLE)
                .requestMatchers(ORGANIZER_URLS).hasRole()
                .requestMatchers(ORGANIZER_URLS).hasRole("ORGANIZER")
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
}
