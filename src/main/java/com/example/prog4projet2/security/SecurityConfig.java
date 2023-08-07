package com.example.prog4projet2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.*;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(publicMatchers()).permitAll()
                                .requestMatchers(privateMatchers()).authenticated()
                )
                .formLogin(withDefaults());

        return http.build();
    }
    private RequestMatcher publicMatchers() {
        return new OrRequestMatcher(
                new AntPathRequestMatcher("/login")
        );
    }
    private RequestMatcher privateMatchers() {
        return new AndRequestMatcher(
                new NegatedRequestMatcher(publicMatchers())
        );
    }
}
