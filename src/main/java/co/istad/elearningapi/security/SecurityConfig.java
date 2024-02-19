package co.istad.elearningapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain apiFilterChain(HttpSecurity httpSecurity) throws Exception {

        // Your security logic
        httpSecurity
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/file/**").permitAll()
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .anyRequest()
                        .authenticated())
                // security mechanism (username & password)
                .httpBasic(Customizer.withDefaults())
                .csrf(token -> token.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        ));

        return httpSecurity.build();
    }

}
