package co.istad.elearningapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userDetailsService);
        dao.setPasswordEncoder(passwordEncoder);
        return dao;
    }

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
